package br.bean;

import br.dao.CrudClientes;
import br.model.Cidade;
import br.model.Cliente;
import br.rest.RestCidadeClient;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
//import javax.faces.view.ViewScoped;

@Named(value = "beanCliente")
@ViewScoped
public class BeanCliente implements Serializable {

    private Cliente cli;
    private CrudClientes cc;
    private int codigo;
    private String nome;
    private int codCidade;

    private ArrayList<Cliente> clientes;
    private ArrayList<Cidade> cidades;

    @PostConstruct
    public void BeanClienteInit() {
        RestCidadeClient rc = new RestCidadeClient();
        cli = new Cliente();
        cc = new CrudClientes();
        cidades = (ArrayList<Cidade>) rc.getAll();
        clientes = new ArrayList<Cliente>();
    }

    public void inserir() {
        
        for (Cidade cid : cidades) {
            if (cid.getCodigo() == codCidade) {
                cli.setCidade(cid);
                break;
            }
        }
        cc.insereCliente(cli);
        listar();
        cli = new Cliente();
    }

    public void listar() {

        clientes = cc.listar();
    }

    public void deletar(int id) {

        for (Cliente cli : clientes) {
            if (cli.getCodigo() == id) {
                cc.delete(cli.getCodigo());
                listar();
                break;
            }
        }
    }

    public void editar(int id) {
        for (Cliente cli : clientes) {
            if (cli.getCodigo() == id) {
                cli.setCodigo(this.cli.getCodigo());
                cli.setNome(this.cli.getNome());
                cli.setCidade(this.cli.getCidade());

                cc.editar(cli);
                listar();
                cli = new Cliente();

            }
        }

    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public int getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
    }

    
    
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(ArrayList<Cidade> cidades) {
        this.cidades = cidades;
    }

    public CrudClientes getCc() {
        return cc;
    }

    public void setCc(CrudClientes cc) {
        this.cc = cc;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

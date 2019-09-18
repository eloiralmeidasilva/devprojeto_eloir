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
    private Cliente cliEdit;
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

        if (clientes.contains(cliEdit)) {
            
            for (Cidade cid : cidades) {
                if (cid.getCodigo() == codCidade) {
                    cli.setCidade(cid);
                    break;
                }
            }
            
            cc.editar(cli);
            listar();
            cliEdit = new Cliente();
            cli = new Cliente();

        } else {
             
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
    }

    public void listar() {

        clientes = cc.listar();
    }

    public void deletar(Cliente cliente) {

        if (clientes.contains(cliente)) {
            cc.delete(cliente.getCodigo());
            listar();

        }

    }

    public void editar(Cliente client) {

        cliEdit = new Cliente();
        cliEdit = client;
        cli = client;

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

    public Cliente getCliEdit() {
        return cliEdit;
    }

    public void setCliEdit(Cliente cliEdit) {
        this.cliEdit = cliEdit;
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

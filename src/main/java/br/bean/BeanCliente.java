
package br.bean;

import br.dao.CrudClientes;
import br.model.Cidade;
import br.model.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
//import javax.faces.view.ViewScoped;


@Named(value = "beanCliente")
@ViewScoped
public class BeanCliente implements Serializable{

    private Cliente cli;
    private CrudClientes cc;
    
    private int codigo;
    private String nome;
    
    private ArrayList<Cliente> clientes;
    private ArrayList<Cidade> cidades;
    
        
    public void preencherObj(){
        
        cc.insereCliente(cli);
        cli = new Cliente();
        listar();
    }
    
    public ArrayList<Cliente> listar(){
        
        return cc.listar();
    }
    
    public void deletar(Cliente cliente){
        for(Cliente cli : clientes){
            cc.delete(cliente.getCodigo());
            clientes.remove(cliente);
        }
    }
    
    
    public BeanCliente() {
        cli = new Cliente();
        cc = new CrudClientes();
    
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

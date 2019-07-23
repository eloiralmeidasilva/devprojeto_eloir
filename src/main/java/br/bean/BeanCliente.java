
package br.bean;

import br.dao.CrudClientes;
import br.model.Cidade;
import br.model.Cliente;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
//import javax.faces.view.ViewScoped;


@Named(value = "beanCliente")
@SessionScoped
public class BeanCliente {

 
    private ArrayList<Cliente> clientes;
    private ArrayList<Cidade> cidades;
    
    CrudClientes cc = new CrudClientes();
    
    public void inserir(Cliente cliente){
        for(Cliente cli : clientes){
            cc.insereCliente(cliente);
            clientes.add(cliente);
        }
    }
    
    
    public void deletar(Cliente cliente){
        for(Cliente cli : clientes){
            cc.delete(cliente.getCodigo());
            clientes.add(cliente);
        }
    }
    
    
    public BeanCliente() {
    
    }
    
}


package br.dao;

import br.model.Cliente;
import java.util.ArrayList;


public class CrudClientes {
    
    public static ArrayList<Cliente> clientes;

    
    public void insereCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
    public ArrayList<Cliente> listar(){
    
        return clientes;
    }

    public void editar(Cliente cliente){
        for(int i = 0; i < clientes.size(); i++){
            if(cliente.getCodigo() == clientes.get(i).getCodigo()){
                clientes.set(i, cliente);
                break;
            }
        }
    }

    
    public void delete(int codigo){
        for(int i = 0; i < clientes.size(); i++){
            if(codigo == clientes.get(i).getCodigo()){
                clientes.remove(i);
                break;
            }
        }
    }
    
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        CrudClientes.clientes = clientes;
    }
    
    
    
    
}

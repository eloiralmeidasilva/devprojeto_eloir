
package br.model;

import br.alerario.ICidade;
import javax.xml.bind.annotation.XmlRootElement;
//import br.alerario.ICliente;

@XmlRootElement(name="Cliente")
public class Cliente implements java.io.Serializable{
    
    private int codigo;
    private String nome;
    private Cidade cidade;
    
    

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


    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    
        
}

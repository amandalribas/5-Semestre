package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable; //permite que a classe seja salva

@Entity
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    //@Collum(nome="nomecompleto"), no bd a tabela ia ficar com o atributo nomecompleto ao inves de nome
    private String nome;
    private String email;

    public Pessoa(){

    }

    public Pessoa(Integer id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Integer getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

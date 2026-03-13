package dominio;

import java.io.Serializable; //permite que a classe seja salva

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String email;

    public Pessoa(){

    }

    public Pessoa(int id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public int getId(){
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

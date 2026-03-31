package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args){


        //criando conexão com o bd
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio1"); //  é o nome atribuido em persistence.xml   <persistence-unit name="exemplo-jpa" transaction-type="RESOURCE_LOCAL">
        EntityManager em = emf.createEntityManager();

        /*
        Pessoa p1 = new Pessoa(null, "Amanda Lemos", "amanda@gmail.com");
        Pessoa p2 = new Pessoa(null, "Diogo Gouveia", "diogo@gmail.com");
        Pessoa p3 = new Pessoa(null, "Lais Nazareth", "lais@gmail.com");

        //Em operações que não são de leitura, é necessário uma transação
        em.getTransaction().begin();
        em.persist(p1); //passando o objeto pro bd
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        */
        
        em.getTransaction().begin();
        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);
        em.remove(p);
        em.getTransaction().commit();

        emf.close();
        em.close();
        System.out.println("Fim.");

    }
}

package com.carlosribeiro.dao.impl;

import com.carlosribeiro.dao.ProdutoDAO;
import com.carlosribeiro.excecao.ProdutoNaoEncontradoException;
import com.carlosribeiro.modelo.Produto;
import com.carlosribeiro.util.FabricaDeEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import java.util.List;

public class JPAProdutoDAO implements ProdutoDAO {
	public long inclui(Produto umProduto) {

		EntityManager em = null;
		EntityTransaction tx = null; //abre uma transação com o SGBD (q pode efetuar um commit no final)

		try {    // transiente - objeto novo: ainda não persistente -- id = null
			// persistente - após ser persistido -- quando o objeto está sendo monitorado pelo entity manager
			// destacado - objeto persistente não vinculado a um entity manager -- id != null e o objeto não está sendo monitorado pelo entity manager

			em = FabricaDeEntityManager.criarEntityManager(); //toda vez cria um novo
			tx = em.getTransaction(); //toda vez que for executado também cria um novo
			//abrindo transação:
			tx.begin();

			em.persist(umProduto); //objeto transiente -- o persist agenda a execução de um comando SQL Insert
			//umProduto.setNome("abc"); //update
			tx.commit(); // só executa no commit
			return umProduto.getId();
		} catch (RuntimeException e) //execção que ocorreu
		{
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	public Produto recuperaUmProduto(long numero) throws ProdutoNaoEncontradoException {
		EntityManager em = null;
		//nao precisa de entity transaction pq é somente select
		try {
			em = FabricaDeEntityManager.criarEntityManager();
			Produto umProduto = em.find(Produto.class, numero); //boxing automático de número: new Long(numero)

			// Características no método find():
			// 1. É genérico: não requer um cast. Cast: (Produto) em.find(Produto.class, numero);
			// 2. Retorna null caso a linha não seja encontrada no banco.

			if (umProduto == null) {
				throw new ProdutoNaoEncontradoException("Produto não encontrado");
			}
			return umProduto;
		} finally {
			if (em != null) { //asset em != null; é usado em desenvolvimento, de que em não poderia ser null
				em.close(); //mas nesse caso pode ser null se der erro
			}
		}
	}


	//não precisa retornar o mesmo que está passando, por isso retornar void!!
	public void altera(Produto umProduto) throws ProdutoNaoEncontradoException {
		EntityManager em = null;
		EntityTransaction tx = null;
		Produto produto = null;
		try
		{
			em = FabricaDeEntityManager.criarEntityManager(); //criando entity manager com lista de objetos monitorados, inicialmente vazia,
			tx = em.getTransaction(); //entity transaction
			tx.begin(); //inicia a transação
			//só os objetos recuperados pela transação são monitorados pelo entity manager
			produto = em.find(Produto.class,umProduto.getId(), LockModeType.PESSIMISTIC_WRITE); //procura no entity manager um objeto do tipo produto cujo o id corresponde ao id de umProduto, se não tiver vai no banco de dados e trás para a memória e retorna ele para o entity manager
			if (produto == null) { //verificando se encontrou
 				tx.rollback();
				 throw new ProdutoNaoEncontradoException(
						 "Produto com id= " + umProduto.getId()  + " não encontrado");
			}
			em.merge(umProduto); //merge: procura na lista de objetos monitorados do entity manager e procura um objeto do tipo produto com o Id igual ao umProduto,se não tem vai no bd e recupera, compara com o que já existe com o umProduto e agenda um update após comparar as diferenças, só será executado no commit
			// O merge entre nada e tudo é tudo. Ao tentar alterar um produto deletado ele será re-inserido
			// no banco de dados.
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if (tx != null)
		    {   tx.rollback();
		    }
		    throw e;
		}
		finally{
			if (em!= null){
				em.close();
			}
		}
	}

	//o padrão para exclusão é retornar void
	public void exclui(long numero) throws ProdutoNaoEncontradoException {

		EntityManager em = null;
		EntityTransaction tx = null;

		try
		{
			em = FabricaDeEntityManager.criarEntityManager();
			tx = em.getTransaction();
			tx.begin(); //

			//JPA não tem método de deleção direto ,exige que recupere primeiro o produto para depois deletar
			Produto produto = em.find(Produto.class, numero); //não precisa botar lockmode

			if(produto == null)
			{	tx.rollback();
				throw new ProdutoNaoEncontradoException("Produto não encontrado");
			}

			em.remove(produto); //remove exige um objeto persistente -- se não for persistente vai falar que não consegue usar objeto destacado

			tx.commit();
		}
		catch(RuntimeException e)
		{
			if (tx != null)
		    {   tx.rollback();
		    }
		    throw e;
		}
		finally
		{
			if (em != null){
				em.close();
			}
		}
	}


	public List<Produto> recuperaProdutos() {
		EntityManager em = null;
		try
		{
			em = FabricaDeEntityManager.criarEntityManager();

			//Não é SQL: "Produto" é o nome da classe, se colocar com letra minúscula dentro da querry não funciona, não é a tabela produto
			//p.id -> p.getId();
			//se fosse sql seria select *, não select p
			List produtos = em.createQuery(
					"select p from Produto p order by p.id"
			).getResultList();
			// Retorna um List vazio caso a tabela correspondente esteja vazia.

			return produtos;
		}
		finally {
			if (em!=null) {
				em.close();
			}
		}
		}
	}


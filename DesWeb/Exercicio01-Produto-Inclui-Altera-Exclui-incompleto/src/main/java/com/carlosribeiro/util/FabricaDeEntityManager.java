package com.carlosribeiro.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaDeEntityManager
{
	private static FabricaDeEntityManager fabrica = null;
	//Fabrica de EntityManager Real:
	private EntityManagerFactory emf = null; //variável de instância do objeto do tipo FabricaDeEntityManager
			
	private FabricaDeEntityManager() //método construtor (privado: a única maneira de criar um objeto do tipo FabricaDeEntity managar é a partir do método criarEntityManager)
	{	
		try
		{	//Custoso de ser criado:
			emf = Persistence.createEntityManagerFactory("desweb"); //cria objeto, emf está apontando para o objeto
		} //nome de unidade de persistencia: Em persistence.xml <persistence-unit name="..." precisam ter o mesmo nome
		catch(Throwable e)
		{
			e.printStackTrace();
			System.out.println(">>>>>>>>>> Mensagem de erro: " + e.getMessage());
		}
	}

	//Estilo Singleton:
		//Construtor Privado e um método estático publico que retorna um método estático
		//Para esse ser uma aplicação sigleton, precisaria estar retornando um objeto singleton
	public static EntityManager criarEntityManager()
	{	if (fabrica == null)
		{	fabrica = new FabricaDeEntityManager(); //cria um objeto do tipo FabricaDeEntityManager -- é pesado, só deve criar 1x
		}	

		return fabrica.emf.createEntityManager(); //para ser singleton teria que retornar fabrica.emf
	}
}
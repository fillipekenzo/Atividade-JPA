package br.edu.ifms.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifms.model.Cliente;

public class AlteraCliente {
	
	public static void main(String... args) {
		
		  EntityManagerFactory entityManagerFactory 
		        = Persistence.createEntityManagerFactory("CadastroPU");
		  EntityManager entityManager = entityManagerFactory.createEntityManager();
		     
		  //Busca o cliente que será alterado
		  Cliente cliente = entityManager.find(Cliente.class, 1l);
		 
		  entityManager.getTransaction().begin();
		  
		  //Altera os campos necessários
		  cliente.setNome("Professor Jeferson");
		  cliente.setIdade(52);
		  entityManager.getTransaction().commit();
		 
		  entityManager.close();
		  entityManagerFactory.close();
		}

}

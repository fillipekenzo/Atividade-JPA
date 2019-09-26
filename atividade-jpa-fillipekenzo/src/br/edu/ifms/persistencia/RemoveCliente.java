package br.edu.ifms.persistencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifms.model.Cliente;

public class RemoveCliente {
	public static void main(String... args) {
		  EntityManagerFactory entityManagerFactory 
		        = Persistence.createEntityManagerFactory("CadastroPU");
		  EntityManager entityManager = entityManagerFactory.createEntityManager();
		     
		  //Primeiro temos que buscar e setar o cliente a ser removido
		  Cliente cliente = entityManager.find(Cliente.class, 2l);
		 
		  entityManager.getTransaction().begin();
		  
		  //Para removermos basta usar o metodo remove e passar o objeto cliente
		  entityManager.remove(cliente);
		  entityManager.getTransaction().commit();
		 
		  entityManager.close();
		  entityManagerFactory.close();
		}

}

package br.edu.ifms.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifms.model.Cliente;

public class BuscaCliente {
	
	public static void main(String... string) {
	
	EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("CadastroPU");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	/*
	 * Para buscarmos um cliente basta usarmos o metodo find
	 * Como parametros devemos passar o tipo de objeto que a JPA
	 * deverá nos devolver (Cliente.class) e o id a ser pesquisado no banco de dados
	 */
	Cliente cliente = entityManager.find(Cliente.class, 1l);
	System.out.println("ID: " + cliente.getId());
	System.out.println("Nome: " + cliente.getNome());
	System.out.println("Idade: " + cliente.getIdade());
	System.out.println("Altura: " + cliente.getAltura());
	System.out.println("Peso: " + cliente.getPeso());
	System.out.println("Data Nascimento: " + cliente.getDataNascimento());

	entityManager.close();
	entityManagerFactory.close();
	}
}

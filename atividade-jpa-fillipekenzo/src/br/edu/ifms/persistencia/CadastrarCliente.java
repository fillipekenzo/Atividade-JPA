package br.edu.ifms.persistencia;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifms.model.Cliente;

public class CadastrarCliente {
	
	public static void main(String... string) {
		
		/*
		 * Precisamos criar uma fábrica de conexões para termos 
		 * acesso ao EntityManager.
		 * Repare que o parâmetro do método createEntityManagerFactory é o mesmo que 
		 * está no persistence.xml, na tag persistence-unit, atributo name.
		 * Uma vez que a fábrica é criada, a ideia é que você guarde essa instância 
		 * durante todo o tempo de vida da sua aplicação.
		 */		
		EntityManagerFactory entityManagerFactory = 
				    Persistence.createEntityManagerFactory("CadastroPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Criando e setando um objeto Cliente
		//O atributo ID é controlado pelo Banco de Dados - auto-incremento
		Cliente cliente = new Cliente();
		cliente.setNome("Jeferson Velasques Rodrigues");
		cliente.setIdade(51);
		cliente.setAltura(1.64);
		cliente.setDataNascimento(new Date());
		cliente.setPeso(89.5);
		
		
		//Controlando o tempo das transações usando begin e commit
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();

		//Fechando o gerenciador e a fabrica de conexões
		entityManager.close();
		entityManagerFactory.close();
		
	}

}

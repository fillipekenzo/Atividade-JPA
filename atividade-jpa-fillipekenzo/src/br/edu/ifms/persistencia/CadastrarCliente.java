package br.edu.ifms.persistencia;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifms.model.Cliente;

public class CadastrarCliente {
	
	public static void main(String... string) {
		
		/*
		 * Precisamos criar uma f�brica de conex�es para termos 
		 * acesso ao EntityManager.
		 * Repare que o par�metro do m�todo createEntityManagerFactory � o mesmo que 
		 * est� no persistence.xml, na tag persistence-unit, atributo name.
		 * Uma vez que a f�brica � criada, a ideia � que voc� guarde essa inst�ncia 
		 * durante todo o tempo de vida da sua aplica��o.
		 */		
		EntityManagerFactory entityManagerFactory = 
				    Persistence.createEntityManagerFactory("CadastroPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Criando e setando um objeto Cliente
		//O atributo ID � controlado pelo Banco de Dados - auto-incremento
		Cliente cliente = new Cliente();
		cliente.setNome("Jeferson Velasques Rodrigues");
		cliente.setIdade(51);
		cliente.setAltura(1.64);
		cliente.setDataNascimento(new Date());
		cliente.setPeso(89.5);
		
		
		//Controlando o tempo das transa��es usando begin e commit
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();

		//Fechando o gerenciador e a fabrica de conex�es
		entityManager.close();
		entityManagerFactory.close();
		
	}

}

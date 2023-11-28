package com.ifpb.estagio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.engine.spi.ExecuteUpdateResultCheckStyle;

import com.ifpb.estagio.model.Aluno;
import com.ifpb.estagio.model.Orientador;

public class Teste {
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoPU");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	public static void main(String[] args) {
//		DELETAR
		entityManager.getTransaction().begin();
		int idAluno = 9;
		entityManager.createQuery("delete from Aluno a where id = :idAluno")
		.setParameter("idAluno", idAluno)
		.executeUpdate();
		
		//Update
//		int idAluno = 1;
//		entityManager.getTransaction().begin();
//		entityManager.createQuery("update Aluno a set nome = 'italo' where a.id = :idAluno")
//		.setParameter("idAluno", idAluno)
//		.executeUpdate();		
		
		//FIND
//		Aluno aluno = entityManager.find(Aluno.class, 2);
//		System.out.println("nome:"+ aluno.getNome() + "\nmatricula:" + aluno.getMatricula());
//		
		//INSERT
//		Aluno aluno = new Aluno();
//		aluno.setNome("Risalva");
//		aluno.setMatricula(5);
//		entityManager.getTransaction().begin();
//		entityManager.persist(aluno);
//		entityManager.getTransaction().commit();
////		
		//DELETE
//		Aluno aluno = entityManager.find(Aluno.class, 1);	
//		entityManager.getTransaction().begin();
//		entityManager.remove(aluno);
//		entityManager.getTransaction().commit();
//		
		//MODIFY
//		Aluno aluno = entityManager.find(Aluno.class, 5);
//		aluno.setNome("Roberto");
//		entityManager.getTransaction().begin();
//		entityManager.merge(aluno);
//		entityManager.getTransaction().commit();
//		
		//LISTAR
//		String jpql = "select a from Aluno a";
//		TypedQuery<Aluno>typedQuery = entityManager.createQuery(jpql, Aluno.class);
//		List<Aluno> listaAluno = typedQuery.getResultList();
//		for(Aluno aluno: listaAluno) {
//			System.out.println(aluno.getNome());
//		}
		
		//INSERT
//		Aluno aluno = new Aluno();
//		aluno.setNome("lucas");
//		entityManager.getTransaction().begin();
//		entityManager.persist(aluno);
	  //entityManager.getTransaction().commit();
//		
//		String jpql = "SELECT DISTINCT a FROM Estagio e JOIN e.aluno a";
//        TypedQuery<Aluno> typedQuery = entityManager.createQuery(jpql, Aluno.class);
//        List<Aluno> alunosEmEstagio = typedQuery.getResultList();
//
//        // Exibir os alunos
//        System.out.println("Alunos em estágio:");
//        for (Aluno aluno : alunosEmEstagio) {
//            System.out.println("Nome do Aluno: " + aluno.getNome());
//        }
		
		
		// ATRIBUIR orientador a aluno
//		 entityManager.getTransaction().begin();
//
// 	    // adicionando aluno
// 	    Aluno aluno = new Aluno();
// 	    
// 	    // Buscando um orientador existente pelo ID (suponha que o ID do orientador desejado seja 1)
// 	    Orientador orientadorExistente = entityManager.find(Orientador.class, 1);
//
// 	    // Verificando se o orientador existe antes de associá-lo ao aluno
// 	    if (orientadorExistente != null) {
// 	        aluno.setNome("Lucas");
// 	        aluno.setOrientador(orientadorExistente);
// 	        entityManager.persist(aluno);
// 	    } else {
// 	        System.out.println("Orientador não encontrado.");
// 	    }

    	entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}

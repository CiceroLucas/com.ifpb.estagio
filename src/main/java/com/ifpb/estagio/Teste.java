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
//		entityManager.getTransaction().begin();
//		int idAluno = 1;
//		entityManager.createQuery("delete from Aluno a where id = :idAluno")
//		.setParameter("idAluno", idAluno)
//		.executeUpdate();
//		entityManager.getTransaction().commit();
		
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
//		Aluno aluno = entityManager.find(Aluno.class, 2);
//		aluno.setNome("Risalva");
//		entityManager.getTransaction().begin();
//		entityManager.merge(aluno);
//		entityManager.getTransaction().commit();
		
		//LISTAR
		String jpql = "select a from Aluno a";
		TypedQuery<Aluno>typedQuery = entityManager.createQuery(jpql, Aluno.class);
		List<Aluno> listaAluno = typedQuery.getResultList();
		for(Aluno aluno: listaAluno) {
			System.out.println(aluno.getNome());
		}
		
		entityManager.close();
		entityManagerFactory.close();
	}
}

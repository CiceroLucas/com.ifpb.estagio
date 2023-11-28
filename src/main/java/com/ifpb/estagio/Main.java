package com.ifpb.estagio;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ifpb.estagio.model.Aluno;
import com.ifpb.estagio.model.Empresa;
import com.ifpb.estagio.model.Estagio;
import com.ifpb.estagio.model.Orientador;
public class Main {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoPU");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        // Adicionando orientador
//        Orientador orientador = new Orientador();
//        orientador.setNome("Daladie");
//        orientador.setDepartamento("ADS");
//        entityManager.persist(orientador);

        // Adicionando empresa
//        Empresa empresa = new Empresa();
//        empresa.setNome("Ads LTDA");
//        empresa.setEndereco("Rua Tal, Número Tal");
//        entityManager.persist(empresa);

        // Adicionando aluno
//        Aluno aluno = new Aluno();
//        aluno.setNome("italo");
//        aluno.setOrientador(orientador);
//        aluno.setEmpresa(empresa);
//        entityManager.persist(aluno);

        entityManager.getTransaction().begin();

        // Adicionando aluno
        Aluno aluno = new Aluno();
        aluno.setNome("Risalva");

        // Buscando um orientador existente pelo ID (suponha que o ID do orientador desejado seja 1)
        Orientador orientadorExistente = entityManager.find(Orientador.class, 3);

        // Verificando se o orientador existe antes de associá-lo ao aluno
        if (orientadorExistente != null) {
            aluno.setOrientador(orientadorExistente);

            // Buscando uma empresa existente pelo ID (suponha que o ID da empresa desejada seja 2)
            Empresa empresaExistente = entityManager.find(Empresa.class, 2);

            // Verificando se a empresa existe antes de associá-la ao aluno
            if (empresaExistente != null) {
                aluno.setEmpresa(empresaExistente);
                entityManager.persist(aluno);

                // Persistindo a empresa (caso não tenha sido persistida antes)
                if (!entityManager.contains(empresaExistente)) {
                    entityManager.persist(empresaExistente);
                }

                // Estágio 1
//                Estagio estagio1 = new Estagio();
//                estagio1.setNome("Assistente");
//                estagio1.setCargaHorariaTotal(50);
//                estagio1.setDataInicio(new java.sql.Date(System.currentTimeMillis()));
//                estagio1.setDataFim(new java.sql.Date(System.currentTimeMillis() + 86400000)); // Adiciona um dia
//                estagio1.setEmpresa(empresaExistente);
//                estagio1.setAluno(aluno);
//                estagio1.setOrientador(orientadorExistente);
//                entityManager.persist(estagio1);

            } else {
                System.out.println("Empresa não encontrada.");
            }
        } else {
            System.out.println("Orientador não encontrado.");
        }

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
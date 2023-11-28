package com.ifpb.estagio;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ifpb.estagio.model.Aluno;
import com.ifpb.estagio.model.Empresa;
import com.ifpb.estagio.model.Estagio;
import com.ifpb.estagio.model.Orientador;

public class PovoarBanco {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Povoamento de Orientadores
            Orientador orientador1 = criarOrientador("João", "TI");
            Orientador orientador2 = criarOrientador("Maria", "Engenharia");
            entityManager.persist(orientador1);
            entityManager.persist(orientador2);

            // Povoamento de Empresas
            Empresa empresa1 = criarEmpresa("Loopis", "Rua 1, Número 1", "Tecnologia");
            Empresa empresa2 = criarEmpresa("TechCorp", "Rua 2, Número 2", "Software");
            entityManager.persist(empresa1);
            entityManager.persist(empresa2);

            // Povoamento de Alunos
            Aluno aluno1 = criarAluno("Lucas", orientador1, empresa1);
            Aluno aluno2 = criarAluno("Maria", orientador2, empresa2);
            entityManager.persist(aluno1);
            entityManager.persist(aluno2);

            // Povoamento de Estágios
            Estagio estagio1 = criarEstagio("Assistente", orientador1, empresa1, aluno1);
            Estagio estagio2 = criarEstagio("Desenvolvedor", orientador2, empresa2, aluno2);
            entityManager.persist(estagio1);
            entityManager.persist(estagio2);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    private static Orientador criarOrientador(String nome, String departamento) {
        Orientador orientador = new Orientador();
        orientador.setNome(nome);
        orientador.setDepartamento(departamento);
        return orientador;
    }

    private static Empresa criarEmpresa(String nome, String endereco, String setor) {
        Empresa empresa = new Empresa();
        empresa.setNome(nome);
        empresa.setEndereco(endereco);
        empresa.setSetor(setor);
        return empresa;
    }

    private static Aluno criarAluno(String nome, Orientador orientador, Empresa empresa) {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setOrientador(orientador);
        aluno.setEmpresa(empresa);
        return aluno;
    }

    private static Estagio criarEstagio(String nome, Orientador orientador, Empresa empresa, Aluno aluno) {
        Estagio estagio = new Estagio();
        estagio.setNome(nome);
        estagio.setCargaHorariaTotal(50);
        estagio.setDataInicio(new java.sql.Date(System.currentTimeMillis()));
        estagio.setDataFim(new java.sql.Date(System.currentTimeMillis() + 86400000)); // Adiciona um dia
        estagio.setEmpresa(empresa);
        estagio.setAluno(aluno);
        estagio.setOrientador(orientador);
        return estagio;
    }
}

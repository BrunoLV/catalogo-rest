package com.valhala.catalogo.dao.producers;

import com.valhala.catalogo.dao.qualifiers.BancoCatalogoMysql;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Classe produtora de entity manager
 *
 * @author Bruno Luiz Viana
 */
public class EntityManagerProducer {

    @PersistenceContext(unitName = "catalogo-PU")
    private EntityManager entityManager;

    @Produces @BancoCatalogoMysql
    public EntityManager obterEntityManagerMySQL() {
        return entityManager;
    } // fim do m�todo obterEntityManagerMySQL

} // fim da classe EntityManagerProducer
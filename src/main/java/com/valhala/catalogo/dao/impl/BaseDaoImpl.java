package com.valhala.catalogo.dao.impl;

import com.valhala.catalogo.dao.exceptions.CatalogoDaoException;
import com.valhala.catalogo.dao.interfaces.BaseDao;
import com.valhala.catalogo.dao.qualifiers.BancoCatalogoMysql;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.io.Serializable;

/**
 * Implementacao base de DAO.
 *
 * @author Bruno Luiz Viana
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    @Inject
    @BancoCatalogoMysql
    protected EntityManager entityManager;
    protected Class<T> classePersistente;

    @Override
    public void salvarEntidade(T t) throws CatalogoDaoException {
        try {
			this.entityManager.persist(t);
		} catch (Exception e) {
			throw new CatalogoDaoException(e.getMessage(), e.getCause());
		} // fim do bloco try/catch
    } // fim do método salvarEntidade

    @Override
    public void editarEntidade(T t) throws CatalogoDaoException {
        try {
			this.entityManager.merge(t);
		} catch (Exception e) {
			throw new CatalogoDaoException(e.getMessage(), e.getCause());
		} // fim do bloco try/catch
    } // fim do método editarEntidade

    @Override
    public void deletarEntidade(T t) throws CatalogoDaoException {
        try {
			this.entityManager.remove(t);
		} catch (Exception e) {
			throw new CatalogoDaoException(e.getMessage(), e.getCause());
		} // fim do bloco try/catch
    } // fim do método deletarEntidade

    @Override
    public T buscarPorId(Serializable id) throws CatalogoDaoException {
        T t;
		try {
			t = this.entityManager.find(classePersistente, id);
		} catch (Exception e) {
			throw new CatalogoDaoException(e.getMessage(), e.getCause());
		} // fim do bloco try/catch
        return t;
    } // do método buscarPorId

} // fim da classe BaseDaoImpl
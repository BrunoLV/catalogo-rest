package com.valhala.catalogo.dao.impl;

import com.valhala.catalogo.dao.exceptions.CatalogoDaoException;
import com.valhala.catalogo.dao.interfaces.RevistaDao;
import com.valhala.catalogo.modelo.Revista;

import javax.persistence.Query;

import java.util.List;

/**
 * Implementação especializada para DAO de Revistas
 *
 * @author Bruno Luiz Viana
 */
public class RevistaDaoImpl extends BaseDaoImpl<Revista> implements RevistaDao {

    public RevistaDaoImpl() {
        this.classePersistente = Revista.class;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Revista> buscarTodos() throws CatalogoDaoException {
        List<Revista> revistas;
		try {
			Query query = this.entityManager.createNamedQuery("buscarTodasRevistas");
			revistas = query.getResultList();
		} catch (Exception e) {
			throw new CatalogoDaoException(e.getMessage(), e.getCause());
		} // fim do bloco try/catch
        return revistas;
    } // fim do método buscarTodos

    @Override
    public Revista buscarRevistaPorTituloEEdicao(String titulo, Short edicao) throws CatalogoDaoException {
        Revista revista;
		try {
			Query query = this.entityManager.createNamedQuery("buscarRevistaPorTituloEEdicao");
			query.setParameter("titulo", titulo);
			query.setParameter("edicao", edicao);
			revista = (Revista) query.getSingleResult();
		} catch (Exception e) {
			throw new CatalogoDaoException(e.getMessage(), e.getCause());
		} // fim do bloco try/catch
        return revista;
    } // fim do método buscarRevistaPorTituloEEdicao

    @SuppressWarnings("unchecked")
    @Override
    public List<Revista> buscarRevistasPorTitulo(String titulo) {
        Query query = this.entityManager.createNamedQuery("buscarRevistasPorTitulo");
        query.setParameter("titulo", titulo);
        List<Revista> revistas = query.getResultList();
        return revistas;
    } // fim do método buscarRevistasPorTituloEEdicao

    @SuppressWarnings("unchecked")
    @Override
    public List<Revista> buscarRevistasPorArco(String arco) {
        Query query = this.entityManager.createNamedQuery("buscarRevistasPorTitulo");
        query.setParameter("arco", arco);
        List<Revista> revistas = query.getResultList();
        return revistas;
    } // fim do método buscarRevistasPorArco

} // fim da classe RevistaDaoImpl
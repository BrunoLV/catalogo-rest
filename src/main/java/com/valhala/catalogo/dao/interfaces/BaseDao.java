package com.valhala.catalogo.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.valhala.catalogo.dao.exceptions.CatalogoDaoException;

/**
 * Interface base para todos os DAO's da aplicaééo.
 *
 * @author Bruno Luiz Viana
 */
public interface BaseDao<T> {

    /**
     * Método utilizado para salvar um registro no banco de dados.
     *
     * @param t
     * @throws CatalogoDaoException 
     */
    void salvarEntidade(T t) throws CatalogoDaoException;

    /**
     * Método utilizado para editar um registro no banco de dados.
     *
     * @param t
     * @throws CatalogoDaoException 
     */
    void editarEntidade(T t) throws CatalogoDaoException;

    /**
     * Método utilizado para deletar um registro no banco de dados.
     *
     * @param t
     * @throws CatalogoDaoException 
     */
    void deletarEntidade(T t) throws CatalogoDaoException;

    /**
     * Método utilizado para realizar um busca no banco de dados utilizadando a chave priméria.
     *
     * @param id
     * @return
     * @throws CatalogoDaoException 
     */
    T buscarPorId(Serializable id) throws CatalogoDaoException;

    /**
     * Método utilizado para realizar a busca de todos os registros gravados no banco de dados.
     *
     * @return
     * @throws CatalogoDaoException 
     */
    List<T> buscarTodos() throws CatalogoDaoException;

} // fim da classe BaseDao
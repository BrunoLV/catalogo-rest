package com.valhala.catalogo.dao.interfaces;

import com.valhala.catalogo.dao.exceptions.CatalogoDaoException;
import com.valhala.catalogo.modelo.Revista;

import java.util.List;

/**
 * Interface DAO especiaizada para a entidade Revista.
 *
 * @author Bruno Luiz Viana
 */
public interface RevistaDao extends BaseDao<Revista> {

    /**
     * M�todo utilizado para buscar Revista por titulo e edicao.
     *
     * @param titulo
     * @param edicao
     * @return
     * @throws CatalogoDaoException 
     */
    Revista buscarRevistaPorTituloEEdicao(String titulo, Short edicao) throws CatalogoDaoException;

    /**
     * M�todo utilizado para buscar revistas por titulo.
     *
     * @param titulo
     * @return
     */
    List<Revista> buscarRevistasPorTitulo(String titulo);

    /**
     * M�todo utilizado para buscar revistas por arco.
     *
     * @param arco
     * @return
     */
    List<Revista> buscarRevistasPorArco(String arco);

} // fim do m�todo RevistaDao
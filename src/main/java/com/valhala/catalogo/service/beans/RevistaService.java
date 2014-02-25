package com.valhala.catalogo.service.beans;

import com.valhala.catalogo.dao.exceptions.CatalogoDaoException;
import com.valhala.catalogo.dao.interfaces.RevistaDao;
import com.valhala.catalogo.modelo.Revista;
import com.valhala.catalogo.service.exceptions.CatalogoServiceException;

import javax.ejb.*;
import javax.inject.Inject;

import java.io.Serializable;
import java.util.List;

/**
 * SessionBean utilizado para regra de negécio referente a Revista.
 *
 * @author Bruno Luiz Viana
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class RevistaService {

    @Inject
    private RevistaDao revistaDao;

    /**
     * Método utilizado para salvar uma revista na base da aplicaééo.
     *
     * @param revista
     * @throws CatalogoServiceException 
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvarRevista(Revista revista) throws CatalogoServiceException {
        try {
			this.revistaDao.salvarEntidade(revista);
		} catch (CatalogoDaoException e) {
			throw new CatalogoServiceException(e.getMessage(), e.getCause());
		} // fim do bloco try/catch
    } // fim do método salvarRevista

    /**
     * Método utilizado para editar uma revista na base da aplicaééo.
     *
     * @param revista
     * @throws CatalogoServiceException 
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editarRevista(Revista revista) throws CatalogoServiceException {
        try {
			this.revistaDao.editarEntidade(revista);
		} catch (CatalogoDaoException e) {
			throw new CatalogoServiceException(e.getMessage(), e.getCause());
		} // fim do bloco try/catch
    } // fim do método editarRevista

    /**
     * Método utilizado para deletar uma revista na base de dados.
     *
     * @param id
     * @throws CatalogoServiceException 
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deletarRevista(Serializable id) throws CatalogoServiceException {
        try {
			this.revistaDao.deletarEntidade(this.revistaDao.buscarPorId(id));
		} catch (CatalogoDaoException e) {
			throw new CatalogoServiceException(e.getMessage(), e.getCause());
		} // fim do bloco try/catch
    } // fim do método deletarRevista

    /**
     * Método utilizado para buscar a lista de revistas cadastradas no banco de dados.
     *
     * @return
     * @throws CatalogoServiceException 
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Revista> buscarRevistas() throws CatalogoServiceException {
        System.out.println("Chegou aqui!!");
        try {
			return this.revistaDao.buscarTodos();
		} catch (CatalogoDaoException e) {
			throw new CatalogoServiceException(e.getMessage(), e.getCause());
		}
    } // fim do método buscarRevistas

} // fim da classe RevistaService
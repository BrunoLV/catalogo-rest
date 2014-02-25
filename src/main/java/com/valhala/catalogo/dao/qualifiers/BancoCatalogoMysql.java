package com.valhala.catalogo.dao.qualifiers;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Qualificador utilizado para o banco de dados da aplica��o que
 * esta no MySQL
 *
 * @author Bruno Luiz Viana
 */
@Target({TYPE, FIELD, METHOD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface BancoCatalogoMysql {

} // fim da @interface BancoCatalogoMysql
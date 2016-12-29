/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author martdominguez
 */
@ApplicationScoped
public class ProductorUtils {
    @Produces @TpEntityManager
    @PersistenceContext(unitName = "TP_PU")
    EntityManager em;
    
    @Produces @UsuarioFinal
    String nombreUsuarioFinal = "USUARIO_FINAL";
    @Produces @UsuarioAdmin
    String nombreUsuarioAdmin = "USUARIO_ADMIN";
}

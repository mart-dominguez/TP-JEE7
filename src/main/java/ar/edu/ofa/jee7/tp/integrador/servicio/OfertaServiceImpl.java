/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.servicio;

import ar.edu.ofa.jee7.tp.integrador.modelo.Departamento;
import ar.edu.ofa.jee7.tp.integrador.modelo.Estado;
import ar.edu.ofa.jee7.tp.integrador.modelo.Oferta;
import ar.edu.ofa.jee7.tp.integrador.util.TpEntityManager;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author martdominguez
 */
@RequestScoped
@Transactional
public class OfertaServiceImpl implements OfertaService{

    @Inject @TpEntityManager
    private EntityManager em;
    
    @Inject
    private UserService usrSrv;
    
    @Override
    public void hacerOferta(Oferta o,String correoUsuario,Departamento d) {
        o.setHuesped(usrSrv.buscarPorNombre(correoUsuario));
        o.setDepartamento(em.find(Departamento.class, d.getId()));
        o.setEstado(em.find(Estado.class,2));
        em.persist(o);
    }
    
}

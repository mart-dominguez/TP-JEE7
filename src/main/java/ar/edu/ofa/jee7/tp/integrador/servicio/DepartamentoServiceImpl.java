/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.servicio;

import ar.edu.ofa.jee7.tp.integrador.modelo.Departamento;
import ar.edu.ofa.jee7.tp.integrador.modelo.Usuario;
import ar.edu.ofa.jee7.tp.integrador.util.TpEntityManager;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author mdominguez
 */
@RequestScoped
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService{

    
    @Inject @TpEntityManager
    private EntityManager em;
    
    @Override
    public Departamento crear(Departamento nuevo) {
        em.persist(nuevo);
        em.flush();
        em.refresh(nuevo);
        return nuevo;
    }

    @Override
    public Departamento actualizar(Departamento nuevo) {
        return em.merge(nuevo);
    }

    @Override
    public void borrar(Departamento nuevo) {
        em.remove(em.find(Departamento.class, nuevo.getId()));
    }

    @Override
    public Departamento buscar(Integer id) {
        return em.find(Departamento.class, id);
    }

    @Override
    public List<Departamento> buscarTodos() {
        return em.createQuery("SELECT d FROM Departamento d").getResultList();
    }

    @Override
    public List<Departamento> buscarTodos(String userName) {
        return em.createQuery("SELECT d FROM Departamento d WHERE d.propietario.correo = :P_USER").setParameter("P_USER", userName).getResultList();
    }
        
}

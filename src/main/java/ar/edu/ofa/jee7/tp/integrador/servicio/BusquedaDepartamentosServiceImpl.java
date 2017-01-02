/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.servicio;

import ar.edu.ofa.jee7.tp.integrador.modelo.Departamento;
import ar.edu.ofa.jee7.tp.integrador.util.TpEntityManager;
import java.util.Date;
import java.util.List;
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
public class BusquedaDepartamentosServiceImpl implements BusquedaDepartamentosService {
    
    @Inject @TpEntityManager
    private EntityManager em;
    
    @Override
    public List<Departamento> buscarPorPrecio(Double minimo){
        return em.createQuery("SELECT d FROM Departamento d WHERE d.precioMinimo >= :P_PRECIO")
                .setParameter("P_PRECIO", minimo)
                .getResultList();
    }
 
    @Override
    public List<Departamento> buscarPorFecha(Date entrada,Date salida){
       return em.createQuery("SELECT depRes "
                + "FROM Departamento depRes "
                + "WHERE depRes.id NOT IN( "
                + "SELECT DISTINCT o.departamento.id FROM Oferta o "
                + "WHERE o.estado.id=1 AND " // el estado 1 es aceptada, asi que no tiene que estar aceptada
                + "( o.fechaSalida BETWEEN :P_FECHA_ENTRADA AND :P_FECHA_SALIDA "
                + " OR o.fechaEntrada BETWEEN :P_FECHA_ENTRADA AND :P_FECHA_SALIDA)"
                + ") ")
                .setParameter("P_FECHA_ENTRADA", entrada)
                .setParameter("P_FECHA_SALIDA", salida)                
                .getResultList(); 
    }

    @Override
    public List<Departamento> buscarHabitaciones(Integer habitacionesMinimas){
        return em.createQuery("SELECT d FROM Departamento d WHERE d.habitaciones >= :P_HAB")
                .setParameter("P_HAB", habitacionesMinimas)
                .getResultList();
    }
    
   @Override
    public List<Departamento> buscarPorPrecioFechaHabitaciones(Double precio,Date entrada,Date salida,Integer habitacionesMin){
        List<Departamento> lista1 = this.buscarPorPrecio(precio);
        List<Departamento> lista2 = this.buscarPorFecha(entrada, salida);
        List<Departamento> lista3 = this.buscarHabitaciones(habitacionesMin);
        lista1.retainAll(lista2);
        lista1.retainAll(lista3);
        return lista1;
    }
}

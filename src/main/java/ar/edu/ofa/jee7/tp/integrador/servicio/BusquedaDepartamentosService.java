/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.servicio;

import ar.edu.ofa.jee7.tp.integrador.modelo.Departamento;
import java.util.Date;
import java.util.List;

/**
 *
 * @author martdominguez
 */
public interface BusquedaDepartamentosService {
    public List<Departamento> buscarPorPrecio(Double minimo);
    public List<Departamento> buscarPorFecha(Date entrada,Date salida);
    public List<Departamento> buscarHabitaciones(Integer habitacionesMinimas);
    public List<Departamento> buscarPorPrecioFechaHabitaciones(Double precio,Date entrada,Date salida,Integer habitacionesMin);
}

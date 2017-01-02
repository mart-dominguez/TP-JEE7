/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.servicio;

import ar.edu.ofa.jee7.tp.integrador.modelo.Departamento;
import ar.edu.ofa.jee7.tp.integrador.modelo.Usuario;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public interface DepartamentoService {
    public Departamento crear(Departamento nuevo,String propietario);
    public Departamento actualizar(Departamento nuevo);
    public void borrar(Departamento nuevo);        
    public Departamento buscar(Integer id);            
    public List<Departamento> buscarTodos();   
    public List<Departamento> buscarTodos(String userName);

}

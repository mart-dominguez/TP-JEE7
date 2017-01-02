/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.servicio;

import ar.edu.ofa.jee7.tp.integrador.modelo.Departamento;
import ar.edu.ofa.jee7.tp.integrador.modelo.Oferta;

/**
 *
 * @author martdominguez
 */
public interface OfertaService {
    public void hacerOferta(Oferta o,String correoUsuario,Departamento d);
}

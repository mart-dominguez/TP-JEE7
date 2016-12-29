/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.vista;

import ar.edu.ofa.jee7.tp.integrador.modelo.Departamento;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author mdominguez
 */
@ViewScoped
@Named("editDeptoView")
public class EditarDepartamentoView implements Serializable{
    private Departamento departamento;

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.vista;

import ar.edu.ofa.jee7.tp.integrador.modelo.Departamento;
import ar.edu.ofa.jee7.tp.integrador.servicio.DepartamentoService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author mdominguez
 */
@ViewScoped
@Named("editDeptoView")
public class EditarDepartamentoView implements Serializable{

    @Inject HttpServletRequest req;
    
    @Inject
    private DepartamentoService deptoService;

    private Boolean editable;
    private Departamento departamento;
    private List<Departamento> departamentosDelUsuario;
    
    @PostConstruct
    public void init(){
        this.departamentosDelUsuario = deptoService.buscarTodos(req.getUserPrincipal().getName());
        editable = false;
    }
    
    public void cancelar(ActionEvent event) {
        this.departamento = null;
        editable=false;
    }   

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }
    
    public void editar(ActionEvent event) {
        editable=true;
    }   
    
    public void nuevo(ActionEvent event) {
        this.departamento = new Departamento();        
        editable=true;
    }   

    public void guardar(ActionEvent event) {
        System.out.println("GUardar "+departamento);
        if(departamento.getId()!=null && departamento.getId()>0){
            this.departamento = this.deptoService.actualizar(departamento);            
        }else{
            this.departamento= this.deptoService.crear(departamento,req.getUserPrincipal().getName());
        }
        // actualizar tabla
        this.departamentosDelUsuario = deptoService.buscarTodos(req.getUserPrincipal().getName());
        this.departamento=null;
        editable=false;
    }   

    public void borrar(ActionEvent event) {
        this.deptoService.borrar(departamento);            
        this.departamento = null;
        editable=false;    
        // actualizar tabla
        this.departamentosDelUsuario = deptoService.buscarTodos(req.getUserPrincipal().getName());
    }   
    
      public void onRowSelect(SelectEvent event) {
          this.departamento = (Departamento) event.getObject();
    }
 
    public void onRowUnselect(UnselectEvent event) {
        this.departamento = null;
    }

public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getDepartamentosDelUsuario() {
        return departamentosDelUsuario;
    }

    public void setDepartamentosDelUsuario(List<Departamento> departamentosDelUsuario) {
        this.departamentosDelUsuario = departamentosDelUsuario;
    }
    
    
    
}

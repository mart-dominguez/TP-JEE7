/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.vista;

import ar.edu.ofa.jee7.tp.integrador.modelo.Departamento;
import ar.edu.ofa.jee7.tp.integrador.modelo.Oferta;
import ar.edu.ofa.jee7.tp.integrador.servicio.BusquedaDepartamentosService;
import ar.edu.ofa.jee7.tp.integrador.servicio.OfertaService;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Named("buscarDeptoView")
public class BuscarDepartamentoView implements Serializable{

    @Inject HttpServletRequest req;
    
    @Inject
    private BusquedaDepartamentosService busqSrv;

    private List<Departamento> departamentosEncontrados;
    private Departamento departamentoSeleccionado;
    private Integer habitacionesMinimas;
    private Double  precioMinimo;
    private Date  fechaArribo;
    private Date  fechaPartida;
    
    private Oferta oferta;
    
    @Inject
    private OfertaService ofertaSrv;
    
    public void prepararOferta(ActionEvent evt){
        this.oferta = new Oferta();
        this.oferta.setMonto(this.departamentoSeleccionado.getPrecioMinimo());
    }
    
    public void ofertar(ActionEvent evt){
        this.ofertaSrv.hacerOferta(oferta, req.getUserPrincipal().getName(), departamentoSeleccionado);
        this.oferta = null;
    }
    
    public void buscar(ActionEvent event) {
        Boolean buscarPorFecha = (fechaArribo != null) && (fechaPartida!= null);
        Boolean buscarPorPrecio = (precioMinimo!=null) && (precioMinimo>0.0);
        Boolean buscarPorHabitaciones = habitacionesMinimas!=null && habitacionesMinimas>0;
        if(buscarPorFecha && buscarPorPrecio && buscarPorHabitaciones){
            this.departamentosEncontrados =busqSrv.buscarPorPrecioFechaHabitaciones(precioMinimo, fechaArribo, fechaPartida, habitacionesMinimas);
            return;
        }
        if(buscarPorHabitaciones){
            this.departamentosEncontrados =busqSrv.buscarHabitaciones(habitacionesMinimas);
            return;
        }
        if(buscarPorPrecio){
            this.departamentosEncontrados =busqSrv.buscarPorPrecio(precioMinimo);
            return;
        }
        if(buscarPorFecha){
            this.departamentosEncontrados =busqSrv.buscarPorFecha(fechaArribo, fechaPartida);
            return;
        }
    }
      public void onRowSelect(SelectEvent event) {
          this.departamentoSeleccionado = (Departamento) event.getObject();
    }
 
    public void onRowUnselect(UnselectEvent event) {
        this.departamentoSeleccionado = null;
    }

    public List<Departamento> getDepartamentosEncontrados() {
        return departamentosEncontrados;
    }

    public void setDepartamentosEncontrados(List<Departamento> departamentosDelEncontrados) {
        this.departamentosEncontrados = departamentosDelEncontrados;
    }

    public Departamento getDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    public void setDepartamentoSeleccionado(Departamento departamentoSeleccionado) {
        this.departamentoSeleccionado = departamentoSeleccionado;
    }

    public Integer getHabitacionesMinimas() {
        return habitacionesMinimas;
    }

    public void setHabitacionesMinimas(Integer habitacionesMinimas) {
        this.habitacionesMinimas = habitacionesMinimas;
    }

    public Double getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(Double precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    public Date getFechaArribo() {
        return fechaArribo;
    }

    public void setFechaArribo(Date fechaArribo) {
        this.fechaArribo = fechaArribo;
    }

    public Date getFechaPartida() {
        return fechaPartida;
    }

    public void setFechaPartida(Date fechaPartida) {
        this.fechaPartida = fechaPartida;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    
    
}

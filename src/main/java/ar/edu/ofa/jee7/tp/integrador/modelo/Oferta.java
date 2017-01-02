/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author martdominguez
 */
@Entity
@Table(name="TP_OFERTA")
public class Oferta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_OFERTA")
    private Usuario huesped;

    @ManyToOne
    @JoinColumn(name = "ID_DEPARTAMENTO")
    private Departamento departamento;
    
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_ENTRADA")
    private Date fechaEntrada;
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_SALIDA")
    private Date fechaSalida;
    private Double monto;
    @ManyToOne
    @JoinColumn(name = "ID_ESTADO")
    private Estado estado;

     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getHuesped() {
        return huesped;
    }

    public void setHuesped(Usuario huesped) {
        this.huesped = huesped;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Oferta{" + "id=" + id + ", huesped=" + huesped + ", departamento=" + departamento + ", estado=" + estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.estado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oferta other = (Oferta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}

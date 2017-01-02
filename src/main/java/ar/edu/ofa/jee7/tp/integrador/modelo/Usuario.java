/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author martdominguez
 */
@Entity
@Table(name="TP_USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.FindByName",query = "SELECT u FROM Usuario u WHERE u.nombre = :P_NOMBRE"),
    @NamedQuery(name = "Usuario.FindByMail",query = "SELECT u FROM Usuario u WHERE u.correo = :P_MAIL"),
    @NamedQuery(name = "Usuario.FindAll",query = "SELECT u FROM Usuario u ")
})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String correo;
    private String clave;
    
    @OneToMany(mappedBy = "propietario")
    private List<Departamento> propiedades;
    @OneToMany(mappedBy = "huesped")
    private List<Oferta> ofertas;  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Departamento> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Departamento> propiedades) {
        this.propiedades = propiedades;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + '}';
    }
    
    
}

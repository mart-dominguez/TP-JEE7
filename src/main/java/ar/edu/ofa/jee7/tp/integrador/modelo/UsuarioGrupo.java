/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 *
 * @author martdominguez
 */
@Entity
@Table(name="TP_USUARIO_GRUPO")
public class UsuarioGrupo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "ID_GRUPO")
    private GrupoUsuario grupo;
    
    @Column(name= "NOMBRE_GRUPO")
    private String nombreGrupo;
    @Column(name= "NOMBRE_USUARIO")
    private String nombreUsuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public GrupoUsuario getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoUsuario grupo) {
        this.grupo = grupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "UsuarioGrupo{" + "id=" + id + ", nombreGrupo=" + nombreGrupo + ", nombreUsuario=" + nombreUsuario + '}';
    }
    
    @PostLoad
    @PrePersist
    @PreUpdate
    public void guardarUsrGrp(){
        System.out.println("====guardarUsrGrp====1: "+this.toString());
        this.nombreGrupo = this.grupo.getGrupo();
        this.nombreUsuario = this.usuario.getCorreo();
        System.out.println("====guardarUsrGrp====2: "+this.toString());
    }
    
}

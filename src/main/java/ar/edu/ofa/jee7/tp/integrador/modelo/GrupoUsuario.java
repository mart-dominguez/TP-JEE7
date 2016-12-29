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
import javax.persistence.Table;

/**
 *
 * @author martdominguez
 */
@Entity
@Table(name="TP_GRUPO_USUARIO")
@NamedQueries({
    @NamedQuery(name = "GrupoUsuario.FindByName",query = "SELECT u FROM GrupoUsuario u WHERE u.grupo = :P_NOMBRE"),
    @NamedQuery(name = "GrupoUsuario.FindAll",query = "SELECT u FROM GrupoUsuario u ")
})
public class GrupoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String grupo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    
}

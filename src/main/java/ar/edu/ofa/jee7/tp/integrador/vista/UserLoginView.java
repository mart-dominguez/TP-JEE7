/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.vista;
import ar.edu.ofa.jee7.tp.integrador.servicio.UserService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
 
import org.primefaces.context.RequestContext;

@Named(value = "userLoginView")
@SessionScoped
public class UserLoginView implements Serializable{
    private String username;
    private String correo;
    private String password;
    
    @Inject 
    private UserService usrSrv;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
   
    
    public String login() {
        usrSrv.crearUsuarioFinal(username, correo,password);
        return "privado/promocion.xhtml";
    }   
}
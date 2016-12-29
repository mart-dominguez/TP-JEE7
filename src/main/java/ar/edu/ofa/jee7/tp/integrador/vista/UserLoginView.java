/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.vista;
import ar.edu.ofa.jee7.tp.integrador.modelo.Usuario;
import ar.edu.ofa.jee7.tp.integrador.servicio.UserService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "userLoginView")
@ViewScoped
public class UserLoginView implements Serializable{
    private String username;
    private String correo;
    private String password;

    boolean userCreado = false;

    public boolean isUserCreado() {
        return userCreado;
    }

    public void setUserCreado(boolean userCreado) {
        this.userCreado = userCreado;
    }
    
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
       
    public void login(ActionEvent event) {
        FacesMessage message = null;
        Usuario usr = usrSrv.crearUsuarioFinal(username, correo,password);         
        if(usr != null ) {
            userCreado = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "usuario creado exitosamente", username);
        } else {
            userCreado = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la creacion de usaurio", "datos invalidos");
        }         
        FacesContext.getCurrentInstance().addMessage(null, message);
    }   
}
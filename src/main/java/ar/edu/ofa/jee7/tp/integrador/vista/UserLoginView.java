/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.vista;
import ar.edu.ofa.jee7.tp.integrador.modelo.Usuario;
import ar.edu.ofa.jee7.tp.integrador.servicio.UserService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named(value = "userLoginView")
@SessionScoped
public class UserLoginView implements Serializable{
    private String username;
    private String correo;
    private String password;
    @Inject HttpServletRequest req;
            
    @Inject 
    private UserService usrSrv;
    
    boolean userCreado = false;
    private Usuario usr;
    
    @PostConstruct
    public void init(){
        if(req.getUserPrincipal()!=null && req.getUserPrincipal().getName()!=null){
            this.usr = usrSrv.buscarPorNombre(req.getUserPrincipal().getName());
        }
    }

    
    public boolean isUserCreado() {
        return userCreado;
    }

    public void setUserCreado(boolean userCreado) {
        this.userCreado = userCreado;
    }

 
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
       
    public void crear(ActionEvent event) {
        FacesMessage message = null;
        usr = usrSrv.crearUsuarioFinal(username, correo,password);         
        if(usr != null ) {
            userCreado = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "usuario creado exitosamente", username);
        } else {
            userCreado = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en la creacion de usaurio", "datos invalidos");
        }         
        FacesContext.getCurrentInstance().addMessage(null, message);
        this.limpiarForm();
    }   
    
    public String cerrarSesion(){
        req.getSession().invalidate();
         FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "inicio.xhtml?faces-redirect=true";
    }
    
    private void limpiarForm(){
        this.username=null;
        this.correo=null;
        this.password=null;   
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }
    
    
}
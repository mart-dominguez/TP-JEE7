/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.servicio;

import ar.edu.ofa.jee7.tp.integrador.modelo.GrupoUsuario;
import ar.edu.ofa.jee7.tp.integrador.modelo.Usuario;
import ar.edu.ofa.jee7.tp.integrador.modelo.UsuarioGrupo;
import ar.edu.ofa.jee7.tp.integrador.util.SecurityUtils;
import ar.edu.ofa.jee7.tp.integrador.util.TpEntityManager;
import ar.edu.ofa.jee7.tp.integrador.util.UsuarioAdmin;
import ar.edu.ofa.jee7.tp.integrador.util.UsuarioFinal;
import ar.edu.ofa.jee7.tp.integrador.util.UtilSeguridad;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author martdominguez
 */
@Named
@RequestScoped
@Transactional
public class UserServiceImpl implements UserService{

    @Inject @TpEntityManager
    private EntityManager em;

    @Inject 
    @UtilSeguridad
    private SecurityUtils seguridad;

    
    @Inject @UsuarioFinal 
    private String nombreGrupoUsuarioFinal;
    
    @Inject @UsuarioAdmin
    private String nombreGrupoAdmin;
    
    @Override
    public Usuario crearUsuarioFinal(String user, String correo,String password) {
        return this.crearUsuario(user, password, correo,this.getGrupoUsuarioFinal());
    }

    @Override
    public Usuario crearUsuarioAdministrador(String user, String correo,String password) {
        return this.crearUsuario(user, password,correo, this.getGrupoAdministrador());
    }        
  
    private Boolean existeNombre(String user){
        List<Usuario> lista = this.em.createNamedQuery("Usuario.FindByName").setParameter("P_NOMBRE", user).getResultList();
        return lista.size()> 0;
    }
    
    private Usuario crearUsuario(String user, String password,String correo,GrupoUsuario grupo) {
        if(this.existeNombre(user)) throw new RuntimeException("Nombre de usuario ya existe");
        else{
                Usuario usr = new Usuario();
                usr.setNombre(user);
                usr.setClave(seguridad.claveSHA256(password));
                usr.setCorreo(correo);
                this.em.persist(usr);
                UsuarioGrupo ug = new UsuarioGrupo();
                ug.setUsuario(usr);
                ug.setGrupo(grupo);
                this.em.persist(ug);
                //this.em.flush();
                //this.em.refresh(usr);
                return usr;
        }
    }
    
    private GrupoUsuario getGrupoAdministrador(){
        return buscarOCrearGrupoUsuario(nombreGrupoAdmin);
    }

    private GrupoUsuario getGrupoUsuarioFinal(){
        return buscarOCrearGrupoUsuario(nombreGrupoUsuarioFinal);
    }
    
    private GrupoUsuario buscarOCrearGrupoUsuario(String grupo){
        List<GrupoUsuario> lista = this.em.createNamedQuery("GrupoUsuario.FindByName").setParameter("P_NOMBRE", grupo).getResultList();
        GrupoUsuario grupoUsuario = null;
        if(!lista.isEmpty()){
            grupoUsuario = lista.get(0);
        }else{
            grupoUsuario = new GrupoUsuario();
            grupoUsuario.setGrupo(grupo);
            em.persist(grupoUsuario);
            em.flush();
            em.refresh(grupoUsuario);
        }
        return grupoUsuario;
    }

}

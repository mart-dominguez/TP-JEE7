/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.servicio;

import ar.edu.ofa.jee7.tp.integrador.modelo.Usuario;

/**
 *
 * @author martdominguez
 */
public interface UserService {
    public Usuario  buscarPorNombre(String correo);
    public Usuario  crearUsuarioFinal(String user,String correo,String password);
    public Usuario  crearUsuarioAdministrador(String user,String correo,String password);
}

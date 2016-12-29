/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ofa.jee7.tp.integrador.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mdominguez
 */
@RequestScoped
@UtilSeguridad
public class SecurityUtils {
    public String claveSHA256(String clave){
        String resultado = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(clave.getBytes("UTF-8")); // Change this to "UTF-16" if needed
            byte[] digest = md.digest();
            resultado = Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecurityUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SecurityUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}

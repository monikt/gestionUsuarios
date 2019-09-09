/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuentes;

/**
 *
 * @author pc lenovo
 */
public class UsuarioNoExisteExepcion extends Exception{
    
    String mensaje;

    public UsuarioNoExisteExepcion(String mensaje) {
        super(mensaje);
        this.mensaje = mensaje;
    }
    
    
}

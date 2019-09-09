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
public class Utilidades {

    private static Utilidades utilidad;

    public static Utilidades getInstance() {
        if (null == utilidad) {
            return new Utilidades();
        } else {
            return utilidad;
        }
    }

    public boolean validacionCampos() {
        return true;
    }
}

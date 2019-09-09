/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuentes.servicio;

import com.fuentes.UsuarioNoExisteExepcion;
import com.fuentes.entidades.Usuario;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author pc lenovo
 */
@Component
public class Servicio {

    @Autowired
    Repositorio repository;

    public void add(Usuario dto) {
        repository.save(dto);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Usuario> getUsuarios() {
        return (List<Usuario>) repository.findAll();
    }

    public Usuario getUsuarioyId(Integer id) throws UsuarioNoExisteExepcion {
        Optional<Usuario> optionalUsuario = repository.findById(id);
        if (optionalUsuario.isPresent()) {

            return optionalUsuario.get();
        } else {
            throw new UsuarioNoExisteExepcion("Valide el id que Ingresa no se encuentra en la bd");

        }
    }

    public String updateUser(Usuario user) {
        try {
            Usuario usuario = getUsuarioyId(user.getSecuenciaUsuario());
            usuario.setNumeroDocumento(user.getNumeroDocumento());
            usuario.setTipoDocumento(user.getTipoDocumento());
            usuario.setNombre(user.getNombre());
            usuario.setFechaModificacion(new Date());
            usuario.setEstado(user.getEstado());
            repository.save(usuario);
            return "Se ha actualizado de manera correcta el usuario";
        } catch (UsuarioNoExisteExepcion e) {
            return "No es posible actualizar el usuario por que no existe en la base de datos";
        }
    }

}

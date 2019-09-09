/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuentes;

import com.fuentes.entidades.Usuario;
import com.fuentes.servicio.Servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *
 * @author pc lenovo
 * 
 * 
 */
@RestController
public class Controlller {

    @Autowired
    Servicio service;

    @RequestMapping(value = "/eliminarUsuario/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>("Se ha eliminado de manera correcta el usuario", HttpStatus.OK);
    }

    @RequestMapping(value = "/UpdateUser", method = RequestMethod.PUT)
    public ResponseEntity<Object> ActualizarUsuario(@RequestBody Usuario usuario) {
        String respuesta = service.updateUser(usuario);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @RequestMapping(value = "/crearUsuario", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Usuario usuario) {
        service.add(usuario);
        return new ResponseEntity<>("Se ha creado de manera correcta el usuario", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/ObtenerUsuarios")
    public List<Usuario> getUsuarios() {
        return service.getUsuarios();
    }

    @RequestMapping(value = "/ObtenerUsuario/{id}")
    public Usuario getUsuarios(@PathVariable("id") Integer id) throws UsuarioNoExisteExepcion {
        return service.getUsuarioyId(id);
    }
}

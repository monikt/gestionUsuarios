/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuentes.servicio;

import com.fuentes.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc lenovo
 */
@Repository
public interface  Repositorio extends CrudRepository<Usuario, Integer>{

}

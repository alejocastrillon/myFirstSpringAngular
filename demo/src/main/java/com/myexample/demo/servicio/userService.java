/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myexample.demo.servicio;

import com.myexample.demo.model.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alejandro
 */
public interface userService {

    /**
     * Guarda un usuario en la BD
     * @param user
     * @return Usuario guardado
     */
    public User save(User user);

    /**
     * Retorna todos los usuarios existentes en la BD
     * @return Lista de Usuario
     */
    public List<User> findAll();
    
    /**
     * Elimina usuario en BD
     * @param user 
     */
    public void delete(User user);

    /**
     * Retorna el usuario de acuerdo al ID
     * @param id
     * @return 
     */
    public Optional<User> findById(Long id);
    
}

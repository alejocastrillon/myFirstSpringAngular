/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myexample.demo.servicio;

import com.myexample.demo.dao.userRepository;
import com.myexample.demo.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alejandro
 */
@Service
public class userServiceImpl implements userService{
    
    @Autowired
    protected userRepository repository;

    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(User user) {
        this.repository.delete(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.repository.findById(id);
    }
    
}

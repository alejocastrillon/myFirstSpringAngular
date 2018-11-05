/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myexample.demo.dao;

import com.myexample.demo.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alejandro
 */
public interface userRepository extends JpaRepository<User, Long>{
    
    @Override
    User save(User user);
    
    @Override
    List<User> findAll();
}

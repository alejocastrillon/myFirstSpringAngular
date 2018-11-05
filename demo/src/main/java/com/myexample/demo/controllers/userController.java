/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myexample.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myexample.demo.model.User;
import com.myexample.demo.servicio.userService;
import com.myexample.demo.util.QueryResult;
import com.myexample.demo.util.RestResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alejandro
 */
@RestController
public class userController {

    @Autowired
    protected userService service;

    protected ObjectMapper mapper;

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String userJson) throws IOException {
        this.mapper = new ObjectMapper();
        User user = this.mapper.readValue(userJson, User.class);
        if (!this.isValidUser(user)) {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los datos no han sido diligenciados completamente");
        }
        this.service.save(user);
        return new RestResponse(HttpStatus.OK.value(), "Se ha registrado el usuario");
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() {
        return this.service.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public RestResponse deleteUser(@PathVariable("id") User user) {
        if (user != null) {
            this.service.delete(user);
            return new RestResponse(HttpStatus.ACCEPTED.value(), "Usuario eliminado");
        }
        return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "El id no pertenece a ningún usuario");
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Optional<User> getUser(@PathVariable("id") Long iduser){
        return this.service.findById(iduser);
    }

    private boolean isValidUser(User user) {
        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            return false;
        } else if (user.getFirstSurname() == null || user.getFirstSurname().isEmpty()) {
            return false;
        } else if (user.getAddress() == null || user.getAddress().isEmpty()) {
            return false;
        }
        return true;
    }

}

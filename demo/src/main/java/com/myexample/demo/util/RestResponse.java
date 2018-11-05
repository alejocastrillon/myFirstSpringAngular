/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myexample.demo.util;

/**
 *
 * @author alejandro
 */
public class RestResponse {
    
    private int responseCode;
    private String message;

    public RestResponse(int responseCode) {
        this.responseCode = responseCode;
    }

    public RestResponse(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }
    
    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Fabio
 */
public class CaronaDAOException extends Exception {
    private final String message;

    CaronaDAOException(String message) {
        this.message = message;
    }
    
    public String info(){
        return message;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.excepciones;

import javax.ejb.ApplicationException;

/**
 *
 * @author DIFC
 */

@ApplicationException(rollback = true)
public class ReservaException extends Exception{
    
    public ReservaException(String mensaje){
        super(mensaje);
    }
    
}

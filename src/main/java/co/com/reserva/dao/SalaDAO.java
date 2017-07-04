/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.dao;

import co.com.reserva.BD.DataService;
import co.com.reserva.entidad.SalaDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DIFC
 */
@Stateless
public class SalaDAO {
    
    @EJB
    DataService dataService;
    
    public SalaDTO consultarSala(){
        return dataService.getSala1();
    }
    
}

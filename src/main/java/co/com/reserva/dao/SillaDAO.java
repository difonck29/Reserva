/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.dao;

import co.com.reserva.BD.DataService;
import co.com.reserva.entidad.FilaDTO;
import co.com.reserva.entidad.SalaDTO;
import co.com.reserva.entidad.SillaDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DIFC
 */

@Stateless
public class SillaDAO {
    
    @EJB
    DataService dataService;
    
    public SillaDTO consultarSilla(String codigo){
        
        SillaDTO sillaDTORespuesta=null;
        
        FOR: for(FilaDTO filaDTO: dataService.getSala1().getFilaDTOs()){
            for(SillaDTO sillaDTO: filaDTO.getSillaDTOs()){
                if(sillaDTO.getCodigo().equals(codigo)){
                    sillaDTORespuesta=sillaDTO;
                    break FOR;
                }
            }
        }
        return sillaDTORespuesta;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.dao;

import co.com.reserva.BD.DataService;
import co.com.reserva.entidad.ReservaDTO;
import co.com.reserva.excepciones.ReservaException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DIFC
 */
@Stateless
public class ReservaDAO {

    @EJB
    DataService dataservice;

    public void registrarReserva(ReservaDTO reservaDTO){
        DataService.setConsecutivoReserva(DataService.getConsecutivoReserva()+1);
        reservaDTO.setId(DataService.getConsecutivoReserva());
        dataservice.getReservaDTOs().add(reservaDTO);
    }
    
    public List<ReservaDTO> consultarReservas(){
        return dataservice.getReservaDTOs();
    }

}

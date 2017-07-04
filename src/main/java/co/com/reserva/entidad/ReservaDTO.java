/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.entidad;

import java.util.Date;
import java.util.List;

/**
 *
 * @author DIFC
 */
public class ReservaDTO {
    
    Integer id;
    List<SillaDTO> sillaDTOs;
    Date fechaReserva;
    Date fechaInicioReserva;
    Date fechaFinReserva;
    UsuarioDTO usuarioDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<SillaDTO> getSillaDTOs() {
        return sillaDTOs;
    }

    public void setSillaDTOs(List<SillaDTO> sillaDTOs) {
        this.sillaDTOs = sillaDTOs;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(Date fechaInicioReserva) {
        this.fechaInicioReserva = fechaInicioReserva;
    }

    public Date getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(Date fechaFinReserva) {
        this.fechaFinReserva = fechaFinReserva;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }



    
      
}

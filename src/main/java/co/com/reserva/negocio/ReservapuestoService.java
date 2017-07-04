/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.negocio;

import co.com.reserva.dao.ReservaDAO;
import co.com.reserva.dao.SalaDAO;
import co.com.reserva.dao.SillaDAO;
import co.com.reserva.entidad.ReservaDTO;
import co.com.reserva.entidad.SalaDTO;
import co.com.reserva.entidad.SillaDTO;
import co.com.reserva.entidad.UsuarioDTO;
import co.com.reserva.excepciones.ReservaException;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DIFC
 */

@Stateless
public class ReservapuestoService {
    
    @EJB
    SalaDAO salaDAO;
    
    @EJB
    ReservaDAO reservaDAO;
    
    @EJB
    SillaDAO sillaDAO;
    
    @EJB
    UsuarioService usuarioService;
        
    public SalaDTO consultarSala(){
       return salaDAO.consultarSala();
    }
    
    public void registrarReserva(ReservaDTO reservaDTO)throws ReservaException{
       
        if(reservaDTO!=null){
            if(reservaDTO.getSillaDTOs()!=null && !reservaDTO.getSillaDTOs().isEmpty() && reservaDTO.getUsuarioDTO()!=null && reservaDTO.getUsuarioDTO().getLogin()!=null){
                
                for(SillaDTO sillaDTO: reservaDTO.getSillaDTOs()){
                    SillaDTO sillaDTOAux=null;
                    sillaDTOAux=sillaDAO.consultarSilla(sillaDTO.getCodigo());
                    if(sillaDTOAux==null){
                        throw new ReservaException("La silla no se encuentra registrada en el sistema");
                    }else{
                        sillaDTO=sillaDTOAux;
                    }
                }
                
                UsuarioDTO usuarioDTO=usuarioService.consultarUsuario(reservaDTO.getUsuarioDTO().getLogin());
                
                if(usuarioDTO==null){
                    throw new ReservaException("La usuario no se encuentra registrado en el sistema");
                }else{
                    reservaDTO.setUsuarioDTO(usuarioDTO);
                }
                
                Date fechaActual=new Date();
                reservaDTO.setFechaReserva(fechaActual);
                reservaDTO.setFechaInicioReserva(fechaActual);
                                
                reservaDAO.registrarReserva(reservaDTO);
                
            }else{
              throw new ReservaException("Datos insuficientes para realizar la reserva");  
            }
        }else{
            throw new ReservaException("La Reserva es obligatoria");
        }
        
    }
    
    public List<ReservaDTO> consultarReservas(){
        return reservaDAO.consultarReservas();
    }
}

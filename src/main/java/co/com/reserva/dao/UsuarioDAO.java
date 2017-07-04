/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.dao;

import co.com.reserva.BD.DataService;
import co.com.reserva.entidad.UsuarioDTO;
import co.com.reserva.excepciones.ReservaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DIFC
 */
@Stateless
public class UsuarioDAO {

    private static List<UsuarioDTO> usuarios = new ArrayList<>();

    Logger logger = Logger.getLogger(getClass().getName());

    @EJB
    DataService dataService;

    public UsuarioDTO consultarUsuario(UsuarioDTO usuario){

        List<UsuarioDTO> usuarios = dataService.getUsuarios();

        UsuarioDTO usuarioRespuesta = null;

        if (usuario != null && usuario.getLogin() != null && usuario.getClave() != null) {
            for (UsuarioDTO usuarioDTO : usuarios) {

                if (usuario.getLogin().equals(usuarioDTO.getLogin())) {
                    usuarioRespuesta = usuarioDTO;
                    break;
                }
            }
        }

        return usuarioRespuesta;
    }
    
    public UsuarioDTO consultarUsuario(String login){

        List<UsuarioDTO> usuarios = dataService.getUsuarios();

        UsuarioDTO usuarioRespuesta = null;

            for (UsuarioDTO usuarioDTO : usuarios) {

                if (login.equals(usuarioDTO.getLogin())) {
                    usuarioRespuesta = usuarioDTO;
                    break;
                }
            }

        return usuarioRespuesta;
    }
    
}

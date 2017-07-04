/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.negocio;

import co.com.reserva.dao.UsuarioDAO;
import co.com.reserva.entidad.UsuarioDTO;
import co.com.reserva.excepciones.ReservaException;
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
public class UsuarioService {
    
    Logger logger = Logger.getLogger(getClass().getName());
    
    @EJB
    UsuarioDAO usuarioDAO;
    
    @PostConstruct
    public void init(){
        
    }
    
    public boolean autenticar(UsuarioDTO usuarioDTO){
       logger.log(Level.INFO,"autenticar(String,String)");
   
       usuarioDTO=usuarioDAO.consultarUsuario(usuarioDTO);
       
       boolean autenticado=false;
       
       if(usuarioDTO!=null){
           autenticado=true;
       }
       
       return autenticado;
    }
    
    public UsuarioDTO consultarUsuario(String login){
        return usuarioDAO.consultarUsuario(login);
    }
}

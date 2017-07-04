/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.managed_bean;

import co.com.reserva.entidad.UsuarioDTO;
import co.com.reserva.negocio.UsuarioService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author DIFC
 */

@SessionScoped
@ManagedBean
public class AutenticacionMB implements Serializable{
    
    UsuarioDTO usuarioDTO;
    
    @PostConstruct
    public void init(){
        System.out.println("Inicio AutenticacionMB");
        usuarioDTO=new UsuarioDTO();
    }
    
    @EJB
    UsuarioService usuarioService;
    
    public String autenticar(){
        System.out.println(usuarioDTO.getLogin());
        System.out.println(usuarioDTO.getClave());
        boolean autentico=usuarioService.autenticar(usuarioDTO);
        
        if(autentico){
            return "reserva";
        }else{
            return "";
        }
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }
    
    
}

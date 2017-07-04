/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.BD;

import co.com.reserva.entidad.FilaDTO;
import co.com.reserva.entidad.ReservaDTO;
import co.com.reserva.entidad.SalaDTO;
import co.com.reserva.entidad.SillaDTO;
import co.com.reserva.entidad.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author DIFC
 */
@Singleton
public class DataService {

    List<UsuarioDTO> usuarios = new ArrayList<>();

    SalaDTO sala1;

    List<ReservaDTO> reservaDTOs = new ArrayList<>();
    
    public static int consecutivoReserva=1;

    @PostConstruct
    public void cargarDatos() {
        System.out.println("Cargar datos");
        UsuarioDTO usuario1 = new UsuarioDTO();
        usuario1.setId(1);
        usuario1.setLogin("daniel");
        usuario1.setClave("Abcd1234");

        UsuarioDTO usuario2 = new UsuarioDTO();
        usuario2.setId(2);
        usuario2.setLogin("daom23");
        usuario2.setClave("android");

        UsuarioDTO usuario3 = new UsuarioDTO();
        usuario3.setId(3);
        usuario3.setLogin("laura.acosta");
        usuario3.setClave("password");

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        sala1 = new SalaDTO();
        sala1.setId(1);
        sala1.setCodigo("Sala1");
        sala1.setFilaDTOs(new ArrayList<FilaDTO>());

        int count = 1;
        for (int i = 1; i <= 20; i++) {
            FilaDTO filaDTO = new FilaDTO();
            filaDTO.setId(i);
            filaDTO.setCodigo(String.valueOf((char) (64 + i)));
            filaDTO.setSillaDTOs(new ArrayList<SillaDTO>());
            for (int j = 1; j <= 10; j++) {
                SillaDTO sillaDTO = new SillaDTO();
                sillaDTO.setId(count);
                sillaDTO.setCodigo(String.valueOf((char) (64 + i)) + "" + j);
                filaDTO.getSillaDTOs().add(sillaDTO);
            }
            sala1.getFilaDTOs().add(filaDTO);
        }

    }

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public SalaDTO getSala1() {
        return sala1;
    }

    public List<ReservaDTO> getReservaDTOs() {
        return reservaDTOs;
    }

    public static int getConsecutivoReserva() {
        return consecutivoReserva;
    }

    public static void setConsecutivoReserva(int consecutivoReserva) {
        DataService.consecutivoReserva = consecutivoReserva;
    }
    
    

}

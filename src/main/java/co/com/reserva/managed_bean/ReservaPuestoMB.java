/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.managed_bean;

import co.com.reserva.entidad.FilaDTO;
import co.com.reserva.entidad.ReservaDTO;
import co.com.reserva.entidad.SalaDTO;
import co.com.reserva.entidad.SillaDTO;
import co.com.reserva.entidad.UsuarioDTO;
import co.com.reserva.excepciones.ReservaException;
import co.com.reserva.negocio.ReservapuestoService;
import co.com.reserva.negocio.UsuarioService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DIFC
 */
@ManagedBean
@SessionScoped
public class ReservaPuestoMB implements Serializable {

    List<String> fila1;
    List<String> fila2;
    List<String> fila3;
    List<String> fila4;
    List<String> fila5;
    List<String> fila6;
    List<String> fila7;
    List<String> fila8;
    List<String> fila9;
    List<String> fila10;
    List<String> fila11;
    List<String> fila12;
    List<String> fila13;
    List<String> fila14;
    List<String> fila15;
    List<String> fila16;
    List<String> fila17;
    List<String> fila18;
    List<String> fila19;
    List<String> fila20;

    List<List<SelectItem>> filaAux = new ArrayList<>();

    @EJB
    ReservapuestoService reservaPuestoService;

    @EJB
    UsuarioService usuarioService;

    @PostConstruct
    public void init() {
        System.out.println("Se ejecuto");
        //filaAux

        SalaDTO salaDTO = reservaPuestoService.consultarSala();

        for (FilaDTO filaDTOAux : salaDTO.getFilaDTOs()) {
            filaAux.add(new ArrayList<SelectItem>());
            for (SillaDTO sillaDTOAux : filaDTOAux.getSillaDTOs()) {
                filaAux.get(filaAux.size() - 1).add(new SelectItem(sillaDTOAux.getCodigo(), sillaDTOAux.getCodigo()));
            }
        }

//        for (SillaDTO sillaDTO : reservaPuestoService.consultarSala().getFilaDTOs().get(0).getSillaDTOs()) {
//            listaSeleccionada1.add(new SelectItem(sillaDTO.getCodigo(), sillaDTO.getCodigo()));
//            System.out.println(sillaDTO.getCodigo());
//        }
        List<ReservaDTO> reservaDTOs = reservaPuestoService.consultarReservas();

        int contador = 1;
        for (FilaDTO filaDTO : salaDTO.getFilaDTOs()) {
            List<String> sillas = new ArrayList<>();
            for (SillaDTO sillaDTOAux : filaDTO.getSillaDTOs()) {
                for (ReservaDTO reservaDTO : reservaDTOs) {
                    for (SillaDTO sillaDTOAux2 : reservaDTO.getSillaDTOs()) {
                        if (sillaDTOAux.getCodigo().equals(sillaDTOAux2.getCodigo())) {
                            sillas.add(sillaDTOAux2.getCodigo());
                        }
                    }
                }
            }
            System.out.println(sillas);
            adicionarSilla(sillas, contador);
            contador++;
        }

        FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        AutenticacionMB autenticacionMB = (AutenticacionMB) session.getAttribute("autenticacionMB");

        System.out.println(autenticacionMB.usuarioDTO.getLogin());

    }

    public List<String> getFila1() {
        return fila1;
    }

    public void setFila1(List<String> fila1) {
        this.fila1 = fila1;
    }

    public List<String> getFila2() {
        return fila2;
    }

    public void setFila2(List<String> fila2) {
        this.fila2 = fila2;
    }

    public List<String> getFila3() {
        return fila3;
    }

    public void setFila3(List<String> fila3) {
        this.fila3 = fila3;
    }

    public List<String> getFila4() {
        return fila4;
    }

    public void setFila4(List<String> fila4) {
        this.fila4 = fila4;
    }

    public List<String> getFila5() {
        return fila5;
    }

    public void setFila5(List<String> fila5) {
        this.fila5 = fila5;
    }

    public List<String> getFila6() {
        return fila6;
    }

    public void setFila6(List<String> fila6) {
        this.fila6 = fila6;
    }

    public List<String> getFila7() {
        return fila7;
    }

    public void setFila7(List<String> fila7) {
        this.fila7 = fila7;
    }

    public List<String> getFila8() {
        return fila8;
    }

    public void setFila8(List<String> fila8) {
        this.fila8 = fila8;
    }

    public List<String> getFila9() {
        return fila9;
    }

    public void setFila9(List<String> fila9) {
        this.fila9 = fila9;
    }

    public List<String> getFila10() {
        return fila10;
    }

    public void setFila10(List<String> fila10) {
        this.fila10 = fila10;
    }

    public List<String> getFila11() {
        return fila11;
    }

    public void setFila11(List<String> fila11) {
        this.fila11 = fila11;
    }

    public List<String> getFila12() {
        return fila12;
    }

    public void setFila12(List<String> fila12) {
        this.fila12 = fila12;
    }

    public List<String> getFila13() {
        return fila13;
    }

    public void setFila13(List<String> fila13) {
        this.fila13 = fila13;
    }

    public List<String> getFila14() {
        return fila14;
    }

    public void setFila14(List<String> fila14) {
        this.fila14 = fila14;
    }

    public List<String> getFila15() {
        return fila15;
    }

    public void setFila15(List<String> fila15) {
        this.fila15 = fila15;
    }

    public List<String> getFila16() {
        return fila16;
    }

    public void setFila16(List<String> fila16) {
        this.fila16 = fila16;
    }

    public List<String> getFila17() {
        return fila17;
    }

    public void setFila17(List<String> fila17) {
        this.fila17 = fila17;
    }

    public List<String> getFila18() {
        return fila18;
    }

    public void setFila18(List<String> fila18) {
        this.fila18 = fila18;
    }

    public List<String> getFila19() {
        return fila19;
    }

    public void setFila19(List<String> fila19) {
        this.fila19 = fila19;
    }

    public List<String> getFila20() {
        return fila20;
    }

    public void setFila20(List<String> fila20) {
        this.fila20 = fila20;
    }

    public void registrarReserva() {
        System.out.println(fila1);
        System.out.println(fila2);
        System.out.println(fila3);
        System.out.println(fila4);
        System.out.println(fila5);
        System.out.println(fila6);
        System.out.println(fila7);
        System.out.println(fila8);
        System.out.println(fila9);
        System.out.println(fila10);
        System.out.println(fila11);
        System.out.println(fila12);
        System.out.println(fila13);
        System.out.println(fila14);
        System.out.println(fila15);
        System.out.println(fila16);
        System.out.println(fila17);
        System.out.println(fila18);
        System.out.println(fila19);
        System.out.println(fila20);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setLogin("daom23");
        usuarioDTO.setClave("android");
        System.out.println(usuarioService.autenticar(usuarioDTO));
        usuarioDTO = usuarioService.consultarUsuario(usuarioDTO.getLogin());
        System.out.println("Id usuario : " + usuarioDTO.getId());
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setUsuarioDTO(usuarioDTO);
        reservaDTO.setSillaDTOs(new ArrayList<SillaDTO>());

        agregarSillasReserva(reservaDTO.getSillaDTOs());

        try {
            reservaPuestoService.registrarReserva(reservaDTO);
        } catch (ReservaException ex) {
            Logger.getLogger(ReservaPuestoMB.class.getName()).log(Level.SEVERE, null, ex);
        }

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Successful", "Reserva exitosa"));
    }

    public List<List<SelectItem>> getFilaAux() {
        return filaAux;
    }

    public void setFilaAux(List<List<SelectItem>> filaAux) {
        this.filaAux = filaAux;
    }

    private void adicionarSilla(List<String> sillas, int contador) {
        switch (contador) {
            case 1:
                if (!sillas.isEmpty()) {
                    fila1 = sillas;
                }
                break;
            case 2:
                if (!sillas.isEmpty()) {
                    fila2 = sillas;
                }
                break;
            case 3:
                if (!sillas.isEmpty()) {
                    fila3 = sillas;
                }
                break;
            case 4:
                if (!sillas.isEmpty()) {
                    fila4 = sillas;
                }
                break;
            case 5:
                if (!sillas.isEmpty()) {
                    fila5 = sillas;
                }
                break;
            case 6:
                if (!sillas.isEmpty()) {
                    fila6 = sillas;
                }
                break;
            case 7:
                if (!sillas.isEmpty()) {
                    fila7 = sillas;
                }
                break;
            case 8:
                if (!sillas.isEmpty()) {
                    fila8 = sillas;
                }
                break;
            case 9:
                if (!sillas.isEmpty()) {
                    fila9 = sillas;
                }
                break;
            case 10:
                if (!sillas.isEmpty()) {
                    fila10 = sillas;
                }
                break;
            case 11:
                if (!sillas.isEmpty()) {
                    fila11 = sillas;
                }
                break;
            case 12:
                if (!sillas.isEmpty()) {
                    fila12 = sillas;
                }
                break;
            case 13:
                if (!sillas.isEmpty()) {
                    fila13 = sillas;
                }
                break;
            case 14:
                if (!sillas.isEmpty()) {
                    fila14 = sillas;
                }
                break;
            case 15:
                if (!sillas.isEmpty()) {
                    fila15 = sillas;
                }
                break;
            case 16:
                if (!sillas.isEmpty()) {
                    fila16 = sillas;
                }
                break;
            case 17:
                if (!sillas.isEmpty()) {
                    fila17 = sillas;
                }
                break;
            case 18:
                if (!sillas.isEmpty()) {
                    fila18 = sillas;
                }
                break;
            case 19:
                if (!sillas.isEmpty()) {
                    fila19 = sillas;
                }
                break;
            case 20:
                if (!sillas.isEmpty()) {
                    fila20 = sillas;
                }
                break;
        }
    }

    private void agregarSillasReserva(List<SillaDTO> sillaDTOs) {
        if (!fila1.isEmpty()) {
            agregarSilla(sillaDTOs, fila1);
        }
        if (!fila2.isEmpty()) {
            agregarSilla(sillaDTOs, fila2);
        }
        if (!fila3.isEmpty()) {
            agregarSilla(sillaDTOs, fila3);    
        }
        if (!fila4.isEmpty()) {
            agregarSilla(sillaDTOs, fila4);    
        }
        if (!fila5.isEmpty()) {
            agregarSilla(sillaDTOs, fila5);    
        }
        if (!fila6.isEmpty()) {
            agregarSilla(sillaDTOs, fila6);
        }
        if (!fila7.isEmpty()) {
            agregarSilla(sillaDTOs, fila7);
        }
        if (!fila8.isEmpty()) {
            agregarSilla(sillaDTOs, fila8);    
        }
        if (!fila9.isEmpty()) {
            agregarSilla(sillaDTOs, fila9);
        }
        if (!fila10.isEmpty()) {
            agregarSilla(sillaDTOs, fila10);    
        }
        if (!fila11.isEmpty()) {
            agregarSilla(sillaDTOs, fila11);
        }
        if (!fila12.isEmpty()) {
            agregarSilla(sillaDTOs, fila12);
        }
        if (!fila13.isEmpty()) {
            agregarSilla(sillaDTOs, fila13);
        }
        if (!fila14.isEmpty()) {
            agregarSilla(sillaDTOs, fila14);
        }
        if (!fila15.isEmpty()) {
            agregarSilla(sillaDTOs, fila15);
        }
//        if (!fila16.isEmpty()) {
//            agregarSilla(sillaDTOs, fila16);
//        }
//        if (!fila17.isEmpty()) {
//            agregarSilla(sillaDTOs, fila17);
//        }
//        if (!fila18.isEmpty()) {
//            agregarSilla(sillaDTOs, fila18);
//        }
//        if (!fila19.isEmpty()) {
//            agregarSilla(sillaDTOs, fila19);
//        }
//        if (!fila20.isEmpty()) {
//            agregarSilla(sillaDTOs, fila20);
//        }

    }

    private void agregarSilla(List<SillaDTO> sillaDTOs, List<String> sillasSeleccionadas) {
        for (String fila : sillasSeleccionadas) {
            SillaDTO sillaDTO = new SillaDTO();
            sillaDTO.setCodigo(fila);
            sillaDTOs.add(sillaDTO);
        }
    }

}

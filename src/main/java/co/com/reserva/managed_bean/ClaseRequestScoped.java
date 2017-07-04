/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.managed_bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author DIFC
 */
@ManagedBean
@RequestScoped
public class ClaseRequestScoped {
    
    @ManagedProperty(value = "#{reservaPuestoMB}")
    ReservaPuestoMB reservaPuestoMB;

    public ReservaPuestoMB getReservaPuestoMB() {
        return reservaPuestoMB;
    }

    public void setReservaPuestoMB(ReservaPuestoMB reservaPuestoMB) {
        this.reservaPuestoMB = reservaPuestoMB;
    }


    
    
}

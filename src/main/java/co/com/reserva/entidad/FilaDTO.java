/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.reserva.entidad;

import java.util.List;

/**
 *
 * @author DIFC
 */
public class FilaDTO {
    private Integer id;
    private String codigo;
    private List<SillaDTO> sillaDTOs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<SillaDTO> getSillaDTOs() {
        return sillaDTOs;
    }

    public void setSillaDTOs(List<SillaDTO> sillaDTOs) {
        this.sillaDTOs = sillaDTOs;
    }
    
    
}

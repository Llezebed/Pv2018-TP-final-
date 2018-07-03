/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.modelo.dominio.Cartelera;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alumno
 */
@ManagedBean
@Dependent
public class CarteleraFormBean {

    private Cartelera cartelera;

    
    /**
     * Get the value of cartelera
     *
     * @return the value of cartelera
     */
    public Cartelera getCartelera() {
        return cartelera;
    }

    /**
     * Set the value of cartelera
     *
     * @param cartelera new value of cartelera
     */
    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

    /**
     * Creates a new instance of CarteleraFormBean
     */
    public CarteleraFormBean() {
    }
    
}

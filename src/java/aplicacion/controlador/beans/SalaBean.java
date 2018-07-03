/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.SalaDAO;
import aplicacion.datos.hibernate.dao.imp.SalaDAOImp;
import aplicacion.modelo.dominio.Sala;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class SalaBean {

    public SalaBean() {
    }

    public Sala consultarSala(int salas){
        Sala sala=null;
        SalaDAO salaDAO=new SalaDAOImp();
        sala=salaDAO.consulta(salas);
        return sala;
    }
}

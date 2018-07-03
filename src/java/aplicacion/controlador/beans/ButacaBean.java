/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.ButacaDAO;
import aplicacion.datos.hibernate.dao.imp.ButacaDAOImp;
import aplicacion.modelo.dominio.Butaca;
import aplicacion.modelo.dominio.Sala;
import java.util.List;

/**
 *
 * @author alumno
 */
public class ButacaBean {

    public ButacaBean() {
    }
    public List<Butaca> listarButacas(Sala butac){
      ButacaDAO butacaDAO=new ButacaDAOImp();
      return butacaDAO.obtenerTodos();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.VentaEntradaDAO;
import aplicacion.datos.hibernate.dao.imp.VentaEntradaDAOImp;
import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.VentaEntrada;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Alumno
 */
@ManagedBean
@ViewScoped
public class VentaEntradaBean {

    /**
     * Creates a new instance of VentaEntradaBean
     */
    public VentaEntradaBean() {
    }
    public void agregarVentaEntrada(VentaEntrada unVentaEntrada){
        VentaEntradaDAO ventaEntradaDAO=new VentaEntradaDAOImp();
        ventaEntradaDAO.agregar(unVentaEntrada);
    }
    public List<VentaEntrada> listarVentaEntrada(){
        VentaEntradaDAO ventaEntradaDAO=new VentaEntradaDAOImp();
        return ventaEntradaDAO.obtenerTodos();
    }
    public void modificarVentaEntrada(VentaEntrada unVentaEntrada){
        VentaEntradaDAO ventaEntradaDAO=new VentaEntradaDAOImp();
        ventaEntradaDAO.modificar(unVentaEntrada);
    }
     public VentaEntrada consulta(ButacaCartelera butacaCar,Perfil perf,String nombreUs,String passwdUs){
        VentaEntrada ventaEntrada=null;
        VentaEntradaDAO ventaEntradaDAO=new VentaEntradaDAOImp();
        ventaEntrada= ventaEntradaDAO.consulta(butacaCar, perf, nombreUs, passwdUs);
        return ventaEntrada;
        
    }
}

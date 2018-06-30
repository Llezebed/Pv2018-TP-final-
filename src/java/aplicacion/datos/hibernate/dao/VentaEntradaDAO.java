/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.VentaEntrada;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public interface VentaEntradaDAO {
    ArrayList<VentaEntrada> obtenerTodos();
    VentaEntrada consulta(ButacaCartelera butacaCar,Perfil perf,String venPre,String venDescrip);
    void modificar (VentaEntrada venta);
    void agregar (VentaEntrada venta);
    void eliminar (VentaEntrada venta);
}

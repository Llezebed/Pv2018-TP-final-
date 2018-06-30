/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Cartelera;
import java.util.ArrayList;



/**
 *
 * @author sandra
 */
public interface CarteleraDAO {
    ArrayList<Cartelera> obtenerTodos();
    void modificar (Cartelera cartelera);
    void agregar (Cartelera cartelera);
    void eliminar (Cartelera cartelera);
}

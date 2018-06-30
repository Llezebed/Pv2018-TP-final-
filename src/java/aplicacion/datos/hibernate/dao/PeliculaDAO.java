/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Pelicula;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public interface PeliculaDAO {
    ArrayList<Pelicula> obtenerTodos();
    Pelicula consulta(String peNombre,String peDescrip);
    void modificar (Pelicula pelicula);
    void agregar (Pelicula pelicula);
    void eliminar (Pelicula pelicula);
}

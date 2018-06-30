/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Director;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public interface DirectorDAO {
    ArrayList<Director> obtenerTodos();
    Director consulta(String direcApellidos,String direcNombres);
    void modificar (Director director);
    void agregar (Director director);
    void eliminar (Director director);
}

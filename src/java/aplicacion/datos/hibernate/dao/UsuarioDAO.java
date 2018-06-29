/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Florencia
 */
public interface UsuarioDAO {
    ArrayList<Usuario> obtenerTodos();
    Usuario consulta(String nombreUsuario,String passwd);
    void modificar (Usuario usuario);
     void agregar (Usuario usuario);
      void eliminar (Usuario usuario);
}

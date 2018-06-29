/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Perfil;
import java.util.ArrayList;

/**
 *
 * @author Florencia
 */
public interface PerfilDAO {
    ArrayList<Perfil> obtenerTodos();
    Perfil consulta(String nombreUsuario,String passwd);
    void modificar (Perfil unPerfil);
     void agregar (Perfil unPerfil);
      void eliminar (Perfil unPerfil);
}

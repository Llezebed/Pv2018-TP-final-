/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Perfil;
//import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Florencia
 */
public interface PerfilDAO {
    List<Perfil> obtenerTodos();
    Perfil obtenerPerfil(String usuario);
    Perfil consulta(String nombreUsuario,String passwd);
    void modificar (Perfil unPerfil);
    void agregar (Perfil unPerfil);
    void eliminar (Perfil unPerfil);
}

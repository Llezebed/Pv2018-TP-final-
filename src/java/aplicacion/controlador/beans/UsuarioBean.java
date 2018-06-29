/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.UsuarioDAO;
import aplicacion.datos.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Florencia
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        
    }
     
    public Usuario validarUsuario(String nombreUs,String passwdUs){
        Usuario usuario=null;
        UsuarioDAO usuarioDAO=new UsuarioDAOImp();
        
        usuario= usuarioDAO.consulta(nombreUs,passwdUs);
        return usuario;
        
    }
    public List<Usuario> obtenerUsuarios(){
        UsuarioDAO usuarioDAO=new UsuarioDAOImp();
        return usuarioDAO.obtenerTodos();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.modelo.dominio.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Fer
 */
@ManagedBean
@ViewScoped
public class UsuarioFormBean {
    @ManagedProperty(value="#{UsuarioBean}")
    private UsuarioBean usuariosb;
    private Integer usuCodigo;
    private String usuNombreUsuario;
    private String usuPassword;
    private String usuTipoUsuario;
    private boolean usuEstado;
    private List<Usuario> listaUsuarios;
    
    /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() {
        usuariosb=new UsuarioBean();
        listarUsuarios();
    }
    private void listarUsuarios(){
        setListaUsuarios(getUsuariosb().obtenerUsuarios());
    }
    
     public String redirreccionDirectores(){
      String resultado="/Directores";
      return resultado;
  }

    /**
     * @return the usuariosb
     */
    public UsuarioBean getUsuariosb() {
        return usuariosb;
    }

    /**
     * @param usuariosb the usuariosb to set
     */
    public void setUsuariosb(UsuarioBean usuariosb) {
        this.usuariosb = usuariosb;
    }

    /**
     * @return the usuCodigo
     */
    public Integer getUsuCodigo() {
        return usuCodigo;
    }

    /**
     * @param usuCodigo the usuCodigo to set
     */
    public void setUsuCodigo(Integer usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    /**
     * @return the usuNombreUsuario
     */
    public String getUsuNombreUsuario() {
        return usuNombreUsuario;
    }

    /**
     * @param usuNombreUsuario the usuNombreUsuario to set
     */
    public void setUsuNombreUsuario(String usuNombreUsuario) {
        this.usuNombreUsuario = usuNombreUsuario;
    }

    /**
     * @return the usuPassword
     */
    public String getUsuPassword() {
        return usuPassword;
    }

    /**
     * @param usuPassword the usuPassword to set
     */
    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    /**
     * @return the usuTipoUsuario
     */
    public String getUsuTipoUsuario() {
        return usuTipoUsuario;
    }

    /**
     * @param usuTipoUsuario the usuTipoUsuario to set
     */
    public void setUsuTipoUsuario(String usuTipoUsuario) {
        this.usuTipoUsuario = usuTipoUsuario;
    }

    /**
     * @return the usuEstado
     */
    public boolean isUsuEstado() {
        return usuEstado;
    }

    /**
     * @param usuEstado the usuEstado to set
     */
    public void setUsuEstado(boolean usuEstado) {
        this.usuEstado = usuEstado;
    }

    /**
     * @return the listaUsuarios
     */
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * @param listaUsuarios the listaUsuarios to set
     */
    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * @return the listaUsuarios
     */

    /**
     * @return the listaUsuarios
     */
    
}

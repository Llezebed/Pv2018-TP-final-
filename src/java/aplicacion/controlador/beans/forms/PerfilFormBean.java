/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.PerfilBean;
import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fer
 */
@ManagedBean
@ViewScoped
public class PerfilFormBean {

     private int usucod;
    @ManagedProperty(value = "#{PerfilBean}")
    private PerfilBean perfilBean;
    @ManagedProperty(value = "#{UsuarioBean}")
    private UsuarioBean usuarioBean;
    private Usuario unUsuario;
    private Perfil unPerfil;
    private String nombreUs;
    private String passwUs;
    private String tipo;
    private String nombres;
    private String apellidos;
    private boolean busqueda;
    private List<Perfil> perfilesEncontrados;
    private String dni;

    public PerfilFormBean() {
        perfilBean = new PerfilBean();
        listarPerfiles();
    }

    private void listarPerfiles() {
        setPerfilesEncontrados(getPerfilBean().listarPerfiles());
    }

    public void establecerPerfil(Perfil per) {
        setUnPerfil(per);
    }

    public void modificarPerfil() {
        unUsuario = new Usuario(getUsucod(), getNombreUs(), getPasswUs(), getTipo(), true);
        unPerfil = new Perfil(getUnUsuario(), getNombres(), getApellidos(), "11111", new Date(), "email", "direcion", true);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario ha sido modificado", null);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);

    }

    public void agregarPerfil() {
        unUsuario = new Usuario(5, getNombreUs(), getPasswUs(), getTipo(), true);
        
        unPerfil = new Perfil(getUnUsuario(), getNombres(), getApellidos(), "11111", new Date(), "email", "direcion", true);
        

        try {
            System.out.println("estoy en el TRY....."+ unUsuario.getUsuCodigo().toString());
            usuarioBean.agregarUsuario(unUsuario);
            //perfilBean.agregarPerfil(unPerfil);
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Felicidades!", "Usuario creado con exito");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } catch (Exception e) {
            FacesMessage faceMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "El usuario no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, faceMessage);
        }
        FacesMessage facesMessage2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Felicidades!", "Usuario creado con exito");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage2);
        listarPerfiles();
    }

    public void eliminarPerfil() {
        getUnPerfil().getUsuarios().setUsuEstado(false);
        getUnPerfil().setPerEstado(false);
        perfilBean.modificarPerfil(getUnPerfil());
        listarPerfiles();
    }

    /**
     * @return the perfilBean
     */
    public PerfilBean getPerfilBean() {
//        Perfil consultado = null;
//        PerfilDAO pd = new PerfilDAOImp();
//        consultado = pd.obtenerPerfil(getNombreUs());
//        setUnPerfil(consultado);
        return perfilBean;
    }

    /**
     * @param perfilBean the perfilBean to set
     */
    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    /**
     * @return the unUsuario
     */
    public Usuario getUnUsuario() {
        return unUsuario;
    }

    /**
     * @param unUsuario the unUsuario to set
     */
    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    /**
     * @return the unPerfil
     */
    public Perfil getUnPerfil() {
        return unPerfil;
    }

    /**
     * @param unPerfil the unPerfil to set
     */
    public void setUnPerfil(Perfil unPerfil) {
        this.unPerfil = unPerfil;
    }

    /**
     * @return the nombreUs
     */
    public String getNombreUs() {
        return nombreUs;
    }

    /**
     * @param nombreUs the nombreUs to set
     */
    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    /**
     * @return the passwUs
     */
    public String getPasswUs() {
        return passwUs;
    }

    /**
     * @param passwUs the passwUs to set
     */
    public void setPasswUs(String passwUs) {
        this.passwUs = passwUs;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the busqueda
     */
    public boolean isBusqueda() {
        return busqueda;
    }

    /**
     * @param busqueda the busqueda to set
     */
    public void setBusqueda(boolean busqueda) {
        this.busqueda = busqueda;
    }

    /**
     * @return the perfilesEncontrados
     */
    public List<Perfil> getPerfilesEncontrados() {
        return perfilesEncontrados;
    }

    /**
     * @param perfilesEncontrados the perfilesEncontrados to set
     */
    public void setPerfilesEncontrados(List<Perfil> perfilesEncontrados) {
        this.perfilesEncontrados = perfilesEncontrados;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the usucod
     */
    public int getUsucod() {
        return usucod;
    }

    /**
     * @param usucod the usucod to set
     */
    public void setUsucod(int usucod) {
        this.usucod = usucod;
    }

    /**
     * @return the usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * @param usuarioBean the usuarioBean to set
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

}

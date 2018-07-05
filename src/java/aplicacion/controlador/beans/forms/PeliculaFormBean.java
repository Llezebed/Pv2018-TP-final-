/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.PeliculaBean;
import aplicacion.modelo.dominio.Pelicula;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author alumno
 */

public class PeliculaFormBean {
    @ManagedProperty(value="#{peliculasBean}")
    private PeliculaBean peliculasBean;
    private String pelNombre;
    private String pelDescripcion;
    private boolean pelEstado;
    private Pelicula unaPelicula;
    private List<Pelicula> peliculasEncontradas;

    /**
     * Creates a new instance of PeliculaFormBean
     */
    public PeliculaFormBean() {
        peliculasBean = new PeliculaBean();
        listarPeliculas();
    }
    
    private void listarPeliculas() {
        setPeliculasEncontradas(getPeliculasBean().listarPelicula());
    }

    public void establecerPerfil(Pelicula per) {
        setUnaPelicula(per);
    }
    public void agregarPerfil(){
        setUnaPelicula(new Pelicula(getPelNombre(),getPelDescripcion(),true));
        try{
            getPeliculasBean().agregarPelicula(getUnaPelicula());
        }
        catch (Exception e){
            FacesMessage facesMessage= new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","El usuario no se a podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Felicidades!","Usuario creado con exito");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarPeliculas();
    }
    public void eliminarPerfil(){
        getUnaPelicula().setPelEstado(false);
        getPeliculasBean().modificarPelicula(getUnaPelicula());
        listarPeliculas();
    }

    /**
     * @return the peliculasBean
     */
    public PeliculaBean getPeliculasBean() {
        return peliculasBean;
    }

    /**
     * @param peliculasBean the peliculasBean to set
     */
    public void setPeliculasBean(PeliculaBean peliculasBean) {
        this.peliculasBean = peliculasBean;
    }

    /**
     * @return the pelNombre
     */
    public String getPelNombre() {
        return pelNombre;
    }

    /**
     * @param pelNombre the pelNombre to set
     */
    public void setPelNombre(String pelNombre) {
        this.pelNombre = pelNombre;
    }

    /**
     * @return the pelDescripcion
     */
    public String getPelDescripcion() {
        return pelDescripcion;
    }

    /**
     * @param pelDescripcion the pelDescripcion to set
     */
    public void setPelDescripcion(String pelDescripcion) {
        this.pelDescripcion = pelDescripcion;
    }

    /**
     * @return the pelEstado
     */
    public boolean isPelEstado() {
        return pelEstado;
    }

    /**
     * @param pelEstado the pelEstado to set
     */
    public void setPelEstado(boolean pelEstado) {
        this.pelEstado = pelEstado;
    }

    /**
     * @return the unaPelicula
     */
    public Pelicula getUnaPelicula() {
        return unaPelicula;
    }

    /**
     * @param unaPelicula the unaPelicula to set
     */
    public void setUnaPelicula(Pelicula unaPelicula) {
        this.unaPelicula = unaPelicula;
    }

    /**
     * @return the peliculasEncontradas
     */
    public List<Pelicula> getPeliculasEncontradas() {
        return peliculasEncontradas;
    }

    /**
     * @param peliculasEncontradas the peliculasEncontradas to set
     */
    public void setPeliculasEncontradas(List<Pelicula> peliculasEncontradas) {
        this.peliculasEncontradas = peliculasEncontradas;
    }
    
}

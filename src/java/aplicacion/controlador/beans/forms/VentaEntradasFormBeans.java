/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ButacaBean;
import aplicacion.controlador.beans.CarteleraBean;
import aplicacion.controlador.beans.PerfilBean;
import aplicacion.controlador.beans.SalaBean;
import aplicacion.controlador.beans.VentaEntradaBean;
import aplicacion.modelo.dominio.Butaca;
import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.dominio.Pelicula;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Sala;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author alumno
 */
@ManagedBean
@ViewScoped
public class VentaEntradasFormBeans {
@ManagedProperty(value = "#(VentaEntradaBean)")
private VentaEntradaBean VentaEntradaBean;
@ManagedProperty(value = "#(CarteleraBean)")
private CarteleraBean carteleraBean;
@ManagedProperty(value = "#(perfilBean)")
private PerfilBean perfilBean;
@ManagedProperty(value = "#(butacaBean)")
SalaBean salaBean;
private String nombrePeli;
private String horario;
private String precio;
private String idButaca;
private String imagenBut;
private Date fecha;
private List<Cartelera> carteleras;
private List<Pelicula> peliculas;
private List<Perfil> perfiles;
private List<Butaca> butacasA;
private List<Butaca> butacasB;
private Cartelera unaCartelera;
private Pelicula unaPelicula;
private Sala salaA;
private Sala salaB;
private boolean act1;
private boolean act2;
private boolean act3;
private boolean act4;
private String resumenReserva;
private ButacaBean butacaBean;


public VentaEntradasFormBeans() {
    carteleraBean = new CarteleraBean();
    perfilBean = new PerfilBean();
    VentaEntradaBean = new VentaEntradaBean();
    butacaBean = new ButacaBean();
    salaBean = new SalaBean();
    imagenBut = "butaca.png";
    act1 = false;
    act2 = true;
    act3 = true;
    act4 = false;
    listarButacas();
}
private void listarButacas (){
    setUnaCartelera(carteleraBean.listarCarteleras().get(0));
    setSalaA(salaBean.consultarSala(1));
    setSalaB(salaBean.consultarSala(4));
    setButacasA(getButacaBean().listarButacas(getSalaA()));
    setButacasB(getButacaBean().listarButacas(getSalaB()));
}

public void establecerPelicula(Cartelera pel) {
//    setUnaCartelera(pel);
    setAct1(true);
    setUnaPelicula(pel.getPeliculas());
    setFecha(pel.getCarFecha());
    setAct2(false);
    listarCarteleraDia();
}
private void listarCarteleraDia() {
//    setCarteleras(getCarteleraBean().buscarCartelera(getUnaPelicula(),getFecha()));
}
    /**
     * @return the carteleraBean
     */
    public CarteleraBean getCarteleraBean() {
        return carteleraBean;
    }

    /**
     * @param carteleraBean the carteleraBean to set
     */
    public void setCarteleraBean(CarteleraBean carteleraBean) {
        this.carteleraBean = carteleraBean;
    }

    /**
     * @return the perfilBean
     */
    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    /**
     * @param perfilBean the perfilBean to set
     */
    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    /**
     * @return the nombrePeli
     */
    public String getNombrePeli() {
        return nombrePeli;
    }

    /**
     * @param nombrePeli the nombrePeli to set
     */
    public void setNombrePeli(String nombrePeli) {
        this.nombrePeli = nombrePeli;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the idButaca
     */
    public String getIdButaca() {
        return idButaca;
    }

    /**
     * @param idButaca the idButaca to set
     */
    public void setIdButaca(String idButaca) {
        this.idButaca = idButaca;
    }

    /**
     * @return the imagenBut
     */
    public String getImagenBut() {
        return imagenBut;
    }

    /**
     * @param imagenBut the imagenBut to set
     */
    public void setImagenBut(String imagenBut) {
        this.imagenBut = imagenBut;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the act1
     */
    public boolean isAct1() {
        return act1;
    }

    /**
     * @param act1 the act1 to set
     */
    public void setAct1(boolean act1) {
        this.act1 = act1;
    }

    /**
     * @return the act2
     */
    public boolean isAct2() {
        return act2;
    }

    /**
     * @param act2 the act2 to set
     */
    public void setAct2(boolean act2) {
        this.act2 = act2;
    }

    /**
     * @return the act3
     */
    public boolean isAct3() {
        return act3;
    }

    /**
     * @param act3 the act3 to set
     */
    public void setAct3(boolean act3) {
        this.act3 = act3;
    }

    /**
     * @return the act4
     */
    public boolean isAct4() {
        return act4;
    }

    /**
     * @param act4 the act4 to set
     */
    public void setAct4(boolean act4) {
        this.act4 = act4;
    }

    /**
     * @return the resumenReserva
     */
    public String getResumenReserva() {
        return resumenReserva;
    }

    /**
     * @param resumenReserva the resumenReserva to set
     */
    public void setResumenReserva(String resumenReserva) {
        this.resumenReserva = resumenReserva;
    }

    /**
     * @return the carteleras
     */
    public List<Cartelera> getCarteleras() {
        return carteleras;
    }

    /**
     * @param carteleras the carteleras to set
     */
    public void setCarteleras(List<Cartelera> carteleras) {
        this.carteleras = carteleras;
    }

    /**
     * @return the peliculas
     */
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    /**
     * @param peliculas the peliculas to set
     */
    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    /**
     * @return the perfiles
     */
    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    /**
     * @param perfiles the perfiles to set
     */
    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    /**
     * @return the butacasA
     */
    public List<Butaca> getButacasA() {
        return butacasA;
    }

    /**
     * @param butacasA the butacasA to set
     */
    public void setButacasA(List<Butaca> butacasA) {
        this.butacasA = butacasA;
    }

    /**
     * @return the butacasB
     */
    public List<Butaca> getButacasB() {
        return butacasB;
    }

    /**
     * @param butacasB the butacasB to set
     */
    public void setButacasB(List<Butaca> butacasB) {
        this.butacasB = butacasB;
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
     * @return the salaA
     */
    public Sala getSalaA() {
        return salaA;
    }

    /**
     * @param salaA the salaA to set
     */
    public void setSalaA(Sala salaA) {
        this.salaA = salaA;
    }

    /**
     * @return the salaB
     */
    public Sala getSalaB() {
        return salaB;
    }

    /**
     * @param salaB the salaB to set
     */
    public void setSalaB(Sala salaB) {
        this.salaB = salaB;
    }

    /**
     * @return the VentaEntradaBean
     */
    public VentaEntradaBean getVentaEntradaBean() {
        return VentaEntradaBean;
    }

    /**
     * @param VentaEntradaBean the VentaEntradaBean to set
     */
    public void setVentaEntradaBean(VentaEntradaBean VentaEntradaBean) {
        this.VentaEntradaBean = VentaEntradaBean;
    }

    /**
     * @return the unaCartelera
     */
    public Cartelera getUnaCartelera() {
        return unaCartelera;
    }

    /**
     * @param unaCartelera the unaCartelera to set
     */
    public void setUnaCartelera(Cartelera unaCartelera) {
        this.unaCartelera = unaCartelera;
    }

    /**
     * @return the butacaBean
     */
    public ButacaBean getButacaBean() {
        return butacaBean;
    }

    /**
     * @param butacaBean the butacaBean to set
     */
    public void setButacaBean(ButacaBean butacaBean) {
        this.butacaBean = butacaBean;
    }


}


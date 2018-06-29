package aplicacion.modelo.dominio;
// Generated 21/06/2018 23:41:07 by Hibernate Tools 4.3.1






/**
 * VentaEntrada generated by hbm2java
 */
public class VentaEntrada  implements java.io.Serializable {


     private Integer venCodigo;
     private ButacaCartelera butacasCarteleras;
     private Perfil perfiles;
     private String venPrecio;
     private String venDescripcion;
     private boolean venEstado;

    public VentaEntrada() {
    }

    public VentaEntrada(ButacaCartelera butacasCarteleras, Perfil perfiles, String venPrecio, String venDescripcion, boolean venEstado) {
       this.butacasCarteleras = butacasCarteleras;
       this.perfiles = perfiles;
       this.venPrecio = venPrecio;
       this.venDescripcion = venDescripcion;
       this.venEstado = venEstado;
    }
   
    public Integer getVenCodigo() {
        return this.venCodigo;
    }
    
    public void setVenCodigo(Integer venCodigo) {
        this.venCodigo = venCodigo;
    }
    public ButacaCartelera getButacasCarteleras() {
        return this.butacasCarteleras;
    }
    
    public void setButacasCarteleras(ButacaCartelera butacasCarteleras) {
        this.butacasCarteleras = butacasCarteleras;
    }
    public Perfil getPerfiles() {
        return this.perfiles;
    }
    
    public void setPerfiles(Perfil perfiles) {
        this.perfiles = perfiles;
    }
    public String getVenPrecio() {
        return this.venPrecio;
    }
    
    public void setVenPrecio(String venPrecio) {
        this.venPrecio = venPrecio;
    }
    public String getVenDescripcion() {
        return this.venDescripcion;
    }
    
    public void setVenDescripcion(String venDescripcion) {
        this.venDescripcion = venDescripcion;
    }
    public boolean isVenEstado() {
        return this.venEstado;
    }
    
    public void setVenEstado(boolean venEstado) {
        this.venEstado = venEstado;
    }




}



package aplicacion.modelo.dominio;
// Generated 21/06/2018 23:41:07 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ButacaCartelera generated by hbm2java
 */
public class ButacaCartelera  implements java.io.Serializable {


     private Integer bcCodigo;
     private Cartelera carteleras;
     private String bcIdentificadorButaca;
     private boolean bcDisponible;
     private boolean bcEstado;
   

    public ButacaCartelera() {
    }

	
    public ButacaCartelera(Cartelera carteleras, String bcIdentificadorButaca, boolean bcDisponible, boolean bcEstado) {
        this.carteleras = carteleras;
        this.bcIdentificadorButaca = bcIdentificadorButaca;
        this.bcDisponible = bcDisponible;
        this.bcEstado = bcEstado;
    }
   
    public Integer getBcCodigo() {
        return this.bcCodigo;
    }
    
    public void setBcCodigo(Integer bcCodigo) {
        this.bcCodigo = bcCodigo;
    }
    public Cartelera getCarteleras() {
        return this.carteleras;
    }
    
    public void setCarteleras(Cartelera carteleras) {
        this.carteleras = carteleras;
    }
    public String getBcIdentificadorButaca() {
        return this.bcIdentificadorButaca;
    }
    
    public void setBcIdentificadorButaca(String bcIdentificadorButaca) {
        this.bcIdentificadorButaca = bcIdentificadorButaca;
    }
    public boolean isBcDisponible() {
        return this.bcDisponible;
    }
    
    public void setBcDisponible(boolean bcDisponible) {
        this.bcDisponible = bcDisponible;
    }
    public boolean isBcEstado() {
        return this.bcEstado;
    }
    
    public void setBcEstado(boolean bcEstado) {
        this.bcEstado = bcEstado;
    }
 



}



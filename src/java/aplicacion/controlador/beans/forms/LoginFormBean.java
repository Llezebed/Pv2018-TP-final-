/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;


//import aplicacion.datos.TablaUsuarios;
import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Florencia
 */
@ManagedBean
@ViewScoped
public class LoginFormBean implements Serializable{
    @ManagedProperty(value="#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private String nombreUs;
    private String paswUs;

    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
        usuarioBean=new UsuarioBean();
    }
    public String validarUsuario(){
        String resultado=null;
        Usuario usuario=null;
        usuario=getUsuarioBean().validarUsuario(getNombreUs(), getPaswUs());
        if(usuario==null){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales Invalidas","No existe el usuario");
          FacesContext.getCurrentInstance().addMessage(null,facesMessage);
        }
        else{
             FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Credenciales validas"," usuario valido");
          FacesContext.getCurrentInstance().addMessage(null,facesMessage);
          FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado",usuario);
          resultado="/bienvenido";
        }
        return resultado;
    }
    public String getNombreUsuarioValidado(){
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        return usuario.getUsuNombreUsuario();
    }
  public String cerrarSesion(){
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
      FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Sesion Cerrada","Sesion Cerrada");
      FacesContext.getCurrentInstance().addMessage(null, facesMessage);
      String resultado="/login_1";
      return resultado;
  }
  public String redirreccionUsuarios(){
      String resultado="/usuarios";
      return resultado;
  }
   public boolean validarSesion(){
        boolean sesionValida=false;
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        if (usuario!=null){
            sesionValida=true;            
        }
        return sesionValida;
    }
   
   public int verificarSesion(){
        
        int tipo=0;
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        if (usuario!=null){            
            if (usuario.getUsuTipoUsuario().equals("final")){
                tipo=1;
            }
            if (usuario.getUsuTipoUsuario().equals("administrador")){
                tipo=2;
            }
            if (usuario.getUsuTipoUsuario().equals("supervisor")){
                tipo=3;
            }
        }
        return tipo;
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
     * @return the paswUs
     */
    public String getPaswUs() {
        return paswUs;
    }

    /**
     * @param paswUs the paswUs to set
     */
    public void setPaswUs(String paswUs) {
        this.paswUs = paswUs;
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

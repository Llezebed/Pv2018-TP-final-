/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.DirectorDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import aplicacion.datos.hibernate.dao.imp.DirectorDAOImp;

import aplicacion.modelo.dominio.Director;

import java.util.List;
/**
 *
 * @author Alumno
 */
@ManagedBean
@ViewScoped
public class DirectorBean {

    /**
     * Creates a new instance of DirectorBean
     */
    public DirectorBean() {
    }
    public void agregarDirector(Director unDirector){
        DirectorDAO directorDAO=new DirectorDAOImp(); //directorDAO es de tipo DirectorDAO(clase abstracta), e implementa las acciones de la misma por DirectorDAoImp
        directorDAO.agregar(unDirector);
    }
    public List<Director> listarDirector(){ //lista los directores disponibles(estado true)
        DirectorDAO directorDAO=new DirectorDAOImp();
        return directorDAO.obtenerTodos();//obtener los directores cuyo estado sea true(este disponible)
    }
    public void modificarDirector(Director unDirector){
        DirectorDAO directorDAO=new DirectorDAOImp();
        directorDAO.modificar(unDirector);
    }
     public Director consulta(String direcApellidos,String direcNombres){
        Director director=null;//vacia los datos para que no coincidan con los q uno va a ingresar 
        DirectorDAO directorDAO=new DirectorDAOImp();
        director= directorDAO.consulta(direcApellidos, direcNombres);
        return director;//devuelve un director con los datos solicitados 
        //direcApellidos y direcNombres son las restricciones, se utilizan para buscar al director 
    }
     
     
}


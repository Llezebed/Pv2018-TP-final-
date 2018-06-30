/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.PeliculaDAO;
import aplicacion.modelo.dominio.Pelicula;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sandra
 */
public class PeliculaDAOImp implements PeliculaDAO{

    @Override
    public ArrayList<Pelicula> obtenerTodos() {
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Criteria criteria=session.createCriteria(Pelicula.class);
      criteria.add(Restrictions.like("pelEstado", true));
      session.close();
      return (ArrayList<Pelicula>) criteria.list();    
    }

    @Override
    public Pelicula consulta(String peNombre, String peDescrip) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Pelicula.class);
        criteria.add(Restrictions.like("pelNombre",peNombre));
        criteria.add(Restrictions.like("pelEstado",true));
        Pelicula p=null;
         if(!criteria.list().isEmpty()){
             p=(Pelicula)criteria.list().get(0);
         }
        return p;
    }

    @Override
    public void modificar(Pelicula pelicula) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(pelicula);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public void agregar(Pelicula pelicula) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(pelicula);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Pelicula pelicula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.DirectorDAO;
import aplicacion.modelo.dominio.Director;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sandra
 */
public class DirectorDAOImp implements DirectorDAO{

    @Override
    public ArrayList<Director> obtenerTodos() {
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Criteria criteria=session.createCriteria(Director.class);
      criteria.add(Restrictions.like("dirEstado", true));
      session.close();
      return (ArrayList<Director>) criteria.list();    
    }

    @Override
    public Director consulta(String direcApellidos, String direcNombres) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Director.class);
        criteria.add(Restrictions.like("dirApellidos",direcApellidos));
        criteria.add(Restrictions.like("dirNombres",direcNombres));
        Director d=null;
         if(!criteria.list().isEmpty()){
             d=(Director)criteria.list().get(0);
         }
        return d;     
    }

    @Override
    public void modificar(Director director) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(director);
        session.getTransaction().commit();
        session.close();    
    }

    @Override
    public void agregar(Director director) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(director);
        session.getTransaction().commit();
        session.close();    
    }

    @Override
    public void eliminar(Director director) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

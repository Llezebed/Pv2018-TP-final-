/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.CarteleraDAO;
import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.dominio.Pelicula;
import aplicacion.modelo.dominio.Sala;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sandra
 */
public class CarteleraDAOImp implements CarteleraDAO{

    @Override
    public ArrayList<Cartelera> obtenerTodos() {
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Criteria criteria=session.createCriteria(Cartelera.class);
      criteria.add(Restrictions.like("carEstado", true));
      session.close();
      return (ArrayList<Cartelera>) criteria.list(); 
    }

    @Override
    public void modificar(Cartelera cartelera) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(cartelera);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public void agregar(Cartelera cartelera) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(cartelera);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public void eliminar(Cartelera cartelera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

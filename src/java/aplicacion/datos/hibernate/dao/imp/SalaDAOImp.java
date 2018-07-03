/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.SalaDAO;
import aplicacion.modelo.dominio.Sala;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sandra
 */
public class SalaDAOImp implements SalaDAO{

    @Override
    public ArrayList<Sala> obtenerTodos() {
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Criteria criteria=session.createCriteria(Sala.class);
      criteria.add(Restrictions.like("salEstado", true));
      session.close();
      return (ArrayList<Sala>) criteria.list(); 
    }

    @Override
    public Sala consulta(String salaNom, String salaDes) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Sala.class);
        criteria.add(Restrictions.like("dirApellidos",salaNom));
        criteria.add(Restrictions.like("dirNombres",salaDes));
        Sala sa=null;
         if(!criteria.list().isEmpty()){
             sa=(Sala)criteria.list().get(0);
         }
        return sa; 
    }

    @Override
    public void modificar(Sala unaSala) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaSala);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void agregar(Sala unaSala) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaSala);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Sala unaSala) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

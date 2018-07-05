/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.PerfilDAO;

import aplicacion.modelo.dominio.Perfil;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Florencia
 */
public class PerfilDAOImp implements PerfilDAO {
    
    private SessionFactory sessionFactory;

    /**
     * Get the value of sessionFactory
     *
     * @return the value of sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Set the value of sessionFactory
     *
     * @param sessionFactory new value of sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Perfil> obtenerTodos() {
        List<Perfil> lista= new ArrayList<Perfil>();
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Perfil.class);
            criteria.add(Restrictions.like("perEstado", true));
            session.flush();
            lista = (ArrayList<Perfil>) criteria.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return lista;
//        List list = getSessionFactory().getCurrentSession().createQuery("from usuarios where perEstado = true").list();
//        return list;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        ArrayList<Perfil> usuarios = new ArrayList();
//        try {
//            Criteria criteria = session.createCriteria(Perfil.class);
//            criteria.add(Restrictions.like("perEstado", true));
//            session.flush();  
//            usuarios = (ArrayList<Perfil>) criteria.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            session.getTransaction().rollback();
//        }
//        session.close();
//        return usuarios;
    }

    @Override
    public Perfil consulta(String nombreUsuario, String passwd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Perfil.class);
        criteria.add(Restrictions.like("usuNombreUsuario", nombreUsuario));
        criteria.add(Restrictions.like("usuNombreUsuario", passwd));
        Perfil u = null;
        if (!criteria.list().isEmpty()) {
            u = (Perfil) criteria.list().get(0);
        }
        return u;
    }

    @Override
    public void modificar(Perfil unPerfil) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unPerfil);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void agregar(Perfil perfil) {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        try  
        {  
            session.beginTransaction();  
            session.merge(perfil);  
            session.flush();  
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();   
    }

    @Override
    public void eliminar(Perfil unPerfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Perfil obtenerPerfil(String usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Criteria criteria = session.createCriteria(Perfil.class);
        criteria.createAlias("usuario.usuNombreUsuario", usuario);
        Perfil u = null;
        if (!criteria.list().isEmpty()) {
            u = (Perfil) criteria.list().get(0);
        }
        return u;
    }

}

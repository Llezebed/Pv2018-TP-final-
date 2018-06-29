/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.UsuarioDAO;

import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Florencia
 */
public class UsuarioDAOImp implements UsuarioDAO {

    @Override
    public ArrayList<Usuario> obtenerTodos() {
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Criteria criteria=session.createCriteria(Usuario.class);
      criteria.add(Restrictions.like("usuEstado", true));
      return (ArrayList<Usuario>) criteria.list();
    }

    @Override
    public Usuario consulta(String nombreUsuario, String passwd) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("usuNombreUsuario",nombreUsuario));
         criteria.add(Restrictions.like("usuNombreUsuario",passwd));
         Usuario u=null;
         if(!criteria.list().isEmpty()){
             u=(Usuario)criteria.list().get(0);
         }
     return u;   
    }

    @Override
    public void modificar(Usuario usuario) {
       Session session =  HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         session.save(usuario);
         session.getTransaction().commit();
         session.close();
    }

    @Override
    public void agregar(Usuario usuario) {
         Session session =  HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         session.save(usuario);
         session.getTransaction().commit();
         session.close();
    }

    @Override
    public void eliminar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

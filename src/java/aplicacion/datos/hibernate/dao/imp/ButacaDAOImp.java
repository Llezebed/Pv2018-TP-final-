/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.ButacaDAO;
import aplicacion.modelo.dominio.Butaca;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sandra
 */
public class ButacaDAOImp implements ButacaDAO{

    @Override
    public ArrayList<Butaca> obtenerTodos() {
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Criteria criteria=session.createCriteria(Butaca.class);
      criteria.add(Restrictions.like("butEstado", true));
      session.close();
      return (ArrayList<Butaca>) criteria.list(); 
    }

    @Override
    public Butaca consulta(String butIde) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Butaca.class);
        criteria.add(Restrictions.like("butIdentificador",butIde));
        Butaca but=null;
         if(!criteria.list().isEmpty()){
             but=(Butaca)criteria.list().get(0);
         }
        return but;
    }

    @Override
    public void modificar(Butaca unaButaca) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaButaca);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public void agregar(Butaca unaButaca) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaButaca);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Butaca unaButaca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

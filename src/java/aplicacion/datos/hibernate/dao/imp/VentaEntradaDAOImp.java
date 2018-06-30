/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.VentaEntradaDAO;
import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.VentaEntrada;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sandra
 */
public class VentaEntradaDAOImp implements VentaEntradaDAO {

    @Override
    public ArrayList<VentaEntrada> obtenerTodos() {
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Criteria criteria=session.createCriteria(VentaEntrada.class);
      criteria.add(Restrictions.like("venEstado", true));
      session.close();
      return (ArrayList<VentaEntrada>) criteria.list();
    }

    @Override
    public VentaEntrada consulta(ButacaCartelera butacaCar, Perfil perf, String venPre, String venDescrip) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(VentaEntrada.class);
        criteria.add(Restrictions.like("butacasCarteleras",butacaCar));
        criteria.add(Restrictions.like("perfiles",perf));
        criteria.add(Restrictions.like("venPrecio",venPre));
        criteria.add(Restrictions.like("venDescripcion",venDescrip));
        VentaEntrada v=null;
         if(!criteria.list().isEmpty()){
             v=(VentaEntrada)criteria.list().get(0);
         }
        return v; 
    }

    @Override
    public void modificar(VentaEntrada venta) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(venta);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void agregar(VentaEntrada venta) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(venta);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(VentaEntrada venta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

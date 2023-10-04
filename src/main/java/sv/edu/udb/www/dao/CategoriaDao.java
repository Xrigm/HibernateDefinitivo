package sv.edu.udb.www.dao;

import sv.edu.udb.www.hibernate.DatosCategoria;
import sv.edu.udb.www.hibernate.Datosempleados;
import sv.edu.udb.www.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class CategoriaDao {

    public void addCategoria(DatosCategoria categoria){
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            ses.save(categoria);
            ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{

            ses.close();
        }
    }

    public List<DatosCategoria> obtenerCategoria(){
        List<DatosCategoria> categoria = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            String queryString = "from DatosCategoria ";
            Query query = ses.createQuery(queryString);
            categoria= query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{

            ses.close();
        }
        return categoria;
    }

    public DatosCategoria getCategoriaID(Integer idCategoria){
        DatosCategoria categoria = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            String queryString = "from DatosCategoria where id = :idFind";
            Query query = ses.createQuery(queryString);
            query.setParameter("idFind", idCategoria);
            categoria = (DatosCategoria) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{

            ses.close();
        }

        return categoria;
    }

    public void updateCategoria(Integer idCategoria, DatosCategoria newCategoria){
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            DatosCategoria categoria = (DatosCategoria) ses.load(DatosCategoria.class,idCategoria);
            categoria.setId(categoria.getId());
            categoria.setNombreCatego(newCategoria.getNombreCatego());

            ses.update(categoria);
            ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{

            ses.close();
        }
    }

    public void deleteCategoria(Integer idCategoria){
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            DatosCategoria categoria = (DatosCategoria) ses.get(DatosCategoria.class,idCategoria);
            ses.delete(categoria);
            ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{

            ses.close();
        }

    }
}

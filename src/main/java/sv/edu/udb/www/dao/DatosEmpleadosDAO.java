package sv.edu.udb.www.dao;

import sv.edu.udb.www.hibernate.Datosempleados;
import sv.edu.udb.www.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DatosEmpleadosDAO {

    public void addEmpleado(Datosempleados empleados){
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            ses.save(empleados);
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
    public void deleteEmpleado(Integer idEmpleado){
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            Datosempleados empleado = (Datosempleados) ses.get(Datosempleados.class,idEmpleado);
            ses.delete(empleado);
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
    public void updateEmpleado(Integer idEmpleado, Datosempleados newEmpleados){
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            Datosempleados empleado = (Datosempleados) ses.load(Datosempleados.class,idEmpleado);
            empleado.setId(empleado.getId());
            empleado.setNombres(newEmpleados.getNombres());
            empleado.setApellidos(newEmpleados.getApellidos());
            empleado.setEdad(newEmpleados.getEdad());
            empleado.setDireccion(newEmpleados.getDireccion());

            ses.update(empleado);
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
    public Datosempleados getEmpleadoID(Integer idEmpleado){
        Datosempleados empleado = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            String queryString = "from Datosempleados where id = :idFind";
            Query query = ses.createQuery(queryString);
            query.setParameter("idFind", idEmpleado);
            empleado = (Datosempleados) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{

            ses.close();
        }

        return empleado;
    }
    public List<Datosempleados> obtenerEmpleados(){
        List<Datosempleados> empleados = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            String queryString = "from Datosempleados";
            Query query = ses.createQuery(queryString);
            empleados= query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{

            ses.close();
        }
        return empleados;
    }

}

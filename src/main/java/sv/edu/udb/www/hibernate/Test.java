package sv.edu.udb.www.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test {
    public static void main(String[] args) { //clase main de ejecucion java
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=ses.beginTransaction();
        Datosempleados datos=new Datosempleados();
        datos.setNombres("Eduardo");
        datos.setApellidos("Cortez");
        datos.setEdad(21);
        datos.setTelefono("2285788");
        datos.setDireccion("Casa de Eduardo");
        ses.save(datos);
        tra.commit();
    }
}

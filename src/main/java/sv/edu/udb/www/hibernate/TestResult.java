package sv.edu.udb.www.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.ArrayList;

public class TestResult {
    public static void main(String[] args) {
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        ArrayList<Datosempleados> listaEmpleado=new ArrayList<Datosempleados>();
        String sql="from Datosempleados";
        listaEmpleado= (ArrayList<Datosempleados>) ses.createQuery(sql).list();
        for(int i=0;i<listaEmpleado.size();i++){
            Datosempleados empleado=(Datosempleados)listaEmpleado.get(i);
            System.out.println(empleado.getId() + " " + empleado.getNombres() + " " +   empleado.getApellidos() );
        }
    }
}

package sv.edu.udb.www.managedbean;

import sv.edu.udb.www.dao.DatosEmpleadosDAO;
import sv.edu.udb.www.hibernate.Datosempleados;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;

import java.util.List;

@ManagedBean
@SessionScoped
public class EmpleadoBean {
    private Integer id;
    private String nombres;
    private String apellidos;
    private int edad;
    private String telefono;
    private String direccion;

    /**
     * Creates a new instance of EmpleadoBean
     */
    public EmpleadoBean() {
    }
    public void addEmpleado(){
        DatosEmpleadosDAO empleadoDao = new DatosEmpleadosDAO();
        Datosempleados empleado = new Datosempleados(nombres, apellidos, edad, telefono, direccion);
        empleadoDao.addEmpleado(empleado);
    }

    public void returnEmpleadoId(){
        DatosEmpleadosDAO empleadoDao = new DatosEmpleadosDAO();
        Datosempleados empleado = empleadoDao.getEmpleadoID(getId()) ;

        if(empleado != null){
            setId(empleado.getId());
            setNombres(empleado.getNombres() );
            setApellidos(empleado.getApellidos());
            setEdad(empleado.getEdad());
            setTelefono(empleado.getTelefono());
            setDireccion(empleado.getDireccion());
        }else{
            setId(0);
            setNombres("");
            setApellidos("");
            setEdad(0);
            setTelefono("");
            setDireccion("");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente NO especificado"));
        }

    }

    public String deleteEmpleado(){
        DatosEmpleadosDAO empleadoDao = new DatosEmpleadosDAO();
        Datosempleados empleado = empleadoDao.getEmpleadoID(getId()) ;

        if(empleado != null){
            empleadoDao.deleteEmpleado(getId());
            setId(getId());
            setNombres("");
            setApellidos("");
            setEdad(0);
            setTelefono("");
            setDireccion("");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente con ID " + getId() + " Eliminado" ));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente con ID " + getId() + " NO encontrado" ));
        }

        return "Empleado";

    }
    public String updateEmpleado(){
        DatosEmpleadosDAO empleadoDao = new DatosEmpleadosDAO();
        Datosempleados obtempleado = empleadoDao.getEmpleadoID(getId()) ;

        if(obtempleado != null){
            Datosempleados empleado = new Datosempleados(nombres, apellidos, edad, telefono, direccion);

            empleadoDao.updateEmpleado(getId(), empleado);
            obtempleado = empleadoDao.getEmpleadoID(getId()) ;
            setId(obtempleado.getId());
            setNombres(obtempleado.getNombres() );
            setApellidos(obtempleado.getApellidos());
            setEdad(obtempleado.getEdad());
            setTelefono(obtempleado.getTelefono());
            setDireccion(obtempleado.getDireccion());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente con ID " + getId() + " Actualizado" ));
        }else{
            setId(0);
            setNombres("");
            setApellidos("");
            setEdad(0);
            setTelefono("");
            setDireccion("");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente con ID " + getId() + " NO encontrado" ));
        }

        return "Empleado";

    }
    public List<Datosempleados> getEmpleados(){
        DatosEmpleadosDAO empleadoDao = new DatosEmpleadosDAO();
        List<Datosempleados> lista = empleadoDao.obtenerEmpleados();
        return lista;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }
    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

package sv.edu.udb.www.managedbean;


import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import sv.edu.udb.www.dao.CategoriaDao;
import sv.edu.udb.www.hibernate.DatosCategoria;

@ManagedBean
@SessionScoped


public class ProductosBean {

    private Integer id;
    private String nombreP;
    private  int idCatego;

    public ProductosBean() {
    }

    public void addCatego() {
        System.out.println("ENTRE AL BEAN");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreP;
    }

    public void setNombreProducto(String nombreP) {
        this.nombreP = nombreP;
    }

    public int getidCategoria() {
        return idCatego;
    }

    public void setidCategoria(int idCatego) {
        this.idCatego = idCatego;
    }
}

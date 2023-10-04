package sv.edu.udb.www.managedbean;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import sv.edu.udb.www.dao.CategoriaDao;
import sv.edu.udb.www.hibernate.DatosCategoria;

import java.util.List;

@ManagedBean
@SessionScoped

public class CategoriaBean {

    private Integer id;
    private String nombreCatego;

    public CategoriaBean(){}

    public void addCatego(){
        CategoriaDao categoriaDao = new CategoriaDao();
        DatosCategoria categoria = new DatosCategoria(nombreCatego);
        categoriaDao.addCategoria(categoria);
    }

    public List<DatosCategoria> getCategoria(){
        CategoriaDao categoriaDao = new CategoriaDao();
        List<DatosCategoria> lista = categoriaDao.obtenerCategoria();
        return lista;
    }

    public String updateCategoria(){
         CategoriaDao categoriaDao = new CategoriaDao();
         DatosCategoria obtCategoria = categoriaDao.getCategoriaID(getId());

        if(obtCategoria != null){
            DatosCategoria categoria = new DatosCategoria(nombreCatego);

            categoriaDao.updateCategoria(getId(), categoria);
            obtCategoria = categoriaDao.getCategoriaID(getId()) ;
            setId(obtCategoria.getId());
            setNombreCatego(obtCategoria.getNombreCatego() );
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Categoria con ID" + getId() + " Actualizado" ));
        }else{
            setId(0);
            setNombreCatego("");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Categoria con ID " + getId() + " NO encontrado" ));
        }

        return "Categoria";
    }

    public void returnCategoriaId(){
        CategoriaDao categoriaDao = new CategoriaDao();
        DatosCategoria categoria = categoriaDao.getCategoriaID(getId()) ;

        if(categoria != null){
            setId(categoria.getId());
            setNombreCatego(categoria.getNombreCatego() );
        }else{
            setId(0);
            setNombreCatego("");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Categoria NO especificado"));
        }

    }

    public String deleteCategoria(){
        CategoriaDao categoriaDao = new CategoriaDao();
        DatosCategoria categoria = categoriaDao.getCategoriaID(getId()) ;

        if(categoria != null){
            categoriaDao.deleteCategoria(getId());
            setId(getId());
            setNombreCatego("");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Categoria con ID " + getId() + " Eliminado" ));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Categoria con ID " + getId() + " NO encontrado" ));
        }

        return "Categoria";

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCatego() {
        return nombreCatego;
    }

    public void setNombreCatego(String nombreCatego) {
        this.nombreCatego = nombreCatego;
    }
}

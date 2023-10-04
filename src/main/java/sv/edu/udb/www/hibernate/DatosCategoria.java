package sv.edu.udb.www.hibernate;

public class DatosCategoria {

    private int id;
    private String nombreCatego;

    public DatosCategoria(){}

    public DatosCategoria(String nombres) {
        this.nombreCatego = nombres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCatego() {
        return nombreCatego;
    }

    public void setNombreCatego(String nombreCatego) {
        this.nombreCatego = nombreCatego;
    }


}

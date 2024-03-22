package entity;

public class Libro {
    private int id;
    private String titulo;
    private int año_de_publicacion;
    private int precio;

    private  int idautor;

    public Libro() {

    }

    public Libro(int id, String titulo, int año_de_publicacion, int precio, int idautor) {
        this.id = id;
        this.titulo = titulo;
        this.año_de_publicacion = año_de_publicacion;
        this.precio = precio;
        this.idautor = idautor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño_de_publicacion() {
        return año_de_publicacion;
    }

    public void setAño_de_publicacion(int año_de_publicacion) {
        this.año_de_publicacion = año_de_publicacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", año_de_publicacion=" + año_de_publicacion +
                ", precio=" + precio +
                ", idAutor=" + idautor +
                '}';
    }
}

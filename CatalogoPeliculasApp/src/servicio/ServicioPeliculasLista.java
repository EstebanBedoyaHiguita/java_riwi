package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements  IServicioPeliculas{

    private final List<Pelicula> peliculas;

    public  ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }
    @Override
    public void listarPeliculas() {
        System.out.println("Listado de peliculas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula:"+ pelicula);

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //Regresa el indice donde se encuentra la pelicula encontrada en la lista
        var indice = peliculas.indexOf(pelicula);

        if(indice == -1){
            System.out.println("La pelicula no fue encontrada");
        }else {
            System.out.println("Pelicula encontrada en el indice:" + indice);
        }
    }
//Pruebas
    public static void main(String[] args) {
        //Creamos objetos de tipo pelicula
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");

        //Creamos el servicio (Patron de diseño service)
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();

        //Agregamos las peliculas  a la lista

        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);

        //Listamos las peliculas
        servicioPeliculas.listarPeliculas();

        //Buscamos el indice de pelicula
        //Se debe implementar el metodo equals  y hascode
        servicioPeliculas.buscarPelicula(pelicula1);
        servicioPeliculas.buscarPelicula(pelicula2);

    }
}

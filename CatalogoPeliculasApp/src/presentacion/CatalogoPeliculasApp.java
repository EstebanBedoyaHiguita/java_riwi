package presentacion;

import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasLista;

import java.util.Scanner;

    public class CatalogoPeliculasApp {

        var salir = false;

        var consola = new Scanner(System.in);

        //Agregamos la implementacion  del servicio

        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();

            while(!salir)

        {
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);
            } catch (Exception e) {
                System.out.println("Ocurrrio un error : " + e.getMessage());
            }
            System.out.println();
        }//Fin while
    }


}
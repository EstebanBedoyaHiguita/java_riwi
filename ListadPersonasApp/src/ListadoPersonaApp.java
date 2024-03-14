import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ListadoPersonaApp {
    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);

        //DEfinimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();

        //Empezamos con el menu
        var salir= false;

        while (!salir){
            mostrarMenu();

            try{
                salir = ejecutarOperacion(consola, personas);
            }catch (Exception e){
                System.out.println("Ocurrio un error:"+ e.getMessage());
            }


            System.out.println();
        }

    }

    private static void mostrarMenu(){
    //Mostramos opciones

        System.out.println("""
                ***Listado Personas App***
                1. Agregar
                2. Listar
                3. Salir""");
        System.out.println("Proporciona la opcion");

    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion  = Integer.parseInt(consola.nextLine());
        var salir = false;

        //Revisemos la opcion proporcionada

        switch (opcion){
            case 1 ->{//Agregar persona
                System.out.println("Ingresa el nombre:");
                var nombre = consola.nextLine();
                System.out.println("Ingresa el telefono:");
                var tel= consola.nextLine();
                System.out.println("ingrese el email");
                var email = consola.nextLine();

                //Crear el objeto Persona

                var persona = new Persona(nombre,tel,email);

                //Agregamos el objeto a la lista
                personas.add(persona);
                System.out.println("La lista tiene : " + personas.size() + "Elementos");

            }
            case 2 ->{//Listar personas
                System.out.println("listado de personas");
                //Mejora usando lambda y metodo de referencia

                //personas.forEach((persona)-> System.out.println(persona));
                personas.forEach(System.out::println);

            }
            case 3 ->{//Salir del ciclo
                System.out.println("Hasta pronto");
                salir = true;

            }
            default -> System.out.println("Opcion erronea: "+  opcion);
        } //fin switch
        return salir;
    }
}
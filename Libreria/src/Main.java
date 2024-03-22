import controller.AutorController;
import controller.LibroController;
import database.ConfiDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AutorController objAutorController = new AutorController();
        LibroController objLibroController = new LibroController();

        String opcion = "";

        do{
            opcion = JOptionPane.showInputDialog("""
                    1. Autores
                    2. Libros
                    3. Salir
                    Selecciones una opcion
                    """);

            switch (opcion){
                case "1":
                    String option1 = "";

                    do{
                        option1 = JOptionPane.showInputDialog("""
                    MENU
                    1. Crear Autor
                    2. Buscar Autor Por Nombre
                    3. Buscar Autor Por Id
                    4. Listar Autores
                    5. Editar Autor
                    6. Eliminar Autor
                    7. Salir
                    Seleccione una opcion
                    """);

                        switch (option1){
                            case "1":
                                objAutorController.create();
                                break;
                            case "2":
                                objAutorController.buscar();
                                break;
                            case "3":
                                objAutorController.buscarId();
                                break;
                            case "4":
                                objAutorController.getAll();
                                break;
                            case "5":
                                objAutorController.edit();
                                break;
                            case "6":
                                objAutorController.delete();
                        }

                    }while(!option1.equals("7"));
                    break;
                case "2":
                    String option2 = "";

                    do{
                        option2 = JOptionPane.showInputDialog("""
                                1. Agregar Libro
                                2. Editar Libro
                                3. Eliminar Libro
                                4. Listar Libros
                                5. Buscar Por ID
                                6. Buscar Por Nombre
                                8. Salir
                                Seleccione una opcion
                                """);
                        switch (option2){
                            case "1":
                                    objLibroController.create();
                                break;
                            case "2":
                                objLibroController.edit();
                                break;
                            case "3":
                                objLibroController.delete();
                                break;
                            case "4":
                                objLibroController.getAll();
                                break;
                            case "5":
                                objLibroController.buscaId();
                                break;
                            case "6":
                                objLibroController.buscar();
                                break;
                        }

                    }while (!option2.equals("8"));

            }


        }while (!opcion.equals("3"));


    }
}
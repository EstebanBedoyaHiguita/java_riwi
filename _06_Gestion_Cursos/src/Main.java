import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //
        Curso objCurso = new Curso();
        Scanner objScan = new Scanner(System.in);
        GestionCurso objGestion = new GestionCurso();

        int option = 0;

        do{
            System.out.println("""
                    1. Administrar Cursos
                    2. Administrar Estudiantes
                    3. Salir
                    """);
            option = objScan.nextInt();

            switch (option){

                case 1:
                    int option2 =0;

                    do{
                        System.out.println("""
                            MENU DE CURSOS
                            
                            1.Crear un curso
                            2.Buscar Curso por codigo
                            3.Listar curso
                            4.Salir
                            """);
                        option2 = objScan.nextInt();

                        switch (option2){

                            case 1:
                                objGestion.guardarCurso(objScan);
                                break;

                            case 2 :
                                System.out.println("Ingresa el codigo del curso");
                                String codigo = objScan.next();
                                System.out.println(objGestion.buscarPorCodigo(codigo).toString());

                                break;
                            case 3:
                                objGestion.listarCursos();
                                break;
                        }
                    }while (option2 != 4);

                    break;
                case 2:
                    int opcion3 =0;

                    do {
                        System.out.println("""
                                MENU GESTION ESTUDIANTE
                                1.Agregar un estudiante
                                2.Eliminar estudiante
                                3.Listar Estudiantes
                                4.Salir
                                """);
                        opcion3 = objScan.nextInt();


                        switch (opcion3){

                            case 1:
                                objGestion.listarCursos();
                                System.out.println("Ingrese el codigo del curso que desea inscribir el estudiante");
                                String codigo = objScan.next();
                                Curso curso = objGestion.buscarPorCodigo(codigo);
                                if(curso == null){
                                    System.out.println("Curso no encontrado");
                                }else{
                                    curso.guardarEstudiante(objScan);
                                }
                                break;

                            case 2:
                                objGestion.listarCursos();
                                System.out.println("Ingrese el codigo del curso en el que desea eliminar  el estudiante");
                                codigo = objScan.next();
                                curso = objGestion.buscarPorCodigo(codigo);
                                if(curso == null){
                                    System.out.println("Curso no encontrado");
                                }else{
                                    curso.eliminarEstudiante(objScan);
                                }

                                break;

                            case 3:
                                objGestion.listarCursos();
                                System.out.println("Ingrese el codigo del curso que desea inscribir el estudiante");
                                 codigo = objScan.next();
                                 curso = objGestion.buscarPorCodigo(codigo);
                                if(curso == null){
                                    System.out.println("Curso no encontrado");
                                }else{
                                    curso.listarEstudiantes();
                                }

                                break;
                        }
                    }while (opcion3 !=4);
                    break;

            }

        }while (option != 3);

    }
}
import java.util.Scanner;
import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner objScan = new Scanner(System.in);
    GestionEmpleados objEmpleado = new GestionEmpleados();

int option = 0;

do {
    System.out.println("""
            1. Añadir Empleado
            2. Eliminar Empleado
            3. Listar Empleado
            4. Salir
            """);
        option = objScan.nextInt();

        switch (option) {

                case 1:
                    int option2 = 0;

                    do {
                        System.out.println("""
                                1. Agregar Empleado Temporal
                                2. Agregar Empleado Permanente
                                3. Salir""");
                        option2 = objScan.nextInt();
                        switch (option2) {
                            case 1:
                                objEmpleado.agregarEmpleadoTemporal(objScan);
                                break;
                            case 2:
                                objEmpleado.agregarEmpleadoPermanente(objScan);
                                break;
                        }


                    } while (option2 != 3);
                    break;
                case 2:
                    objEmpleado.listarEmpleados();
                    System.out.println("Ingrese el id del empleado que desea eliminar");
                    objEmpleado.eliminarEmpleado(objScan);

                    break;

                case 3:
                    System.out.println("***Listado Actual De Empleados");
                    objEmpleado.listarEmpleados();


                break;
            }

        } while (option != 4);
    }





}//Fin class
import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio02Cine {
    public static void main (String[] args){


//        3. Sistema de Reservas: Desarrolla un programa para un teatro para gestionar las
//        reservas de asientos. El teatro tiene 5 filas con 10 asientos cada una. Utiliza un
//        arreglo bidimensional de boolean donde true representa un asiento ocupado y false
//        uno disponible. El sistema debe permitir:
        // Reservar y cancelar asientos.
        // Mostrar los asientos disponibles.
        // Contabilizar el total de asientos ocupados y disponibles.


        //Creamos la matriz que nos permitira guardar el estado de todos los asientos

//        boolean [][] listaAsientos = new boolean[5][10];
//
//        Scanner objScanner = new Scanner(System.in);
//
//        //Variable para guardar la opcion del usuario
//
//        int opcion ;
//        int fila ;
//        int asiento;
//
//        do{
//            objScanner.nextLine();
//            System.out.println("\nEnter para continuar");
//            objScanner.nextLine();
//
//            System.out.println("Reserva de sillas teatro");
//            System.out.println("1.Reservar asientos");
//            System.out.println("2.Cancelar asientos");
//            System.out.println("3.Mostrar asientos disponibles");
//            System.out.println("4.Contabilizar total asientos ocupados y disponibles");
//            System.out.println("5.Salir");
//            System.out.println("Ingresar una opcion");
//
//            //Leemos la opcion elegible por el usuario
//            opcion = objScanner.nextInt();
//
//
//            switch (opcion){
//                case 1 :
//                    System.out.println("Ingrese la fila (1-5");
//                    fila = objScanner.nextInt() -1;
//                    System.out.println("ingrese el asiento (1-10");
//                    asiento = objScanner.nextInt()-1;
//
//                    if(!listaAsientos[fila][asiento]){
//                        listaAsientos[fila][asiento] = true;
//                        System.out.println("Asiento reservado correctamente");
//
//                    }else {
//                        System.out.println("El asiento se encuentra reservado");
//                    }
//                    break;
//                case 2:
//                    System.out.println("Ingrese la fila (1-5");
//                    fila = objScanner.nextInt() -1;
//                    System.out.println("ingrese el asiento (1-10");
//                    asiento = objScanner.nextInt()-1;
//
//                    if(listaAsientos[fila][asiento]){
//                        listaAsientos[fila][asiento] = false;
//                        System.out.println("Reserva cancelada");
//                    }else {
//                        System.out.println("Este asiento se encuentra libre");
//                    }
//
//                    break;
//                case 3:
//                    System.out.println("Asientos disponibles (fila-asiento)");
//
//                    for(int i = 0; i < listaAsientos.length; i++){
//                        System.out.print("\n F"+(i+1)+":");
//
//                        for(int j = 0; j < 10;j++){
//                            if(listaAsientos[i][j]){
//                                System.out.print("S"+(j+1)+"✔️");
//                            }else{
//                                System.out.print("S"+(j+1)+"❌");
//                            }
//                        }
//                    }break;
//                case 4:
//                    int ocupados =0,disponibles = 0;
//
//                    for(boolean[] filaAsientos: listaAsientos){
//                        for (boolean asientoOcupado: filaAsientos){
//                            if(asientoOcupado){
//                                ocupados++;
//                            }else {
//                                disponibles++;
//                            }
//                        }
//                    }
//
//                    System.out.println("\nTotal de asientos ocupado:"+ ocupados);
//                    System.out.println("Total de asientos disponibles:" + disponibles);
//
//                    break;
//            }
//
//
//
//
//
//
//        }while (opcion != 5);

//        2. Buscador de Número Mayor y Menor: Utiliza un array de int para almacenar 5
//        números enteros ingresados por el usuario (puedes usar la clase Scanner para la
//        entrada de datos). El programa debe encontrar y mostrar el número mayor y el
//        menor de la lista.

        int [] datos = new int [5];


        for(int i = 0; i < datos.length;i++) {
            String info = JOptionPane.showInputDialog(null, "Ingrese el dato" + (1 + i));
            int datoint = Integer.parseInt(info);

            datos[i] = datoint;


        }

//        mostrar un array
        System.out.println(Arrays.toString(datos));
        int menor=datos[0];
        int mayor=datos[0];

        for(int i = 0; i < datos.length;i++){
            if( menor > datos[i]){
                menor = datos[i];
            }

            if(mayor < datos[i]){
                mayor = datos[i];
            }
        }
        JOptionPane.showMessageDialog(null,"El numero menor es :"+menor+""+"El numero mayor es :"+mayor);





    }
}

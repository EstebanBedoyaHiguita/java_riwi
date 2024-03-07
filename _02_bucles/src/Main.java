import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Contador Simple: Escribe un programa que utilice un bucle for para contar del 1 al 10 e
        //imprimir cada número en la consola.

//        for(int i = 1; i <=10; i++){
//            System.out.println(i);
//        }
        //Suma de Números: Utiliza un bucle while para sumar los números del 1 al 100 e imprimir
        //el resultado.

//        int contador = 0;
//        int sumaTotal = 0;
//
//        while (contador <= 100){
//            sumaTotal += contador;
//            contador++;
//
//        }
//        System.out.println(sumaTotal);

//        Tabla de Multiplicar: Utiliza un bucle for anidado para imprimir la tabla de multiplicar
//        del 1 al 10.

//        for (int i = 1; i <= 10; i++) {
//            System.out.println("tabla de :"+i);
//            for (int j = 1; j < 10 ; j++) {
//                System.out.println(i+"x" +j+"="+(i*j));
//
//            }
//        }

//Sistema de Menú Interactivo: Desarrolla un sistema de menú interactivo que muestre
//diferentes opciones al usuario (por ejemplo, 1. Ver saldo 2. Depositar dinero 3. Retirar
//dinero 4. Salir). Utiliza un bucle para permitir al usuario interactuar con el menú hasta que
//elija salir.
//        String option;
//        double saldo=0;
//        do {
//             option = JOptionPane.showInputDialog(null,"\n\n MENU OPTION"+ "\n\n" +
//                    "1.Ver saldo\n"+
//                    "2.Depositar dinero\n"+
//                    "3.Retirar Dinero\n"+
//                    "4.Salir\n\n"+
//                    "Ingrese una opcion");
//            switch (option){
//                case "1":
//                    JOptionPane.showMessageDialog(null,"Tu saldo hasta el momento es: $"+ saldo);
//                    break;
//                case "2":
//                    String precioString = JOptionPane.showInputDialog(null,"Ingresa el valor a depositar\n" );
//                    try{
//                        double precio = Double.parseDouble(precioString);
//                        saldo += precio;
//                        JOptionPane.showMessageDialog(null,"Dinero ingresado correctamente\n"+"Tu saldo es "+saldo);
//                    }
//                    catch (Exception e){
//                        JOptionPane.showMessageDialog(null,"El valor no es valido");
//                    }
//                    break;
//
//                case "3":
//                    try{
//                        double valorRetirar = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa el valor a retirar"));
//
//
//                        if(valorRetirar <= saldo){
//                            saldo -= valorRetirar;
//                            JOptionPane.showMessageDialog(null,"Retiro correcto");
//                        }else{
//                            JOptionPane.showMessageDialog(null,"Saldo insuficiente");
//                        }
//                    }
//                    catch (Exception e){
//                        JOptionPane.showMessageDialog(null,"El valor no es valido");
//                    }
//
//
//            }
//        }while (!option.equals("4"));

//        Cálculo de Interés Compuesto: Crea un programa que calcule el crecimiento de una
//        inversión bajo un esquema de interés compuesto. El usuario debe poder ingresar el capital
//        inicial, la tasa de interés anual y el número de años. Utiliza un bucle para calcular y mostrar
//        el saldo de la inversión al final de cada año.

        String option;

        double capitalInicial;
        double años;
        double interes;



        do {

            if(años < 3){

            }
            option = JOptionPane.showInputDialog(null, "\n\n MENU OPTION" + "\n\n" +
                    "1.Ingresar capital inicial\n" +
                    "2.Escoger el numero de años\n" +
                    "3.Ingrese la tase de interes de su ahorro\n" +
                    "4.Salir\n\n" +
                    "Ingrese una opcion");


            switch (option) {
                case "1":
                    capitalInicial = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el valor del capital incial"));
                    break;
                case "2":
                    años = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el numero de años en que desea hacer su ahorro"));

                    break;

                case "3":

                    interes = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el porcentaje sobre el que desea realizar su ahorro"));

                    break;


            }




        }while (!option.equals("4"));

//        Suma de Números Pares: Escribe un programa que sume solo los números pares del 1 al
//        100 usando un bucle for y luego imprime el resultado.

//        int contador = 0;
//
//        for(int i = 1; i <= 100; i++){
//            if(i % 2 == 0){
//                contador += i;
//
//                System.out.println("la suma de los numeros pares es :" + contador);
//            }
//        }
//        5. Validación de Entrada de Usuario: Escribe un programa que solicite al usuario que
//        ingrese su edad. Si el usuario ingresa un valor que no es un número válido o está fuera de
//        un rango razonable (por ejemplo, 0-120), el programa debe pedirle al usuario que intente de
//        nuevo. Utiliza un bucle para seguir solicitando la entrada hasta que sea válida.

        String edadInput = JOptionPane.showInputDialog(null,"Ingresa tu edad\n" );



    }
}

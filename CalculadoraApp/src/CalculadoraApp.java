import java.util.Scanner;

public class CalculadoraApp {
    public static  void main(String[] args){

        Scanner consola = new Scanner(System.in);

        while (true) {
            System.out.println("**** Aplicacion calculadora ****");

            //Mostramos el menu
            System.out.println("""
                    1.Suma
                    2.Resta
                    3.Multiplicacion
                    4:Division
                    5.Salir
                    """);
            System.out.println("La operacion a realizar es ?");
            var operacion = Integer.parseInt(consola.nextLine());

            //Revisar que este dentro de las opciones
            if (operacion >= 1 && operacion <= 4) {

                System.out.print("Proporciona valor operando1:");


                var operando1 = Integer.parseInt(consola.nextLine());
                System.out.print("Proporciona valor operando2:");

                var operando2 = Integer.parseInt(consola.nextLine());
                int resultado;

                switch (operacion) {

                    case 1 -> {
                        resultado = operando1 + operando2;
                        System.out.println("Resultado Suma:\n" + resultado);

                    }


                    case 2 -> {
                        resultado = operando1 - operando2;
                        System.out.println("Resultado Resta:\n" + resultado);
                    }

                    case 3 -> {
                        resultado = operando1 * operando2;
                        System.out.println("Resultado Multiplicacion:\n" + resultado);

                    }
                    case 4 -> {
                        resultado = operando1 / operando2;
                        System.out.println("Resultado Division:\n" + resultado);
                    }

                    default -> System.out.println("Opcion erronea:\n" + operacion);

                }

            }
            else if (operacion == 5) {
                System.out.println("Hasta pronto");
                break;

            } else {
                System.out.println("Opcion erronea");
            }
            System.out.println();
        }
    }
}

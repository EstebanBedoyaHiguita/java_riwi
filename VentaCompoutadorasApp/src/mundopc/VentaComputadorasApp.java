package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class VentaComputadorasApp {
    public static void main(String[] args) {
    //Crear objetos

        Raton ratonLenovo = new Raton("bluthooth","Lenovo");

        //System.out.println(ratonLenovo);

        Teclado  tecladoLenovo = new Teclado("bluethooth","Lenovo");
        //System.out.println(tecladoLenovo);

        Monitor monitorLenovo = new Monitor("Lenovo",27);
        //System.out.println(monitorLenovo);

        //CReamos un objeto Computadora
        Computadora computadoraLanovo = new Computadora("Computadora lenovo",monitorLenovo,tecladoLenovo,ratonLenovo);
        //System.out.println(computadoraLanovo);

        //Creamos un orden


        //Objeto computadora
        Monitor monitorDell =new Monitor("Dell", 15);
        Teclado tecladoDell = new Teclado("USB","DEll");
        Raton ratonDell = new Raton("USB","Dell");
        Computadora computadoraDell = new Computadora("Computadora Dell",monitorDell,tecladoDell,ratonDell);

        //Computadora mac

        Monitor monitorMac = new Monitor("Mac",14);
        Teclado tecladoMac = new Teclado("Usb","Mac");
        Raton ratonMac = new Raton("Usb","Mac");
        Computadora computadoraMac = new Computadora("iMac",monitorMac,tecladoMac,ratonMac);


        Orden orden1 = new Orden();

        orden1.agregarComputadora(computadoraLanovo);
        orden1.agregarComputadora(computadoraDell);
        orden1.mostrarOrden();


        Orden orden2 = new Orden();

        orden2.agregarComputadora(computadoraMac);
        orden2.agregarComputadora(computadoraDell);
        orden2.agregarComputadora(computadoraLanovo);
        System.out.println();
        orden2.mostrarOrden();







    }
}
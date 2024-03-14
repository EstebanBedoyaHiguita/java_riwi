import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario objInventario = new Inventario();
        Scanner objScanner = new Scanner(System.in);
        Main main = new Main();


        Producto pro1 = new Producto(1, "Lápiz", 2000);
        Producto pro2 = new Producto(2, "cuaderno", 7000);

        objInventario.agregarProducto(pro1);
        objInventario.agregarProducto(pro2);

        System.out.println("Lista de productos");
        objInventario.listarProductos();

        objInventario.eliminarProducto(1);
        System.out.println("Lista despues de eliminar");
        objInventario.listarProductos();

        System.out.println(objInventario.buscarPorNombre("cuaderno"));

        int option = objScanner;
        do {
            option = main.mostrarMenu();

            try {


                switch (option) {

                    case 1:
                        int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de id"));
                        String nombre = JOptionPane.showInputDialog(null,"Escriba el nombre del producto");
                        double precio =Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el precio del producto"));
                        String categoria = JOptionPane.showInputDialog(null,"Ingrese la categoria del producto");
                        String marca = JOptionPane.showInputDialog(null,"Ingrese la marca del producto");
                        ProductoEspecifico nuevoProducto = new ProductoEspecifico( id, nombre,precio,categoria,marca);
                        objInventario.agregarProducto(nuevoProducto);
                        break;

                    case 2:
                        int productoEliminar = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el id del producto que desea eliminar"));
                        objInventario.eliminarProducto(productoEliminar);
                        break;

                    case 3:
                        objInventario.listarProductos();
                        break;

                    case 4:
                        String buscarProducto = JOptionPane.showInputDialog(null,"Ingrese el nombre del producto que desea buscar");
                        objInventario.buscarPorNombre(buscarProducto);
                        break;

                    case 5: if (option == 5){

                    }



                }


            } catch (Exception e) {
                System.out.println("Eleccion no valida" + e.getMessage());
            }

        }while (true);



    }

    public int mostrarMenu () {
        System.out.println("""
                    ***Inventario***
                    1. Agregar producto
                    2. Eliminar Producto
                    3. Ver productos
                    4. Buscar productos
                    5. Salir
                    Seleccionar una opción
                    """);
        System.out.println();
    }
}
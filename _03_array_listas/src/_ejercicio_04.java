import javax.swing.*;
import java.util.ArrayList;
public class _ejercicio_04 {public static void main(String[] args){

//    4. Planificador de Viajes: Escribe un programa para ayudar a planificar viajes por
//    carretera. Los usuarios pueden ingresar varias ciudades que planean visitar en
//    orden. Utiliza un arreglo de String para almacenar las ciudades. El programa debe
//    ser capaz de:
// Añadir y remover ciudades del itinerario.
// Mostrar la lista completa de ciudades a visitar.
// (Opcional) Calcular la distancia total del viaje asumiendo distancias ficticias entre
//
   //instancear la clase _ejercicio_04
_ejercicio_04 main = new _ejercicio_04();

     ArrayList <String> ciudades = new ArrayList<String>();
       int option = 0;
       do{
           option = main.showMenu();
           switch (option) {

               case 1:

                   main.addNewCity(ciudades);
                  break;

               case 2:
                   main.removeCities(ciudades);

                   break;
               case 3:
                   main.seeCities(ciudades);

                   break;

               case 4:
                   main.calculateDistance();

                   break;



           }

       } while (option != 5);




}
    private void addNewCity(ArrayList<String> ciudades){
     int repeat = 0;

     while (repeat == 0) {

         String ciudad =JOptionPane.showInputDialog(null,"Ingrese el nombre de la ciudad que desea visitar");
         if(ciudad.isEmpty()){
             JOptionPane.showMessageDialog(null,"Caracter no valido");
             return;
         }
         ciudades.add(ciudad);
         repeat = JOptionPane.showConfirmDialog(null,"Desea agregar mas ciudades?");
     };






    }
    private void calculateDistance(){
    
    }
    private  void seeCities(ArrayList<String> ciudades){
       JOptionPane.showMessageDialog(null,"Las ciudades que ha elegido para visitar son:"+ ciudades);
    }
    private void removeCities(ArrayList<String> ciudades) {
    ciudades.remove(JOptionPane.showInputDialog(null,"Ingrese el nombre de la ciudad que desea eliminar"));
    }

    private void addCity(ArrayList<String> ciudades) {

    String ciudad =JOptionPane.showInputDialog(null,"Ingrese el nombre de la ciudad que desea visitar");
        if(ciudad.isEmpty()){
            JOptionPane.showMessageDialog(null,"Caracter no valido");
            return;
        }
        ciudades.add(ciudad);



    }

    public  int showMenu (){
        return Integer.parseInt(JOptionPane.showInputDialog(null,
                "1.Add city \n"+
                "2.Remove city  \n"+
                "3.See cities list\n"+
                "4.Calculate distance\n"+
                "5.Salir"));
    }
}

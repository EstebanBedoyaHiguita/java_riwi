import javax.swing.*;
import java.util.ArrayList;

public class Ejercicio05 {
    public static void main(String[] args) {
//        5. Lista de Reproducción Musical: Imagina que estás creando una aplicación para
//        gestionar listas de reproducción musicales. Cada canción es representada
//        simplemente por su nombre. El programa debe permitir:
// Añadir y remover canciones de la lista de reproducción.
// Mostrar la canción actual y las siguientes en la lista.
// Saltar a la siguiente canción.

        //Creacion de la lista de canciones
        ArrayList <String>playList = new ArrayList<String>();
        int option = 0;
        int cancionActual = 0;
        do {
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog(null,"PLAYLIST\n"+
                        "1.Agregar cancion\n"+
                        "2.Remover Cancion\n"+
                        "3.Mostrar cancion actual y siguiente en la lista\n"+
                        "4.Saltar a la siguiente cancion\n"+
                        "5.Salir\n"+
                        "Ingrese una opcion"));

                switch (option){

                    case 1: //Añadir una cancion

                        //Pedimos la nueva cancion al usuario
                        String nuevaCancion = JOptionPane.showInputDialog(null,"Ingrese el nombre de la cancion que desea agregar");
                        //Agregamos la nueva cancion a la playlist
                        if(nuevaCancion.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Caracter no valido");
                            break;
                        }

                        playList.add(nuevaCancion.toLowerCase());

                        JOptionPane.showMessageDialog(null,"Cancion agregada correctamente 🎶");
                        break;

                    case 2:
                        String eliminarCancion = JOptionPane.showInputDialog(null,"Ingrese el nombre de la cancion que desea eliminar");

                        if(playList.remove(eliminarCancion.toLowerCase())){
                            JOptionPane.showMessageDialog(null,"Cancion eliminada correctamente ❌");

                        }else {
                            JOptionPane.showMessageDialog(null,"Cancion no existe ❌");

                        }

                        break;

                    case 3:
                        //mostrar la cancion actual y la siguiente en la lista

                        //Preguntar si la playlist esta vacia
                        if (playList.isEmpty()){
                            JOptionPane.showMessageDialog(null,"La playlist esta vacia");
                        }else {
                            //Creamos una variable para guardar en texto todas las canciones mayores a la actual
                            String listaTotal = "";

                            //Agregamos la cancion actual
                            listaTotal ="Cancion actual\n"+ playList.get(cancionActual)+"\n"+"\n Siguientes en la lista\n";

                            for(int i = cancionActual; i < playList.size()-1;i++){
                                //por cada iteracion concatenamos a la variable lista total
                                listaTotal +="🎶"+ playList.get(i+1);



                            }
                            JOptionPane.showMessageDialog(null,listaTotal);

                        }
                        break;

                    case 4://Salta a la cancion siguiente

                        //Validar que haya una siguiente cancion

                        if(cancionActual+1 < playList.size()){
                            cancionActual++;
                            JOptionPane.showMessageDialog(null,playList.get(cancionActual)+"Reproducida correctamente");
                        }else {
                            JOptionPane.showMessageDialog(null,"Playlist finalizada");
                            cancionActual = 0;

                        }

                        break;
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Caracter no valido");

            }



        }while (option != 5);
    }
}

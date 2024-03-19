package controller;

import entity.Coder;
import model.CoderModel;

import javax.swing.*;
import java.util.List;

public class CoderController {

    CoderModel objCoderModel;

    public CoderController(){
        //Crear una instancia del  model

        this.objCoderModel = new CoderModel();
    }

    //Metodo para listar todos los coders
    public void getAll(){
        String list = "List Coders \n";

        // iteramos sobre la lista que devuelve el metodo fin all
        for(Object obj : this.objCoderModel.finAll()){

            //Convertimos o casteamos el objeto tipo Object a un coder
            Coder objCoder  = (Coder)obj;

            list += objCoder.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null,list);

    }

    //Metodo para crea coder
    public void create (){
        Coder objCoder =  new Coder();
        String name = JOptionPane.showInputDialog("Insert name");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Insert age"));
        String clan = JOptionPane.showInputDialog("Insert Clan");

        objCoder.setName(name);
        objCoder.setAge(age);
        objCoder.setClan(clan);

        objCoder = (Coder) this.objCoderModel.insert(objCoder);

        JOptionPane.showMessageDialog(null,objCoder.toString());

    }

    //Metodo para buscar por nombre

    public void buscar (){
        String name = JOptionPane.showInputDialog("Insert name");
        List<Object> listCoders = objCoderModel.findName(name);

        String srtlistaCoders = "";

        if(listCoders.isEmpty()){
            JOptionPane.showMessageDialog(null,"La lista esta vacia");

        }else {
            for(Object obj: listCoders){
                Coder objCoder = (Coder) obj;
                srtlistaCoders += objCoder.toString()+"\n";

            }
            JOptionPane.showMessageDialog(null,"Coders encontrados:" + srtlistaCoders);
        }
    }

    //Metodo para buscar por id
    public void buscarId (){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insert id"));

        Coder objCoder =(Coder) this.objCoderModel.findById(id);

        if (objCoder == null){
            return;
        }else {
            JOptionPane.showMessageDialog(null,objCoder.toString());
        }



    }

}

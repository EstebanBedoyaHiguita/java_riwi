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

    //Metodo para editar

    public  void  edit (){
        String listCoderString = "CODER LIST \n";
        int confirm = 1;

        for (Object obj:this.objCoderModel.findAll()){
            Coder objCoder = (Coder) obj;
            listCoderString += objCoder.toString() + "\n";
        }
        int idEdit = Integer.parseInt((JOptionPane.showInputDialog(listCoderString + "Enter ID of the coder to edit")));
        Coder objCoder  = (Coder) this.objCoderModel.findById(idEdit);
        if (objCoder == null){
            JOptionPane.showMessageDialog(null,"El id no fue encontrado");

        }else{

            confirm = JOptionPane.showConfirmDialog(null,"Esta seguro de editar este usuario");
            if (confirm == 0){
                objCoder.setName(JOptionPane.showInputDialog("Ingrese el nuevo nombre"));
                objCoder.setAge(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad")));
                objCoder.setClan(JOptionPane.showInputDialog("Ingrese el nuevo clan"));
                this.objCoderModel.update(objCoder);
            }
        }
    }
    //Metodo para eliminar

    public void delete (){
        String listCoderString = "CODER LIST \n";
        int comfirm = 1;

        for(Object obj: this.objCoderModel.findAll()){
            Coder objCoder = (Coder) obj;
            listCoderString += objCoder.toString() + "\n";

        }

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listCoderString + "Enter the ID of the coder to delete"));
        Coder objCoder = (Coder) this.objCoderModel.findById(idDelete);

        if (objCoder == null){
            JOptionPane.showMessageDialog(null,"Id no encontrado");
        }else {
            comfirm = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar este usuario");
            if(comfirm == 0){
                this.objCoderModel.delete(objCoder);
            }
        }

    }

    //Metodo para listar todos los coders
    public void getAll(){
        String list = "List Coders \n";

        // iteramos sobre la lista que devuelve el metodo fin all
        for(Object obj : this.objCoderModel.findAll()){

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

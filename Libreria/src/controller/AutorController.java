package controller;

import entity.Autor;
import entity.Libro;
import model.AutorModel;

import javax.swing.*;
import java.util.List;


public class AutorController {
    AutorModel objAutorModel;

    public AutorController(){

        this.objAutorModel = new AutorModel();
    }

    public void create (){
        Autor objAutor = new Autor();
        String name = JOptionPane.showInputDialog("Ingrese el nombre");
        String nacionalidad = JOptionPane.showInputDialog("Ingrese la nacionalidad");

        objAutor.setNombre(name);
        objAutor.setNacionalidad(nacionalidad);

        objAutor = (Autor) this.objAutorModel.insert(objAutor);
        JOptionPane.showMessageDialog(null,objAutor.toString());
    }

    public void edit(){
        String listAutorString = "AUTOR LIST\n";
        int confirm = 1;

        for(Object obj:this.objAutorModel.findAll()){
            Autor objAutor = (Autor) obj;
            listAutorString += objAutor.toString() + "\n";
        }

        int idEdit = Integer.parseInt((JOptionPane.showInputDialog(listAutorString + "Ingresar el ID del autor que desea editar")));
        Autor objAutor = (Autor) this.objAutorModel.findById(idEdit);
        if (objAutor == null){
            JOptionPane.showMessageDialog(null,"El id no fue encontrado");
        }else{
            confirm = JOptionPane.showConfirmDialog(null,"Esta seguro de editar este usuario");
            if (confirm ==0){
                objAutor.setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre"));
                objAutor.setNacionalidad(JOptionPane.showInputDialog("Ingrese la nueva nacionalidad"));
                this.objAutorModel.update(objAutor);
            }
        }
    }

    public void delete(){
        List<Object> listAutores = objAutorModel.findAll();

        Autor[] listAutors = new Autor[listAutores.size()];
        int index = 0;
        for (Object iterados : listAutores){
            Autor obj = (Autor) iterados;
            listAutors[index] = obj;
            index++;
        }

        Autor autorSelected = (Autor) JOptionPane.showInputDialog(
                null,
                "Select a role:\n",
                "Choosing role",
                JOptionPane.QUESTION_MESSAGE,
                null,
                listAutors,
                listAutors[0]);



        this.objAutorModel.delete(autorSelected);

//

    }

    public void getAll(){
        String list = "LIST AUTORES \n";

        for(Object obj: this.objAutorModel.findAll()){
            Autor objAutor = (Autor) obj;
            list += objAutor.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,list);

    }



    public  void buscar (){
        String name = JOptionPane.showInputDialog("Ingrese el nombre");
        List <Object> listAutores = objAutorModel.findName(name);

        String srtlistAutores = "";

        if(listAutores.isEmpty()){
            JOptionPane.showMessageDialog(null,"La lista esta vacia");

        }else{
            for(Object obj : listAutores){
                Autor objAutor = (Autor) obj;
                srtlistAutores += objAutor.toString()+"\n";
            }
            JOptionPane.showMessageDialog(null,"Autores encontrados:"+srtlistAutores);
        }
    }

    public void buscarId(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id que desea buscar"));

        Autor objAutor = (Autor) this.objAutorModel.findById(id);
        if(objAutor == null){
            return;
        }else {
            JOptionPane.showMessageDialog(null,objAutor);
        }
    }
}

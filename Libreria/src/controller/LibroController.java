package controller;

import entity.Autor;
import entity.Libro;
import model.AutorModel;
import model.LibroModel;

import javax.swing.*;
import java.util.List;

public class LibroController {

    LibroModel objLibroModel;
    AutorModel objAutorModel;
    AutorController objAutorcontroler = new AutorController();
    
    public LibroController(){

        this.objLibroModel = new LibroModel();
        this.objAutorModel = new AutorModel();

    }

    public void create (){



        Libro objLibro = new Libro();
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro ");
        int año_de_publicacion =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de publicacion del libro")) ;
        int precio =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del libro")) ;
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


        objLibro.setTitulo(titulo);
        objLibro.setAño_de_publicacion(año_de_publicacion);
        objLibro.setPrecio(precio);
        objLibro.setIdautor(autorSelected.getId());



        objLibro = (Libro) this.objLibroModel.insert(objLibro);

        JOptionPane.showMessageDialog(null,objLibro.toString());

    }

    public void edit (){
        String listLibros = "LISTA DE LIBROS\n";

        int confirm = 1;

        for(Object obj:this.objLibroModel.findAll()){
            Libro objLibro = (Libro) obj;
            listLibros += objLibro.toString();
        }
        int idEdit = Integer.parseInt(JOptionPane.showInputDialog(listLibros + "Ingrese el ID del libro que desea editar"));
        Libro objLibro = (Libro) this.objLibroModel.findById(idEdit);

        if(objLibro == null){
            JOptionPane.showMessageDialog(null,"El ID no fue encontrado");
        }else{
            confirm = JOptionPane.showConfirmDialog(null,"Esta seguro de editar este libro?");
            if(confirm == 0){
                objLibro.setTitulo(JOptionPane.showInputDialog("Ingrese el nuevo titulo"));
                objLibro.setAño_de_publicacion(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo año de publicacion")));
                objLibro.setPrecio(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio")));
                this.objLibroModel.update(objLibro);
            }
        }
    }

    public void delete (){
        String listLibros = "LISTA DE LIBROS \n";

        int confirm = 1;

        for (Object obj:this.objLibroModel.findAll() ){
            Libro objLibro = (Libro) obj;
            listLibros += objLibro.toString() + "\n";
        }
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listLibros + "Selecciones el ID del libro que desea eleminiar"));
        Libro objLibro= (Libro) this.objLibroModel.findById(idDelete);

        if(objLibro == null){
            JOptionPane.showMessageDialog(null,"Id no encontrado");
        }else{
            confirm = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar este usuario?");
            if(confirm == 0 ){
                this.objLibroModel.delete(objLibro);
            }
        }
    }

    public void getAll (){
        String list = "Lista de libros \n";

        for(Object obj:this.objLibroModel.findAll()){
            Libro objLibro = (Libro) obj;
            list += objLibro.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,list);
    }

    public  void buscaId(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del libro que desea buscar"));
        Libro  objLibro = (Libro) this.objLibroModel.findById(id);

        if(objLibro == null){
            return;
        }else{
            JOptionPane.showMessageDialog(null,objLibro.toString());
        }
    }

    public void buscar(){
        String name = JOptionPane.showInputDialog("Ingrese el titulo del lobro");
        List<Object> listLibros = objLibroModel.findName(name);

        String srtlistaLibros = "";

        if(listLibros.isEmpty()){
            JOptionPane.showMessageDialog(null,"Lista vacia");
        }else {
            for (Object obj:listLibros){
                Libro objLibro = (Libro) obj;
                srtlistaLibros += objLibro.toString() + "\n";
            }
        }
    }
}

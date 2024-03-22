package model;

import database.CRUD;
import database.ConfiDB;
import entity.Libro;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroModel implements CRUD {

    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfiDB.openConnection();

        Libro objLibro = (Libro) object;



        try{
            String sql = "INSERT INTO libro (titulo,año_de_publicacion,precio,idautor) VALUES (?,?,?,?)";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setString(1,objLibro.getTitulo());
            objPrepare.setInt(2,objLibro.getAño_de_publicacion());
            objPrepare.setInt(3,objLibro.getPrecio());
            objPrepare.setInt(4,objLibro.getIdautor());


            objPrepare.executeUpdate();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objLibro.setId(objResult.getInt(1));
            }
            objPrepare.close();
            JOptionPane.showMessageDialog(null,"Libro guardado exitosamente");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error agregando libro"+ e.getMessage());
        }
        ConfiDB.closeConnection();
        return objLibro;


    }

    @Override
    public boolean update(Object object) {

        Connection objConnection = ConfiDB.openConnection();
        Libro objLibro = (Libro) object;

        boolean isEdit = false;

        try{
            String sql = "UPDATE libro SET titulo = ?, año_de_publicacion = ?,precio = ?, idautor = ? where id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objLibro.getTitulo());
            objPrepare.setInt(2,objLibro.getAño_de_publicacion());
            objPrepare.setInt(3,objLibro.getPrecio());
            objPrepare.setInt(4,objLibro.getIdautor());

            int totalAfect = objPrepare.executeUpdate();

            if (totalAfect > 0){
                isEdit = true;
                JOptionPane.showMessageDialog(null,"El libro fue editado");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfiDB.closeConnection();


        return isEdit;
    }

    @Override
    public boolean delete(Object object) {
        Libro objLibro = (Libro) object;
        boolean isDelete = false;

        Connection objConnection = ConfiDB.openConnection();

        try{
            String sql = "DELETE FROM libro WHERE id = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1,objLibro.getId());

            int totalAfect = objPrepare.executeUpdate();

            if (totalAfect > 0){
                isDelete = true;
                JOptionPane.showMessageDialog(null,"Libro eliminado correctamentes");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfiDB.closeConnection();


        return isDelete;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection  = ConfiDB.openConnection();

        List<Object> listAutores = new ArrayList<>();

        try{
            String sql = "SELECT * FROM libro ORDER BY libro.id ASC;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = (ResultSet) objPrepare.executeQuery();

            while (objResult.next()){
                Libro objLibro = new Libro();
                objLibro.setId(objResult.getInt("id"));
                objLibro.setTitulo(objResult.getString("titulo"));
                objLibro.setAño_de_publicacion(objResult.getInt("año_de_publicacion"));
                objLibro.setPrecio(objResult.getInt("precio"));
                objLibro.setIdautor(objResult.getInt("idautor"));

                listAutores.add(objLibro);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error al adquirir");
        }
        ConfiDB.closeConnection();
        return listAutores;
    }

    @Override
    public Object findById(int id) {
        Connection objConnection = ConfiDB.openConnection();
        Libro objlibro = new Libro();

        try{
            String sql = "SELECT * FROM libro WHERE id = "+ id +";";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = (ResultSet)objPrepare.executeQuery();

            boolean ressultadoId = objResult.next();

            if (!ressultadoId){
                JOptionPane.showMessageDialog(null,"ID no encontrado");
                return null;
            }else{
                objlibro.setId(objResult.getInt("id"));
                objlibro.setTitulo(objResult.getString("titulo"));
                objlibro.setAño_de_publicacion(objResult.getInt("año_de_publicacion"));
                objlibro.setPrecio(objResult.getInt("precio"));
                objlibro.setIdautor(objResult.getInt("idautor"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la adquisicion");
            System.out.println(e.getMessage());
        }
        ConfiDB.closeConnection();
        return objlibro;
    }

    @Override
    public List<Object> findName(String titulo) {

        Connection objConnection = ConfiDB.openConnection();

        List<Object> listLibros = new ArrayList<>();

        try{
            String sql = "SELECT * FROM libro WHERE titulo LIKE '%" + titulo + "%';";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = (ResultSet) objPrepare.executeQuery();

            while(objResult.next()){
                Libro objLibro = new Libro();
                objLibro.setTitulo(objResult.getString("titulo"));
                objLibro.setAño_de_publicacion(objResult.getInt("año_de_publicacion"));
                objLibro.setPrecio(objResult.getInt("precio"));
                objLibro.setIdautor(objResult.getInt("idautor"));

                listLibros.add(objLibro);
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error en adquisicion");

        }
        ConfiDB.closeConnection();
        return listLibros;
    }


}

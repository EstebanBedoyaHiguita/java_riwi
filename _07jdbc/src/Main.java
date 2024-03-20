import controller.CoderController;
import database.ComfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ComfigDB.openConnection();

        CoderController objCoderController = new CoderController();
        String option = "";
        do{
            option = JOptionPane.showInputDialog("""
                    MENU
                    1. Listar Coders
                    2. Insert Coder
                    3. Update Coder
                    4. Delete Coder
                    5. Search coder by name
                    6. Search by id
                    7. Salir
                    Chose an option
                    """);

            switch (option){

                case "1":
                    //LIst All Coders
                    objCoderController.getAll();
                    break;

                case "2":
                    objCoderController.create();
                    break;
                case "3":
                    objCoderController.edit();
                    break;
                case "4":
                    objCoderController.delete();
                    break;
                case "5":
                    objCoderController.buscar();
                    break;

                case "6":
                    objCoderController.buscarId();
                    break;
            }
        }while (!option.equals("7"));

    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    private static int idEstudiante = 1;


    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaEstudiantes = new ArrayList<>();
    }
    public Curso (){

    }

    public void guardarEstudiante(Scanner objScan){
        System.out.println("Agregar nuevo estudiante");
        System.out.println("Ingrese el nombre del estudiante");
        String nombre = objScan.next();
        System.out.println("Ingrese el email del estudiante");
        String email = objScan.next();

        Estudiante objEstudiante = new Estudiante(idEstudiante,nombre,email);
        idEstudiante ++;

        if(this.listaEstudiantes.add(objEstudiante)){
            System.out.println("Estudiante agregado correctamente");
        }else {
            System.out.println("No se pudo agregar al estudiante");
        }
    }

    public void listarEstudiantes(){

        if(this.listaEstudiantes.isEmpty()){
            System.out.println("El curso\n"+this.nombre +"\nNo tiene estudiantes");
        }else{
            System.out.println("\n Estudiantes inscritos al curso" + this.nombre);
            for (Estudiante estudianteTemp : this.listaEstudiantes){
                System.out.println(estudianteTemp.toString());
            }
        }

    }

    public void eliminarEstudiante(Scanner objScan){
        this.listarEstudiantes();
        System.out.println("Ingrese el id del estudiante que desea eliminiar");
        int idEliminar = objScan.nextInt();
        if(this.listaEstudiantes.removeIf(estudiante -> estudiante.getId() == idEliminar)){
            System.out.println("El estudiante fue eliminado del curso");
        }else{
            System.out.println("El estudiante no se encontro");
        }

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

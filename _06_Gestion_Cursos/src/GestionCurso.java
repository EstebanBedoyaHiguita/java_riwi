import java.util.ArrayList;
import java.util.Scanner;

public class GestionCurso {
    private ArrayList<Curso> listaCursos;

    public GestionCurso(){
        this.listaCursos = new ArrayList<>();

    }

    public void guardarCurso(Scanner objScan){
        System.out.println("Agregar Curso");
        System.out.println("Ingrese el nombre del curso:");
        String nombre = objScan.next();
        System.out.println("Ingrese el codigo del curso");
        String codigo = objScan.next();

        if(this.buscarPorCodigo(codigo)!= null){
            System.out.println("El codigo del curso ya existe");
        }else {
            Curso objcurso = new Curso(codigo,nombre);
            this.listaCursos.add(objcurso);
        }


    }

    public Curso buscarPorCodigo(String codigoBuscar) {
        for (Curso cursoTem : this.listaCursos) {
            if (cursoTem.getCodigo().equalsIgnoreCase(codigoBuscar)) {
                return cursoTem;
            }
        }
        return null;
    }

    public void  listarCursos(){
        if(this.listaCursos.isEmpty()){
            System.out.println("No hay cursos registrados");
        }else {
            System.out.println("Lista de cursos");
            for(Curso temp : this.listaCursos){
                System.out.println(temp.toString());
            }
        }
    }
    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(ArrayList<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
}

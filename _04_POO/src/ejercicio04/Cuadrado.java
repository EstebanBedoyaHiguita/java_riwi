package ejercicio04;

public class Cuadrado extends Rectangulo {

    public Cuadrado (double lado){
        super(lado, lado);
    }

    //No es necesario sobreescribir calcularArea porque al implementar de Rectangulo
    //Ya estamos obteniendo la funcionalidad
}

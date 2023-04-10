package boletin2t5;

public class Linea extends Forma {

    //Atributos
    private double longitud;

    //Constructores con parametros
    public Linea(double longitud) {
        this.longitud = longitud;
    }

    //Getters

    public double getLongitud() {
        return longitud;
    }

    @Override
    public double calcularArea() throws FormasException {
       
         throw new FormasException("No se puede calcular el area de una linea");
        
    }

    @Override
    public String toString() {
        return "Linea [longitud=" + longitud + "]";
    }
    
}

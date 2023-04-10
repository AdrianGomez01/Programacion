package boletin2t5;


public class Circulo extends Forma implements iDibujable {

    //Atributos
    private double radio;
    private double area;
    private final double PI = 3.1416;


    //Constructores con parametros
    public Circulo(double radio, double area) {
        this.radio = radio;
        this.area = area;
    }

    //Getters
    public double getRadio() {
        return radio;
    }

    public double getArea() {
        return area;
    }


    @Override
    public void dibujar() {

        if (radio > 0) {
            System.out.println("Dibujando un circulo con radio: " + radio);
        } else {
            System.out.println("No se puede dibujar un circulo con radio: " + radio);
        }
        
    }

    @Override
    public double calcularArea() {

        if (radio > 0) {
            area = PI * Math.pow(radio, 2);
        } else {
            area = 0;
        }
        return area;
    }

    @Override
    public String toString() {
        return "Circulo [radio=" + radio + ", area=" + area + "]";
    }
    
}


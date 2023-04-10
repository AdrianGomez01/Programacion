package boletin2t5;

public class Rectangulo extends Forma implements iDibujable {

    //Atributos
    private double base;
    private double altura;

    //Constructores con parametros
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    //Getters
    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    
    @Override
    public void dibujar() {

        if (base > 0 && altura > 0) {
            System.out.println("Dibujando un rectangulo con base: " + base + " y altura: " + altura);
        } else {
            System.out.println("No se puede dibujar un rectangulo con base: " + base + " y altura: " + altura);
        }
        
    }

    @Override
    public double calcularArea() {
        double area;
        if (base > 0 && altura > 0) {
            area = base * altura;
        } else {
            area = 0;
        }
        return area;
    }

    @Override
    public String toString() {
        return "Rectangulo [base=" + base + ", altura=" + altura + "]";
    }

}
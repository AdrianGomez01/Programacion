package boletin2t5;


public class Canvas {

    //Atributos
    private Forma[] formas;

    //Constructores con parametros
    public Canvas(Forma[] formas) {
        this.formas = formas;
    }

    //Getters
    public Forma[] getFormas() {
        return formas;
    }

    //Metodos
    public void dibujaYanimaFormas(Forma[] formas) {
        for (Forma forma : formas) {
            if(forma == null) {
                continue;
            }
            if (forma instanceof iDibujable) {
                ((iDibujable) forma).dibujar();
            }
            if (forma instanceof IAnimable) {
                ((IAnimable) forma).animar();
            }
            try {
                forma.calcularArea();
            } catch (FormasException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        Forma[] formas = new Forma[4];
        formas[0] = new Circulo(5, 0);
        formas[1] = new Rectangulo(5, 10);
        formas[2] = new CirculoMovible(5, 0);
        formas[3] = new Linea(0);
        Canvas canvas = new Canvas(formas);
        canvas.dibujaYanimaFormas(formas);

    }
    
}

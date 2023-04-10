package spaceConquerors;


public class Dado implements ILanzable {

    // Constantes
    public static final int CARAS_DEFECTO = 4;
    // Atributos
    int caras;
    int numMin;

    /**
     * Constructor con parámetros
     * 
     * @param caras  numero de caras del dado
     * @param numMin numero minimo del dado
     * @throws DadosException
     */
    public Dado(int caras, int numMin) throws DadosException {
        /*
         * Si no se cumple la condición, se lanza la excepción
         * y se interrumpe la ejecución del constructor
         */
        setCaras(caras);
        setNumMin(numMin);
    }

    // Getters y Setters

    public int getCaras() {
        return caras;
    }

    public void setCaras(int caras) throws DadosException {
        if (caras < CARAS_DEFECTO) {
            throw new DadosException("El numero de caras no puede ser menor que " + CARAS_DEFECTO);
        }
        this.caras = caras;
    }

    public void setNumMin(int numMin) throws DadosException {
        if (numMin < 1) {
            throw new DadosException("El numero mínimo del Dado no puede ser menor que 1");
        }
        this.numMin = numMin;
    }

    // Métodos
    @Override
    public int lanzar() {

        return (int) (Math.random() * (getMax() - getMin() + 1) + getMin());
    }

    @Override
    public int getMin() {

        return numMin;
    }

    @Override
    public int getMax() {

        return getMin() + getCaras() - 1;
    }

}

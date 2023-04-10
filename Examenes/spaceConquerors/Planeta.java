package spaceConquerors;


public class Planeta implements IAtacable {

    //Constantes
    public static final int MAX_PERSONAS = 30;
    public static final int MAX_UNIDADES_PIEDRA = 5;
    public static final int MAX_UNIDADES_HIERRO = 4;
    public static final int MAX_UNIDADES_COMBUSTIBLE = 2;
    public static final int MAX_UNIDADES_MINAS = 10;

    //Atributos
    private String nombre;
    private int personas;
    private int unidadesPiedra;
    private int unidadesHierro;
    private int unidadesCombustible;
    private int Minas[]; //Array de minas

    //Constructor con parámetros
    public Planeta(String nombre, int personas, int unidadesPiedra, int unidadesHierro, int unidadesCombustible) {
        this.nombre = nombre;
        this.personas = personas;
        this.unidadesPiedra = unidadesPiedra;
        this.unidadesHierro = unidadesHierro;
        this.unidadesCombustible = unidadesCombustible;
        this.Minas = new int[MAX_UNIDADES_MINAS];
    }
    

    //Getters

    public String getNombre() {
        return nombre;
    }

    public int getPersonas() {
        return personas;
    }

    public int getUnidadesPiedra() {
        return unidadesPiedra;
    }

    public int getUnidadesHierro() {
        return unidadesHierro;
    }

    public int getUnidadesCombustible() {
        return unidadesCombustible;
    }

    public int[] getMinas() {
        return Minas;
    }

    //Métodos

    /**
     * Método que muestra los habitantes de un planeta
     * @return
     * @throws PlanetasException
     */

    public int mostrarHabitantes() throws PlanetasException {
        /*
         * Si el planeta no tiene habitantes, se lanza una excepción
         * Si el planeta tiene habitantes, se muestran
         */
        if (personas == 0) {
            throw new PlanetasException("No hay habitantes en este planeta");
        } else {
            return personas;
        }
    }

    /**
     * Método que muestra las materias primas de un planeta
     * @return
     * @throws PlanetasException
     */

    public int mostrarMateriasPrimas() throws PlanetasException {
        /*
         * Si el planeta no tiene materias primas, se lanza una excepción
         * Si el planeta tiene materias primas, se muestran
         */
        if (unidadesPiedra == 0 && unidadesHierro == 0 && unidadesCombustible == 0) {
            throw new PlanetasException("No hay materias primas en este planeta");
        } else {
            return unidadesPiedra + unidadesHierro + unidadesCombustible;
        }
    }

    /**
     * Método que muestra las minas actuales de un planeta
     * y de que tipo son las minas que se encuentran en el planeta
     * @return
     * @throws PlanetasException
     */

    public int mostrarMinas() throws PlanetasException {
        /*
         * Si el planeta no tiene minas, se lanza una excepción
         * Si el planeta tiene minas, se muestran
         */
        if (Minas.length == 0) {
            throw new PlanetasException("No hay minas en este planeta");
        } else {
            return Minas.length;
        }
    }

    /**
     * Método que muestra el escudo protector de un planeta
     * @return
     * @throws PlanetasException
     */

     
    @Override
    public void serAtacado(int ataque) {
        // TODO Auto-generated method stub
        
    }


}

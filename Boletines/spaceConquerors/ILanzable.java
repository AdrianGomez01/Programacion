package spaceConquerors;

public interface ILanzable {
    
    /**
     * Lanza el dado y devuelve el valor obtenido
     */
    public int lanzar();
    /**
     * Devuelve el valor mínimo del dado
     */
    public int getMin();
    /**
     * Devuelve el valor máximo del dado
     */
    public int getMax();

}

package practicaExamenMatrices.src.practicaExamenMatrices;

import java.util.Scanner;

public class Laberinto {

	static Scanner teclado = new Scanner(System.in);
			
	public static void main(String[] args) {
		//Llamamos al metodo con la posicion de salida introducida manualmente.
		pideMovimiento(laberinto, 6, 2);
	}

	//Con este método creamos el laberinto
    public static char[][] laberinto = {	{ 'X', 'V', 'X', 'X', 'X','X','X'},
											{ 'X', ' ', 'X', ' ', 'X',' ','X'},
											{ 'X', ' ', ' ', ' ', 'X',' ','X'},
											{ 'X', 'X', 'X', ' ', ' ',' ','X'},
											{ 'X', ' ', 'X', 'X', 'X',' ','X'},
											{ 'X', ' ', ' ', ' ', ' ',' ','X'},
											{ 'X', 'X', 'o', 'X', 'X','X','X'} 
											};

	//Uso este método para pintar la matriz.
    public static void imprimirMatriz(char[][] laberinto) {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {
                System.out.print(laberinto[i][j] + "  ");
            }
            System.out.println();
        }
    }

	//Almacenaré las coordenadas del jugador en un nuevo array, para ello saco la columna y la fila y las meto en el array.
    public int filaJugador(char[][] laberinto2) {
        int fila = 0;
        for (int i = 0; i < laberinto2.length; i++) {
            for (int j = 0; j < laberinto2[0].length; j++) {
                if (laberinto2[i][j]=='o') {
                    fila = i;
                }
            }
        }
        return fila;
    }
    public int columJugador(char[][] laberinto2) {
        int fila = 0;
        for (int i = 0; i < laberinto2.length; i++) {
            for (int j = 0; j < laberinto2[0].length; j++) {
                if (laberinto2[i][j]=='o') {
                    fila = j;
                }
            }
        }
        return fila;
    }
    static int [] posJugador= new int[2];
    
    //Marcaré la posición de la casilla de salida, la cual será una 'V' de VICTORIA.
    public static int [] posV(char[][] laberinto2){
         for (int i = 0; i < laberinto2.length; i++) {
             for (int j = 0; j < laberinto2[0].length; j++) {
                 if (laberinto2[i][j]=='V') {
                     posJugador[0]=i;
                     posJugador[1]=j;
                 }
             }
         }
         return posJugador;
     }
    
    //Con este método moveremos al usuario 
    public static void pideMovimiento(char[][] laberinto, int filas, int colum) {
        int []array = posV(laberinto);
        //Hacemos un bucle para que pida movimientos hasta que la posicion del jugador sea la de Victoria (V).
        //Si el jugador golpea con un obstáculo se lo indicaremos y volverá al bucle.
        while (posJugador == array) {
            if (laberinto[filas][colum] == laberinto[array[0]][array[1]]) {
                System.out.println("¡¡ VICTORIA !!");
              break;
            } else {
                imprimirMatriz(laberinto);  
                System.out.println("¿Hacia dónde quieres moverte?");
        		System.out.println("A: Izquierda, D: Derecha, W: Arriba, S: Abajo");
                char movimiento = teclado.next().toUpperCase().charAt(0);
                //Para la derecha
                if (movimiento=='D') {
                    if (!(laberinto[filas][colum + 1]=='X')) {
                        laberinto[filas][colum + 1] = 'o';
                        laberinto[filas][colum] = ' ';
                        colum++;
                    } else {
                        System.out.println("Has golpeado con una pared");
                    }
                }
                //Para la izquierda
                if (movimiento=='A') {
                    if (!(laberinto[filas][colum - 1]=='X')) {
                        laberinto[filas][colum - 1] = 'o';
                        laberinto[filas][colum] = ' ';
                        colum--;
                    } else {
                    	 System.out.println("Has golpeado con una pared");
                    }
                }
                //Hacia arriba
                if (movimiento=='W') {
                    if (!(laberinto[filas - 1][colum]=='X')) {
                        laberinto[filas - 1][colum] = 'o';
                        laberinto[filas][colum] = ' ';
                        filas--;
                    } else {
                    	 System.out.println("Has golpeado con una pared");
                    }
                }
                //Hacia abajo
                if (movimiento=='S') {
                    if (!(laberinto[filas + 1][colum]=='X')) {
                        laberinto[filas + 1][colum] = 'o';
                        laberinto[filas][colum] = ' ';
                        filas++;
                    } else {
                    	System.out.println("Has golpeado con una pared");
                    }
                }
            }
        }
        teclado.close();
    }
}
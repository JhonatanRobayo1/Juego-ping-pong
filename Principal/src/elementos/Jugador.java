package elementos;

import java.util.Scanner;

public class Jugador {
    private int posicion;

    public Jugador() {
        posicion = 0;
    }

    public int getPosicion() {
        return posicion;
    }

    public void moverArriba() {
        // Lógica para mover la raqueta hacia arriba
        posicion--;
    }

    public void moverAbajo() {
        posicion++;
        // Lógica para mover la raqueta hacia abajo
    }
}
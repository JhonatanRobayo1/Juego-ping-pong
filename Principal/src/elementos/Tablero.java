package elementos;

import java.util.*;

public class Tablero {
    private Jugador jugador1;
    private Jugador jugador2;
    private Pelota pelota;
    private int ancho;
    private int alto;
    private int puntosGanar;
    private int puntosJugador1;
    private int puntosJugador2;

    public Tablero(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        pelota = new Pelota();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de puntos para ganar: ");
        puntosGanar = scanner.nextInt();
    }

    public void dibujar() {
        // Lógica para dibujar los elementos del juego en pantalla
        System.out.print("\033[H\033[2J"); // Limpia la consola
        System.out.flush();

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (j == 0 || j == ancho - 1) {
                    System.out.print("|"); // Paredes laterales
                } else if (i == pelota.getPosicionY() && j == pelota.getPosicionX()) {
                    System.out.print("O"); // Pelota
                } else if (i >= jugador1.getPosicion() && i < jugador1.getPosicion() + 3 && j == 1) {
                    System.out.print("#"); // Raqueta jugador 1
                } else if (i >= jugador2.getPosicion() && i < jugador2.getPosicion() + 3 && j == ancho - 2) {
                    System.out.print("#"); // Raqueta jugador 2
                } else {
                    System.out.print(" "); // Espacio vacío
                }
            }
            System.out.println();
        }
    }

    public void actualizar() {
        // Lógica para actualizar el estado del juego
        // Mover la pelota
        pelota.mover();
        // Verificar colisiones con las paredes
        if (pelota.getPosicionX() == 0 || pelota.getPosicionX() == ancho - 1) {
            pelota.cambiarDireccionX();
        }
        if (pelota.getPosicionY() == 0 || pelota.getPosicionY() == alto - 1) {
            pelota.cambiarDireccionY();
        }
        // Verificar colisiones con las raquetas
        if (pelota.getPosicionX() == 1 && pelota.getPosicionY() >= jugador1.getPosicion()
                && pelota.getPosicionY() < jugador1.getPosicion() + 3) {
            pelota.cambiarDireccionX();
        }
        if (pelota.getPosicionX() == ancho - 2 && pelota.getPosicionY() >= jugador2.getPosicion()
                && pelota.getPosicionY() < jugador2.getPosicion() + 3) {
            pelota.cambiarDireccionX();
        }

        // Verificar si algún jugador alcanza la cantidad de puntos requeridos para
        // ganar
        if (puntosJugador1 >= puntosGanar || puntosJugador2 >= puntosGanar) {
            System.out.println("¡Juego terminado!");
            if (puntosJugador1 >= puntosGanar) {
                System.out.println("¡Jugador 1 ha ganado!");
            } else {
                System.out.println("¡Jugador 2 ha ganado!");
            }
            System.exit(0); // Finalizar el programa
        }
        if (pelota.getPosicionX() == 0) {
            puntosJugador2++;
            // Restablecer la posición de la pelota y las raquetas
            // ...
        }
        if (pelota.getPosicionX() == ancho - 1) {
            puntosJugador1++;
            // Restablecer la posición de la pelota y las raquetas
            // ...
        }

    }

    public void manejarEntradas() {
        // Lógica para manejar las entradas de los jugadores
        Scanner scanner = new Scanner(System.in);
        char input1 = scanner.next().charAt(0);
        char input2 = scanner.next().charAt(0);
        if (input1 == 'w') {
            jugador1.moverArriba();
        }
        if (input1 == 's') {
            jugador1.moverAbajo();
        }
        if (input2 == 'i') {
            jugador2.moverArriba();
        }
        if (input2 == 'k') {
            jugador2.moverAbajo();
        }
    }

}
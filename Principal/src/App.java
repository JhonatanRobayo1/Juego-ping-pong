import elementos.*;

public class App {
    public static void main(String[] args) throws Exception {

        int alto = 45;
        int ancho = 25;
        Tablero tablero = new Tablero(ancho, alto);

        while (true) {
            tablero.manejarEntradas();
            tablero.actualizar();
            tablero.dibujar();
        }
    }
}

package elementos;

public class Pelota {
    private int posicionX;
    private int posicionY;
    private int direccionX;
    private int direccionY;

    public Pelota() {
        posicionX = 0;
        posicionY = 0;
        direccionX = 1;
        direccionY = 1;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void mover() {
        // Lógica para mover la pelota
        posicionX += direccionX;
        posicionY += direccionY;
    }

    public void cambiarDireccionX() {

        // Lógica para cambiar la dirección X de la pelota
        direccionX = -direccionX;
    }

    public void cambiarDireccionY() {
        // Lógica para cambiar la dirección Y de la pelota
        direccionY = -direccionY;
    }
}
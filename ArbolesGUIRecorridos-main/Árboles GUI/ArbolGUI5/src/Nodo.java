public class Nodo {
    int x, y;
    String etiqueta;
   Nodo izquierda1, izquierda2, derecha1, derecha2, centro;

    public Nodo(int x, int y, String etiqueta) {
        this.x = x;
        this.y = y;
        this.izquierda1 = this.izquierda2 = this.derecha1 = this.derecha2 = this.centro = null;
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return etiqueta + " (" + x + ", " + y + ")";
    }
}
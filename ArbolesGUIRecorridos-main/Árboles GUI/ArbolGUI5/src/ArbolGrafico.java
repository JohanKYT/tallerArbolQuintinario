import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ArbolGrafico extends JPanel {
    private Arbol arbol;

    public ArbolGrafico (Arbol arbol) {
        this.arbol = arbol;
    }

    @Override

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Obtener el tamaño del panel
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Calcular la posición inicial (centrado en el panel)
        int x = panelWidth / 2;
        int y = 50; // Un valor fijo para la raíz del árbol

        // Dimensiones para los nodos hijos
        int dimensionX = panelWidth / 4;
        int dimensionY = 50;

        // Dibujar el árbol
        dibujarArbol(g2d, arbol.getRaiz(),x, y, dimensionX, dimensionY);
    }
    // Modificada para soportar hasta 5 hijos
    public void dibujarArbol(Graphics2D g2d, Nodo nodo, int x, int y, int dimensionX, int dimensionY) {
        if (nodo != null) {
            // Dibuja el nodo actual (puedes personalizar cómo se dibuja el nodo aquí)
            g2d.fillOval(x - 5, y - 5, 10, 10);
            g2d.drawString(nodo.etiqueta, x - 5, y + 2);

            // Asigna las coordenadas del nodo actual
            nodo.x = x;
            nodo.y = y;

            // Calcular la posición de los hijos
            int hijoX = x - 2 * dimensionX;  // Inicialmente, colocamos el primer hijo a la izquierda
            int hijoY = y + dimensionY;

            // Iteramos sobre los 5 posibles hijos
            for (int i = 1; i <= 5; i++) {
                Nodo hijo = obtenerHijoPorIndice(nodo, i);
                if (hijo != null) {
                    // Dibujamos la línea entre el nodo y el hijo
                    g2d.drawLine(x, y, hijoX, hijoY);
                    // Llamamos recursivamente para dibujar el árbol del hijo
                    dibujarArbol(g2d, hijo, hijoX, hijoY, dimensionX / 2, dimensionY);
                }
                // Reajustamos la posición X para el siguiente hijo
                hijoX += dimensionX * 2;  // Incrementamos para distribuir los hijos horizontalmente
            }
        }
    }

    // Obtiene el hijo según el índice (1-5) del nodo
    private Nodo obtenerHijoPorIndice(Nodo nodo, int indice) {
        switch (indice) {
            case 1: return nodo.izquierda1;
            case 2: return nodo.izquierda2;
            case 3: return nodo.centro;
            case 4: return nodo.derecha1;
            case 5: return nodo.derecha2;
            default: return null;
        }
    }
}

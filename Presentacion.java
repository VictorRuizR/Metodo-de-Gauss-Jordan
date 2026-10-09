/**
 * Clase encargada de la presentación de resultados en consola.
 */
public class Presentacion {

    /**
     * Imprime una matriz aumentada con formato de columnas.
     * @param titulo Texto descriptivo que se muestra antes de la matriz.
     * @param matriz Matriz aumentada a imprimir.
     */
    public static void imprimirMatriz(String titulo, double[][] matriz) {
        System.out.println(titulo);
        for (double[] fila : matriz) {
            for (double valor : fila) {
                System.out.printf("%12.6f", valor);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Imprime el vector de soluciones.
     * @param soluciones Arreglo con los valores de x1, x2, x3...
     */
    public static void imprimirSoluciones(double[] soluciones) {
        System.out.println("Soluciones del sistema:");
        for (int i = 0; i < soluciones.length; i++) {
            System.out.printf("x%d = %.6f%n", (i + 1), soluciones[i]);
        }
    }
}

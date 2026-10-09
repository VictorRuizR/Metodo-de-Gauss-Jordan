/**
 * Clase con la lógica del Método de Gauss-Jordan.
 * REUTILIZA el módulo Gauss (triangulación inferior) y lo completa con
 * la normalización de pivotes y la eliminación de coeficientes superiores,
 * dejando la matriz aumentada convertida en la matriz identidad.
 */
public class GaussJordan {

    /**
     * Transforma la matriz aumentada [A | b] en [I | x] modificándola directamente
     * en memoria (paso por referencia). Al terminar, la última columna contiene
     * las soluciones, por lo que no se requiere sustitución regresiva.
     * @param matriz Matriz aumentada [A | b] de tamaño n x (n+1).
     */
    public static void eliminacionGaussJordan(double[][] matriz) {
        int n = matriz.length; // Tamaño del sistema (número de filas)

        // PASO 1 (REUTILIZACIÓN): triangulación superior con el módulo del método de Gauss.
        // No se reescriben los ciclos de eliminación inferior.
        Gauss.eliminacionGaussiana(matriz);

        // PASO 2: Recorre los renglones de ABAJO hacia ARRIBA
        for (int i = n - 1; i >= 0; i--) {

            // NORMALIZACIÓN: divide TODA la fila entre el pivote para que matriz[i][i] = 1
            double pivote = matriz[i][i];
            for (int k = i; k <= n; k++) {
                matriz[i][k] /= pivote;
            }

            // BARRIDO SUPERIOR: anula los coeficientes que están ARRIBA del pivote
            // aplicando R_j = R_j - (factor * R_i)
            for (int j = i - 1; j >= 0; j--) {
                double factor = matriz[j][i];
                for (int k = i; k <= n; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
    }

    /**
     * Lectura directa de resultados: con la matriz ya convertida en identidad,
     * cada incógnita xi es el valor de la última columna (matriz[i][n]).
     * @param matriz Matriz aumentada ya reducida a [I | x].
     * @return Arreglo con las soluciones x1, x2, x3...
     */
    public static double[] obtenerSoluciones(double[][] matriz) {
        int n = matriz.length;
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = matriz[i][n];
        }
        return x;
    }
}

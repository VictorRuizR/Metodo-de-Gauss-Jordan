/**
 * Clase principal que coordina la ejecución del Método de Gauss-Jordan.
 */
public class LanzadorGaussJordan {
    public static void main(String[] args) {
        // 1. Obtener la matriz aumentada [A | b]
        double[][] matriz = DatosMatriz.obtenermatriz();
        Presentacion.imprimirMatriz("Matriz aumentada inicial [A | b]:", matriz);

        // 2. Aplicar Gauss-Jordan (reutiliza Gauss.eliminacionGaussiana internamente).
        //    La matriz se modifica directamente en memoria (paso por referencia).
        GaussJordan.eliminacionGaussJordan(matriz);
        Presentacion.imprimirMatriz("Matriz final (identidad | soluciones):", matriz);

        // 3. Lectura directa de resultados: columna matriz[i][n]
        double[] soluciones = GaussJordan.obtenerSoluciones(matriz);

        // 4. Imprimir resultados
        Presentacion.imprimirSoluciones(soluciones);
    }
}

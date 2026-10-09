 /**
 * Clase encargada de la lectura/definición de los datos del sistema.
 * Aquí se define la matriz aumentada [A | b] del sistema de ecuaciones.
 */

public class DatosMatriz {

    /**
     * @return Matriz aumentada 3x4: tres ecuaciones con tres incógnitas
     *         y la última columna correspondiente a los términos independientes.
     */

    public static double[][] obtenermatriz() {
        return new double[][] {
                    { 3.0, -0.1, -0.2,  7.85 },   // 3x1 - 0.1x2 - 0.2x3 = 7.85
                    { 0.1,  7.0, -0.3, -19.3 },   // 0.1x1 + 7x2 - 0.3x3 = -19.3
                    { 0.3, -0.2, 10.0,  71.4 }    // 0.3x1 - 0.2x2 + 10x3 = 71.4
        };
    }
}


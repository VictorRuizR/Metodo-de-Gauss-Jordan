# Método de Gauss-Jordan en Java

Programa que resuelve sistemas de ecuaciones lineales con el **Método de Gauss-Jordan**: transforma la matriz aumentada `[A | b]` en la matriz identidad, de modo que las soluciones quedan directamente en la última columna, sin sustitución regresiva.

Reutiliza el módulo `Gauss` de la práctica anterior (`Gauss.eliminacionGaussiana`) para la triangulación superior.

**Autor:** Víctor Ruiz R.
**Materia:** SCC-1017 Métodos Numéricos — Unidad 3
**Institución:** Instituto Tecnológico Superior de Xalapa

## Lenguaje de programación

**Java** (JDK 17 o superior recomendado).

## Estructura modular del proyecto

| Archivo | Responsabilidad |
|---|---|
| `DatosMatriz.java` | Definición de los datos: devuelve la matriz aumentada `[A \| b]`. |
| `Gauss.java` | Práctica anterior: triangulación superior (`eliminacionGaussiana`) y sustitución regresiva. |
| `GaussJordan.java` | Reutiliza `Gauss.eliminacionGaussiana` y agrega la normalización de pivotes y el barrido superior. |
| `Presentacion.java` | Presentación de resultados: imprime la matriz y las soluciones en consola. |
| `LanzadorGaussJordan.java` | Clase principal (`main`) de esta práctica. |
| `LanzadorGauss.java` | Clase principal de la práctica anterior (Gauss con sustitución regresiva). |

La matriz se pasa **por referencia**: `Gauss` y `GaussJordan` la modifican directamente en memoria, sin crear copias.

## Cómo compilar y ejecutar

### Desde la terminal

1. Clona el repositorio (o descarga los archivos en una misma carpeta):
   ```bash
   git clone https://github.com/VictorRuizR/Metodo-de-Gauss.git
   cd Metodo-de-Gauss
   ```
2. Compila:
   ```bash
   javac *.java
   ```
3. Ejecuta Gauss-Jordan:
   ```bash
   java LanzadorGaussJordan
   ```
   (Para la práctica anterior: `java LanzadorGauss`)

### Desde IntelliJ IDEA

1. Abre la carpeta del proyecto con *File → Open*.
2. Abre `LanzadorGaussJordan.java`.
3. Presiona el botón verde ▶ junto al método `main`.

## Ejemplo de prueba

Sistema de ecuaciones (solución exacta: x1 = 3, x2 = -2.5, x3 = 7):

```
3x1   - 0.1x2 - 0.2x3 =   7.85
0.1x1 +   7x2 - 0.3x3 = -19.3
0.3x1 - 0.2x2 +  10x3 =  71.4
```

Salida por consola:

```
Matriz aumentada inicial [A | b]:
    3.000000   -0.100000   -0.200000    7.850000
    0.100000    7.000000   -0.300000  -19.300000
    0.300000   -0.200000   10.000000   71.400000

Matriz final (identidad | soluciones):
    1.000000    0.000000    0.000000    3.000000
    0.000000    1.000000    0.000000   -2.500000
    0.000000    0.000000    1.000000    7.000000

Soluciones del sistema:
x1 = 3.000000
x2 = -2.500000
x3 = 7.000000
```

## Funcionamiento

1. **Triangulación superior (reutilizada):** `Gauss.eliminacionGaussiana(matriz)` anula los elementos debajo de la diagonal.
2. **Normalización:** cada fila se divide entre su pivote para que la diagonal sea 1.
3. **Barrido superior:** se anulan los coeficientes arriba de cada pivote con `R_j = R_j - factor * R_i`.
4. **Lectura directa:** con la matriz ya convertida en identidad, `x[i] = matriz[i][n]`.

## Limitación

No se usa pivoteo parcial; si un pivote fuera 0 habría división entre cero. Con el sistema de prueba (pivotes distintos de cero) funciona correctamente.

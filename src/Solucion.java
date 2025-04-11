import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Solucion {
    public static void main(String[] args) {
        // Manejo de una Excepción evitando la IOException
        try {
            File archivo = new File("archivo_no_existente.txt");
            if (archivo.exists()) {
                FileReader file = new FileReader(archivo);
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (IOException e) {
            System.out.println("¡Excepción capturada! Archivo no encontrado: " + e);
        }

        // Manejo de una Excepción evitando la ArithmeticException
        try {
            //int divisor = 0;
            int divisor = 2; // Cambiamos el divisor a un valor diferente de cero
            if (divisor != 0) {
                int resultado = 10 / divisor;
                System.out.println("Manejada -> Resultado: " + resultado);
            } else {
                System.out.println("No se puede dividir por cero.");
            }
        } catch (ArithmeticException e) {
            System.out.println("¡Excepción capturada! División por cero: " + e);
        }

        // Manejo de Error (OutOfMemoryError) - evitando el error sin usar try-catch
        List<int[]> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // Limita la cantidad de arreglos creados
            lista.add(new int[1000000]);
        }

        // Manejo de Error (StackOverflowError) - evitando el error sin usar try-catch
        metodoRecursivoSeguro(0); // Agregamos condición de parada
    }

    public static void metodoRecursivoSeguro(int contador) {
        if (contador >= 1000) return; // condición de parada para evitar el StackOverflow
        metodoRecursivoSeguro(contador + 1);
    }
}

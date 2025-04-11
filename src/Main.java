import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    // Método para generar StackOverflowError (recursión infinita)
    static void metodoRecursivo() {
        metodoRecursivo();
    }
    public static void main(String[] args) {
        // Manejo de una Excepción (Checked Exception)
        try {
            FileReader file = new FileReader("archivo_no_existente.txt"); // Generará IOException
        } catch (IOException e) {
            System.out.println("¡Excepción capturada! Archivo no encontrado: " + e);
        }
        // Manejo de una Excepción (Unchecked Exception)
        try {
            int resultado = 10 / 0; // División por cero genera ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("¡Excepción capturada! División por cero: " + e);
        }
        // Generar un Error (OutOfMemoryError)
        try {
            List<int[]> lista = new ArrayList<>();
            while (true) {
                lista.add(new int[1000000]); // Consumirá toda la memoria heap
            }
        } catch (OutOfMemoryError e) {
            System.out.println("¡Error crítico! Memoria insuficiente: " + e);
        }
        // Generar un Error (StackOverflowError)
        try {
            metodoRecursivo();
        } catch (StackOverflowError e) {
            System.out.println("¡Error crítico! Desbordamiento de pila: " + e);
        }
    }
}

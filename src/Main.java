import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //IO exepcion
        try{
            FileReader file = new FileReader("archivo_no_existe.txt");
            BufferedReader br = new BufferedReader(file);
            System.out.println(br.readLine());
            br.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Sigue la ejecucion");
        }

        //division por cero
        try {
            int resultado = 10 / 0; // División por cero
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero no permitida.");
        }

        //punteros nulos
        try {
            String texto = null;
            System.out.println(texto.length()); // Genera NullPointerException

            int[] numeros = {1, 2, 3};
            System.out.println(numeros[5]); // Genera ArrayIndexOutOfBoundsException
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error detectado: " + e.getMessage());
        }

        //Personalizada
        try{
            validarEdad(18);
        }catch (MiExepcion e){
            System.out.println(e.getMessage());
        }

        //desbordamiento error
        try {
            metodoRecursivo();
        }catch (StackOverflowError e){
            System.out.println("" + e);
        }

        try{
            List<int[]> lista = new ArrayList<>();
            int i = 0;
            while (true){
                lista.add(new int[10]);
                System.out.println(i++);
            }
        }catch (OutOfMemoryError e){
            System.out.println(e);
        }

    }
    //PERSONALIZADA
    static void validarEdad(int edad) throws MiExepcion{
        if (edad < 18){
            throw new MiExepcion("Debes ser mayor de edad!");
        }
        System.out.println("Acceso completo");
    }

    static void metodoRecursivo(){
        metodoRecursivo();
    }


}


package tema1.ej1;

import java.io.*;

public class LeerNombre2 {
    public static void main(String[] args) throws IOException {
        /*
        Posteriormente haz un programa similar a Ejemplo3.java para ejecutar Leernombre.java.
        Utiliza el metodo waitFor() para comprobar el valor de salida del proceso que se ejecuta.
        Prueba la ejecución del programa pasando un parámetro y sin pasarlo.
        ¿Qué devuelve waitFor() en cada caso?
        */

        try {
            // Este comando ejecuta directamente el proceso, es parecido a ProcessBuilder
            Process p =  Runtime.getRuntime().exec("java -cp src/tema1.ej1.LeerNombre hola");

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String in;
            while ((in = br.readLine()) != null){
                System.out.println(in);
            }

            int w8 = p.waitFor();
            System.out.println("Salida waitFor: " + w8);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
package tema1.ej4;

import java.io.*;

public class Ej4 {
    public static void main(String[] args) throws IOException {
        //Aquí ponemos la ruta de la clase compilada (el .class)
        File directory = new File("out/production/PSP");
        //Creación de ficheros de Salida, entrada y error
        File fOut = new File("src/tema1/ej4/Salida.txt");
        File fErr = new File("src/tema1/ej4/Error.txt");
        File fIn = new File("src/tema1/ej4/Entrada.txt");

        //Montamos el proceso (Ejecutar la clase EjemploLectura)
        ProcessBuilder pb = new ProcessBuilder("java", "tema1.ejemplos.EjemploLectura");
        //Le decimos el directorio donde se encuentra el .class
        pb.directory(directory);

        //Redirigimos
        pb.redirectInput(fIn);
        pb.redirectOutput(fOut);
        pb.redirectError(fErr);

        //Arrancamos el proceso
        Process p = pb.start();
        //Pillamos la entrada
        OutputStream os = p.getOutputStream();
        os.flush(); //Limpieza buffer
        os.close(); //Se cierra

        try{
            int exitValue = p.waitFor();
            System.out.println("Exit value: " + exitValue);
        } catch (IllegalThreadStateException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}

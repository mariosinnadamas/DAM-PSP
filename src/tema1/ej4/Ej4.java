package tema1.ej4;

import java.io.*;

public class Ej4 {
    public static void main(String[] args) throws IOException {
        File directory = new File("out/production/PSP");

        File fOut = new File("src/tema1/ej4/Salida.txt");
        File fErr = new File("src/tema1/ej4/Error.txt");
        File fIn = new File("src/tema1/ej4/Entrada.txt");

        ProcessBuilder pb = new ProcessBuilder("java", "tema1.ejemplos.EjemploLectura");

        pb.directory(directory);

        pb.redirectInput(fIn);
        pb.redirectOutput(fOut);
        pb.redirectError(fErr);

        Process p = pb.start();
        OutputStream os = p.getOutputStream();
        os.flush();
        os.close();

        try{
            int exitValue = p.waitFor();
            System.out.println("Exit value: " + exitValue);
        } catch (IllegalThreadStateException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}

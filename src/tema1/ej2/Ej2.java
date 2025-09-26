package tema1.ej2;

import java.io.File;
import java.io.InputStream;

public class Ej2 {
    public static void main(String[] args) {
        File f = new File(".");
    try{
        //Ponemos una ruta inventada

        ProcessBuilder pb = new ProcessBuilder("java","-cp", ".","tema1.ej1.LeerNombre", "Prueba");
        pb.directory(f);
        Process p = pb.start();
        int exitCode = p.waitFor();
        System.out.println("Exited with code " + exitCode);
        //Stream devuelve bytes, por eso hacemos un casting a char
        InputStream er = p.getErrorStream();
        int c;
        while((c=er.read())!=-1){
            System.out.print((char)c);
        }
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }
    }
}

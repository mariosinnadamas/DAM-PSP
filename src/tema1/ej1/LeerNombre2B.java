package tema1.ej1;

import java.io.File;

public class LeerNombre2B {
    public static void main(String[] args) {
        try {
            //Directorio donde está compilada la clase
            File f = new File(".");

            /*Proceso con argumento que queremos ejecutar, se pone -cp (Class path) para indicarle a java que empiece buscando en el directorio
            MUY IMPORTANTE saber desde donde compilas, yo he compilado dentro de src y por eso despues de -cp he puesto un . en este
            ProcessBuilder, si compilas desde fuera como por ejemplo desde PSP tendrias que cambiar el . por "src y aun así te puede dar
            ERROR, depende mucho del IDE y de los directorios"
            */
            ProcessBuilder pb = new ProcessBuilder("java","-cp", ".","tema1.ej1.LeerNombre", "Prueba");
            //Le decimos el directorio al proceso
            pb.directory(f);
            //Arrancar proceso
            Process p = pb.start();
            //Almacenamos el resultado en una variable
            int exitCode = p.waitFor();
            //Si sale 0 está bien
            System.out.println("Exited with code " + exitCode);

            //Proceso sin argumento
            ProcessBuilder pb2 = new ProcessBuilder("java","-cp",".", "tema1.ej1.LeerNombre");
            pb.directory(f);
            Process p2 = pb2.start();
            int exitCode2 = p2.waitFor();
            //Si sale con -1 o 255 es error porque no se pasó un argumento
            System.out.println("Exited with code " + exitCode2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package tema1.ejemplos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejemplo03 {

	public static void main(String[] args) throws IOException {
		//Creamos objeto File al directorio donde este Ejemplo2
        File d = new File(".");
        //proceso a ejecutar es Ejemplo2
        ProcessBuilder pb = new ProcessBuilder("java", "ejercicios1.Ejemplo02");
        //establecemos el directorio donde este el ejecutable
        pb.directory(d);
        System.out.print("Directorio de trabajo: ");
        System.out.println(pb.directory());
        //ejecutar proceso
        Process p = pb.start();
        //obtener la salida
        try {
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read())!=-1){
                System.out.print((char) c);
            }
            is.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }    
	}
}
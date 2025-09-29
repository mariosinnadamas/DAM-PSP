package tema1.ejemplos;

import java.io.IOException;

public class Ejemplo01 {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
        //Creas el proceso que quieres ejecutar
		 ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
        //Inicias el proceso
         Process p = pb.start();
	}
}

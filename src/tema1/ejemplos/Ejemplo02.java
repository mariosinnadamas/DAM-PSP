package tema1.ejemplos;

import java.io.IOException;
import java.io.InputStream;

public class Ejemplo02 {

	public static void main(String[] args) throws IOException {

        //Ejecutamos el proceso DIR
        Process p = new ProcessBuilder("CMD","/C","DIR").start();
        
        //Mostramos caracter a caracter la salida del comando
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

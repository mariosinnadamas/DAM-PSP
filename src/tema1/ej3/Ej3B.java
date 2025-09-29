package tema1.ej3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ej3B {
    public static void main(String[] args) throws IOException {
        File f = new File("src");
        ProcessBuilder pb = new ProcessBuilder("java", "tema1.ej3.Ej3");
        pb.directory(f);
        Process p = pb.start();

        //En este output sacas la información de este archivo (Por eso es out y no in), en este caso estamos sacando el 2 y 3
        OutputStream os = p.getOutputStream();
        os.write("2\n".getBytes()); //El \n nos simula haber dado al enter
        os.write("3\n".getBytes());
        os.flush();
        os.close(); //Importante cerrar siempre

        //Lectura
        try {
            //Aqui es input porque recibe los datos de esta clase, es decir, los introduce
            InputStream is = p.getInputStream();
            InputStream err = p.getErrorStream(); //Importante para poder leer el fallo del proceso hijo
            int c;
            while ((c = is.read())!=-1){
                System.out.print((char) c);
            }
            //Esto te permite leer el error del proceso hijo
            while ((c = err.read())!=-1){
                System.err.print((char) c);
            }
            is.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        //comprobacion de error: 0 bien | 1 mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

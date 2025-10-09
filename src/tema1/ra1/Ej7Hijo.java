package tema1.ra1;

import java.io.*;

public class Ej7Hijo {
    public static void main(String[] args) {
        if (args.length == 0){
            System.err.println("No se ha especificado un archivo");
            System.exit(1);
        }

        File f = new File(args[0]);
        int suma = 0;

        //Leer archivo pasado por argumento
        try (BufferedReader br = new BufferedReader(new FileReader(f))){
            String linea;
            while ((linea = br.readLine()) != null){
                suma += Integer.parseInt(linea.trim());
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println(suma);
    }
}

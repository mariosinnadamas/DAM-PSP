package tema1.ra1;

import java.io.*;

public class Ej6ContarI {
    public static void main(String[] args) {

        File f = new File("tema1/ra1/Texto.txt");
        String linea;
        char c;
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            while ((linea = br.readLine())!=null){
                for (int i = 0; i < linea.length(); i++) {
                    c = linea.charAt(i);
                    if (c == 'i'|| c == 'I'){
                        contador++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("HIJO: Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Salida de I: " + contador);
    }
}

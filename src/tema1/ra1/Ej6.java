package tema1.ra1;

import java.io.*;

/*
Desarrolla un programa que determine cuántas veces aparecen las vocales en
un archivo de texto. El programa principal deberá generar cinco procesos
secundarios, donde cada uno de ellos será responsable de contar una vocal
específica (tanto en mayúscula como en minúscula).
Cada proceso secundario escribirá el resultado de su conteo en un archivo independiente. Luego, el
programa principal recuperará los datos de estos archivos temporales, sumará
los resultados parciales y mostrará el total de vocales encontradas en la
pantalla.
 */
public class Ej6 {
    public static void main(String[] args) {

        ProcessBuilder pbA = new ProcessBuilder("java","-cp",".", "tema1.ra1.Ej6ContarA");
        ProcessBuilder pbE = new ProcessBuilder("java", "tema1.ra1.Ej6ContarE");
        ProcessBuilder pbI = new ProcessBuilder("java", "tema1.ra1.Ej6ContarI");
        ProcessBuilder pbO = new ProcessBuilder("java", "tema1.ra1.Ej6ContarO");
        ProcessBuilder pbU = new ProcessBuilder("java", "tema1.ra1.Ej6ContarU");

        try {
            Process pA = pbA.start();
            Process pE = pbE.start();
            Process pI = pbI.start();
            Process pO = pbO.start();
            Process pU = pbU.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(pA.getInputStream()));
            String linea;
            //Leer salida del hijo A
            while ((linea = br.readLine())!= null){
                System.out.println(linea);
            }

            //Leer errores del hijo A
            BufferedReader erA = new BufferedReader(new InputStreamReader(pA.getErrorStream()));
            while ((linea = erA.readLine()) != null) {
                System.err.println("HIJO ERROR A-> " + linea);
            }

            //Leer salida del hijo E
            BufferedReader brE = new BufferedReader(new InputStreamReader(pE.getInputStream()));
            while ((linea = brE.readLine())!= null){
                System.out.println(linea);
            }

            //Leer errores del hijo E
            BufferedReader erE = new BufferedReader(new InputStreamReader(pE.getErrorStream()));
            while ((linea = erE.readLine()) != null) {
                System.err.println("HIJO ERROR E-> " + linea);
            }

            //Leer salida del hijo I
            BufferedReader brI = new BufferedReader(new InputStreamReader(pI.getInputStream()));
            while ((linea = brI.readLine())!= null){
                System.out.println(linea);
            }

            //Leer errores del hijo I
            BufferedReader erI = new BufferedReader(new InputStreamReader(pI.getErrorStream()));
            while ((linea = erI.readLine()) != null) {
                System.err.println("HIJO ERROR I-> " + linea);
            }

            //Leer salida del hijo O
            BufferedReader brO = new BufferedReader(new InputStreamReader(pO.getInputStream()));
            while ((linea = brO.readLine())!= null){
                System.out.println(linea);
            }

            //Leer errores del hijo O
            BufferedReader erO = new BufferedReader(new InputStreamReader(pO.getErrorStream()));
            while ((linea = erO.readLine()) != null) {
                System.err.println("HIJO ERROR O -> " + linea);
            }

            //Leer salida del hijo U
            BufferedReader brU = new BufferedReader(new InputStreamReader(pU.getInputStream()));
            while ((linea = brU.readLine())!= null){
                System.out.println(linea);
            }

            //Leer errores del hijo U
            BufferedReader erU = new BufferedReader(new InputStreamReader(pO.getErrorStream()));
            while ((linea = erU.readLine()) != null) {
                System.err.println("HIJO ERROR U -> " + linea);
            }

            //Salidas
            int exitValue;
            exitValue = pA.waitFor();
            System.out.println("ExitValue de A: " + exitValue);
            exitValue = pE.waitFor();
            System.out.println("ExitValue de E: " + exitValue);
            exitValue = pI.waitFor();
            System.out.println("ExitValue de I: " + exitValue);
            exitValue = pO.waitFor();
            System.out.println("ExitValue de O: " + exitValue);
            exitValue = pU.waitFor();
            System.out.println("ExitValue de U: " + exitValue);


            br.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

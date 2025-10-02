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
        File a = new File("tema1/ra1/Texto.txt");
        ProcessBuilder pbA = new ProcessBuilder("java","-cp",".", "tema1.ra1.Ej6ContarA");
        ProcessBuilder pbE = new ProcessBuilder("java", "tema1.ra1.Ej6ContarE");
        ProcessBuilder pbI = new ProcessBuilder("java", "tema1.ra1.Ej6ContarI");
        ProcessBuilder pbO = new ProcessBuilder("java", "tema1.ra1.Ej6ContarO");
        ProcessBuilder pbU = new ProcessBuilder("java", "tema1.ra1.Ej6ContarU");

        try {
            pbA.directory(a);
            Process pA = pbA.start();

            Process pE = pbE.start();
            Process pI = pbI.start();
            Process pO = pbO.start();
            Process pU = pbU.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(pA.getInputStream()));
            String resultado = br.readLine();
            System.out.println(resultado);
            br.close();

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
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

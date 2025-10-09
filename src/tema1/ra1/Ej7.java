package tema1.ra1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Se desea crear un programa que procese ficheros aprovechando el paralelismo
de la máquina. Se tienen cinco ficheros con los siguientes nombres:
• informatica.txt
• gerencia.txt
• contabilidad.txt
• comercio.txt
• rrhh.txt
En cada fichero hay una lista de cantidades enteras que representa las
contabilidades de distintos departamentos. Hay una cantidad en cada línea. Se
desea que el programa creado sume la cantidad total que suman todas las
cantidades de los cinco ficheros haciendo uso del paralelismo.
 */
public class Ej7 {
    public static void main(String[] args) {

        // Lista de archivos a procesar
        String[] ficheros = {
                "../Recursos/informatica.txt",
                "../Recursos/gerencia.txt",
                "../Recursos/contabilidad.txt",
                "../Recursos/comercio.txt",
                "../Recursos/rrhh.txt"
        };

        int total = 0;
        List<Process> procesos = new ArrayList<>();

        try {
            for (String fichero : ficheros) {
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", ".", "tema1.ra1.Ej7Hijo", fichero);
                procesos.add(pb.start());
            }

            // Recoger salidas
            for (Process p : procesos) {
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String linea = br.readLine();
                if (linea != null) {
                    int parcial = Integer.parseInt(linea.trim());
                    total += parcial;
                    System.out.println("Suma parcial: " + parcial);
                }

                // Leer errores
                BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                String error;
                while ((error = err.readLine()) != null) {
                    System.err.println(error);
                }

                p.waitFor();
            }

            System.out.println("Suma de todos los departamentos: " + total);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

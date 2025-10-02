package tema1.ra1;
/*
Crea un proyecto Java con una Clase Principal. Usando la línea de comando,
pide al usuario qué acción quiere realizar (apagar, reiniciar o suspender) y
cuánto tiempo quiere dejar antes de realizar la acción de apagado del sistema.
Busca información sobre el funcionamiento del comando shutdown en
GNU/Linux y haz que tu aplicación funcione para ambos sistemas.
La aplicación tiene que perarar el comando correcto para la selección que haya
hecho el usuario y para el sistema operativo que la esté ejecutando.
Muestra por consola el resultado del metodo ProcessBuilder.command() de
forma legible.
shutdown /s /t 20 -> Espera 20 segundos para apagar el equipo
 */

import java.io.IOException;
import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner (System.in);
        String dec = "";
        while (true){
            System.out.println("1.Apagar, 2.Reiniciar, 3.Suspender");
            dec = sc.nextLine().trim();
            ProcessBuilder pb = new ProcessBuilder("");
            switch (dec){
                case "1": //Apagar
                    System.out.println("¿Qué SO tienes? 1.Windows, 2.Linux");
                    String so = sc.nextLine().trim();
                    System.out.println("¿Cuando quieres apagarlo? El tiempo en segundos");
                    String tiempo = sc.nextLine();

                    if (so.equalsIgnoreCase("1")){ //Apagar windows
                        //pb.command("cmd", "shutdown /s /t " + tiempo);
                        //pb.command("sh", "-c", "sudo shutdown -h now");
                        pb.inheritIO();
                        Process p = pb.start();
                        break;
                    } else if (so.equalsIgnoreCase("2")) { //Apagar Linux

                    }
                    break;
                case "2": //Reiniciar
                    break;
                case "3": //Suspender
                    break;
                default:
                    break;
            }
        }

    }
}

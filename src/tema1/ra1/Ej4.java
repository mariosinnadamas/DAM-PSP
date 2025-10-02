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
        String dec;

        //Pedir accion
        System.out.println("1.Apagar, 2.Reiniciar, 3.Suspender");
        dec = sc.nextLine().trim();

        System.out.println("¿Qué SO tienes? 1.Windows, 2.Linux");
        String so = sc.nextLine().trim();

        System.out.println("Escribe el tiempo en segundos: ");
        String tiempo = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder();
        try {
            if (so.equalsIgnoreCase("1")){ //Apagar windows
                switch (dec){
                    case "1":
                        // CMD por el interprete de windows
                        // /c indica que ejecute el comando que sigue y que luego se salga
                        // /s apaga inmediatamente el pcç
                        // /t es para que tarde x tiempo en ejecutar eso, solo funciona con apagar y reiniciar
                        //Pb espera que le mandes un comando por partes, pero si usas /c no hace falta
                        pb.command("CMD","/c","shutdown /s /t " + tiempo);
                        break;
                    case "2": //Reiniciar Windows
                        pb.command("CMD","/c","shutdown /r /t " + tiempo);
                        break;
                    case "3": //Suspender Windows
                        pb.command("CMD","/c","shutdown /h");
                        break;
                }
            } else{
                switch (dec){
                    case "1":
                        pb.command("sh", "-c", "shutdown -h +" + tiempo);
                        break;
                    case "2":
                        pb.command("sh", "-c", "shutdown -r +" + tiempo);
                        break;
                    case "3":
                        pb.command("sh", "-c", "systemctl suspend");
                        break;
                }
            }
            try {
                Process p = pb.start();
                int exitValue = p.waitFor();
                System.out.println(exitValue);
            } catch (IOException | InterruptedException e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

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
 */

import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String dec = "";
        while (true){
            System.out.println("1.Apagar, 2. Reiniciar, 3 Suspender");
            dec = sc.nextLine().trim();
            switch (dec){
                case "1": //Apagar
                    break;
                case "2": //Reiniciar
                    break;
                case "3": //Suspender
                    break;
            }
        }



    }
}

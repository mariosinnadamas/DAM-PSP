package tema1.ej1;

import java.util.Scanner;

public class LeerNombre {
    public static void main(String[] args) {
        /*

        Crea un programa Java llamado LeerNombre.java que reciba desde los argumentos de
        main() un nombre y lo visualice en pantalla.
        Utiliza System.exit(0) para una finalización correcta del programa y System.exit(-1)
        para el caso en el que no se hayan introducido los argumentos correctos en main().
         */

        //Args es el argumento que le pasamos al programa cuando ejecutamos desde la terminal
        if (args.length!=1){
            System.err.println("ERROR: debes meter un argumento");
            System.exit(-1); //Finaliza mal
        } else {
            System.out.println("Argumento: " + args[0]);
            System.exit(0); //Finaliza bien
        }
    }
}

package tema1.ra1;

import java.util.Random;
import java.util.Scanner;

/*
Cree un proceso hijo que esté encargado de generar números aleatorios.
 */
public class Ej3Hijo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dec = "";
        while (!(dec = sc.nextLine()).equalsIgnoreCase("fin")){
            int rand = ((int) (Math.random() * 10));
            System.out.println(rand);
            System.out.flush(); //Se asegura de que el padre reciba la entrada antes de que el Buffer se llene
        }
    }
}

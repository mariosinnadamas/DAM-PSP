package ejrepaso;

import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] numeros = new int[5];
        System.out.println("Ingrese un numero entero");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }
}

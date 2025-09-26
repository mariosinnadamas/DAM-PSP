package ejrepaso;

import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] tabla1 = new int[10];
        int [] tabla2 = new int[10];
        int [] tabla3 = new int[20];

        System.out.println("Ingresa 10 nº para la primera tabla: ");
        for (int i = 0; i < tabla1.length; i++) {
            tabla1[i] = sc.nextInt();
        }

        System.out.println("Ingresa 10 nº para la segunda tabla: ");
        for (int i = 0; i < tabla2.length; i++) {
            tabla2[i] = sc.nextInt();
        }

        //Mezclar tabla 3
        int j = 0;
        //Por cada valor de i introduzco un valor de cada tabla e incremento la posicion de j una vez
        for (int i = 0; i < 10; i++) {
            tabla3[j++] = tabla1[i];
            tabla3[j++] = tabla2[i];
        }

        for (int i = 0; i < tabla3.length; i++) {
            System.out.println(tabla3[i]);
        }
        sc.close();
    }
}

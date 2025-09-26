package ejrepaso;

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] numeros = new int[10];
        int elementos = 0;

        //Leer 5 numeros y que sean crecientes e introducirlos en el array
        System.out.println("Ingresa 5 numeros de forma creciente: ");
        for (int i = 0; i < 5; i++) {
            int valor = sc.nextInt();

            if (i > 0 && valor <= numeros[i-1]) {
                System.out.println("El número debe ser MAYOR que el anterior");
                i--;
            } else {
                numeros[i] = valor;
                elementos++;
            }
        }

        //Y ahora introducir de nuevo 1 numero y que lo coloque donde debe
        System.out.println("Ingresa 1 numero");
        int n = sc.nextInt();
        int posicion = 0;

        //Busca posicion de insercion
        while (posicion < elementos && numeros[posicion] < n) {
            posicion++;
        }

        //Desplaza los elementos a la derecha
        for (int i = elementos; i > posicion; i--) {
            numeros[i] = numeros[i - 1];
        }

        //Inserta el numero en su lugar
        numeros[posicion] = n;
        elementos++;

        for (int i = 0; i < elementos; i++) {
            System.out.println(numeros[i]);
        }
        sc.close();
    }
}

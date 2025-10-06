package tema1.ra1;
/*
Realizar un programa que permita sumar los datos de un fichero dado
“numeros.dat” que contiene 1000 números enteros, cada uno de estos
números se encontrará en una línea diferente. El usuario deberá decidir desde
qué número hasta qué número debe sumar el programa, por lo que estos dos
valores se pedirán por teclado. El programa principal mostrará la suma total.
 */

import java.io.*;
import java.util.Scanner;

public class Ej5 {
    //Volver a hacer pero separando la suma en un proceso hijo, el ejercicio está bien
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        File f = new File ("src/tema1/ra1/numeros.dat");
        //Escritura del archivo
        /*
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))){
            for (int i = 1; i <= 1000; i++) {
                dos.writeInt(i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        System.out.println("Introduce el minimo desde el que quieres que empiece a sumar: ");
        int min = sc.nextInt();
        System.out.println("Introduce el maximo hasta el que quieres que sume: ");
        int max = sc.nextInt();



        //Lectura
        int sumaTotal = 0;
        try(DataInputStream dis = new DataInputStream(new FileInputStream(f))){
            while (true){
                try{
                    int numDat = dis.readInt();
                    if (numDat >= min && numDat<=max) {
                         sumaTotal = sumaTotal + numDat;
                    }
                } catch (EOFException e){
                    System.out.println("Fin del fichero");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sumaTotal);
    }
}

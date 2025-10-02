package tema1.ra1;

import java.io.*;
import java.util.Scanner;

/*
Escribe un programa Aleatorios que haga lo siguiente:
• Cree un proceso hijo que esté encargado de generar números aleatorios.

• Este proceso hijo escribirá en su salida estándar un número aleatorio del 0 al
10 cada vez que reciba una petición de ejecución por parte del padre.

• El proceso padre lee líneas de la entrada estándar y por cada línea que lea
solicitará al hijo que le envíe un número aleatorio, lo leerá y lo imprimirá en
pantalla.
• Cuando el proceso padre reciba la palabra “fin”, finalizará la ejecución del
hijo y procederá a finalizar su ejecución.
 */

public class Ej3Padre {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        //El . es porque asi va a la misma carpeta donde se haya compilado la clase padre
        ProcessBuilder pb = new ProcessBuilder("java","-cp",".", "tema1.ra1.Ej3Hijo");

        Process p = pb.start();

        //Streams de comunicacion
        BufferedWriter hijoEntrada = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        BufferedReader hijoSalida = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String dec = "";

        while (!dec.equalsIgnoreCase("fin")){
            System.out.println("Introduce cualquier letra para generar un numero aleatorio");
            dec = sc.nextLine();

            //Envio al hijo la peticion
            hijoEntrada.write(dec + "\n");
            hijoEntrada.flush();

            if (!dec.equalsIgnoreCase("fin")){
                String num = hijoSalida.readLine();
                System.out.println("Numero aleatroio: " + num);
            }
        }

        //Cerramos porque no hemos usado try with resources
        hijoEntrada.close();

        try{
            int exitCode = p.waitFor();
            System.out.println("Exitcode: " + exitCode);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

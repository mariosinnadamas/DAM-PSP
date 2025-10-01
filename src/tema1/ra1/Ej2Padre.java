package tema1.ra1;

/*
    Escribe un programa que solicite un número, lo pase a un proceso hijo y éste
    calcule el doble de dicho número, mostrando el resultado por pantalla.
 */
import java.io.*;

public class Ej2Padre {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Recoge el numero
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce un numero: ");
        int n = 0;
        try {
            n = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Debes introducir un numero entero");
        } catch (IOException e) {
            e.printStackTrace();
        }


        //File dir = new File("out/production/PSP");
        ProcessBuilder pb = new ProcessBuilder("java", "tema1.ra1.Ej2Hijo");
        //pb.directory(dir);
        //System.out.println(dir.exists());
        Process process = pb.start();

        OutputStream os = process.getOutputStream();
        os.write((n+"\n").getBytes());
        os.flush();
        os.close();

        //Leemos el resultado
        BufferedReader hijoSalida = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String resultado = hijoSalida.readLine();
        System.out.println("Resultado: " + resultado);
        hijoSalida.close();

        //Esperar a que acabe el proceso
        int exitCode = process.waitFor();
        System.out.println("Exit value: " + exitCode);

    }
}

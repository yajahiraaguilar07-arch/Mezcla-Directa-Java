import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class MezclaDirectaPractica {

    public static void intercalarBloques(
            String archivoF1, String archivoF2,
            String archivoSalida, int L) {

        try (
            BufferedReader lector1 = new BufferedReader(new FileReader(archivoF1));
            BufferedReader lector2 = new BufferedReader(new FileReader(archivoF2));
            PrintWriter escritor = new PrintWriter(new FileWriter(archivoSalida))
        ) {

            String linea1 = lector1.readLine();
            String linea2 = lector2.readLine();

            while (linea1 != null && linea2 != null) {

                int val1 = Integer.parseInt(linea1);
                int val2 = Integer.parseInt(linea2);

                if (val1 <= val2) {
                    escritor.println(val1);
                    linea1 = lector1.readLine();
                } else {
                    escritor.println(val2);
                    linea2 = lector2.readLine();
                }
            }

            while (linea1 != null) {
                escritor.println(linea1);
                linea1 = lector1.readLine();
            }

            while (linea2 != null) {
                escritor.println(linea2);
                linea2 = lector2.readLine();
            }

            System.out.println("Bloque intercalado con exito!");

        } catch (IOException e) {
            System.out.println("Error en E/S de archivos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        intercalarBloques("f1.txt", "f2.txt", "f3.txt", 1);
    }
}

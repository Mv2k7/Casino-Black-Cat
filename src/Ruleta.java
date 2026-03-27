import java.security.spec.RSAOtherPrimeInfo;
import java.util.Random;
import java.util.Scanner;

public class Ruleta {
    
    public static final int MAX_HISTORIAL = 100;

    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;

    public static Random rng = new Random();
    public static int[] numerosRojos =
            {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        System.out.println("BIENVENIDO A CASINO BLACK CAT");
        System.out.println("Selecciona la opción que quieres");
        System.out.println("1. Iniciar una apuesta \n2. Ver Estadísticas \n3. Salir");
    }

    public static int leerOpcion(Scanner in) {
        // que hago aquii aaaaaaaaaaa (preguntar)
        return 0;
    }

    public static void ejecutarOpcion(int opcion, Scanner in) {
        opcion = leerOpcion(in);
        if (opcion == 1) {
            System.out.println("Seleccionaste la opcion: Iniciar una apuesta");
        } else if (opcion == 2) {
            System.out.println("Seleccionaste la opcion: Ver Estadísticas");
        } else if (opcion == 3) {
            System.out.println("Seleccionaste la opcion: Salir");
        }
        // creo que esto está mal hecho, no entiendo que es Scanner in.
    }

    public static void iniciarRonda(Scanner in) {

    }

    public static char leerTipoApuesta(Scanner in) {
        return 'a';
    }

    public static int girarRuleta() {
        return 0;
    }

    public static boolean evaluarResultado(int numero, char tipo) {
        return false;
    }

    public static boolean esRojo(int n) {
        return false;
    }

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {}

    public static void mostrarResultado(int numero, char tipo, int monto, boolean
            acierto) {}

    public static void mostrarEstadisticas() {}
}

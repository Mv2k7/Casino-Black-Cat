import org.w3c.dom.ls.LSOutput;

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
    public static int[] numerosRojos = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        mostrarMenu();
        Scanner in = new Scanner(System.in);
        int opcion;
        opcion = leerOpcion(in);
        ejecutarOpcion(opcion, in);
    }

    public static void mostrarMenu() {
        System.out.println("BIENVENIDO A CASINO BLACK CAT" +
                "\nSelecciona la opción que quieres" +
                "\n1. Iniciar una apuesta \n2. Ver Estadísticas \n3. Salir");
    }

    public static int leerOpcion(Scanner in) {
        System.out.println("Selecciona tu opción: ");
        int opcion = in.nextInt();
        return opcion;
    }

    public static void ejecutarOpcion(int opcion, Scanner in) {
        if (opcion == 1) {
            System.out.println("Seleccionaste la opcion: Iniciar una ronda\n");
            leerOpcion(in);
        } else if (opcion == 2) {
            System.out.println("Seleccionaste la opcion: Ver Estadísticas\n");
        } else if (opcion == 3) {
            System.out.println("Seleccionaste la opcion: Salir\n");
        } else {
            System.out.println("Opción inválida...");}
    }

    public static char leerTipoApuesta(Scanner in) {
        System.out.println("BIENVENIDO A LA RULETA!" +
                "\nSelecciona tu tipo de apuesta" +
                "\nP/I (Par o Impar) Y R/N (Rojo o Negro)" +
                "\nLuego, elige el monto a jugar.");

        char apuesta = in.next().charAt(0); // Para la primera letra

        while (apuesta != 'P' && apuesta != 'I' && apuesta != 'R' && apuesta != 'N') {
            System.out.println("Opcion inválida, intenta otra vez por favor.");
            apuesta = in.next().charAt(0);
        }

        return apuesta;
    }

    public static void iniciarRonda(Scanner in) {

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

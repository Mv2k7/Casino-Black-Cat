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

    public static void menu() {
        while (true){
            mostrarMenu();
            Scanner in = new Scanner(System.in);
            int opcion;
            opcion = leerOpcion(in);
            ejecutarOpcion(opcion, in);
            if (opcion == 3)
                break;
        }
    }

    public static void mostrarMenu() {
        System.out.println("\nBIENVENIDO A CASINO BLACK CAT" +
                "\nSelecciona la opción que quieres" +
                "\n1. Iniciar una apuesta \n2. Ver Estadísticas \n3. Salir");
    }

    public static int leerOpcion(Scanner in) {
        System.out.println("Selecciona tu opción: ");
        int opcion = in.nextInt();
        return opcion; // creo que puede ser mas corto
    }

    public static void ejecutarOpcion(int opcion, Scanner in) {
        if (opcion == 1) {
            System.out.println("Seleccionaste la opcion: Iniciar una ronda\n");
            iniciarRonda(in);
        } else if (opcion == 2) {
            System.out.println("Seleccionaste la opcion: Ver Estadísticas\n");
            mostrarEstadisticas();
        } else if (opcion == 3) {
            System.out.println("Seleccionaste la opcion: Salir\nHasta Luego!");
        } else {
            System.out.println("Opción inválida...");
        }
    }

    public static char leerTipoApuesta(Scanner in) {
        System.out.println("BIENVENIDO A LA RULETA!" +
                "\nSelecciona tu tipo de apuesta" +
                "\nP/I (Par o Impar) Y R/N (Rojo o Negro)");

        char apuesta = in.next().charAt(0); // Para la primera letra
        apuesta = Character.toLowerCase(apuesta); // Para que sea minúscula

        while (apuesta != 'p' && apuesta != 'i' && apuesta != 'r' && apuesta != 'n') {
            System.out.println("Opcion inválida, intenta otra vez por favor.");
            apuesta = in.next().charAt(0);
            // Esto es para que si elige cualquier valor, que no sea p/i/r/n, reintente.
        }

        return apuesta;
    }

    public static void iniciarRonda(Scanner in) {
        // Aquí voy a definir todas las variables utilizadas al momento de jugar
        char tipo = leerTipoApuesta(in);
        System.out.println("ELIGE EL MONTO");
        int monto = in.nextInt(); // monto a jugar
        System.out.println("ELIGE EL NÚMERO!!");
        int numero = girarRuleta();
        boolean acierto = evaluarResultado(numero, tipo);

        registrarResultado(numero, monto, acierto);
        mostrarResultado(numero, tipo, monto, acierto);
    }

    public static int girarRuleta() {
        return rng.nextInt(37); // retorna un número random desde el 0 hasta el 36
    }

    public static boolean evaluarResultado(int numero, char tipo) {
        switch (tipo) {
            case 'r':
                return esRojo(numero);
            case 'n':
                return !esRojo(numero) && numero != 0;
            case 'p':
                return numero % 2 == 0 && numero != 0;
            case 'i':
                return numero % 2 != 0;
        }
        return false;
    }

    public static boolean esRojo(int n) {
        for (int i = 0; i < numerosRojos.length; i++) {
            if (numerosRojos[i] == n) {
                return true;
            }
        }
        return false; // como no está en la lista, retornará false.
    }

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
        historialNumeros[historialSize] = numero;
        historialApuestas[historialSize] = apuesta;
        historialAciertos[historialSize] = acierto;
        historialSize++; // para que no se sobreescriba
    }

    public static void mostrarResultado(int numero, char tipo, int monto, boolean
            acierto) {
        if (tipo == 'r') System.out.println("Seleccionaste: color Rojo");
        if (tipo == 'n') System.out.println("Seleccionaste: color Negro");
        if (tipo == 'p') System.out.println("Seleccionaste: números Par");
        if (tipo == 'i') System.out.println("Seleccionaste: números Impar");
        System.out.println("MONTO EN APUESTA: " + monto);
        System.out.println("SALIÓ EL NÚMERO: " + numero);
        if (acierto) {
            System.out.println("FELICIDADES!!! HAS GANADO!");
        } else {
            System.out.println("Perdiste esta vez...");
        }
    }

    public static void mostrarEstadisticas() {
        int partidas = historialSize;
        int gastado = 0;
        int aciertos = 0;
        int ganancias = 0;

        for (int i = 0; i < historialSize; i++) {
            gastado += historialApuestas[i];

            if (historialAciertos[i]) {
                aciertos++;
                ganancias += historialApuestas[i];
            } else {
                ganancias -= historialApuestas[i];
            }
        }
        double porcentaje = 0;
        // para que no divida por 0 y sea positivo, tiene que cumplir que las partidas sean mayores que 0.
        if (partidas > 0) {
            porcentaje = (double) aciertos / partidas * 100;
        }
        System.out.println("Partidas jugadas: " + partidas +
                "\nTotal apostado: " + gastado +
                "\nTotal aciertos: " + aciertos +
                "\nPorcentaje de aciertos " + porcentaje + "%" +
                "\nGanancia o Pérdida: " + ganancias);
    }
}
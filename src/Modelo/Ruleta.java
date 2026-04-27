package Modelo;

import java.util.Random;

public class Ruleta {

    public static final int MAX_HISTORIAL = 100;

    public static int[] historialNumeros        = new int[MAX_HISTORIAL];
    public static int[] historialApuestas       = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos   = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;

    public static Random rng = new Random();

    public static int[] numerosRojos = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};

    public static int girarRuleta() {
        return rng.nextInt(37);
    }
    public static String jugar(char tipo, int apuesta) {
        int numero = girarRuleta();
        boolean acierto = evaluarResultado(numero, tipo);
        registrarResultado(numero, apuesta, acierto);
        if (acierto) {
            return "Número: " + numero + " → GANASTE!";
        } else {
            return "Número: " + numero + " → PERDISTE";
        }
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
        return false;
    }

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
        historialNumeros[historialSize]     = numero;
        historialApuestas[historialSize]    = apuesta;
        historialAciertos[historialSize]    = acierto;
        historialSize++;
    }
}
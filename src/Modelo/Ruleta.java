package Modelo;

import java.util.Random;

public class Ruleta {

    public static final int MAX_HISTORIAL = 100;

    private int saldo;
    private int[] historialNumeros        = new int[MAX_HISTORIAL];
    private int[] historialApuestas       = new int[MAX_HISTORIAL];
    private boolean[] historialAciertos   = new boolean[MAX_HISTORIAL];
    private int historialSize = 0;

    private Random rng = new Random();

    private static final int[] numerosRojos = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};

    public Ruleta(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public Ruleta() {
        this(1000);
    }

    public int getSaldo() {
        return saldo;
    }

    public void depositar(int monto) {
        if (monto > 0) saldo += monto;
    }

    public int getHistorialSize() {
        return historialSize;
    }
    public int getHistorialNumero(int i) {return historialNumeros[i];}
    public int getHistorialApuesta(int i) {return historialApuestas[i];}
    public boolean getHistorialAcierto(int i) {return historialAciertos[i];}


    public void setHistorialSize(int historialSize) {}

    public String jugar(TipoApuesta tipo, int apuesta) {
        int numero = girarRuleta();
        boolean acierto = evaluarResultado(numero, tipo);
        historialNumeros[historialSize]     = numero;
        historialApuestas[historialSize]    = apuesta;
        historialAciertos[historialSize]    = acierto;
        historialSize++;
        if (acierto) {
            saldo += apuesta;
            return "Número: " + numero + "GANASTE!";
        } else {
            saldo -= apuesta;
            return "Número: " + numero + "PERDISTE";
        }
    }

    public boolean evaluarResultado(int numero, TipoApuesta tipo) {
        return switch (tipo) {
                case ROJO -> esRojo(numero);
                case NEGRO -> !esRojo(numero) && numero != 0;
                case PAR -> numero % 2 == 0 && numero != 0;
                case IMPAR -> numero % 2 != 0;
        };
    }
    private int girarRuleta() {
        return rng.nextInt(37);
    }

    private boolean esRojo(int n) {
        for (int r : numerosRojos) if (r == n) return true;
        return false;
        }
    }
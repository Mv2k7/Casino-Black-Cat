package Modelo;

import java.util.Random;

public class Ruleta {

    private int saldo;
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

    public Resultado jugar(TipoApuesta tipo, int apuesta) {
        int numero = girarRuleta();
        boolean acierto = evaluarResultado(numero, tipo);
        if (acierto) {
            saldo += apuesta;
        } else {
            saldo -= apuesta;
        }
        return new Resultado(numero, tipo, apuesta, acierto);
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
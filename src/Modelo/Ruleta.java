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

    public Resultado jugar(ApuestaBase apuesta) {
        int numero = girarRuleta();
        String color = colorDe(numero);
        boolean acierto = apuesta.acierta(numero, color);
        if (acierto) {
            saldo += apuesta.getMonto();
        } else {
            saldo -= apuesta.getMonto();
        }
        return new Resultado(numero, apuesta.getEtiqueta(), apuesta.getMonto(), acierto);
    }

    private String colorDe(int numero) {
        if (numero == 0) return "verde";
        return esRojo(numero) ? "rojo" : "negro";
    }

    private int girarRuleta() {
        return rng.nextInt(37);
    }

    private boolean esRojo(int n) {
        for (int r : numerosRojos) if (r == n) return true;
        return false;
        }
    }
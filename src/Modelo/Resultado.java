package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Resultado {
    private final int numero;
    private final TipoApuesta tipo;
    private final boolean acierto;
    private final int saldo;

    public Resultado(int numero, TipoApuesta tipo, int saldo, boolean acierto) {
        this.numero = numero;
        this.tipo = tipo;
        this.acierto = acierto;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public TipoApuesta getTipo() {
        return tipo;
    }

    public boolean isAcierto() {
        return acierto;
    }

    public int getSaldo() {
        return saldo;
    }

}

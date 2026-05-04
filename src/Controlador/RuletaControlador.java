package Controlador;

import Modelo.*;

public class RuletaControlador {
    private Ruleta ruleta;

    public RuletaControlador(Ruleta ruleta) {
        this.ruleta = ruleta;
    }
    public String intentarJugar(TipoApuesta tipo, int monto) {
        if (monto <= 0) return "Monto inválido";
        if (monto > ruleta.getSaldo()) return "Saldo Insuficiente";
        return ruleta.jugar(tipo, monto);
    }

    public int getSaldo() {
        return ruleta.getSaldo();
    }

    public void recargarSaldo(int monto) {
        ruleta.depositar(monto);
    }
    public Ruleta getRuleta() {
        return ruleta;
    }
}

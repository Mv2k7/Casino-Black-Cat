package Controlador;

import Modelo.*;

public class RuletaControlador {
    private Ruleta ruleta;
    private SesionControlador sesion;

    public RuletaControlador(Ruleta ruleta, SesionControlador sesion) {
        this.ruleta = ruleta;
        this.sesion = sesion;
    }
    public String intentarJugar(TipoApuesta tipo, int monto) {
        if (monto <= 0)
            throw new IllegalArgumentException("Montno invalido");
        if (monto > ruleta.getSaldo())
            throw new IllegalArgumentException("Saldo Insuficiente");
        Resultado resultado = ruleta.jugar(tipo, monto);
        sesion.getUsuarioActual().agregarResultado(resultado);
        return "Número: " + resultado.getNumero() +
                (resultado.isAcierto() ? " - GANASTE!" : " - PERDISTE") +
                "\nSaldo: $" + ruleta.getSaldo();
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

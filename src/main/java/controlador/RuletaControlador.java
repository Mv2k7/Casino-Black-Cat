package controlador;

import modelo.*;

public class RuletaControlador {
    private Ruleta ruleta;
    private SesionControlador sesion;

    public RuletaControlador(Ruleta ruleta, SesionControlador sesion) {
        this.ruleta = ruleta;
        this.sesion = sesion;
    }
    public String intentarJugar(ApuestaBase apuesta) {
        if (apuesta.getMonto() <= 0)
            throw new IllegalArgumentException("Montno invalido");
        if (apuesta.getMonto() > ruleta.getSaldo())
            throw new IllegalArgumentException("Saldo Insuficiente");
        Resultado resultado = ruleta.jugar(apuesta);
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

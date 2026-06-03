package Controlador;

import Modelo.Estadisticas;
import Modelo.Resultado;
import java.util.List;

public class EstadisticasControlador {
    private final SesionControlador sesion;
    private final Estadisticas estadisticas = new Estadisticas();

    public EstadisticasControlador(SesionControlador sesion) {
        this.sesion = sesion;
    }

    private List<Resultado> getHistorial() {
        return sesion.getUsuarioActual().getHistorial();
    }

    public int getTotalJugadas() {
        return estadisticas.calcularTotalJugadas(getHistorial());
    }

    public int getVictorias() {
        return estadisticas.calcularVictorias(getHistorial());
    }

    public double getPorcentajeVictorias() {
        return estadisticas.calcularPorcentajeVictorias(getHistorial());
    }

    public int getRachaMaxima() {
        return estadisticas.calcularRachaMaxima(getHistorial());
    }

    public String getTipoMasJugado() {
        if (getHistorial().isEmpty()) return null;
        return estadisticas.calcularTipoMasJugado(getHistorial());
    }
}
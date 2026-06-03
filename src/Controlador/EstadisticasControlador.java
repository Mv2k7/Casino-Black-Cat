package Controlador;

import Modelo.Estadisticas;
import Modelo.IRepositorioResultados;

public class EstadisticasControlador {
    private final IRepositorioResultados repositorio;
    private final Estadisticas estadisticas = new Estadisticas();

    public EstadisticasControlador(IRepositorioResultados repositorio) {
        this.repositorio = repositorio;
    }

    public int getTotalJugadas() {
        return estadisticas.calcularTotalJugadas(repositorio);
    }

    public int getVictorias() {
        return estadisticas.calcularVictorias(repositorio);
    }

    public double getPorcentajeVictorias() {
        return estadisticas.calcularPorcentajeVictorias(repositorio);
    }

    public int getRachaMaxima() {
        return estadisticas.calcularRachaMaxima(repositorio);
    }

    public String getTipoMasJugado() {
        if (repositorio.obtenerTodos().isEmpty()) return "No se ha jugado";
        return estadisticas.calcularTipoMasJugado(repositorio);
    }
}

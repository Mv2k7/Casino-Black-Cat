package controlador;

import modelo.Estadisticas;
import modelo.IRepositorioResultados;

public class EstadisticasControlador {
    private final IRepositorioResultados repositorio;
    private final Estadisticas estadisticas = new Estadisticas();

    public EstadisticasControlador(IRepositorioResultados repositorio) {
        this.repositorio = repositorio;
    }

    public int getTotalJugadas() {
        return estadisticas.calcularTotalJugadas(repositorio.obtenerTodos());
    }

    public int getVictorias() {
        return estadisticas.calcularVictorias(repositorio.obtenerTodos());
    }

    public double getPorcentajeVictorias() {
        return estadisticas.calcularPorcentajeVictorias(repositorio.obtenerTodos());
    }

    public int getRachaMaxima() {
        return estadisticas.calcularRachaMaxima(repositorio.obtenerTodos());
    }

    public String getTipoMasJugado() {
        if (repositorio.obtenerTodos().isEmpty()) return "No se ha jugado";
        return estadisticas.calcularTipoMasJugado(repositorio.obtenerTodos());
    }
}

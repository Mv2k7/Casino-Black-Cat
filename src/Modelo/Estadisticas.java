package Modelo;

import java.util.List;

public class Estadisticas {
    public int calcularTotalJugadas(List<Resultado> historial) {
        return historial.size();
    }

    public int calcularVictorias(List<Resultado> historial) {
        int victorias = 0;
        for (Resultado r : historial) {
            if (r.isAcierto()) {
                victorias++;
            }
        }
        return victorias;
    }

    public double calcularPorcentajeVictorias(List<Resultado> historial) {
        if (historial.size() == 0) return 0;
        return (double) calcularVictorias(historial) / historial.size() * 100;
    }

    public int calcularRachaMaxima(List<Resultado> historial) {
        int rachaActual = 0;
        int rachaMaxima = 0;
        for (Resultado r : historial) {
            if (r.isAcierto()) {
                rachaActual++;
                if (rachaActual > rachaMaxima) {
                    rachaMaxima = rachaActual;
                }
            } else {
                rachaActual = 0;
            }
        }
        return rachaMaxima;
    }

    public TipoApuesta calcularTipoMasJugado(List<Resultado> historial) {
        int contRojo = 0, contNegro = 0, contPar = 0, contImpar = 0;
        for (Resultado r : historial) {
            switch (r.getTipo()) {
                case ROJO  -> contRojo++;
                case NEGRO -> contNegro++;
                case PAR   -> contPar++;
                case IMPAR -> contImpar++;
            }
        }
        int max = Math.max(Math.max(contRojo, contNegro), Math.max(contPar, contImpar));
        if (max == contRojo)  return TipoApuesta.ROJO;
        if (max == contNegro) return TipoApuesta.NEGRO;
        if (max == contPar)   return TipoApuesta.PAR;
        return TipoApuesta.IMPAR;
    }
}

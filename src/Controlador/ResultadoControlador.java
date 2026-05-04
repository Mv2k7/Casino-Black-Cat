package Controlador;

import Modelo.*;

public class ResultadoControlador {
        private Ruleta ruleta;

        public ResultadoControlador(Ruleta ruleta) {
            this.ruleta = ruleta;
        }

        public String getTextoHistorial() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ruleta.getHistorialSize(); i++) {
                sb.append("Número: ").append(ruleta.getHistorialNumero(i));
                sb.append(" | Apuesta: ").append(ruleta.getHistorialApuesta(i));
                sb.append(ruleta.getHistorialAcierto(i) ? " | GANÓ" : " | PERDIÓ");
                sb.append("\n");
            }
            return sb.toString();
        }
    }

//    public static void mostrarEstadisticas() {
//        int partidas = Ruleta.historialSize;
//        int gastado = 0;
//        int aciertos = 0;
//        int ganancias = 0;
//
//        for (int i = 0; i < Ruleta.historialSize; i++) {
//            gastado += Ruleta.historialApuestas[i];
//
//            if (Ruleta.historialAciertos[i]) {
//                aciertos++;
//                ganancias += Ruleta.historialApuestas[i];
//            } else {
//                ganancias -= Ruleta.historialApuestas[i];
//            }
//        }
//        double porcentaje = 0;
//        // para que no divida por 0 y sea positivo, tiene que cumplir que las partidas sean mayores que 0.
//        if (partidas > 0) {
//            porcentaje = (double) aciertos / partidas * 100;
//        }
//        System.out.println("Partidas jugadas: " + partidas +
//                "\nTotal apostado: " + gastado +
//                "\nTotal aciertos: " + aciertos +
//                "\nPorcentaje de aciertos " + porcentaje + "%" +
//                "\nGanancia o Pérdida: " + ganancias);
//    }

package Controlador;

import Modelo.*;

public class ResultadoControlador {
        private SesionControlador sesion;

        public ResultadoControlador(SesionControlador sesion) {
            this.sesion = sesion;
        }

        public String getTextoHistorial() {
            StringBuilder sb = new StringBuilder();
            for (Resultado r : sesion.getUsuarioActual().getHistorial()) {
                sb.append("Número: ").append(r.getNumero());
                sb.append(" | Apuesta: ").append(r.getEtiqueta());
                sb.append(r.isAcierto() ? " | GANÓ" : " | PERDIÓ");
                sb.append("\n");
            }
            return sb.toString();
        }
    }
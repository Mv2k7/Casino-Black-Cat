package controlador;

import modelo.*;

public class ResultadoControlador {
        private IRepositorioResultados repositorio;

        public ResultadoControlador(IRepositorioResultados repositorio) {
            this.repositorio = repositorio;
        }

        public String getTextoHistorial() {
            StringBuilder sb = new StringBuilder();
            for (Resultado r : repositorio.obtenerTodos()) {
                sb.append("Número: ").append(r.getNumero());
                sb.append(" | Apuesta: ").append(r.getEtiqueta());
                sb.append(r.isAcierto() ? " | GANÓ" : " | PERDIÓ");
                sb.append("\n");
            }
            return sb.toString();
        }
    }
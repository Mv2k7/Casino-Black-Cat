package Controlador;

import Modelo.*;

public class ResultadoControlador {
    public class ResultadoController {
        private Ruleta ruleta;

        public ResultadoController(Ruleta ruleta) {
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
}

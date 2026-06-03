package Vista;

import Controlador.*;

import javax.swing.*;

public class VentanaEstadisticas {
    private final JFrame frame     = new JFrame("Estadísticas - Casino Black Cat");
    private final JButton btnAtras = new JButton("Atras");
    private final JTextArea area   = new JTextArea();

    private final SesionControlador sesion;
    private final RuletaControlador controlador;

    public VentanaEstadisticas(SesionControlador sesion, RuletaControlador controlador) {
        this.sesion      = sesion;
        this.controlador = controlador;

        EstadisticasControlador estadisticas = new EstadisticasControlador(
                controlador.getRuleta().getRepositorio()
        );

        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area.setBounds(50, 20, 390, 280);
        area.setEditable(false);
        btnAtras.setBounds(20, 320, 100, 30);

        String tipoMasJugado = estadisticas.getTipoMasJugado() != null
                ? estadisticas.getTipoMasJugado().toString()
                : "Sin jugadas";

        area.setText(
                "Total jugadas:        " + estadisticas.getTotalJugadas() + "\n" +
                        "Victorias:            " + estadisticas.getVictorias() + "\n" +
                        "Porcentaje victorias: " + String.format("%.1f", estadisticas.getPorcentajeVictorias()) + "%\n" +
                        "Racha máxima:         " + estadisticas.getRachaMaxima() + "\n" +
                        "Tipo más jugado:      " + tipoMasJugado
        );

        frame.add(area);
        frame.add(btnAtras);

        btnAtras.addActionListener(e -> {
            frame.dispose();
            new VentanaMenu(sesion, controlador).mostrarVentana();
        });
    }

    public void mostrarEstadisticas() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
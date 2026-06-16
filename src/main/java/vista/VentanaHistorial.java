package vista;

import controlador.ResultadoControlador;
import controlador.RuletaControlador;
import controlador.SesionControlador;

import javax.swing.*;

public class VentanaHistorial {
    private final JFrame frame        = new JFrame("Historial - Casino Black Cat");
    private final JLabel lblTitulo    = new JLabel("Historial de jugadas");
    private final JButton btnAtras    = new JButton("Atras");
    private final JTextArea area      = new JTextArea();

    private final SesionControlador sesion;
    private final RuletaControlador controlador;

    public VentanaHistorial(SesionControlador sesion, RuletaControlador ruletaControlador) {
        this.sesion      = sesion;
        this.controlador = ruletaControlador;

        ResultadoControlador resultadoControlador = new ResultadoControlador(ruletaControlador.getRuleta().getRepositorio());

        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblTitulo.setBounds(180, 10, 200, 30);
        area.setBounds(50, 50, 390, 250);
        btnAtras.setBounds(20, 320, 100, 30);

        area.setEditable(false);
        area.setText(resultadoControlador.getTextoHistorial());

        frame.add(lblTitulo);
        frame.add(area);
        frame.add(btnAtras);

        btnAtras.addActionListener(e -> {
            frame.dispose();
            new VentanaMenu(sesion, controlador).mostrarVentana();
        });
    }

    public void mostrarHistorial() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

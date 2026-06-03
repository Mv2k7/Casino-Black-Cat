package Vista;

import Controlador.*;


import javax.swing.*;

public class VentanaRegistro {
    private final JFrame frame          = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblHistorial   = new JLabel("Historial");
    private final JTextField username   = new JTextField();
    private final JButton btnAtras      = new JButton("Atras");
    private JTextArea area              = new JTextArea();


    public VentanaRegistro(SesionControlador sesion, RuletaControlador ruleta) {
        ResultadoControlador resultadoControlador = new ResultadoControlador(ruleta.getRuleta().getRepositorio());
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        area.setEditable(false);
        area.setText(resultadoControlador.getTextoHistorial());

        // Posiciones
        lblHistorial.setBounds(230, 10, 300, 100);
        btnAtras.setBounds(20, 320, 100, 30);
        area.setBounds(50, 80, 380, 220);


        frame.add(lblHistorial);
        frame.add(btnAtras);
        frame.add(area);

        btnAtras.addActionListener(e -> {
            frame.dispose();
            VentanaMenu menu = new VentanaMenu(sesion, ruleta);
            menu.mostrarVentana();
        });
    }
}
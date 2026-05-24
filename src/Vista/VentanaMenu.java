package Vista;

import Controlador.*;
import Modelo.Ruleta;

import javax.swing.*;
import java.awt.*;

public class VentanaMenu {

    // Interfaz
    private final JFrame frame              = new JFrame("RULETA - Casino Black Cat");
    private final JButton btnInicio         = new JButton("Inicio");
    private final JButton btnJugar          = new JButton("Jugar");
    private final JButton btnHistorial      = new JButton("Historial");
    private final JButton btnSalir          = new JButton("Salir");
    private final JPanel panelInfo          = new JPanel();

    private final SesionControlador sesion;
    private final RuletaControlador controlador;

    public VentanaMenu(SesionControlador sesion, RuletaControlador ruletaControlador) {
        this.sesion = sesion;
        this.controlador = ruletaControlador;

        // Ventana
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelInfo.setLayout(null);
        panelInfo.setBounds(130, 20, 340, 250);
        panelInfo.setBorder(BorderFactory.createLineBorder(Color.black));
        JTextArea txtInfo = new JTextArea();
        txtInfo.setText("Bienvenido/a al menú principal.\n\n" +
                        "A la izquierda tienes:\n" +
                        "• Jugar: abre la ventana de juego\n" +
                        "• Historial: abre el historial\n" +
                        "• Salir: cierra sesión");
        txtInfo.setBounds(10, 10, 320, 230);
        txtInfo.setEditable(false);
        txtInfo.setBackground(panelInfo.getBackground());
        panelInfo.add(txtInfo);

        // Posiciones
        btnInicio.setBounds(10, 10, 100, 30);
        btnJugar.setBounds(10, 50, 100, 30);
        btnHistorial.setBounds(10, 90, 100, 30);
        btnSalir.setBounds(10, 130, 100, 30);

        frame.add(btnInicio);
        frame.add(btnJugar);
        frame.add(btnHistorial);
        frame.add(btnSalir);
        frame.add(panelInfo);

        btnInicio.addActionListener(e -> abrirInicio());
        btnJugar.addActionListener(e -> abrirJugar());
        btnHistorial.addActionListener(e -> abrirHistorial());
        btnSalir.addActionListener(e -> abrirSalir());
    }

    private void abrirInicio(){
        frame.dispose();
        mostrarVentana();
    }
    private void abrirJugar() {
        frame.dispose();
        new VentanaRuleta(sesion, controlador).mostrarRuleta();
    }
    private void abrirHistorial() {
        frame.dispose();
        new VentanaHistorial(sesion, controlador).mostrarHistorial();
    }
    private void abrirSalir() {
        sesion.cerrarSesion();
        frame.dispose();
        new VentanaLogin(sesion).mostrarVentana();
    }
    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

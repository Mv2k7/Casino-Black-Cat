import javax.swing.*;
import java.awt.*;

public class VentanaRuleta {
    private final JFrame frame          = new JFrame("RULETA! - Casino Black Cat");
    private final JLabel lblApuesta     = new JLabel("Selecciona que tipo de apuesta quieres");
    private final JButton btnRojoNegro  = new JButton("Rojo/Negro");
    private final JButton btnParImpar   = new JButton("Par/Impar");
    private final JButton btnAtras      = new JButton("Atras");

    public VentanaRuleta() {
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Posiciones
        lblApuesta.setBounds(80, 10, 300, 70);
        btnRojoNegro.setBounds(70, 80, 150, 30);
        btnParImpar.setBounds(70, 120, 150, 30);
        btnAtras.setBounds(20, 320, 100, 30);

        frame.add(lblApuesta);
        frame.add(btnRojoNegro);
        frame.add(btnParImpar);
        frame.add(btnAtras);

        btnAtras.addActionListener(e -> {
            frame.dispose();
            VentanaMenu menu = new VentanaMenu();
            menu.mostrarVentana();
        });
        btnRojoNegro.addActionListener(e -> {});
        btnParImpar.addActionListener(e -> {});
    }

    public void mostrarRuleta() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
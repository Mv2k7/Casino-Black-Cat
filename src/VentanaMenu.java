import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaMenu {
    private final JFrame frame              = new JFrame("RULETA - Casino Black Cat");
    private final JButton btnInicio         = new JButton("Inicio");
    private final JButton btnJugar          = new JButton("Jugar");
    private final JButton btnHistorial      = new JButton("Historial");
    private final JButton btnSalir          = new JButton("Salir");


    public VentanaMenu() {

        // Ventana
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Posiciones
        btnInicio.setBounds(10, 10, 100, 30);
        btnJugar.setBounds(10, 50, 100, 30);
        btnHistorial.setBounds(10, 90, 100, 30);
        btnSalir.setBounds(10, 130, 100, 30);

        frame.add(btnInicio);
        frame.add(btnJugar);
        frame.add(btnHistorial);
        frame.add(btnSalir);


    }
    public void mostrarInicio() {

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void jugar() {

    }
}

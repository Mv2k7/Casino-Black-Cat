import javax.swing.*;

public class VentanaRegistro {

    private JFrame frame = new JFrame("Registro");


    public VentanaRegistro() {
        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

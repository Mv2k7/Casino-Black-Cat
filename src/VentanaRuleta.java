import javax.swing.*;
import java.awt.*;

public class VentanaRuleta {
    private final JFrame frame          = new JFrame("RULETA! - Casino Black Cat");
    private final JComboBox<String> cbTipoApuesta = new JComboBox<>(new String[]{"Tipo de apuesta...", "Colores", "Paridad"});
    private final JComboBox<String> cbOpcion = new JComboBox<>(new String[]{"Seleccione opcion..."});
    private final JButton btnGirar      = new JButton("Girar Ruleta!");
    private final JButton btnAtras      = new JButton("Atras");


    public VentanaRuleta() {
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Posiciones
        cbTipoApuesta.setBounds(70, 80, 150, 30);
        cbOpcion.setBounds(250, 80, 150, 30);
        btnGirar.setBounds(300, 180, 150, 30);
        btnAtras.setBounds(20, 320, 100, 30);

        frame.add(cbTipoApuesta);
        frame.add(cbOpcion);
        frame.add(btnAtras);
        frame.add(btnGirar);

        btnAtras.addActionListener(e -> {
            frame.dispose();
            VentanaMenu menu = new VentanaMenu();
            menu.mostrarVentana();
        });
        cbTipoApuesta.addActionListener(e -> actualizarOpciones());
        btnGirar.addActionListener(e -> {
            String seleccion = (String) cbOpcion.getSelectedItem();
            if (cbOpcion.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(frame, "Selecciona una opción.");
                return;
            }
            char tipo = seleccion.toLowerCase().charAt(0);
            String resultado = Ruleta.jugar(tipo, 100);
            JOptionPane.showMessageDialog(frame, resultado);
        });
    }

    private void actualizarOpciones() {
        cbOpcion.removeAllItems();
        cbOpcion.addItem("Seleccione opcion...");
        String tipo = (String) cbTipoApuesta.getSelectedItem();

        if ("Colores".equals(tipo)) {
            cbOpcion.addItem("Rojo");
            cbOpcion.addItem("Negro");
        } else if ("Paridad".equals(tipo)) {
            cbOpcion.addItem("Par");
            cbOpcion.addItem("Impar");
        }
    }

    public void mostrarRuleta() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
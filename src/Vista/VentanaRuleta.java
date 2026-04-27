package Vista;

import Controlador.*;

import javax.swing.*;

public class VentanaRuleta {
    private final JFrame frame          = new JFrame("RULETA! - Casino Black Cat");
    private final JComboBox<String> cbTipoApuesta = new JComboBox<>(new String[]{"Tipo de apuesta...", "Colores", "Paridad"});
    private final JComboBox<String> cbOpcion = new JComboBox<>(new String[]{"Seleccione opcion..."});
    private final JButton btnGirar      = new JButton("Girar Modelo.Ruleta!");
    private final JButton btnAtras      = new JButton("Atras");
    private final JTextField txtMonto = new JTextField();
    private final JLabel lblMonto = new JLabel("Monto:");

    private Usuario usuario;

    public VentanaRuleta(Usuario usuario) {
        this.usuario = usuario;
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Posiciones
        cbTipoApuesta.setBounds(70, 80, 150, 30);
        cbOpcion.setBounds(250, 80, 150, 30);
        btnGirar.setBounds(300, 180, 150, 30);
        btnAtras.setBounds(20, 320, 100, 30);
        txtMonto.setBounds(70, 130, 150, 30);
        lblMonto.setBounds(70, 110, 150, 20);

        frame.add(cbTipoApuesta);
        frame.add(cbOpcion);
        frame.add(btnAtras);
        frame.add(btnGirar);
        frame.add(txtMonto);
        frame.add(lblMonto);

        btnAtras.addActionListener(e -> {
            frame.dispose();
            VentanaMenu menu = new VentanaMenu(usuario);
            menu.mostrarVentana();
        });
        cbTipoApuesta.addActionListener(e -> actualizarOpciones());
        btnGirar.addActionListener(e -> {

            if (cbOpcion.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(frame, "Selecciona una opción.");
                return;
            }

            int monto;

            try {
                monto = Integer.parseInt(txtMonto.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Monto inválido");
                return;
            }

            if (monto > usuario.getSaldo()) {
                JOptionPane.showMessageDialog(frame, "No tienes suficiente saldo");
                return;
            }

            char tipo = obtenerTipoApuesta();

            String resultado = Ruleta.jugar(tipo, monto);

            if (resultado.contains("GANASTE")) {
                usuario.sumarSaldo(monto);
            } else {
                usuario.restarSaldo(monto);
            }

            JOptionPane.showMessageDialog(frame,
                    resultado + "\nSaldo: $" + usuario.getSaldo());
        });
    }

    private char obtenerTipoApuesta() {
        String opcion = (String) cbOpcion.getSelectedItem();

        switch (opcion) {
            case "Rojo":
                return 'r';
            case "Negro":
                return 'n';
            case "Par":
                return 'p';
            case "Impar":
                return 'i';
        }
        return ' '; // por si algo falla
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
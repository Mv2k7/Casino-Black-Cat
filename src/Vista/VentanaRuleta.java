package Vista;

import Controlador.*;
import Modelo.*;

import javax.swing.*;

public class VentanaRuleta {
    private final JFrame frame                    = new JFrame("RULETA! - Casino Black Cat");
    private final JComboBox<String> cbTipoApuesta = new JComboBox<>(new String[]{"Tipo de apuesta...", "Colores", "Paridad"});
    private final JComboBox<String> cbOpcion      = new JComboBox<>(new String[]{"Seleccione opcion..."});
    private final JButton btnGirar                = new JButton("Girar Ruleta!");
    private final JButton btnAtras                = new JButton("Atras");
    private final JTextField txtMonto             = new JTextField();
    private final JLabel lblMonto                 = new JLabel("Monto:");

    private final SesionControlador sesion;
    private final RuletaControlador controlador;

    public VentanaRuleta(SesionControlador sesion, RuletaControlador ruletaControlador) {
        this.sesion      = sesion;
        this.controlador = ruletaControlador;

        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        btnAtras.addActionListener(e -> botonAtras());
        cbTipoApuesta.addActionListener(e -> actualizarOpciones());
        btnGirar.addActionListener(e -> intentarJugar());
    }

    private void botonAtras() {
        frame.dispose();
        new VentanaMenu(sesion, controlador).mostrarVentana();
    }

    private void intentarJugar() {
        if (cbOpcion.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(frame, "Seleccione una opcion");
            return;
        }

        int monto;
        try {
            monto = Integer.parseInt(txtMonto.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Ingrese un monto válido");
            return;
        }

        String opcion = (String) cbOpcion.getSelectedItem();
        ApuestaBase apuesta = switch (opcion) {
            case "Rojo"  -> new ApuestaRojo(monto);
            case "Negro" -> new ApuestaNegro(monto);
            case "Par"   -> new ApuestaPar(monto);
            case "Impar" -> new ApuestaImpar(monto);
            default -> throw new IllegalArgumentException("Opción inválida");
        };

        try {
            String resultado = controlador.intentarJugar(apuesta);
            JOptionPane.showMessageDialog(frame, resultado);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage());
        }
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
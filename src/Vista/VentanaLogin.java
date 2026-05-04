package Vista;

import Controlador.*;
import Modelo.Ruleta;

import javax.swing.*;

public class VentanaLogin {
    // Interfaz
    private final JFrame frame              = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario         = new JLabel("Usuario:");
    private final JTextField txtUsuario     = new JTextField();
    private final JLabel lblClave           = new JLabel("Clave:");
    private final JPasswordField txtClave   = new JPasswordField();
    private final JButton btnIngresar       = new JButton("Ingresar");

    public VentanaLogin(SesionControlador sesion) {
        //Ventana
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Posiciones
        lblUsuario.setBounds(30, 10, 300, 30);
        txtUsuario.setBounds(35, 40, 300, 30);

        lblClave.setBounds(30, 70, 300, 30);
        txtClave.setBounds(35, 100, 300, 30);

        btnIngresar.setBounds(75, 200, 250, 30);

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);

        btnIngresar.addActionListener(e -> intentarLogin(sesion));
    }

//    private Usuario validarCredenciales(String u, String p) {
//        for (Usuario user : USUARIOS) {
//            if (user.validarCredenciales(u, p)) {
//                return user;
//            }
//        }
//        return null;
//    }

    private void intentarLogin(SesionControlador sesion) {
        String usuario = txtUsuario.getText();
        String clave = new String(txtClave.getPassword());

        if (sesion.iniciarSesion(usuario, clave)) {
            frame.dispose();
            Ruleta ruleta = new Ruleta(sesion.getUsuarioActual().getSaldo());
            RuletaControlador ruletaControlador = new RuletaControlador(ruleta);
            new VentanaMenu(sesion, ruletaControlador).mostrarVentana();
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario o clave incorrectos.");
        }
    }

    public void abrirRegistro() {
        JOptionPane.showMessageDialog(frame, "Estamos trabajando en ello...");
    }


    public void mostrarVentana() {

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
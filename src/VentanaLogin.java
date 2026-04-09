import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaLogin {
    // Lista dinámica de usuarios
    public static final List<Usuario> USUARIOS = new ArrayList<>();

    // UI
    private final JFrame frame              = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario         = new JLabel("Usuario:");
    private final JTextField txtUsuario     = new JTextField();
    private final JLabel lblClave           = new JLabel("Clave:");
    private final JPasswordField txtClave   = new JPasswordField();
    private final JButton btnIngresar       = new JButton("Ingresar");

    public VentanaLogin() {
        // TODO: inicializar usuarios hardcodeados
        USUARIOS.add(new Usuario("marchelito", "si", "Marcelo"));
        // TODO: inicializar y configurar la ventana
        //Ventana
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Posiciones
        lblUsuario.setBounds(30, 10, 300, 30); // Texto que indica, usuario
        txtUsuario.setBounds(35, 40, 300, 30); // Cajita donde ingresar datos

        lblClave.setBounds(30, 70, 300, 30);
        txtClave.setBounds(35, 100, 300, 30);

        btnIngresar.setBounds(75, 200, 250, 30);

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);

        btnIngresar.addActionListener(e -> login());
    }

    public void mostrarVentana() {
        // TODO: mostrar ventana
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void login() {
        String usuario = txtUsuario.getText();
        String clave = new String(txtClave.getPassword());

        String nombre = validarCredenciales(usuario, clave);

        if (!nombre.equals("")) {
            JOptionPane.showMessageDialog(frame, "Bienvenido! " + nombre);

            frame.dispose();
        }

    }

    private String validarCredenciales(String u, String p) {
        // TODO: recorrer arreglo y validar credenciales
        for (Usuario user : USUARIOS) {
            if (user.validarCredenciales(u, p)) {
                return user.getNombre();
            }
        }
        return "";
    }
    public void abrirRegistro() {
    JOptionPane.showMessageDialog(frame, "Estamos trabajando en ello...");
    }
}
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
        // TODO: inicializar y configurar la ventana
    }

    public void mostrarVentana() {
        // TODO: mostrar ventana
    }

    private void login() {

    }

    private String validarCredenviales(String u, String p) {
        // TODO: recorrer arreglo y validar credenciales
        return "";
    }
    void abrirRegistro() {

    }
}
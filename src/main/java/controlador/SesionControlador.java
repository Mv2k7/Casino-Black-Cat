package controlador;

import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class SesionControlador {
    private List<Usuario> usuarios = new ArrayList<>();
    private Usuario usuarioActual;

    public void registrarUsuario(String usuario, String clave, String n) {
        if (usuario == null || usuario.isBlank() || clave == null || clave.isBlank() || n == null || n.isBlank())
            throw new IllegalArgumentException("Datos requeridos");
        usuarios.add(new Usuario(usuario, clave, n));
    }
    public boolean iniciarSesion(String usuario, String clave) {
        for (Usuario u : usuarios) {
            if (u.validarCredenciales(usuario, clave)) {
                usuarioActual = u;
                return true;
            }
        }
        return false;
    }
    public boolean hayUsuario() {
        return usuarioActual != null;
    }
    public String getNombreUsuario() {
        return hayUsuario() ? usuarioActual.getNombre() : "";
    }
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    public void cerrarSesion() {
        usuarioActual = null;
    }
}
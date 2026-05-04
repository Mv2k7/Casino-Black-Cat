package Controlador;

import Modelo.Usuario;

import javax.swing.*;

public class SesionControlador {

    private Usuario usuarioActual;

    public void registrarUsuario(String usuario, String clave, String n) {
        if (usuario == null || usuario.isBlank() || clave == null || clave.isBlank() || n == null || n.
                isBlank())
            throw new IllegalArgumentException("Datos requeridos");
        this.usuarioActual = new Usuario(usuario, clave, n);
    }
    public boolean iniciarSesion(String usuario, String clave) {
        if (usuarioActual == null) return false;
        return usuarioActual.validarCredenciales(usuario, clave);
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
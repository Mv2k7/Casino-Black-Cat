package Modelo;

public class Usuario {
    private String username;
    private String password;
    private String nombre;
    private int saldo = 1000;

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }

    public Usuario() {
        this("invitado", "", "invitado");
    }

    public boolean validarCredenciales(String usuario, String clave) {
        return this.username.equals(usuario) && this.password.equals(clave);
    }

    public String getNombre() {
        return nombre;
    }
    public int getSaldo() {
        return saldo;
    }

    public void sumarSaldo(int monto) {
        saldo += monto;
    }

    public void restarSaldo(int monto) {
        saldo -= monto;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
        }
    }
}
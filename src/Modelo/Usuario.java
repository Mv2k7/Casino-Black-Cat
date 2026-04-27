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

    public boolean validarCredenciales(String u, String p) {
        return this.username.equals(u) && this.password.equals(p);
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
}
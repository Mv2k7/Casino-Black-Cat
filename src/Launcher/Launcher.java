package Launcher;

import Controlador.SesionControlador;
import Vista.VentanaLogin;

public class Launcher {
    static void main(String[] args) {
        SesionControlador sesion = new SesionControlador();
        sesion.registrarUsuario("marchelito", "si", "Marcelo");
        sesion.registrarUsuario("asd", "asd", "DonDonnie");

        new VentanaLogin(sesion).mostrarVentana();
    }
}

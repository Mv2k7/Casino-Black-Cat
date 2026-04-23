import javax.swing.*;
import java.awt.*;

public class VentanaRegistro {
    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblHistorial = new JLabel("Historial");
    private final JTextField username = new JTextField();
    private final JButton btnAtras = new JButton("Atras");

    public VentanaRegistro() {
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Posiciones
        lblHistorial.setBounds(230, 10, 300, 100);
        btnAtras.setBounds(20, 320, 100, 30);

        frame.add(lblHistorial);
        frame.add(btnAtras);

        btnAtras.addActionListener(e -> {
            frame.dispose();
            VentanaMenu menu = new VentanaMenu();
            menu.mostrarVentana();
        });
    }

    public void mostrarHistorial() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void mostrarEstadisticas() {
        int partidas = Ruleta.historialSize;
        int gastado = 0;
        int aciertos = 0;
        int ganancias = 0;

        for (int i = 0; i < Ruleta.historialSize; i++) {
            gastado += Ruleta.historialApuestas[i];

            if (Ruleta.historialAciertos[i]) {
                aciertos++;
                ganancias += Ruleta.historialApuestas[i];
            } else {
                ganancias -= Ruleta.historialApuestas[i];
            }
        }
        double porcentaje = 0;
        // para que no divida por 0 y sea positivo, tiene que cumplir que las partidas sean mayores que 0.
        if (partidas > 0) {
            porcentaje = (double) aciertos / partidas * 100;
        }
        System.out.println("Partidas jugadas: " + partidas +
                "\nTotal apostado: " + gastado +
                "\nTotal aciertos: " + aciertos +
                "\nPorcentaje de aciertos " + porcentaje + "%" +
                "\nGanancia o Pérdida: " + ganancias);
    }
}
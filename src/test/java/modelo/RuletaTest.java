package modelo;

import controlador.SesionControlador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class RuletaTest {

    // Caso 1: Constructor rechaza saldo negativo
    @Test
    void constructorRechazaSaldoNegativo() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ruleta(-1, new RepositorioEnMemoria())
        );
    }

    // Caso 2: Depósito válido incrementa el saldo
    @Test
    void depositoValidoIncrementaSaldo() {
        Ruleta ruleta = new Ruleta(1000, new RepositorioEnMemoria());
        ruleta.depositar(500);
        assertEquals(1500, ruleta.getSaldo());
    }

    // Caso 3: Apuesta nula es rechazada
    @Test
    void apuestaNulaEsRechazada() {
        Ruleta ruleta = new Ruleta(1000, new RepositorioEnMemoria());
        assertThrows(IllegalArgumentException.class, () ->
                ruleta.jugar(null)
        );
    }

    // Caso 4: Apuesta con monto mayor al saldo
    @Test
    void apuestaConMontoMayorAlSaldo() {
        Ruleta ruleta = new Ruleta(100, new RepositorioEnMemoria());
        assertThrows(IllegalArgumentException.class, () ->
                ruleta.jugar(new ApuestaRojo(500))
        );
    }

    // Caso 5: Estadísticas calculan racha y tipo más jugado
    @Test
    void estadisticasCalculanCorrectamente() {
        Estadisticas estadisticas = new Estadisticas();
        List<Resultado> historial = List.of(
                new Resultado(1,  "Rojo",  100, true),
                new Resultado(2,  "Rojo",  100, true),
                new Resultado(3,  "Par",   100, false),
                new Resultado(5,  "Impar", 100, true),
                new Resultado(7,  "Rojo",  100, true)
        );

        assertEquals(5,     estadisticas.calcularTotalJugadas(historial));
        assertEquals(4,     estadisticas.calcularVictorias(historial));
        assertEquals(2,     estadisticas.calcularRachaMaxima(historial));
        assertEquals(80.0,  estadisticas.calcularPorcentajeVictorias(historial), 0.01);
        assertEquals("Rojo", estadisticas.calcularTipoMasJugado(historial));
    }

    // Caso 6: Inicio de sesión con usuario no registrado
    @Test
    void loginConUsuarioNoRegistrado() {
        SesionControlador sesion = new SesionControlador();
        sesion.registrarUsuario("marcelo", "1234", "Marcelo");
        boolean resultado = sesion.iniciarSesion("desconocido", "1234");
        assertFalse(resultado);
    }

    // Caso 7: Inicio de sesión con username nulo
    @Test
    void loginConUsernameNulo() {
        SesionControlador sesion = new SesionControlador();
        boolean resultado = sesion.iniciarSesion(null, "1234");
        assertFalse(resultado);
    }
}
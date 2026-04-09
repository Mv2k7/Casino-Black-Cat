import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VentanaLoginTest {

    @Test
    void testValidarCredencialesCorrectas() {

        VentanaLogin.USUARIOS.clear();
        VentanaLogin.USUARIOS.add(new Usuario("marchelito", "si", "Marcelo"));

        VentanaLogin v = new VentanaLogin();

        String resultado = vTestValidar(v, "marchelito", "si");

        assertEquals("Marcelo", resultado);
    }

    private String vTestValidar(VentanaLogin v, String u, String p) {
        try {
            var metodo = VentanaLogin.class.getDeclaredMethod("validarCredenciales", String.class, String.class);
            metodo.setAccessible(true);
            return (String) metodo.invoke(v, u, p);
        } catch (Exception e) {
            return "";
        }
    }
}
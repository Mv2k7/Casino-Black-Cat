package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioEnMemoria implements IRepositorioResultados {
    private final List<Resultado> historial = new ArrayList<>();

    @Override
    public void guardar(Resultado resultado) {
        historial.add(resultado);
    }

    @Override
    public List<Resultado> obtenerTodos() {
        return Collections.unmodifiableList(historial);
    }
}

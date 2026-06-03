package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioArchivo implements IRepositorioResultados {
    private final String archivo;

    public RepositorioArchivo(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void guardar(Resultado resultado) {
        try (FileWriter fw = new FileWriter(archivo, true)) {
            fw.write(resultado.getNumero() + "," +
                    resultado.getEtiqueta() + "," +
                    resultado.getSaldo() + "," +
                    resultado.isAcierto() + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    @Override
    public List<Resultado> obtenerTodos() {
        List<Resultado> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int numero       = Integer.parseInt(partes[0]);
                String etiqueta  = partes[1];
                int monto        = Integer.parseInt(partes[2]);
                boolean acierto  = Boolean.parseBoolean(partes[3]);
                lista.add(new Resultado(numero, etiqueta, monto, acierto));
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado, historial vacío");
        }
        return lista;
    }
}

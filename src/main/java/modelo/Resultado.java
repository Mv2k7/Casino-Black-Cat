package modelo;

public class Resultado {
    private final int numero;
    private final String etiqueta;
    private final boolean acierto;
    private final int saldo;

    public Resultado(int numero, String etiqueta, int saldo, boolean acierto) {
        this.numero = numero;
        this.etiqueta = etiqueta;
        this.acierto = acierto;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public boolean isAcierto() {
        return acierto;
    }

    public int getSaldo() {
        return saldo;
    }

}

package InversaFadheva;

public class ValoresPronosticados {
    private String numberYEstimate;
    private Double valor;

    public ValoresPronosticados(String numberYEstimate, Double valor) {
        this.numberYEstimate = numberYEstimate;
        this.valor = valor;
    }

    public String getNumberYEstimate() {
        return numberYEstimate;
    }

    public void setNumberYEstimate(String numberYEstimate) {
        this.numberYEstimate = numberYEstimate;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

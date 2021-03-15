package InversaFadheva;

public class LimitesConfianza {

    private double beta;
    private double limite_inferior;
    private double limite_superior;
    private double pruebaDeSignificancia;

    public LimitesConfianza(double beta, double limite_inferior, double limite_superior, double pruebaDeSignificancia) {
        this.beta = beta;
        this.limite_inferior = limite_inferior;
        this.limite_superior = limite_superior;
        this.pruebaDeSignificancia = pruebaDeSignificancia;
    }

    public double getPruebaDeSignificancia() {
        return pruebaDeSignificancia;
    }

    public void setPruebaDeSignificancia(double pruebaDeSignificancia) {
        this.pruebaDeSignificancia = pruebaDeSignificancia;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getLimite_inferior() {
        return limite_inferior;
    }

    public void setLimite_inferior(double limite_inferior) {
        this.limite_inferior = limite_inferior;
    }

    public double getLimite_superior() {
        return limite_superior;
    }

    public void setLimite_superior(double limite_superior) {
        this.limite_superior = limite_superior;
    }
}

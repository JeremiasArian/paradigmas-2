package actividad2209;

public class Alumno {
    private Turno turno;
    private boolean accesoAlcomedor = false;
    private boolean poseeHermanoInscripto = false;

    public Alumno(){}

    public boolean isAccesoAlcomedor() {
        return accesoAlcomedor;
    }

    public void setAccesoAlcomedor(boolean accesoAlcomedor) {
        this.accesoAlcomedor = accesoAlcomedor;
    }

    public boolean isPoseeHermanoInscripto() {
        return poseeHermanoInscripto;
    }

    public void setPoseeHermanoInscripto(boolean poseeHermanoInscripto) {
        this.poseeHermanoInscripto = poseeHermanoInscripto;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public enum Turno{
        MANANA,
        TARDE,
        DOBLE
    }
}

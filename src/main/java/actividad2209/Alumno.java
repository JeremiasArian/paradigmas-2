package actividad2209;

public class Alumno {
    private boolean accesoAlcomedor = false;
    private boolean poseeHermanoInscripto = false;

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

    public enum Turno{
        MANANA,
        TARDE,
        DOBLE
    }
}

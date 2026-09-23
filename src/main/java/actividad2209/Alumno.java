package actividad2209;

public class Alumno {
    private Turno turno;
    private boolean accesoAlcomedor = false;
    private boolean poseeHermanoInscripto = false;
    private int edad = 0;
    private boolean meses = false;
    private boolean anios = false;

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

    public boolean isMeses() {
        return meses;
    }

    public void setMeses(boolean meses) {
        this.meses = meses;
    }

    public boolean isAnios() {
        return anios;
    }

    public void setAnios(boolean anios) {
        this.anios = anios;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public enum Turno{
        MANANA,
        TARDE,
        DOBLE
    }
}

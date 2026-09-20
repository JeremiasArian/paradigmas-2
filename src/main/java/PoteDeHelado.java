
/*
@author Jeremias Arian Duarte
*/
public class PoteDeHelado {
    private Sabor sabor;
    private double precio;
    private Cantidad cantidad;
    
    public PoteDeHelado(){}

    public enum Sabor {
        CHOCOLATE_AMARGO,
        VAINILLA,
        FRUTILLA_A_LA_CREMA
    }

    public enum Cantidad {
        UN_CUARTO,
        MEDIO_KILO,
        UN_KILO
    }

    @Override
    public String toString(){
        return this.getSabor().toString()+" de "+this.getCantidad() ;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public void setCantidad(Cantidad cantidad) {
        this.cantidad = cantidad;
    }

}

public class Libro {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int precio;

    public Libro(){}

    public void setCodigo(int c){
        this.codigo = c;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public void setNombre(String n){
        this.nombre = n;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setDescripcion(String d){
        this.descripcion = d;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setPrecio(int p){
        this.precio = p;
    }

    public int getPrecio(){
        return this.precio;
    }
}

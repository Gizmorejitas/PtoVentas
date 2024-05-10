public class Articulo {

     // -- Atributos

    public String nombre;
    public String marca;
    public String tipo;
    public double precio;
    private int stock;

    // -- Métodos 
    
    // Constructor
    public Articulo() {

    }
      public Articulo(String _nombre, double _precio, int _stock) {
        this.nombre =_nombre;
        this.precio = _precio;
        this.stock = _stock;
    }
    //getter y setter
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}
    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}


    
    
}
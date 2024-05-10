public class Vendedor {
    
    // Atributos
    public String nombre;
    public String apellidos;
    public int matricula;
    private double ventas ;


    public Vendedor() {
            this.ventas = 0;
    }

    public Vendedor(String nombre, String apellidos, int matricula) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.matricula = matricula;
        this.ventas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

// Métdos de negocio
/**
 * 
 * @param miArticulo
 * @param numArt número de unidades. Siempre valores positivos y distintos de cero
 */

public void vende(Articulo miArticulo, int numArt) {

    double precio_operacion;
    int nuevo_stock;

    if (numArt <= miArticulo.getStock()) {

        // Calculo precio y actualizo stock
        precio_operacion = numArt * miArticulo.precio; // Importe de la venta
        nuevo_stock = miArticulo.getStock()-numArt;
        miArticulo.setStock(nuevo_stock);    // actualizo unidades
        // Apuntarme la venta
        this.ventas = this.ventas + precio_operacion;

    }
    else {

    }
}
    

}

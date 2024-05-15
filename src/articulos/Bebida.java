package articulos;

public class Bebida extends Articulo {

    private char envase;
    private Integer cantidad;

    public Bebida(String _nombre, double _precio, int _stock, char envase, Integer cantidad) {
        super(_nombre, _precio, _stock);
        this.envase = envase;
        this.cantidad = cantidad;
    }

    public char getEnvase() {
        return envase;
    }

    public void setEnvase(char envase) {
        this.envase = envase;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}

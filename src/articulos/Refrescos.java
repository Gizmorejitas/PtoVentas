package articulos;
public class Refrescos extends Bebida {

    private char nutriscore ='E';
    private Double glucosa;
    
    public Refrescos(String _nombre, double _precio, int _stock, char envase, Integer cantidad, char nutriscore,
            Double glucosa) {
        super(_nombre, _precio, _stock, envase, cantidad);
        this.nutriscore = nutriscore;
        this.glucosa = glucosa;
    }

    public char getNutriscore() {return nutriscore;}
    public void setNutriscore(char nutriscore) {this.nutriscore = nutriscore;}

    public Double getGlucosa() {return glucosa;}
    public void setGlucosa(Double glucosa) {this.glucosa = glucosa;}
    
}

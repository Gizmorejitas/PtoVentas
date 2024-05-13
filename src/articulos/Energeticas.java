package articulos;

public class Energeticas extends Bebida{

    private Double taurina;
    private Double cafeina;
    
    public Energeticas(String _nombre, double _precio, int _stock, char envase, Integer cantidad, Double taurina,
            Double cafeina) {
        super(_nombre, _precio, _stock, envase, cantidad);
        this.taurina = taurina;
        this.cafeina = cafeina;
    }

    public Double getTaurina() {return taurina;}
    public void setTaurina(Double taurina) {this.taurina = taurina;}

    public Double getCafeina() {return cafeina;}
    public void setCafeina(Double cafeina) {this.cafeina = cafeina;}
    
}

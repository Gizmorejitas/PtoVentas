package Tools;
import java.util.Scanner;

public class menu {
    //atributos
    private String[] opciones;
    private int eleccion = 0;
    public String titulo = "";

    //constructor vacio
    public menu (){
        this.eleccion = 0;
        this.titulo = "Menu de opciones";
    }
    //constructor con parametros
    public menu(String[] _opciones){
        this.opciones = _opciones;
        this.eleccion = 0;
        this.titulo = "Menu de opciones";
    }
    //get y set
    public String[] getOpciones(){
        return this.opciones;
    }
    public void setOpciones(String[] _opciones){
        this.opciones = _opciones;
    }
    public int getEleccion(){
        return this.eleccion;
    }
    public void setEleccion(int _eleccion){
        this.eleccion = _eleccion;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String _titulo){
        this.titulo = _titulo;
    }

    //metodo mostrar Menu
    public void mostrarMenu(){
        System.out.println(this.titulo);
        System.out.println("-".repeat(this.titulo.length()) + "\n");
        for(int i = 0; i < opciones.length; i++){
            System.out.println((i+1) + ".- " + opciones[i]);
        }
        System.out.println("0.- Salir" + "\n");
    }
    //metodo elige opcion
    public int eligeOpcion(){
        int opcion = 0;
        Scanner giz = new Scanner(System.in);
        boolean salir = false;
        while(!salir){
            System.out.println("Dime tu eleccion: ");
            opcion = giz.nextInt();
            if(opcion >= 0 && opcion <= opciones.length){
                salir = true;
            } else {
                System.out.println("Opcion incorrecta.");
            }
        }
        this.eleccion = opcion;
        return opcion;
    }


    
}

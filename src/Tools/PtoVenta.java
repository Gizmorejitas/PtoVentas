package Tools;
import java.util.ArrayList;
//import java.util.HashMap;

import Tienda.*;
import articulos.Articulo;

public class PtoVenta {
        public static void main(String[] args) throws Exception {

                DAOMySql miCon = new DAOMySql();
                DAOTienda dt = new DAOTienda();
                // String ruta = "..\\.csv";

                if (miCon != null) {
                        System.out.println("Conexion exitosa.");
                        ArrayList<Tienda> misTiendas = new ArrayList<Tienda>();
                        //HashMap<String, Tienda> miTiendaHash = new HashMap<String, Tienda>();



                        misTiendas = dt.getAllTiendas(miCon.c);
                        //misTiendas = getAllTiendasCSV(ruta);
                        //misTiendas = new ArrayList<>(dt.getAll_TiendasH(miCon.c).values());
                        //miTiendaHash = dt.getAll_TiendasH(miCon.c);
                        //dt.listarTiendaBD(miCon.c);
                        dt.imprimeTiendas(misTiendas);
                        miCon.c.close();
                }
        }

        /**
         * Muestra el nombre y el stock de un articulo
         * @param artnnn Articulo que queremos inspeccionar */
        public static void muestra_articulo(Articulo artnnn) {
                System.out.println(artnnn.getNombre() + " : " + artnnn.getStock());
        }
}

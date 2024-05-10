import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PtoVenta {
        public static void main(String[] args) throws Exception {

                DAOMySql miCon = new DAOMySql();
                String ruta = "..\\tiendas.csv";

                if (miCon != null) {
                        System.out.println("Conexion exitosa.");
                        ArrayList<Tienda> misTiendas = new ArrayList<Tienda>();
                        //misTiendas = getAllTiendas(miCon.c);
                        misTiendas = getAllTiendasCSV(ruta);
                        //listarTiendaBD(miCon.c);
                        imprimeTiendas(misTiendas);
                        miCon.c.close();
                }

                

                /* System.out.println("\n\n\nGestión de Tiendas");
                System.out.println("-----------------------------------");
                Tienda myStore = new Tienda("1WET", "C.\\Francos Rodriguez,1", 6, 4);

                System.out.println("Mi tienda se llama : " + myStore.getNombre());
                System.out.println("Articulos máximos en tienda : " + myStore.getNumArticulos());
                // Otra forma de obtener el número de articulos, así se comprueba si se ha
                // instanciado bien el objeto
                // System.out.println("Articulos en tienda :" + myStore.getArtTienda().length);
                System.out.println("Vendedores máximos en tienda : " + myStore.getNumVendedores());
                System.out.println("-----------------------------------");
                // ----------------- Asignar los vendedores

                // --- Primero crearlos
                // -- Creación mediante constructor por defecto y asignando posteriomente los
                // atributos
                Vendedor vendedor1 = new Vendedor();
                vendedor1.setNombre("Luis");
                vendedor1.setApellidos("García Perez");
                vendedor1.setMatricula(1);
                // -- Utilizando un constructor con parámetros
                Vendedor vendedor2 = new Vendedor("Juan", "Martinez Rodriguez", 2);

                // --- Asignarlos a la tienda

                myStore.Contratar(vendedor1, 0); // Se usa la versión preliminar de este procedimiento
                myStore.Contratar(vendedor2, 1); // es preciso tener cuiado en la elección de la posición

                // --- Creación de artículos mediante constructor parametrizado

                Articulo art001 = new Articulo("CoKe Light", 0.8, 12);
                Articulo art002 = new Articulo("CoKe Zero", 0.8, 24);
                Articulo art003 = new Articulo("CoKe Original", 0.8, 48);
                Articulo art004 = new Articulo("Cherry CoKe", 0.8, 64);

                // --- Asignarlos a la tienda

                myStore.addArticulo(art001, 1);
                myStore.addArticulo(art002, 2);
                myStore.addArticulo(art003, 3);
                myStore.addArticulo(art004, 4);

                // --- Listar los vendedores
                System.out.println("Listado de Vendedores :");
                System.out.println("-----------------------------------");
                myStore.listarVendedores();
                System.out.println("-----------------------------------");
                // --- Listar los artículos disponibles
                System.out.println("Listado de Articulos :");
                System.out.println("-----------------------------------");
                myStore.listarArticulos();
                System.out.println("-----------------------------------");
                // -------------------------- Fragmentos de código para mostrar como se accede a
                // las propiedades
                // -------------------------- de los objetos creados de forma directa
                // -------------------------- También se prueba el método 'vende' de la clase
                // vendedor

                /*
                 * //System.out.println(art004.getNombre()+ " : "+ art004.getStock());
                 * muestra_articulo(art001);
                 * muestra_articulo(art002);
                 * muestra_articulo(art003);
                 * muestra_articulo(art004);
                 * 
                 * // Hacer una venta con el vendedor 1 con 6 unidades de coca cola light
                 * System.out.println("Venta de 6 uds de "+ art001.getNombre());
                 * vendedor1.vende(art001, 6);
                 * System.out.println("Stock de "+ art001.getNombre());
                 * muestra_articulo(art001);
                 * System.out.println("La venta actualizada de :"+ vendedor1.getNombre());
                 * System.out.println("Ventas :"+ vendedor1.getVentas());
                 * // Hacer una venta con el vendedor 1 con 6 unidades de cherry coke
                 * System.out.println("Venta de 5 uds de "+ art004.getNombre());
                 * vendedor1.vende(art004, 5);
                 * System.out.println("Stock de "+ art004.getNombre());
                 * muestra_articulo(art004);
                 * System.out.println("La venta actualizada de :"+ vendedor1.getNombre());
                 * System.out.println("Ventas :"+ vendedor1.getVentas());
                 * 
                 */
                //System.out.println("\n");
        } // main

        /**
         * Muestra el nombre y el stock de un articulo
         * 
         * @param artnnn Articulo que queremos inspeccionar
         */

        public static void muestra_articulo(Articulo artnnn) {
                System.out.println(artnnn.getNombre() + " : " + artnnn.getStock());
        }

        public static void imprimeTiendas(ArrayList<Tienda> _at){
                //listar las tiendas de arraylist que me pasan
                for (Tienda tienda : _at) { //por cada obj tienda del arraylist _at
                     System.out.println(tienda.toString());   
                }
        }

        public static void listarTiendaBD(Connection _c){
                try {
                        Statement stmt = _c.createStatement();
                        String sql1 = "SELECT * FROM tienda";
                        ResultSet rs = stmt.executeQuery(sql1);
                        while (rs.next()) {
                                //nombre, direccion ((max_artticulos, max_vendedores))no
                                String _nombre = rs.getString(1); // se puede hacer con el num de columna
                                String _direccion = rs.getString("direccion"); // tmbn con el nombre de columna
                                //SOLO IMPRIMIR
                                System.out.println(_nombre + ", " + _direccion);
                        }

                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        //IMPLEMENTA UN METODO QUE SE CONECTE A LA BD Y CONSTRUYA UN ARRAY DE REGISTROS TIENDA
        //recupera todas las tiendas que esten en la base de datos, un arrayList con todos los obj tienda
        public static ArrayList<Tienda> getAllTiendas(Connection _c){
                ArrayList<Tienda> at = new ArrayList<Tienda>();
                Statement stmt;
                try {
                        stmt = _c.createStatement();
                        String sql1 = "SELECT * FROM tienda";
                        ResultSet rs = stmt.executeQuery(sql1);
                        while (rs.next()) {
                                
                                String _nombre = rs.getString("nombre");
                                String _direccion = rs.getString("direccion"); 
                                int _maxArticulos = rs.getInt("max_articulos"); 
                                int _maxVendedores = rs.getInt("max_vendedores"); 
                                Tienda t = new Tienda(_nombre, _direccion, _maxArticulos, _maxVendedores);

                                at.add(t);
                        }

                } catch (SQLException e) {
                        e.printStackTrace();
                        at = null;
                }
                return at;
        }

        public static ArrayList<Tienda> getAllTiendasCSV(String ruta){
                File f = new File(ruta);
                ArrayList<Tienda> at = new ArrayList<Tienda>();

                try {
                        BufferedReader bfr = new BufferedReader(new FileReader(f));
                        while (bfr.ready()) {
                                String linea = bfr.readLine();
                                String[] partes = linea.split(",");

                                int articulos = Integer.parseInt(partes[2]);
                                int vendedores = Integer.parseInt(partes[3]);

                                Tienda t = new Tienda(partes[0], partes[1], articulos, vendedores);    
                                
                                at.add(t);
                        }
                } catch (Exception e) {
                        e.getStackTrace();
                }
                return at;
        }

}

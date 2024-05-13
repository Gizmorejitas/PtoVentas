package Tienda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import Tools.DAOMySql;

public class DAOTienda {

    public static Connection c;

    public DAOTienda() {
        try {
            DAOMySql miConn = new DAOMySql();
            c = miConn.c;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void imprimeTiendas(ArrayList<Tienda> _at) {
        // listar las tiendas de arraylist que me pasan
        for (Tienda tienda : _at) { // por cada obj tienda del arraylist _at
            System.out.println(tienda.toString());
        }
    }

    public static void imprimeTiendasH(HashMap<String, Tienda> ht) {
                // listar las tiendas de arraylist que me pasan
                for (Entry<String, Tienda> e : ht.entrySet()) { // por cada obj tienda del arraylist _at
                        System.out.println(e.getValue().toString());
                }
        }

    public void listarTiendaBD(Connection _c) {
        try {
            Statement stmt = _c.createStatement();
            String sql1 = "SELECT * FROM tienda";
            ResultSet rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                // nombre, direccion ((max_artticulos, max_vendedores))no
                String _nombre = rs.getString(1); // se puede hacer con el num de columna
                String _direccion = rs.getString("direccion"); // tmbn con el nombre de columna
                // SOLO IMPRIMIR
                System.out.println(_nombre + ", " + _direccion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // IMPLEMENTA UN METODO QUE SE CONECTE A LA BD Y CONSTRUYA UN ARRAY DE REGISTROS
    // TIENDA
    // recupera todas las tiendas que esten en la base de datos, un arrayList con
    // todos los obj tienda
    public ArrayList<Tienda> getAllTiendas(Connection _c) {
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
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            at = null;
        }
        return at;
    }

    public HashMap<String, Tienda> getAll_TiendasH(Connection _c) {
        HashMap<String, Tienda> hashMapT = new HashMap<String, Tienda>();
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
                hashMapT.put(t.getNombre(), t);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            hashMapT = null;
        }
        return hashMapT;
    }

    public ArrayList<Tienda> getAllTiendasCSV(String ruta) {
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
            bfr.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return at;
    }
}

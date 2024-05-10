import java.sql.*;

public class DAOMySql {
    public static Connection c;

    public DAOMySql()throws Exception{

        String server_ip    =   "10.21.0.57";
        String server_port  =   "3306";
        String database     =   "ptoventa";
        String _usr         =   "root";
        String _pwd         =   "root";
        String dbcs;        

        dbcs = "jdbc:mysql://" + server_ip + ":" + server_port + "/" + database;
        c = DriverManager.getConnection (dbcs,_usr,_pwd);  
            
    } 
}
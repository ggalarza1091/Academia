package service.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaDb {

    Connection cn;
    
    public static final String bd = "conexion";
    
    public ConectaDb() {
        
    }
    
    public Boolean getConecta(){
        Boolean resultado = true;

        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cn=DriverManager.getConnection("jdbc:odbc:"+bd);
        }
        catch(Exception e){
            resultado = false;
        }finally{
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return resultado;
    }
    
    
}

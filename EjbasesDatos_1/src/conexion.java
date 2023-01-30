import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class conexion {
    public conexion(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/estudiantes","root","sQL123server");

            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM PROFESORES");
            while(rs.next()){
                System.out.println( rs.getInt("cedula") + " " + rs.getString("nombre")
                +" PERTENECE AL DEPARTAMENTO DE: " + rs.getString("departamento") );

            }

            conexion.close();
        }catch (Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
        }

    }//constructor



}

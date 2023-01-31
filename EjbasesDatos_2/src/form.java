import com.mysql.cj.jdbc.exceptions.SQLError;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.InputMismatchException;

public class form {
    private JPanel panel1;
    private JTextField txtID;
    private JTextField txtNombre;
    private JTextField txtCelular;
    private JTextField txtCorreo;
    private JTextField txtCarrera;
    private JButton insertarDatosButton;
    private JButton mostrarDatosButton;

    private PreparedStatement ps;
    public form(){



        mostrarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDatos();
            }
        });


        insertarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn;
                try{
                    conn = getConnection();
                    ps = conn.prepareStatement("INSERT INTO estudiante(id, nombre, celular, correo, carrera) VALUES(?,?,?,?,?)" );
                    try{

                        if( !txtID.getText().matches("[0-9]*") ){
                            throw new SQLException("Ingresa bien los datos");
                        }

                        ps.setString(1, txtID.getText());
                        ps.setString(2, txtNombre.getText());
                        ps.setString(3, txtCelular.getText());
                        ps.setString(4, txtCorreo.getText());
                        ps.setString(5, txtCarrera.getText());

                    }catch (SQLException es){
                        System.out.println("Error: " + es + "||||");
                        JOptionPane.showMessageDialog(null,"Ingrese bien los datos");
                    }


                    System.out.println(ps);
                    int res = ps.executeUpdate();

                    if(res > 0){
                        JOptionPane.showMessageDialog(null, "Persona Ingresada en el sistema");
                    }else{
                        JOptionPane.showMessageDialog(null, "Persona No Ingresada en el sistema");
                    }
                    conn.close();
                }catch (HeadlessException | SQLException f){
                    System.out.println(f);
                }

            }
        });
    }//FIN DEL CONSTRUCTOR

    public void mostrarDatos(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/alumnos","root","sQL123server");

            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM estudiante");

            while(rs.next()){
                /*
                System.out.println( rs.getInt("id") + "\n" + rs.getString(2)
                        +"\n"+ rs.getString("celular") +"\n" +
                        rs.getString("correo") + "\n"+
                        rs.getString(5) );
                */
                JOptionPane.showMessageDialog(null, rs.getInt("id") + "\n" + rs.getString(2)
                        +"\n"+ rs.getString("celular") +"\n" +
                        rs.getString("correo") + "\n"+
                        rs.getString(5));
                //cadena += Integer.toString(rs.getInt("cedula")) + " " + rs.getString("nombre") +" " + rs.getString("departamento") + "\n" ;
            }

            conexion.close();
        }catch (Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
        }

    }

    public static Connection getConnection(){
        Connection conn = null;
        String base = "ALUMNOS";
        String url = "jdbc:mysql://localhost:3306/" + base;
        String user = "root";
        String password = "sQL123server";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        }catch (ClassNotFoundException | SQLException ex){
            System.out.printf("Error: " + ex);
        }
        return conn;
    }




    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema");
        frame.setContentPane(new form().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

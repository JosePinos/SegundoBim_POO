import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class Tiendita {
    private JTextField txtNombre;
    private JTextField txtId;
    private JTextField txtDescrip;
    private JTextField txtPrecio;

    private JComboBox cmbCategoria;
    private JPanel Panel1;
    private JButton crearButton;
    private JButton eliminarButton;
    private JButton buscarButton;
    private JButton actualizarButton;

    private PreparedStatement ps;
    private ResultSet rs;



    public Tiendita() {


        //*****************************************************
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn;
                try{
                    conn = getConnection();
                    ps = conn.prepareStatement("INSERT INTO producto(Id, Nombre, Descripcion, Precio, Categoria) VALUES(?,?,?,?,?)" );
                    try{

                        ps.setString(1, txtId.getText());
                        ps.setString(2, txtNombre.getText());
                        ps.setString(3, txtDescrip.getText());
                        ps.setString(4, txtPrecio.getText());
                        int seleccionado1 = cmbCategoria.getSelectedIndex();
                        ps.setString(5,   (String)cmbCategoria.getItemAt(seleccionado1));

                    }catch (SQLException es){
                        System.out.println("Error: " + es + "||||");
                        JOptionPane.showMessageDialog(null,"Ingrese bien los datos");
                    }


                    System.out.println(ps);
                    int res = ps.executeUpdate();

                    if(res > 0){
                        JOptionPane.showMessageDialog(null, "Producto guardado exitosamente");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al guardar el producto");
                    }
                    conn.close();
                }catch (HeadlessException | SQLException f){
                    System.out.println(f);
                }
                limpiarCajas();



            }
        });


        //*****************************************************


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sql = "SELECT * FROM producto where Id ="+txtId.getText();
                Connection conn = getConnection();

                try{
                    ps = conn.prepareStatement(sql);
                    rs = ps.executeQuery();

                    while( rs.next() ){
                        txtId.setText(rs.getString("Id"));
                        txtNombre.setText(rs.getString("Nombre"));
                        txtDescrip.setText(rs.getString("Descripcion"));
                        txtPrecio.setText(rs.getString("Precio"));
                        cmbCategoria.addItem( rs.getString("Categoria") );

                    }


                }catch (SQLException e1){
                    System.out.println("Error1: " + e1);
                }

            }
        });


        //*****************************************************


        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn;
                try{
                    conn = getConnection();
                    ps = conn.prepareStatement("UPDATE producto SET Id = ?, Nombre = ?, Descripcion = ?, Precio = ?, Categoria = ? WHERE Id = " + txtId.getText() );
                    try{

                        ps.setString(1, txtId.getText());
                        ps.setString(2, txtNombre.getText());
                        ps.setString(3, txtDescrip.getText());
                        ps.setString(4, txtPrecio.getText());
                        int seleccionado1 = cmbCategoria.getSelectedIndex();
                        ps.setString(5,   (String)cmbCategoria.getItemAt(seleccionado1));

                    }catch (SQLException es){
                        System.out.println("Error: " + es + "||||");
                        JOptionPane.showMessageDialog(null,"Ingrese bien los datos");
                    }


                    System.out.println(ps);
                    int res = ps.executeUpdate();

                    if(res > 0){
                        JOptionPane.showMessageDialog(null, "Producto modificado exitosamente");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al modificar el producto");
                    }
                    conn.close();
                }catch (HeadlessException | SQLException f){
                    System.out.println(f);
                }
                limpiarCajas();
            }
        });

        //*****************************************************

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn;
                try{
                    conn = getConnection();
                    ps = conn.prepareStatement("DELETE FROM producto WHERE Id = " + txtId.getText() );


                    System.out.println(ps);
                    int res = ps.executeUpdate();

                    if(res >= 0){
                        JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
                    }
                    conn.close();
                }catch (HeadlessException | SQLException f){
                    System.out.println(f);
                }

                limpiarCajas();
            }
        });

        //*****************************************************
    }//FIN DEL CONSTRUCTOR



    //*****************************************************
    public static Connection getConnection(){
        Connection conn = null;
        String base = "Tienda_abarrotes";
        String url = "jdbc:mysql://localhost:3306/" + base;
        String user = "root";
        String password = "sQL123server";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        }catch (ClassNotFoundException | SQLException ex){
            System.out.printf("No se pudo conectar a la base de datos");
        }
        return conn;
    }
    //*****************************************************

    public void limpiarCajas(){
        txtId.setText("");
        txtNombre.setText("");
        txtDescrip.setText("");
        txtPrecio.setText("");
    }





    public static void main(String[] args) {
        JFrame frame = new JFrame("Tiendita");
        frame.setContentPane(new Tiendita().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}//FIN DE LA CLASE

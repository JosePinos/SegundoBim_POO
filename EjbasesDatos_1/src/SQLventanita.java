import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SQLventanita {
    private JPanel panel1;
    public JLabel lblDatos;
    private JButton mostrarDatosButton;

    public SQLventanita()
    {


        mostrarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conexion2 cn = new conexion2();
                lblDatos.setText(cn.mostrarDatos());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BD1");
        frame.setContentPane( new SQLventanita().panel1 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

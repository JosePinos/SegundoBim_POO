import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioBMI {
    private JPanel panel2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton CALCULARButton;
    private JLabel etiquetaRespuesta;

    public EjercicioBMI() {
        CALCULARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double respuesta = Double.parseDouble(textField1.getText()) / (Double.parseDouble(textField2.getText()) * Double.parseDouble(textField2.getText()) );
                JOptionPane.showMessageDialog(null,"Hola");
                etiquetaRespuesta.setText("BMI = " + respuesta);
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI calculator");
        frame.setContentPane(new EjercicioBMI().panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }



}

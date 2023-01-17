import javax.swing.*;

public class ven1 {
    private JButton OKButton;
    private JTextField ingreseSuNombreTextField;
    private JTextField ingreseSuEdadTextField;
    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("VENTANA 1");
        frame.setContentPane(new ven1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

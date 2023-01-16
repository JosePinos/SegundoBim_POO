import javax.swing.JFrame;
public class panelDibujo {
    public static void main(String[] args) {


        Dibujopanel panel = new Dibujopanel();
        JFrame appli = new JFrame();

        appli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appli.add(panel);
        appli.setSize(250,250);
        appli.setVisible(true);

    }
}

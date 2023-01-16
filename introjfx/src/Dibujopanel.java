import java.awt.Graphics;
import javax.swing.JPanel;

public class Dibujopanel extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        int width = getWidth();//anchura
        int height = getHeight();//altura

       // g.drawLine(0,0,width, height);
       // g.drawLine(0,height,width,0);
         g.drawLine(0,20,40,20);
        g.drawLine(20,5,20,60);
        g.drawArc(-10,40,30,30,0,-160);


    }

}

import javax.swing.JOptionPane;
public class dialogo1 {
    public static void main(String[] args) {
        //JOptionPane.showMessageDialog(null, "Bienvenido a GUI con javax.swing");

        /*
        String nombre = JOptionPane.showInputDialog("Ingresa tu nombre: ");
        String mensaje = String.format("Bienvenido %s a la programación en JAVA",nombre);
        JOptionPane.showMessageDialog(null, mensaje);
        */

        boolean esError = true;
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingresa tu peso: "));
        double altura = Double.parseDouble(JOptionPane.showInputDialog("Ingresa tu altura:"));


        double imc = 0;

        try{
            imc = peso/Math.pow(altura,2);

        } catch (Exception e){
            System.out.println("dentro del catch");
            System.out.println("Error: " + e);
        }


        //imc = peso/Math.pow(altura,2);
        System.out.println(imc);
        JOptionPane.showMessageDialog(null, "Su imc es: " + imc);
    }
}

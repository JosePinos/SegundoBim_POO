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

        if(peso < 0.0 || altura <= 0.0 ){
            throw new ArithmeticException("El peso o la altura ingresados son incorrectos");
        }

        double imc = 0;

        try{
            imc = peso/Math.pow(altura,2);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e);
            imc = -54;
            System.out.println("Error: " + e);
        }


        //imc = peso/Math.pow(altura,2);
        JOptionPane.showMessageDialog(null, "Su imc es: " + imc);
    }
}

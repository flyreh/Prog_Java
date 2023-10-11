package ArrayObjects.Array1EQuipo;
import javax.swing.JOptionPane;
public class Class3Team_main {
    public static void main (String[] args){
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de equipos"));
        Class2Team_array OBJECT = new Class2Team_array(cantidad);
        OBJECT.menu();
    }
}

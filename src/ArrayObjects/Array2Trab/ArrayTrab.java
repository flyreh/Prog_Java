package ArrayObjects.Array2Trab;
import javax.swing.JOptionPane;

import Auto.Auto;
public class ArrayTrab {
    ClassTrab[] trabaja;
    public ArrayTrab(int n){
        trabaja = new ClassTrab[n];
    }
    public void Inputs(int m){
        for (int i=0; i<m; i++){
            trabaja[i]=new ClassTrab();
            trabaja[i].setCodigo(JOptionPane.showInputDialog("ingrese el codigo del trabajador "+(i+1)));
            trabaja[i].setNombre(JOptionPane.showInputDialog("ingrese el nombre"));
            trabaja[i].setHorasT( Float.parseFloat(JOptionPane.showInputDialog("ingrese las horas trabajadas ")));
            trabaja[i].setCargo( Integer.parseInt(JOptionPane.showInputDialog("ingrese su ocupacion"+"\n[1]Obrero"+"\n[2]Empleado"+"\n[3]Asesor")));
            trabaja[i].setSueldo(trabaja[i].getCargo()*100*trabaja[i].getHorasT());
        }
    }
    public void Outputs(int p) {
        String[] cargos = {"Obrero", "Empleado", "Asesor"};
        String[] estados = {"codigo", "nombre", "horas trabajadas", "ocupación", "sueldo"};
        for (int i=0; i<p; i++){
            Auto.FormarMensajeDeSalidaPorConsola("REPORTE DE DATOS- Cliente n"+(i+1));
            String[] valor_estados = {trabaja[i].getCodigo(), trabaja[i].getNombre(), String.valueOf(trabaja[i].getHorasT()),
                    String.valueOf(trabaja[i].getCargo()) +" "+cargos[trabaja[i].getCargo()-1], String.valueOf(trabaja[i].getSueldo())};
            for (int k=0; k<5;k++){
                System.out.println(estados[k] +" :"+ valor_estados[k]);
            }
        }
    }
}

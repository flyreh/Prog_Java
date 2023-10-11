package ArrayObjects.Array1EQuipo;
import javax.swing.JOptionPane;
import Auto.Auto;
import Auto.MetAuto;
public class Class2Team_array {
    private Class1Team_met[] Teams;
    private Class1Team_met[] order;
    int tope_iteracion;

    public Class2Team_array(int m) {
        Teams = new Class1Team_met[m];
        order = new Class1Team_met[m];
        tope_iteracion = m;
    }

    public void InputDatos() {
        for (int i = 0; i < tope_iteracion; i++) {
            Teams[i] = new Class1Team_met(); // importante: asignar los atributos a cada objeto del arreglo;
            Teams[i].setClub(JOptionPane.showInputDialog(" Club n°" + (i + 1) + "\nIngrese el nombre del club"));
            Teams[i].setDirec_T(JOptionPane.showInputDialog("Ingresa el nombre del director tecnico"));
            Teams[i].setPresidente(JOptionPane.showInputDialog("Ingresa el nombre del presidente"));
            Teams[i].setEstadio(JOptionPane.showInputDialog("Ingrese el nombre del estadio donde juega el equipo"));
            Teams[i].setPoints(Integer.parseInt(JOptionPane.showInputDialog("Importante!! Puntos obtenidos")));
        }
    }

    public void mostarInputs() {
        String[] estados = {"Nombre del club", "Director tecnico", "Presidente", "Estadio",
                "Puntos obtenidos"};
        for (int i = 0; i < tope_iteracion; i++) {
            String[] valorEstados = {Teams[i].getClub(), Teams[i].getDirec_T(), Teams[i].getPresidente()
                    , Teams[i].getEstadio(), String.valueOf(Teams[i].getPoints())};
            Auto.FormarMensajeDeSalidaPorConsola("DATOS DE LOS EQUIPOS- equipo n°" + (i + 1));
            for (int j = 0; j < 5; j++) {
                System.out.println(estados[j] + " : " + valorEstados[j]);
            }
        }
    }

    public void ordenamiento() {
        order = Teams;
        new Class1Team_met();
        Class1Team_met ObjectAUX;
        for (int i = 0; i < tope_iteracion; i++) {
            for (int j = i + 1; j < tope_iteracion; j++) {
                if (Teams[i].getPoints() > Teams[j].getPoints()) {
                    ObjectAUX = order[i];
                    order[i] = order[j];
                    order[j] = ObjectAUX;
                }
            }
        }
    }

    public void mostrarorder() {
        ordenamiento();
        String[] nombres = {"Nombre del club",
                "Puntos obtenidos"};
        for (int k = 0; k < tope_iteracion; k++) {
            String[] valorEstados = {order[k].getClub(), String.valueOf(order[k].getPoints())};
            Auto.FormarMensajeDeSalidaPorConsola("EQUIPOS ORDENADOS");
            for (int j = 0; j < 2; j++) {
                System.out.println(nombres[j] + " : " + valorEstados[j]);
            }
        }
    }

    public void menu() {
        String[] opciones = {"[1].Ingresar datos", "[2].mostrar equipos", "[3].mostrar equipos ordenados"};
        int opc;
        do {
            opc = MetAuto.pintarMenu(opciones);
            switch (opc){
                case 1 -> InputDatos();
                case 2 -> mostarInputs();
                case 3 -> mostrarorder();
            }
        }while(opc != opciones.length);
    }
}

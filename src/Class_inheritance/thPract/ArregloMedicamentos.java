package Class_inheritance.thPract;
import ArrayObjects.ArrayList_guiaC.ArregloProductos;
import ArrayObjects.ArrayList_guiaC.Producto;
import ArrayObjects.ArrayList_guiaC.ReporteAlmacen;
import Auto.MetAuto;

import java.util.Date;
import java.util.ArrayList;
import javax.print.attribute.standard.JobKOctets;
import javax.swing.JOptionPane;
public class ArregloMedicamentos {
    private ArrayList listaMedicamentos;
    private ReporteAlmacenMed almacen;

    public ArregloMedicamentos() {
        listaMedicamentos = new ArrayList();
        almacen = new ReporteAlmacenMed(listaMedicamentos);
    }
    public void añadirmedicamento(){
        String mensaje;
        String codigo = JOptionPane.showInputDialog("ingrese el codigo del medicameto");
        if(almacen.devolverPosMedicamento(codigo)<0){
            listaMedicamentos.add(RegistrarMedicamento(codigo));
            mensaje  = "El producto ha sido añadido con exito";
        }else{
            mensaje = "El Medicamento ya existe";
        }
        JOptionPane.showMessageDialog(null, mensaje, "Información", 1);
    }
    public Medicamento RegistrarMedicamento(String cod){
        String dato;
        Medicamento MedNuevo = new Medicamento();
        MedNuevo.setCodigo(cod);
        dato = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
        MedNuevo.setNombre(dato);
        int cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del medicamento"));
        MedNuevo.setCantidad(cant);
        double prec = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del medicamento"));
        MedNuevo.setPrecioUnitario(prec);
        return MedNuevo;
    }
    public void menu(){
        int opcion;
        String[] cadena ={"1.- Añadir Producto",
                "2.- Mostrar el almacen de medicinas",
                "3.- Buscar Medicamento",
                "4.- Eliminar Medicamento",
                "5.- Ordenar almacen por nombres",
                "6.- Salir"};
        do{
            System.out.println("MENU DEL ALMACEN");
            opcion = MetAuto.pintarMenu(cadena);
            switch (opcion) {
                case 1 -> añadirmedicamento();
                case 2 -> almacen.imprimirAlmacen();
                case 3 -> almacen.buscarMedicamento();
                case 4 -> almacen.EliminarMedicamento();
                case 5 -> almacen.ordenarPornombre();
                case 6 -> {}
                default -> throw new IllegalStateException("Unexpected value: " + opcion);
            }
        }while(opcion != cadena.length);
    }
    public static void main (String[] args){
        ArregloMedicamentos inicio = new ArregloMedicamentos();
        inicio.menu();
    }

}

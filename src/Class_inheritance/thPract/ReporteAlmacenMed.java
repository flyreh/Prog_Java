package Class_inheritance.thPract;

import ArrayObjects.ArrayList_guiaC.Producto;

import javax.swing.*;
import java.util.ArrayList;

public class ReporteAlmacenMed {
    private ArrayList reporteAlmacen;

    public ReporteAlmacenMed(ArrayList almacen){
        reporteAlmacen = almacen;
    }

    public Medicamento devolverMedicamento (int indice){
        return (Medicamento) reporteAlmacen.get(indice);
    }
    public void ordenarPornombre(){
        int i, j;
        if (reporteAlmacen.size() > 0) {
            for (i = 0; i < reporteAlmacen.size() - 1; i++) {
                for (j = 0; j < reporteAlmacen.size() - 1; j++){
                    Medicamento A = devolverMedicamento(j);
                    Medicamento B = devolverMedicamento(j+1);
                    if (A.getCodigo().compareTo(B.getCodigo()) < 0) {
                        reporteAlmacen.set(j, B);
                        reporteAlmacen.set(j + 1, A);
                    }
                }
            }
            imprimirAlmacen();
        } else {
            String mensaje = "No existen Productos en el Almacen.";
            int tipoDeIcono = JOptionPane.INFORMATION_MESSAGE;
            JOptionPane.showMessageDialog(null,mensaje, "Ordenamiento por Codigo", tipoDeIcono);
        }
    }
    public int devolverPosMedicamento(String name){
        int posicion = -1;
        for (int indice = 0; indice < reporteAlmacen.size() ; indice++){
            Medicamento auxiliar = (Medicamento) reporteAlmacen.get(indice); // iguala auxiliar a cada elemento de la lista "arreglo"
            if(auxiliar != null){
                if(auxiliar.getNombre().equals(name)){
                    return indice;
                } else if (auxiliar.getCodigo().equals(name)) {
                    return indice;
                }
            }
        }
        return  posicion;
    }
    public void buscarMedicamento(){
        String num, mensaje;
        int icono = JOptionPane.WARNING_MESSAGE;
        num = JOptionPane.showInputDialog("ingrese el nombre del producto a buscar");
        if(devolverPosMedicamento(num) >= 0){
            for (Object obj1 : reporteAlmacen){
                Medicamento buscar = (Medicamento) obj1;
                if(buscar.getNombre().equals(num)){
                    mensaje = buscar.toString();
                    JOptionPane.showMessageDialog(null, mensaje, "señal", icono);
                }else{
                    mensaje = "Nombre de producto no encontrado";
                    JOptionPane.showMessageDialog(null, mensaje, "informacion", 1);
                }
            }
        }else{
            mensaje = "el producto no existe en el almacen";
            JOptionPane.showMessageDialog(null, mensaje, "señal", icono);
        }
    }

    public void EliminarMedicamento(){
        String codigoEliminar = JOptionPane.showInputDialog("Ingrese el codigo del producto que desea eliminar");
        if(devolverPosMedicamento(codigoEliminar)>=0){
            reporteAlmacen.remove(devolverPosMedicamento(codigoEliminar));
            JOptionPane.showMessageDialog(null, "Producto eliminado", "INFORMACION", 1);
        }else{
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "INFORMACION", 0);
        }

    }
    public void imprimirAlmacen(){
        String espacio3 = "             ";
        String mensaje ="", cabecera = "", espacionecesario;
        if(reporteAlmacen.size() > 0){
            String salto = "--------------------------------------------------------------------------------------------------------------------\n";
             cabecera ="Nombre"+ espacio3+espacio3+ "Codigo"+espacio3+ "Cantidad"+espacio3+" Precio Unitario"+espacio3+" Monto invertido\n" + salto;
            for(Object obj : reporteAlmacen){
                espacionecesario = "";
                Medicamento prod = (Medicamento) obj;
                int espacio = 35 - prod.getNombre().length();
                for (int i = 0; i< espacio; i++){
                    espacionecesario = espacionecesario + " ";
                }
                mensaje = mensaje + prod.getNombre()+espacionecesario+ prod.getCodigo() + "  "+espacio3 + prod.getCantidad()+ espacio3 +espacio3+ prod.getPrecioUnitario()
                + espacio3 + espacio3+ prod.getPrecioUnitario() * prod.getCantidad()+ "\n" + salto;
            }
        }else{
            mensaje = "No existen Productos en el Almacen.";
        }
        JOptionPane.showMessageDialog(null, cabecera +mensaje , "ALMACEN", 1);

    }

}

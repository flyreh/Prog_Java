package ArrayObjects.ArrayList_guiaC;
import Auto.MetAuto;

import java.util.*;
import javax.swing.JOptionPane;
public  class ReporteAlmacen {
    private ArrayList arregloparalmacen;
    public ReporteAlmacen(ArrayList arreglo_referencia) {
        arregloparalmacen = arreglo_referencia;
    }
    public void menu() {
        int opcion;
        String[] cadena = {"1.- Producto mas costoso", "2.- Productos con cantidades mínimas permitidas",
                "3.- Productos con cantidades igual a 0 (cero)", "4.- Productos con fecha de Vencimiento vencidas",
                "5.- Productos desactivados", "6.- Productos ordenados por Codigo",
                "7.- Productos ordenados por Descripcion", "8.- Productos ordenados por Cantidad",
                "9.- Productos ordenados por Precio", "10.- Salir"};

        do {
            System.out.println("REPORTES DEL ALMACEN");
            opcion = MetAuto.pintarMenu(cadena);
            switch (opcion) {
                case 1 -> hallarProductoMasCostoso();
                case 2 -> {}
                case 3 ->{}
                case 4 -> {}
                case 5 -> ProductosDesactivados();
                case 6 -> ordenarArregloDeProductoPorCodigo();
                case 7 -> ordenarporDescrip();
                case 8 -> ordenarPorCantidad();
                case 9 -> ordenarPorPrecio();
                case 10 -> {}
                default -> throw new IllegalStateException("Unexpected value: " + opcion);
            }
        } while (opcion != cadena.length);
    }
    public Producto devolverProducto(int indice) {
        return (Producto) arregloparalmacen.get(indice);
    }

    public void Produc_cantidadesminimass(){



    }
    
    public void hallarProductoMasCostoso() {
        double maximo;
        int indice, i;
        String mensaje;
        int tipoDeIcono;
        if (arregloparalmacen.size() > 0) {
            maximo = -1;
            indice = 0;
            i = 0;
            //Recorro el arreglo de productos
            //Hacemos un if para saber cual es mayor precio
            //Guardamos el indice donde se encuentra dicho producto
            for (Object obj : arregloparalmacen) {
                Producto prod = (Producto) obj; //prod se iguala a cada objeto que pertenece al arreglo "arregloalmacen"
                if (prod.getPrecio() > maximo) {
                    maximo = prod.getPrecio();
                    indice = i;
                }
                i++;
            }
            //Invocamos al método devolverProducto()
            //se le pasa por parámetro el indice
            //este método nos devuelve un OBJETO Producto
            //al cual le aplicamos su método toString()
            mensaje = devolverProducto(indice).toString(); ///////////////////
        } else {
            mensaje = "No existen Productos en el Almacen.";
        }
        tipoDeIcono = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(null, mensaje,
                "Producto mas costoso", tipoDeIcono);

    }
    //método de la burbuja
    public void ordenarArregloDeProductoPorCodigo() {
        int i, j;
        if (arregloparalmacen.size() > 0) {
            //Inicio de la Burbuja
            for (i = 0; i < arregloparalmacen.size() - 1; i++) {
                for (j = 0; j < arregloparalmacen.size() - 1; j++) {
                    Producto A = (Producto) arregloparalmacen.get(j);
                    Producto B = (Producto) arregloparalmacen.get(j + 1);
                    if (A.getCodigo().compareTo(B.getCodigo()) > 0) {
                        arregloparalmacen.set(j, B);
                        arregloparalmacen.set(j + 1, A);
                    }
                }
            }
            imprimirArregloDeProducto();
        } else {
            String mensaje = "No existen Productos en el Almacen.";
            int tipoDeIcono = JOptionPane.INFORMATION_MESSAGE;
            JOptionPane.showMessageDialog(null,mensaje, "Ordenamiento por Codigo", tipoDeIcono);
        }
    }
    public void ordenarporDescrip(){
        int i, j;
        if (arregloparalmacen.size() > 0) {
            //Inicio de la Burbuja
            for (i = 0; i < arregloparalmacen.size() - 1; i++) {
                for (j = 0; j < arregloparalmacen.size() - 1; j++) {
                    Producto A = (Producto) arregloparalmacen.get(j);
                    Producto B = (Producto) arregloparalmacen.get(j + 1);
                    if (A.getDescripcion().compareTo(B.getDescripcion()) > 0) {
                        arregloparalmacen.set(j, B);
                        arregloparalmacen.set(j + 1, A);
                    }
                }
            }
            imprimirArregloDeProducto();
        } else {
            String mensaje = "No existen Productos en el Almacen.";
            int tipoDeIcono = JOptionPane.INFORMATION_MESSAGE;
            JOptionPane.showMessageDialog(null,mensaje, "Ordenamiento por Codigo", tipoDeIcono);
        }
    }
    public void ordenarPorCantidad(){
        if(arregloparalmacen.size() > 0){
            for(int i = 0; i<arregloparalmacen.size()-1; i++){
                for( int j = 0; j<arregloparalmacen.size()-1 ; j++){
                    Producto A = (Producto)arregloparalmacen.get(j);
                    Producto B = (Producto)arregloparalmacen.get(j+1);
                    if(B.getCantidad()> A.getCantidad()){
                        arregloparalmacen.set(j, B);
                        arregloparalmacen.set(j+1, A);
                    }
                }
            }
            imprimirArregloDeProducto();
        }else{
            String mensaje = "no existen productos en el almacen";
            JOptionPane.showMessageDialog(null, mensaje, "INFORMACION", 1);
        }
    }
    public void ordenarPorPrecio(){
        if(arregloparalmacen.size() > 0){
            for(int i = 0; i<arregloparalmacen.size()-1; i++){
                for( int j = 0; j<arregloparalmacen.size()-1; j++){
                    Producto A = (Producto)arregloparalmacen.get(j);
                    Producto B = (Producto)arregloparalmacen.get(j+1);
                    if(B.getPrecio()> A.getPrecio()){
                        arregloparalmacen.set(j, B);
                        arregloparalmacen.set(j+1, A);
                    }
                }
            }
            imprimirArregloDeProducto();
        }else{
            String mensaje = "no existen productos en el almacen";
            JOptionPane.showMessageDialog(null, mensaje, "INFORMACION", 1);
        }
    }
    public void imprimirArregloDeProducto(){
        if(arregloparalmacen.size() > 0){
            String dato;
            System.out.println("Listado de Productos...");
            System.out.println("***********************");
            //Recorremos el arreglo de productos
            //Obtenemos cada producto
            //Concatenamos sus atributos y lo asignamos ;dato;
            //Imprimimos en una sola linea todos los datos del producto
            for(Object objetoaux : arregloparalmacen){
                Producto prod = (Producto)objetoaux;
                dato = prod.getCodigo() + " " + prod.getDescripcion() + " " +
                        prod.getCantidad() + " " + prod.getPrecio();
                System.out.println(dato);
            }
            System.out.println("***********************");
        }else{
            String mensaje = "No existen Productos en el Almacen.";
            int tipoDeIcono = JOptionPane.INFORMATION_MESSAGE;
            JOptionPane.showMessageDialog(null,
                    mensaje,
                    "!!!!!!!!!",
            tipoDeIcono);

        }
    }
    public void ProductosDesactivados(){
        for(Object desactivado : arregloparalmacen){
            Producto Desactivo = (Producto) desactivado;
            if (!Desactivo.getEstado()) {
                System.out.println(Desactivo);
                System.out.println("----------------------------");
            }
        }
    }

}
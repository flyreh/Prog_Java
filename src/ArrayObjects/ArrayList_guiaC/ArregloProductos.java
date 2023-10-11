package ArrayObjects.ArrayList_guiaC;
import Auto.MetAuto;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArregloProductos {
    private ArrayList arreglo;
    private ReporteAlmacen reporte;
    public ArregloProductos(){
        arreglo = new ArrayList();
        reporte = new ReporteAlmacen(arreglo);
    }

    public int devolverPosicionDelProducto(String codigo){ //en parte verifica si existe el producto
        int posicion = -1;
        for (int indice = 0; indice < arreglo.size() ; indice++){
            Producto auxiliar = (Producto) arreglo.get(indice); // iguala auxiliar a cada elemento de la lista "arreglo"
            if(auxiliar != null){
                if(auxiliar.getCodigo().equals(codigo)){
                    return indice;
                }
            }
        }
        return posicion; // si ninguno coincide retorna -1
    }
    public void buscarProducto(){
        String cod, mensaje;
        int icono = JOptionPane.WARNING_MESSAGE;
        cod = JOptionPane.showInputDialog("ingrese el codigo del producto a buscar");
        if(devolverPosicionDelProducto(cod) >= 0){
                for (Object obj1 : arreglo){
                    Producto buscar = (Producto)obj1;
                    if(buscar.getCodigo().equals(cod)){
                        System.out.println(buscar);
                        mensaje = "Producto encontrado";
                        JOptionPane.showMessageDialog(null, mensaje, "señal", icono);
                    }
                }
        }else{
            mensaje = "el producto no existe en la lista";
            JOptionPane.showMessageDialog(null, mensaje, "señal", icono);
        }
    }
    public void modAtributo (){
        mostrarArregloDeProducto();
        String codAtributo = JOptionPane.showInputDialog("ingresa el codigo del producto para modificar un atributo");
        String mensajeest, mensajegeneral;
        String[] atributos = {"1.Codigo", "2.Descripcion", "3.Cantidad", "4.Precio", "5.Fecha de vencimiento", "6.Estado"};
            if(devolverPosicionDelProducto(codAtributo)>=0){
                Producto objAtributo = (Producto) arreglo.get(devolverPosicionDelProducto(codAtributo));
                int opcion = MetAuto.pintarMenu(atributos);
                switch (opcion){
                    case 1 -> {String newcod = JOptionPane.showInputDialog("Codigo actual:"+ objAtributo.getCodigo()+"\n Ingrese el nuevo valor");
                        objAtributo.setCodigo(newcod);}
                    case 2 -> {String newdescrip = JOptionPane.showInputDialog("Descripción actual :"+ objAtributo.getDescripcion()+"\n Ingrese el nuevo valor");
                        objAtributo.setDescripcion(newdescrip);}
                    case 3 -> {int newcant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad actual :"+ objAtributo.getCantidad()+"\n Ingrese el nuevo valor"));
                        objAtributo.setCantidad(newcant);}
                    case 4 -> {double newprecio = MetAuto.aReal(JOptionPane.showInputDialog("Precio Actual : "+ objAtributo.getPrecio()+"\nIngrese el nuevo valor"));
                        objAtributo.setPrecio(newprecio);}
                    case 5 -> {Date newdate = new Date(JOptionPane.showInputDialog("Fecha actual : "+objAtributo.getFechaV()+"\nIngrese el nuevo valor")) ;
                        objAtributo.setFechaV(newdate);}
                    case 6 -> {if (objAtributo.getEstado()) {
                            mensajeest = "estado actual: " + objAtributo.getEstado() + "\n Cambiado a DESACTIVADO";
                            objAtributo.setEstado(false);
                        } else {
                            mensajeest = "estado actual: " + objAtributo.getEstado() + "\n Cambiado a ACTIVADO";
                            objAtributo.setEstado(true);
                        }
                        JOptionPane.showMessageDialog(null, mensajeest, "cambio de estado", 1);
                    }
                }
                mensajegeneral = "Atributo cambiado con éxito";
                JOptionPane.showMessageDialog(null,mensajegeneral, "Mensaje", 1);
        }else{
                mensajegeneral = "Producto no encontrado";
                JOptionPane.showMessageDialog(null,mensajegeneral, "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
    }
    public void activar_desactivarProduct (boolean z) {
        String codigoActivar = JOptionPane.showInputDialog("Ingresa el codigo del producto");
        Producto objEstado = (Producto) arreglo.get(devolverPosicionDelProducto(codigoActivar));
        if(z){
            if (devolverPosicionDelProducto(codigoActivar) >= 0) {
                if(objEstado.getEstado()){
                    JOptionPane.showMessageDialog(null, "El producto ya está ACTIVADO", "INFORMACION", 0);
                }else{
                    objEstado.setEstado(true);
                    JOptionPane.showMessageDialog(null, "Producto ACTIVADO", "INFORMACION0", 1);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Producto no encontrado", "INFORMACION", 0);}
        }else{
            if(devolverPosicionDelProducto(codigoActivar)>=0){
                if(objEstado.getEstado()){
                    objEstado.setEstado(false); JOptionPane.showMessageDialog(null, "Producto DESACTIVADO", "INFORMACION", 1);
                }else{
                    JOptionPane.showMessageDialog(null, "El producto ya está DESACTIVADO", "INFORMACION", 0);}
            }else{
                JOptionPane.showMessageDialog(null, "Producto no encontrado", "INFORMACION", 0);
            }
        }
    }
    public void Eliminar(){
        String codigoEliminar = JOptionPane.showInputDialog("Ingrese el codigo del producto que desea eliminar");
        if(devolverPosicionDelProducto(codigoEliminar)>=0){
            arreglo.remove(devolverPosicionDelProducto(codigoEliminar));
            JOptionPane.showMessageDialog(null, "Producto borrado", "INFORMACION", 1);
        }else{
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "INFORMACION", 0);
        }
        mostrarArregloDeProducto();
    }
    public Producto registrarProducto(String codigo){
        String dato;
        Producto productonuevo = new Producto();
        productonuevo.setCodigo(codigo);
        dato = MetAuto.ingresarDato("Ingrese la DESCRIPCION del Producto: ");
        productonuevo.setDescripcion(dato);
        dato = MetAuto.ingresarDato("Ingrese la CANTIDAD del Producto: ");
        productonuevo.setCantidad(MetAuto.aEntero(dato));
        dato = MetAuto.ingresarDato("Ingrese el PRECIO del Producto: ");
        productonuevo.setPrecio(MetAuto.aReal(dato));
        dato = MetAuto.ingresarDato("Ingrese la FECHA DE VENCIMIENTO del Producto: ");
        Date fecha = new Date(dato);
        productonuevo.setFechaV(fecha);
        return productonuevo;
    }
    public void añadirProducto(){
        String codigo;
        String mensaje;
        int tipoDeIcono;
        codigo = MetAuto.ingresarDato("Ingrese el CODIGO del Producto: ");
        if(devolverPosicionDelProducto(codigo) < 0){
            arreglo.add(registrarProducto(codigo)); //añade un producto a la lista arreglo (Producto nuevo)
            mensaje = "El Producto ha sido REGISTRADO con éxito.";
            tipoDeIcono = JOptionPane.INFORMATION_MESSAGE;
        }else{
            mensaje = "El código ingresado, YA éxiste.";
            tipoDeIcono = JOptionPane.WARNING_MESSAGE;
        }
        JOptionPane.showMessageDialog(null, mensaje, "Añadir Producto", tipoDeIcono);
    }
    public void mostrarArregloDeProducto(){
        String mensaje;
        int tipoDeIcono;
        if(arreglo.size() > 0){
            for(Object obj : arreglo){ //otra forma de recorrer una lista, sin un indice como el anterior
                Producto prod = (Producto)obj; //asignar cada elemento de la lista a un objeto auxiliar mediante obj
                System.out.print(prod.toString());
            }
            mensaje = "Productos mostrados con éxito.";
        }else{
            mensaje = "No existen Productos en el Almacen.";
        }
        tipoDeIcono = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(null, mensaje, "Mostrar Producto", tipoDeIcono);
    }
    public void menu(){
        int opcion;
        String[] cadena ={"1.- Añadir Producto",
                "2.- Mostrar Productos",
                "3.- Buscar Producto",
                "4.- Modificar datos del Producto",
                "5.- Activar estado del Producto",
                "6.- Desactivar (anular) estado del Producto",
                "7.- Eliminar Producto",
                "8.- Reportes del almacen",
                "9.- Salir"};

        do{
            System.out.println("MENU DEL ALMACEN");
            opcion = MetAuto.pintarMenu(cadena);
            switch (opcion) {
                case 1 -> añadirProducto();
                case 2 -> mostrarArregloDeProducto();
                case 3 -> buscarProducto();
                case 4 -> modAtributo();
                case 5 -> activar_desactivarProduct(true);
                case 6 -> activar_desactivarProduct(false);
                case 7 -> Eliminar();
                case 8 -> reporte.menu();
                case 9 -> {}
                default -> throw new IllegalStateException("Unexpected value: " + opcion);
            }
        }while(opcion != cadena.length);
    }
    public static void main (String[] args){
        ArregloProductos inicio = new ArregloProductos();
        inicio.menu();
    }

}

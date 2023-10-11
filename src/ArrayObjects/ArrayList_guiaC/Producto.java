package ArrayObjects.ArrayList_guiaC;
import java.util.Date;

public class Producto {
    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precio;
    private Date fechaV;
    private boolean estado;

    //constructor
    public Producto() {
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Date getFechaV() {
        return fechaV;
    }
    public void setFechaV(Date fechaV) {
        this.fechaV = fechaV;
    }
    public boolean getEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String estadoProducto(){
        if(estado){
            return  "ACTIVO";
        }else {
            return "DESACTIVO";
        }
    }
    public String toString(){
        String separator = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        buffer.append(separator);
        buffer.append("codigo = ");
        buffer.append(codigo);
        buffer.append(separator);
        buffer.append("descripcion = ");
        buffer.append(descripcion);
        buffer.append(separator);
        buffer.append("cantidad = ");
        buffer.append(cantidad);
        buffer.append(separator);
        buffer.append("precio = ");
        buffer.append(precio);
        buffer.append(separator);
        buffer.append("Fecha de vencimiento = ");
        buffer.append(fechaV);
        buffer.append(separator);
        buffer.append("estado = ");
        buffer.append(estadoProducto());
        buffer.append(separator);

        return buffer.toString();
    }
}

package Class_inheritance.thPract;

public class Medicamento {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    public Medicamento(){
    }

    public String getCodigo() {
        return codigo;
    }
    public String getNombre(){
        return  nombre;
    }
    public int getCantidad(){
        return  cantidad;
    }
    public double getPrecioUnitario(){
        return precioUnitario;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCantidad(int cant){
        this.cantidad = cant;
    }
    public void setPrecioUnitario(double precioU){
        this.precioUnitario = precioU;
    }
    public String toString(){
        String separator = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        buffer.append(separator);
        buffer.append("Codigo = ");
        buffer.append(codigo);
        buffer.append(separator);
        buffer.append("Nombre = ");
        buffer.append(nombre);
        buffer.append(separator);
        buffer.append("Cantidad = ");
        buffer.append(cantidad);
        buffer.append(separator);
        buffer.append("Precio Unitario = ");
        buffer.append(precioUnitario);
        buffer.append(separator);
        buffer.append("Monto invertido = ");
        buffer.append(precioUnitario * cantidad);
        buffer.append(separator);


        return buffer.toString();
    }
}

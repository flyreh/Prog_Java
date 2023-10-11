package Auto;
import javax.swing.JOptionPane;

public class Auto {
    private String placa;
    private double velocidadActual;
    private double  velocidadMinima;
    private double  velocidadMaxima;
    private boolean estado;
    private double gasolinaActual;
    private double aceiteActual;
    public Auto(){
        this.placa = "RD1234";
        this.velocidadActual = 0;
        this.velocidadMaxima = 150;
        this.velocidadMinima = 0;
        this.gasolinaActual = 2000;
        this.aceiteActual = 1500;
        this.estado = false;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getVelocidadActual() {
        return this.velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public double getVelocidadMinima() {
        return this.velocidadMinima;
    }

    public void setVelocidadMinima(double velocidadMinima) {
        this.velocidadMinima = velocidadMinima;
    }

    public double getVelocidadMaxima() {
        return this.velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public void setGasolinaActual (double gasolinaActual){
        this.gasolinaActual = gasolinaActual;
    }
    public double getGasolinaActual(){
        return this.gasolinaActual;
    }
    public void setAceiteActual (double aceiteActual){
        this.aceiteActual = aceiteActual;
    }
    public double getAceiteActual(){
        return this.aceiteActual;
    }

    public String devolverEstadodelAuto(){
        if(getEstado()){
            return "ENCENDIDO";
        }
        return "APAGADO";
    }

    public static void FormarMensajeDeSalidaPorConsola(String mensaje){
        int largo = mensaje.length();
        int i;
        System.out.print("+");
        for (i = 1; i<= largo; i++){
            System.out.print("-");
        }
        String mensaje_sinsalto = mensaje.replaceAll("\\n|\\r\\n", "");
        System.out.println(" +");
        System.out.println("| " + mensaje_sinsalto + " |");
        System.out.print("+");
        for (i = 1; i<= largo; i++){
            System.out.print("-");
        }
        System.out.println(" +");
    }
    public void EncenderAuto(){
        if(getEstado()){
            FormarMensajeDeSalidaPorConsola ("El auto YA ESTABA encendido");
        }else{
            setEstado(true);
            FormarMensajeDeSalidaPorConsola ("El auto HA SIDO encendido cone exito");

        }
    }
    public void ApagarAuto(){
        if(getEstado()){
            setEstado(false);
            FormarMensajeDeSalidaPorConsola ("El auto HA SIDO APAGADO con éxito");
        }else{

            FormarMensajeDeSalidaPorConsola ("El auto ya esta apagado");
        }
    }
    public void AumentarVelocidadAuto(){
        if(getEstado()){
            String dato;
            int cantidad;
            dato= JOptionPane.showInputDialog("Velocidad Actual = " + getVelocidadActual()+ "\n Ingrese la cantidad a aumentar");
            cantidad = Integer.parseInt(dato);
            setVelocidadActual( getVelocidadActual() + cantidad);
            FormarMensajeDeSalidaPorConsola ("Velocidad del auto actual = "+ getVelocidadActual());
        }else{
            FormarMensajeDeSalidaPorConsola ("El auto esta APAGADO");
        }
    }
    public void ReducirVelocidadAuto(){
        if(getEstado()){
            String dato;
            int cantidad;
            dato = JOptionPane.showInputDialog("Velocidad Actual = " + getVelocidadActual()+ "\n Ingrese la cantidad a reducir");
            cantidad = Integer.parseInt(dato);
            setVelocidadActual(getVelocidadActual() - cantidad);
            FormarMensajeDeSalidaPorConsola("Velocidad del auto actual = "+ getVelocidadActual());
        }else{
            FormarMensajeDeSalidaPorConsola("El auto está APAGADO");
        }
    }
    public void AumentarGasolina(){
        if(getEstado()){
            String dato;
            int cantidad;
            dato= JOptionPane.showInputDialog("Gasolina Actual = " + getGasolinaActual()+ "\n Ingrese la cantidad a aumentar de gasolina");
            cantidad = Integer.parseInt(dato);
            setGasolinaActual(getGasolinaActual() + cantidad);
            FormarMensajeDeSalidaPorConsola ("Gasolina del auto actual = "+ getGasolinaActual());
        }else{
            FormarMensajeDeSalidaPorConsola ("El auto esta APAGADO");
        }
    }

    public void AumentarAceite(){
        if(getEstado()){
            String dato;
            int cantidad;
            dato= JOptionPane.showInputDialog("Aceite Actual = " + getAceiteActual()+ "\n Ingrese la cantidad a aumentar de Aceite");
            cantidad = Integer.parseInt(dato);
            setAceiteActual(getAceiteActual() + cantidad);
            FormarMensajeDeSalidaPorConsola ("Aceite del auto actual = "+ getAceiteActual());
        }else FormarMensajeDeSalidaPorConsola("El auto esta APAGADO");
    }
    public void MostrarCondiciones(){
        String dato;
        String[] estados = {"Placa del auto", "Estado del auto", "Velocidad del auto", "Nivel de gasolina", "Nivel de aceite"};
        String[] valor_estados= {getPlaca(), devolverEstadodelAuto(), String.valueOf(getVelocidadActual()), String.valueOf(getGasolinaActual()), String.valueOf(getAceiteActual())};
        for (int i=0; i<5; i++){
            FormarMensajeDeSalidaPorConsola(estados[i]+" : "+valor_estados[i]+"\n");
        }
    }
    public void manejarTableroDeComandosDelAuto(){
        String[] ArregloDeOpciones = {"1. Encender Auto", "2. Aumentar Velocidad",
                "3. Reducir Velocidad",
                "4. Cargar Tanque de gasolina",
                "5. Cargar tanque de aceite",
                "6. Mostrar condiciones del auto",
                "7. Apagar auto",
                "8. Salir"};
        int opcion;
        do{
            System.out.println("****************************");
            System.out.println("Tablero de comandos del auto");
            System.out.println("*****************************");
            opcion = MetAuto.pintarMenu(ArregloDeOpciones);
            switch (opcion) {
                case 1 -> EncenderAuto();
                case 2 -> AumentarVelocidadAuto();
                case 3 -> ReducirVelocidadAuto();
                case 4 -> AumentarGasolina();
                case 5 -> AumentarAceite();
                case 6 -> MostrarCondiciones();
                case 7 -> ApagarAuto();
                case 8 -> {
                }
            }
        }while(opcion != ArregloDeOpciones.length);
    }

}
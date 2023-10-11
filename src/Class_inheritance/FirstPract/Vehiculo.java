package Class_inheritance.FirstPract;
import java.util.Scanner;

class Vehiculo {
    private String marca;
    private String modelo;
    private int año;

    public Vehiculo(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public void arrancar() {
        System.out.println("El vehículo ha arrancado.");
    }

    public void detener() {
        System.out.println("El vehículo se ha detenido.");
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la marca del vehículo:");
        marca = scanner.nextLine();
        System.out.println("Ingrese el modelo del vehículo:");
        modelo = scanner.nextLine();
        System.out.println("Ingrese el año del vehículo:");
        año = scanner.nextInt();
    }

    public String obtenerDetalles() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año;
    }
}

class Coche extends Vehiculo {
    private int puertas;

    public Coche(String marca, String modelo, int año, int puertas) {
        super(marca, modelo, año);
        this.puertas = puertas;
    }

    @Override
    public void ingresarDatos() {
        super.ingresarDatos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de puertas del coche:");
        puertas = scanner.nextInt();
    }

    @Override
    public void arrancar() {
        super.arrancar();
        System.out.println("El coche ha arrancado.");
    }

    public void abrirMaletero() {
        System.out.println("Se ha abierto el maletero del coche.");
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + ", Puertas: " + puertas;
    }
}

class Motocicleta extends Vehiculo {
    private boolean tieneMarchas;

    public Motocicleta(String marca, String modelo, int año, boolean tieneMarchas) {
        super(marca, modelo, año);
        this.tieneMarchas = tieneMarchas;
    }

    @Override
    public void ingresarDatos() {
        super.ingresarDatos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿La motocicleta tiene marchas? (true/false):");
        tieneMarchas = scanner.nextBoolean();
    }

    @Override
    public void arrancar() {
        super.arrancar();
        System.out.println("La motocicleta ha arrancado.");
    }

    public void hacerCaballito() {
        System.out.println("La motocicleta está haciendo un caballito.");
    }

    @Override
    public String obtenerDetalles() {
        String marchas = tieneMarchas ? "Sí" : "No";
        return super.obtenerDetalles() + ", Tiene marchas: " + marchas;
    }
}

 class GestionVehiculos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de coches: ");
        int cantidadCoches = scanner.nextInt();

        Coche[] coches = new Coche[cantidadCoches];
        for (int i = 0; i < cantidadCoches; i++) {
            coches[i] = new Coche("", "", 0, 0);
            System.out.println("\nIngreso de datos para el Coche " + (i + 1) + ":");
            coches[i].ingresarDatos();
        }

        System.out.print("\nIngrese la cantidad de motocicletas: ");
        int cantidadMotocicletas = scanner.nextInt();

        Motocicleta[] motocicletas = new Motocicleta[cantidadMotocicletas];
        for (int i = 0; i < cantidadMotocicletas; i++) {
            motocicletas[i] = new Motocicleta("", "", 0, false);
            System.out.println("\nIngreso de datos para la Motocicleta " + (i + 1) + ":");
            motocicletas[i].ingresarDatos();
        }

        scanner.close();

        System.out.println("\nDetalles de los Coches:");
        for (Coche coche : coches) {
            System.out.println(coche.obtenerDetalles());
        }

        System.out.println("\nDetalles de las Motocicletas:");
        for (Motocicleta motocicleta : motocicletas) {
            System.out.println(motocicleta.obtenerDetalles());
        }
    }
}


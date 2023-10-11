package Auto;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MetAuto {
    public static String LeerDato(){
        String dato;
        try{
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            dato= teclado.readLine();
        }catch (Exception exception){
            System.out.println("Error al momento de leer el dato por consola");
            dato= "";
        }
        return dato;
    }

    public static int aEntero (String cadena){
        int dato;
        try{
            dato= Integer.parseInt(cadena);
        }catch(Exception e){
            System.out.println("Error al conventir un string a entero.");
            dato= 999;
        }
        return dato;
    }

    public static double aReal(String cadena){
        double dato;
        try{
            dato= Integer.parseInt(cadena);
        }catch(Exception e){
            System.out.println("Error al convertir un String a real");
            dato= 999;
        }

        return dato;
    }
    public static String ingresarDato(String mensaje){
        String dato;
        do{
            System.out.println(mensaje);
            dato= LeerDato().trim();
        }while (dato.isEmpty());
        return dato;
    }
    public static String convertirCadenaAminuscula(String sPalabra){
        return sPalabra.toLowerCase();
    }
    public static String convertirCadenaAmayuscula(String sPalabra){
        return sPalabra.toUpperCase();

    }
    public static int pintarMenu(String[] mensaje){
        int opcion;
        do{
            for(String cadena: mensaje){
                System.out.println(cadena);
            }
            System.out.println("ingrese su opcion");
            opcion = aEntero(LeerDato());

        }while(opcion<1 || opcion>mensaje.length);
        return opcion;
    }

}


import java.io.*;
import java.util.*;
/**
 * Clase en donde se cargara la informacion contenida en los archivos
 * y permitira realizar distintos movimientos como seran depositos,
 * retiros y transacciones, añadir cuentas, eliminar cuentas, etc...
 * 
 * @author [Gonzalez Velasco Jesus & Reyes Hernandez Erik Jahaziel] 
 * @version [28 de mayo de 2018]
 */
public class CargaArchivos{
    protected static List <Cuenta> listaC = new ArrayList<Cuenta>();
    protected static List <Persona> listaP = new ArrayList<Persona>();
    private static File cuentas = new File("Libro1.csv");
    private static File personas = new File("ObjPersonas.csv");
    
    /**Metodo cargarCuentas que no recibe ningun parametro.
     * Permitira la lectura del documento que contiene las cuentas y asi mismo las
     * guardara en un ArrayList para su uso dentro del programa
     */
    protected static void cargarCuentas(){
        String[] dateCuentas = new String[0]; 
        int x       = 0; //Variable que permitira contabilizar cuantos objetos pudieron ser cargados
        int contador = 0;//Variable de tipo entera que dara acceso al uso del polimorfismo ya que permitira
                         //dentro del ciclo while crear cuentas de distintos tipos 
        
        try{
            listaC.clear();  //Limpieza al ArrayList para su uso posterior
            
            //Declaracion de un FileReader y un BufferedReader para la lectura del archivo
            //Libros1.csv
            FileReader fr = new FileReader(cuentas);
            BufferedReader p = new BufferedReader(fr);

            String s         = p.readLine();
            
            //While que apoyandose de la variable s, ira creando objetos de tipo Cuenta
            while (s != null){
                x++;
                dateCuentas = s.split(",");
                if(contador == 0){
                    listaC.add(new CuentaNomina(Integer.parseInt(dateCuentas[0]), Float.parseFloat(dateCuentas[1]),
                    Integer.parseInt(dateCuentas[2])));
                } else if(contador == 1){
                    listaC.add(new CuentaAhorro(Integer.parseInt(dateCuentas[0]), Float.parseFloat(dateCuentas[1]),
                    Integer.parseInt(dateCuentas[2])));
                } else if(contador == 2){
                    listaC.add(new CuentaCorriente(Integer.parseInt(dateCuentas[0]), Float.parseFloat(dateCuentas[1]),
                    Integer.parseInt(dateCuentas[2])));
                    contador =0;
                } else if(contador == 3){
                    listaC.add(new CuentaEmpresa(Integer.parseInt(dateCuentas[0]), Float.parseFloat(dateCuentas[1]),
                    Integer.parseInt(dateCuentas[2])));
                    contador = 0;
                }
                s = p.readLine();
            }
        } catch (FileNotFoundException noFile){
            System.out.println("Archivo " + cuentas + " no encontrado");
        } catch (IOException error){
            System.out.println("Error inesperado");
        } finally{
            System.out.println("Cargadas de manera exitosa " + x + " cuentas");
        }
    }

    /**Metodo cargarPersonas() que no recibe ningun parametro, su funcion es leer el documento
     * que contiene la relacion de personas y guardarlo en un ArrayList para su uso posterior
     */
    protected static void cargarPersonas(){
        String [] datePersonas = new String[3];
        int x = 0;
        int contador = 0;
        
        try{
            listaC.clear();
            
            FileReader fr = new FileReader(personas);
            BufferedReader p = new BufferedReader(fr);
            
            String s         = p.readLine();
            
            while (s != null){
                x++;
                datePersonas = s.split(",");
                if(contador == 0){
                    listaP.add(new Persona(Integer.parseInt(datePersonas[0]), datePersonas[1], false));
                } else if(contador == 1){
                    listaP.add(new Empleado(Integer.parseInt(datePersonas[0]), datePersonas[1], false));
                } if(contador == 2){
                    listaP.add(new Moral(Integer.parseInt(datePersonas[0]), datePersonas[1], false));
                } if(contador == 3){
                    listaP.add(new Fisica(Integer.parseInt(datePersonas[0]), datePersonas[1], false));
                    contador = 0;
                }
                s = p.readLine();
            }
        } catch (FileNotFoundException noFile){
            System.out.println("Archivo " + personas + " no se encuentra.");
        } catch (IOException error){
            System.out.println("Error inesperado");
        } finally{
            System.out.println("Cargadas de manera exitosa " + x + " personas");
        }
    }
    
    /**Metodo guardarPersonas que no tiene parametros de entrada, su funcion es guardar en el documento
     * "relacionPersonas.csv" todos los cambios realizados, ya sea por la creacion de una nueva cuenta
     * o la eliminacion de una
     */
    protected static void guardarPersonas(){
        FileWriter lector = null;
        PrintWriter pw = null;
        
        try{
            lector = new FileWriter("ObjPersonas.csv");
            pw = new PrintWriter(lector);

            for (Persona lis: listaP){
                if(lis != null){
                    pw.println(lis.id + "," + lis.nombre + "," + lis.stsDeudor);
                }
            } lector.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
    }
     
    /**Metodo guardarCuentas que no tiene parametros de entrada, su funcion es guardar en el documento
     * "Libro1.csv" todos los cambios realizados, ya que despues de cada retiro, tranzaccion o deposito cambian
     * los valores de los saldos en las cuentas
     */
    protected static void guardarCuentas(){
        FileWriter lector = null;
        PrintWriter pw = null;
        
        try{
            lector = new FileWriter("Libro1.csv");
            pw = new PrintWriter(lector);

            for (Cuenta lis: listaC){
                if(lis != null){
                    pw.println(lis.id + "," + lis.getSaldo() + "," + lis.idPropietario);
                }
                //pw.println(lis.id + "," + lis.getSaldo() + "," + lis.idPropietario);
            } lector.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    /**Metodo transferencia que recibe como parametros el idCuenta1 que es el que hace la transferencia, el idCuenta2 que es
     * la cuenta que recibe la transferencia y una cantidad por la que se hace el movimiento ya mencionado
     */
    protected void transferencia(int idCuenta1, int idcuenta2, float cantidad){
        for(Cuenta lis: listaC){
            if(lis.id == idCuenta1){
                for(Cuenta lis1: listaC){
                    if(lis1.id == idcuenta2){
                    lis.retirar(cantidad);
                    lis1.depositar(cantidad);
                    guardarCuentas();
                    break;
                    }
                }
            }
        }
    }
    
    /**Metodo retiros que recibe como parametros un idCuenta que es de la cuenta que se hace el retiro y una cantidad
     * que es el monto del retiro
     */
    protected void retiros(int idCuenta, float cantidad){
        for(Cuenta lis: listaC){
            if(lis.id == idCuenta){
                lis.retirar(cantidad);
                guardarCuentas();
                break;
            }
        }
    }
    
    /**Metodo depositos que como su nombre lo dice se encarga de realizar un deposito
     * a la cuenta que tenga en mismo identificador como el que se pasa el los parametros
     * y por una cantidad dada de igual manera como parametro
     */
    protected void depositos(int idCuenta, float cantidad){
        for(Cuenta lis: listaC){
            if(lis.id == idCuenta){
                lis.depositar(cantidad);
                guardarCuentas();
                break;
            }
        }
    }
    
    /** Metodo eliminacionDeUnaCuenta que lo primero que haces es pedir el id de la cuenta que va a eliminar
     * como segundo paso elimina la cuenta de arrayList y posteriormente guarda los cambios en el archivo
     * "Libro1.csv"
     */
    protected void eliminacionDeUnaCuenta(int idCuenta){
        int x = 0;
        for(Cuenta lis: listaC){
            if(lis.id == idCuenta){
                listaC.remove(x);
                guardarCuentas();
                break;
            }
            x++;
        }
    }

    /**Metodo newCuentaPersonaExistente del cual su funcion es crearle una cuenta a una persona ya existente
     * pide como parametros el identificador del propietario de la cuenta y un saldo inicial para posteriormente 
     * guardar la informacion de la cuenta en el archivo "Libro1.csv" 
     */
    protected void newCuentaPersonaExistente(int idPropietario, float saldoInicial){
        FileWriter lector = null;
        PrintWriter pw = null;
        
        try{
            lector = new FileWriter("Libro1.csv", true);
            pw = new PrintWriter(lector);
            pw.println(999999 + "," + saldoInicial + "," + idPropietario);
            
            lector.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
    }

    /**Metodo newCuentaPersonaNoExis que se encarga de crear un objeto persona y uno tipo cuenta de los 
     * cuales guarda su informacion en sus archivos correspondientes
     */
    protected void newCuentaPersonaNoExis(String nombre, float saldo){
        FileWriter lector = null;
        FileWriter lector1 = null;
        PrintWriter pw = null;
        PrintWriter pw1 = null;
        
        try{
            lector = new FileWriter("Libro1.csv", true);
            pw = new PrintWriter(lector);
            pw.println(100001 + "," + saldo + "," + 401);
            lector1 = new FileWriter("ObjPersonas.csv", true);
            pw1 = new PrintWriter(lector1);
            pw1.println(401 + "," + nombre + "," + false);
            lector.close();
            lector1.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        } finally{
            cargarCuentas();
            cargarPersonas();
        }
    }
}   

/**
 * Write a description of class NewCuenPersonNoExis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewCuenPersonNoExis
{
    public static void main(String [] args){
        CargaArchivos cA1 = new CargaArchivos();
        cA1.cargarCuentas();
        
        /**En esta prueba se añade una cuenta para la persona : Hernandez Hernandez Rebeca con un saldo inicial de $1000000"
         * estos cambios se añaden a los archivos "Libro1.csv" y "ObjPersonas.csv"
         */
        cA1.newCuentaPersonaNoExis("Hernandez Hernandez Rebeca", 100000);
    }
}

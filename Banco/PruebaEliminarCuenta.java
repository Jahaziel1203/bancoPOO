
/**
 * Write a description of class PruebaEliminarCuenta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PruebaEliminarCuenta
{
    public static void main(String [] args){
        CargaArchivos cA1 = new CargaArchivos();
        cA1.cargarCuentas();
        
        /**En esta prueba se eliminara la cuenta 14101 y por consiguiente al eliminarse esta se guardan los cambios
         * en el archivo "Libro1.csv"
         */
        cA1.eliminacionDeUnaCuenta(14101);
    }
}

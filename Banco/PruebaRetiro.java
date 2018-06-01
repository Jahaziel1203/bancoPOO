
/**
 * Write a description of class PruebaRetiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PruebaRetiro
{
    public static void main(String [] args){
        CargaArchivos cA1 = new CargaArchivos();
        cA1.cargarCuentas();
        
        /**En este retiro en la cuenta existe un saldo inicial de $900 y con la transferencia adquiere un saldo de
         * $0 lo que se puede verificar en el archivo "Libro1.csv"
         */
        cA1.retiros(16270, 900);
    }
}

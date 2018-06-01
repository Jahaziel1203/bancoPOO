
/**
 * Write a description of class PruebaDeposito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PruebaDeposito{
    public static void main(String [] args){
        CargaArchivos cA1 = new CargaArchivos();
        cA1.cargarCuentas();
        
        /**En este deposito en la cuenta existe un saldo inicial de $6 y con la transferencia adquiere un saldo de
         * $506 lo que se puede verificar en el archivo "Libro1.csv"
         */
        cA1.depositos(6787, 500);
    }
}

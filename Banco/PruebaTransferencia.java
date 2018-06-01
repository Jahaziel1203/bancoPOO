
/**
 * Write a description of class Movimientos here.
 * 
 * @author [Gonzalez Velasco Jesus & Reyes Hernandez Erik Jahaziel] 
 * @version [28 de mayo de 2018]
 */
public class PruebaTransferencia{
    
    public static void main(String [] args){
        CargaArchivos cA1 = new CargaArchivos();
        cA1.cargarCuentas();
        
        /**En esta transferencia no existe saldo suficiente en la cuenta emisora por lo tanto
         * no se podra realizar la transferencia
         */
        cA1.transferencia(10314, 11594, 14000);
        
        /**En esta transferencia la cuenta emisora tiene un saldo de $30898.0 y la cuenta repectora un saldo de
         * $1, la transferencia tendra un monto de $30,000 por lo que los nuevos saldos serian $898 y $30001
         * respectivamente
         */ 
        cA1.transferencia(16194, 1, 30000);
    }
}

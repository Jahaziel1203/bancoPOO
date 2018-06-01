
/**
 * Write a description of class PruebaNuevaCuenPersonExis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PruebaNuevaCuenPersonExis
{
    public static void main(String [] args){
        CargaArchivos cA1 = new CargaArchivos();
        cA1.cargarCuentas();
        
        /**En esta prueba se añade una cuenta del usuario con el identificador 1 con un saldo inicial de 10000,
         * guardando estos cambios en el archivo "Libro1.csv"
         */
        cA1.newCuentaPersonaExistente(1, 10000);
    }
}

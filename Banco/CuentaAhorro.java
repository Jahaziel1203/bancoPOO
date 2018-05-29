
/**
 * Write a description of class CuentaAhorro here.
 * 
 * @author [Gonzalez Velasco Jesus & Reyes Hernandez Erik Jahaziel] 
 * @version [28 de mayo de 201]
 */
public class CuentaAhorro extends Cuenta{
    protected final float rentabilidad = 0.02f;

    //Constructor de la clase CuentaAhorro
    protected CuentaAhorro(float saldo, int idPropietario){
        super(saldo, idPropietario);
        
    }
    //Metodo que calculara el saldo de cuenta en base a la rentabilidad 
    //que esta ofrece
    protected void saldoConRentabilidad(){
        saldo = saldo + (saldo * rentabilidad);
    }
}
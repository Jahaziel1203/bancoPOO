/**
 * Write a description of class CuentaCorriente here.
 * 
 * @author [Gonzalez Velasco Jesus & Reyes Hernandez Erik Jahaziel] 
 * @version [28 de mayo de 201]
 */
public class CuentaCorriente extends Cuenta{
    private final float comision = 17.80f;
    //Constructor de la clase CuentaCorriente
    protected CuentaCorriente(float saldo, int idPropietario){
        super(saldo, idPropietario);
    }
    //Método depositar, se reliza un override ya que al ser cuenta corriente genera
    //una comision por cada movimiento que se realiza en la cuenta
    protected void depositar(float cantidad){
        saldo = saldo + (cantidad - comision);
    }
    //Método retirar, que al igual que el método depositar, a la cantidad retirada se
    //le suma la comision por movimiento
    protected void retirar(float cantidad){
        float retiro = cantidad + comision;
        if(saldo - retiro >=0){
            saldo = saldo - retiro;
            System.out.println("Su retiro asciende a: $ " + cantidad + " la comision por moviemiento " + comision);
            System.out.println("Cantidad total retirada " + retiro);
            System.out.println("Su saldo actual es de: $ " + saldo);
        }
        else{
            System.out.println("No cuenta con suficiente saldo para realizar ese retiro");
            System.out.println("Su saldo es de: " + saldo);
        }
    }
}
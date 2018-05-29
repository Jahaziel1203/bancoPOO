
/**
 * Es la clase madre dentro de la rama de las clases de tipo Cuenta
 * 
 * @author [Gonzalez Velasco Jesus & Reyes Hernandez Erik Jahaziel] 
 * @version [28 de mayo de 201]
 */
public abstract class Cuenta{
    protected int id;
    protected static float saldo;
    //private float cantidad;
    
    //Constructor de la clase cuenta
    public Cuenta(float saldo){
        this.saldo = saldo;
    }
    //Método para realizar un deposito a la cuenta
    protected void depositar(float cantidad){
        saldo = saldo + cantidad;
    }
    //Método para realizar un retiro
    protected void retirar(float cantidad){
        if((saldo-cantidad) >=0){
            saldo= saldo-cantidad;
            System.out.println("Su retiro asciende a: $ " + cantidad);
            System.out.println("Su saldo actual es de: $ " + saldo);
        }
        else{
            System.out.println("No cuenta con suficiente saldo para realizar ese retiro");
            System.out.println("Su saldo es de: " + saldo);
        }
    }
    //Metodo para consultar el saldo de la cuenta
    protected float consultarSaldo(){
        return saldo;
    }
}

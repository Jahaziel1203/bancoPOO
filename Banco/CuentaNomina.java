
/**
 * Write a description of class CuentaNomina here.
 * 
 * @author [Gonzalez Velasco Jesus & Reyes Hernandez Erik Jahaziel] 
 * @version [28 de mayo de 201]
 */
public class CuentaNomina extends Cuenta{
    private static float saldo1 = 0; //Variable que llevara la cuenta de los depositos realizados a la cuenta

    //Constructor de la clase CuentaNomina
    protected CuentaNomina(float saldo){
        super(saldo);
    }

    //Metodo depositar 
    protected void depositar(float cantidad){
        saldo1 += cantidad;
        saldo = saldo + cantidad;
        regalo();
    }
    //Metodo que regalo que por cada $15,000 abonados a la cuenta el banco ofrece de regalo
    //la cantidad de $150.00
    private void regalo(){
        if(saldo1 >= 15000){
            saldo += 150;
            saldo1 = saldo - 15000;
        }
    }
}

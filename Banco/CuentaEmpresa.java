/** 
 * @author [Gonzalez Velasco Jesus & Reyes Hernandez Erik Jahaziel] 
 * @version [28 de mayo de 201]
 */
public class CuentaEmpresa extends Cuenta{
    boolean flag = false; //Bandera booleana que verificara que se cumpla la condicion
                          //de una cuenta empresa

    //Constructor de la clase CuentaEmpresa
    protected CuentaEmpresa(int id, float saldo,int idPropietario){
        super(id, saldo, idPropietario);
    }
}
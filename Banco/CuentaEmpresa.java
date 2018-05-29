
/**
 * Write a description of class CuentaEmpresa here.
 * 
 * @author [Gonzalez Velasco Jesus & Reyes Hernandez Erik Jahaziel] 
 * @version [28 de mayo de 201]
 */
public class CuentaEmpresa extends Cuenta{
    boolean flag = false; //Bandera booleana que verificara que se cumpla la condicion
                          //de una cuenta empresa

    //Constructor de la clase CuentaEmpresa
    protected CuentaEmpresa(float saldo,int idPropietario){
        super(saldo, idPropietario);
        condicion();
    }

    //Para tener una cuenta de este tipo es necesario tener un saldo mayor a 200,000 y 
    //menor a 100,000,000 por lo que este metodo verifica que el saldo este entre el
    //rango establecido
    protected String condicion(){
        String mensaje ="";
        if((saldo >= 200000)&&(saldo <= 100000000)){
            flag = true; //Si se cumple la condicion de CuentaEmpresa la bandera pasa a true
        }if(saldo <= 200000){
            mensaje = "No existe el saldo suficiente para ser una cuenta para empresas";
        }else{
            mensaje = "El saldo supera el de una cuenta para empresas";
        }
        return mensaje;
    }
    //Metodo depositar que como parametro requiere de una cantidad depositada
    protected void depositar(float cantidad){
        condicion();
        if(flag = false){ //Si es una cuentaEmprese realiza la operacion
            saldo = saldo + cantidad;
        }else{
            System.out.println("La operacion no se pudo realizar");
        }
    }
    //Metod retirar que recibe como parametro una cantodad a retirar
    protected void retirar(float cantidad){
        condicion();
        if(((saldo-cantidad) >=0) && (flag = true)){ //El if verifica que el saldo sea positivo y que sea una cuenta empresa
            saldo= saldo-cantidad;
            System.out.println("Su retiro asciende a: $ " + cantidad);
            System.out.println("Su saldo actual es de: $ " + saldo);
        }if(flag = false){
            System.out.println("La cuenta no cumple con la condicion para ser una cuenta empresa");
        } else{
            System.out.println("No cuenta con suficiente saldo para realizar ese retiro");
            System.out.println("Su saldo es de: " + saldo);
        }
    }
}

/**
 * @author [Gonzalez Velasco Jesus & Reyes Hernandez Erik Jahaziel] 
 * @version [28 de mayo de 2018]
 */
public class Empleado extends Persona
{
    private String cargo; //Un empleado tendra un cargo

    /** Constructor de la clase Empleado
     * recibe como parametros un identificador, un nombre y un estatus deudor
     */
    public Empleado(int iden, String n,boolean s)
    {
        super(iden,n,s);
    }
    public Empleado(int iden, String n,boolean s,String cargo)
    {
        super(iden, n, s);
        this.cargo=cargo;
    }
}


/**
 * Write a description of class Empleado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Empleado extends Persona
{
    private String cargo;
    public Empleado(String n,String r,int e,boolean s)
    {
        super(n,r,e,s);
    }
    public Empleado(String n,String r,int e,boolean s,String cargo)
    {
        super(n,r,e,s);
        this.cargo=cargo;
    }
}

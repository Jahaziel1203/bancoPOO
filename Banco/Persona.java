
/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persona
{
    protected String nombre,rfc;
    protected int edad;
    static boolean stsDeudor;
    protected Cuenta [] cta;
    public Persona(String n,String r,int e,boolean s)
    {
        nombre=n;
        rfc=r;
        edad=e;
        stsDeudor=s;
    }
    public void contratarCta(){}
    public void cancelarCta(){}
    public boolean setDeudor(){return stsDeudor;}
}

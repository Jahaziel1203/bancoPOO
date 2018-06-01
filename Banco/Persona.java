
/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persona
{
    protected String nombre;
    protected int id;
    static boolean stsDeudor;//donde true=deudor
    Prestamo p;
    public Persona(int iden, String n,boolean s)
    {
        nombre=n;
        id=iden;
        stsDeudor=s;
    }
    public void contratarCta(){}
    public void cancelarCta(){}
    public boolean setDeudor(){return stsDeudor;}
    public String getNombre(){return nombre;}
    //Este es el metodo que estaba en Prestamo y se copio a Persona
    public boolean solicitarPrestamo(boolean s)
    {
        if(s==false)//verificar que la persona no tenga adeudos
        {
            s=true;
        }
        else
        {
            System.out.println("Eres deudor, paga antes para pedir otro prestamo");
        }
        return s;
    }
}

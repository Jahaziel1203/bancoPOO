
/**
 * Write a description of class Prestamo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prestamo
{
    private int monto,plazo;
    float interes,totPagar;
    public Prestamo(int monto,int plazo,float interes,float totPagar,boolean s)
    {
        this.monto=monto;
        this.plazo=plazo;
        this.interes=interes;
        this.totPagar=totPagar;
    }
    public void prestar(int m,int p,float i,float t,boolean s)
    {
        if(s==false)//verificar que la persona no tenga adeudos
        {
            s=true;
            m+=m*i;
        }
        else
        System.out.println("Eres deudor, paga antes para pedir otro prestamo");
    }
}

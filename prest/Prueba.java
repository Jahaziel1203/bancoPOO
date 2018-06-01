
/**
 * Write a description of class Prueba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prueba
{
    public static void main(String [] args)
    {
        //para implementar el prestamo
        Persona p=new Persona(1234,"nombre",false);
        Prestamo pe=new Prestamo(8000,12,1,0,false);
        if(p.solicitarPrestamo(p.setDeudor())==false)
        {
            pe.amortizacion();
            pe.generaAm();
            pe.generaPagare("fecha1","fecha2",p);
            
        }
    }
}

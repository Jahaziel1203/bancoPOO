
/**
 * Write a description of class Prestamo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.Math;
import java.io.*;
public class Prestamo
{
    private int plazo;
    float interes,monto,totPagar;
    
    public Prestamo(float m,int p,float i,float t,boolean s)
    {
        monto=m;
        plazo=p;
        interes=i;
        totPagar=t;
    }
    public boolean prestar(boolean s)
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
    public String[] amortizacion(){
        double r;
        double capital;
        double intereses;
        double saldo = monto;
        String [] linea=new String[plazo+2];
        r = (float)((monto * (interes/100.0)) / (1 - (Math.pow(1 + (interes / 100.0), (plazo * -1)))));
        linea[0]=("Pago Fijo:" +r);
        linea[1]=("Pago" + "    "+"Capital"+"    "+ "Intereses"+"    "+ "Pago total"+"    "+ "Saldo"+"\n");
        for( int m=1; m<=plazo; m++)
        {
            intereses = saldo * interes/100.0;
            capital = (float)(r - intereses);
            saldo -=(float)capital;
            linea[m+1]=( m+"    "+capital+"    "+intereses+"    "+r+"    "+saldo+"\n");
        }
        return linea;
    }
    public void generaAm()
    {
        try
        {
            File archivo = new File("tabla.txt");
            FileWriter escribir = new FileWriter(archivo,true);
            for(String s: amortizacion())
            {
                escribir.write(s);
                escribir.write("\n");
            }
            escribir.close();
        }
        catch(Exception e){System.out.println("Error al escribir");}
    }
    public void generaPagare(String fecha,String fechaHoy,Persona p)
    {
        String a="Vencimiento "+fecha+'\n';
        String b="Intereses: "+interes+"%"+'\n';
        String c="Monto prestado: "+monto+'\n';
        String d="Por este PAGARE, yo "+p.getNombre()+" prometo incondicionalmenten pagar a la orden del banco la cantidad de $ ";
        double r = (monto * (interes/100.0)) / (1 - (Math.pow(1 + (interes / 100.0), (plazo * -1))));
        r=r*plazo;
        String f=r+" El dia "+fecha+".La suma que ampara este titulo causara intereses a razon del "+ interes+"%."+'\n';
        String g=String.format("%20s%15s","Oaxaca de Juarez a",fechaHoy);
        String h="\n";
        String i="          Nombre y firma";
        try
        {
            File archivo = new File("pagare.txt");
            FileWriter escribir = new FileWriter(archivo,true);
            escribir.write(a);
            escribir.write(b);
            escribir.write(c);
            escribir.write(d);
            escribir.write(f);
            escribir.write(g);
            escribir.write(h);
            escribir.write(i);
            escribir.close();
        }
        catch(Exception e){System.out.println("Error al escribir");}
    }
}

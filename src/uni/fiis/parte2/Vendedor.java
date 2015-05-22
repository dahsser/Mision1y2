package uni.fiis.parte2;

/**
 * Created by Diego on 22/05/2015.
 */
public class Vendedor {
    private int numero_ventas;
    private double bono_ventas;


    public Vendedor(int numero_ventas) {
        this.numero_ventas = numero_ventas;
        this.bono_ventas=0;
    }
    public int getNumero_ventas() {
        return numero_ventas;
    }

    public void setNumero_ventas(int numero_ventas) {
        this.numero_ventas = numero_ventas;
    }

    public double getBono_ventas() {
        return bono_ventas;
    }

    public void setBono_ventas(double bono_ventas) {
        this.bono_ventas = bono_ventas;
    }
    public double bonoxNumeroVentas(){
        double bono=0;
        if(numero_ventas>30 && numero_ventas<40){
            bono=20;
        }else{
            if(numero_ventas>=40 && numero_ventas <100){
                bono=50;
            }else{
                if(numero_ventas>=100){
                    bono=100;
                }
            }
        }
        return bono;
    }

}

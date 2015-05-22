package uni.fiis.parte2;

/**
 * Created by Diego on 22/05/2015.
 */
public class Venta {
    private double monto;

    static double IGV=0.19;

    public Venta(double monto) {
        this.monto = monto;
    }
    public double hallarbono(){
        double bono;
        if(monto/(1+IGV)>500 &&monto/(1+IGV)<1000){
            bono=0.03*monto/(1+IGV);
        }else{
            if(monto/(1+IGV)>=1000 && monto/(1+IGV) <1500){
                bono=0.05*monto/(1+IGV);
            }else{
                if(monto/(1+IGV)>=1500){
                    bono=0.07*monto/(1+IGV);
                }else{
                    bono=0;
                }
            }
        }
        return bono;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public static void main(String[] args) {
        int i,numero_de_ventas=1;
        int[] vectorVentas = new int[numero_de_ventas];
        Venta unaVenta=new Venta(0);
        Vendedor juanito=new Vendedor(0);
        for(i=0;i<numero_de_ventas;i++){
            vectorVentas[i]=i*30+900;
        }
        for(i=0;i<numero_de_ventas;i++){
            unaVenta.setMonto(vectorVentas[i]);
            juanito.setBono_ventas(juanito.getBono_ventas()+unaVenta.hallarbono());
            juanito.setNumero_ventas(juanito.getNumero_ventas()+1);
        }
        System.out.printf("Bono Ventas = %f\n", juanito.getBono_ventas());
        System.out.printf("Bono Ventas = %f\n", juanito.bonoxNumeroVentas());
        System.out.printf("Bono Total = %f\n", juanito.getBono_ventas() + juanito.bonoxNumeroVentas());

    }

}

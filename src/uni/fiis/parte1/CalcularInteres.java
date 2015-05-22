package uni.fiis.parte1;

public class CalcularInteres{
    private double prestamo;
    private int periodo;
    private double tasaAnual;
    private double tasaMensual;
    private double saldo;



    public CalcularInteres(double prestamo, int periodo, double tasaAnual) {
        this.prestamo = prestamo;
        this.periodo = periodo;
        this.tasaAnual = tasaAnual;
        this.saldo=prestamo;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(double prestamo) {
        this.prestamo = prestamo;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public double getTasaAnual() {
        return tasaAnual;
    }

    public void setTasaAnual(double tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public double getTasaMensual() {
        return tasaMensual;
    }

    public void setTasaMensual() {
        this.tasaMensual =Math.pow(1+tasaAnual,0.08333)-1 ;
    }
    public double pago_mensual(){
        return (tasaMensual*prestamo)/(1- Math.pow(1+tasaMensual,-periodo));
    }
    public double interes(){
        return (tasaMensual*saldo);
    }
    public double amortizacion(){
        return pago_mensual()-interes();
    }

    public static void main(String[] args) {
        int i;
        CalcularInteres joven= new CalcularInteres(15000,24,0.36);
        joven.setTasaMensual();
        System.out.println("Prestamos a 24 cuotas");
        System.out.println("# de Cuota\t Cuota por mes\tInteres\t    Amortizacion\tSaldo");
        for(i=0;i<24;i++){
            System.out.printf("     %d\t\t\t",i+1);
            System.out.printf("%.2f\t\t",joven.pago_mensual());
            System.out.printf("%.2f\t\t",joven.interes());
            System.out.printf("%.2f\t\t\t",joven.amortizacion());
            joven.setSaldo(joven.getSaldo() - joven.amortizacion());
            System.out.printf("%.2f\n",joven.saldo);

        }
    }
}

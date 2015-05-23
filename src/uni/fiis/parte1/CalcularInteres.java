package uni.fiis.parte1;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.DoubleSummaryStatistics;
/*Librerías para trabajar con archivos excel*/
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
        int i,f;
        String cadena;
        Workbook libro = new HSSFWorkbook();
        Sheet hoja = libro.createSheet("new sheet");
        CalcularInteres joven= new CalcularInteres(15000,24,0.36);
        joven.setTasaMensual();
        System.out.println("Prestamos a 24 cuotas");
        System.out.println("# de Cuota\t Cuota por mes\tInteres\t    Amortizacion\tSaldo");
        for(i=0;i<25;i++){
            Row fila = hoja.createRow(i);

            Cell celda = fila.createCell(1);
            if (i == 0) {
                celda.setCellValue("# de Cuota");
            } else {
                cadena=Integer.toString(i);
                celda.setCellValue(cadena);
            }
            celda = fila.createCell(2);
            if (i == 0) {
                celda.setCellValue("Cuota por mes");
            } else {
                cadena=Double.toString(joven.pago_mensual());
                celda.setCellValue(cadena);
            }
            celda = fila.createCell(3);
            if (i == 0) {
                celda.setCellValue("Interes");
            } else {
                cadena=Double.toString(joven.interes());
                celda.setCellValue(cadena);
            }
            celda = fila.createCell(4);
            if (i == 0) {
                celda.setCellValue("Amortizacion");
            } else {
                cadena=Double.toString(joven.amortizacion());
                celda.setCellValue(cadena);
            }

            celda = fila.createCell(5);
            if (i == 0) {
                celda.setCellValue("Saldo");
            } else {
                joven.setSaldo(joven.getSaldo() - joven.amortizacion());
                celda.setCellValue(joven.saldo);
            }
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("workbook.xls");
            libro.write(fileOut);
            fileOut.close();
        }catch(FileNotFoundException e){
            throw new RuntimeException();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

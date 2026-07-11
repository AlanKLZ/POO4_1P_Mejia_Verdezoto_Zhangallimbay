
import java.util.Date; 

public class Reporte {
    private int totalCompras; 
    private int totalEntradas; 
    private int totalKits; 
    private double montoTotal; 
    private Date fechaReporte; 

    public Reporte(int totalCompras, int totalEntradas, int totalKits, double montoTotal){
        this.totalCompras = totalCompras; 
        this.totalEntradas = totalEntradas; 
        this.totalKits = totalKits; 
        this.montoTotal = montoTotal; 
        this.fechaReporte = new Date(); 
    }

    public int getTotalCompras(){
        return totalCompras; 
    }
    public void setTotalCompras(int totalCompras){
        this.totalCompras=totalCompras; 
    }
    public int getTotalEntradas(){
        return totalEntradas; 
    }
    public void setTotalEntradas(int totalEntradas){
        this.totalEntradas= totalEntradas; 
    }
    public int getTotalKits(){
        return totalKits; 
    }
    public void setTotalKits(int totalKits){
        this.totalKits = totalKits; 
    }

    public double getMontoTotal(){
        return montoTotal; 
    }
    public void setMontoTotal(double montoTotal){
        this.montoTotal = montoTotal; 
    }
    public Date getFechaReporte(){
        return fechaReporte; 
    }

    @Override
    public String toString(){
        return "Resumen de ventas registradas: " + "\nTotal de compras: " + totalCompras +
        "\nCompras por tipo: "+ "\nEntradas: "+ totalEntradas + "\nKits: "+ totalKits + 
        "\nMonto total recaudado: "+ "\n$"+ montoTotal; 
    }

}

import java.util.ArrayList;

public class Reporte {
    private int totalCompras; 
    private int totalEntradas; 
    private int totalKits; 
    private double montoTotal; 
    //private Date fechaReporte; 

    public Reporte(int totalCompras, int totalEntrada, int totalKits, double montoTotal){
        this.totalCompras = totalCompras; 
        this.totalEntradas = totalEntrada; 
        this.totalKits = totalCompras; 
        this.montoTotal = montoTotal; 
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

    @Override
    public String toString(){
        return "Resumen de ventas registradas: " + "\nTotal de compras: " + totalCompras +
        "\nCompras por tipo: "+ "\nEntradas: "+ totalEntradas + "\nKits: "+ totalKits + 
        "\nMonto total recaudado: "+ "\n$"+ montoTotal; 
    }

}

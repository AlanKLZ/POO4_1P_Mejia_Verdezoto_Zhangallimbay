
import java.time.LocalDate; 

public class Reporte {
    private int totalCompras; 
    private int totalEntradas; 
    private int totalKits; 
    private double montoTotal; 
    private LocalDate fechaReporte; 

    public Reporte(int totalCompras, int totalEntradas, int totalKits, double montoTotal){
        this.totalCompras = totalCompras; 
        this.totalEntradas = totalEntradas; 
        this.totalKits = totalKits; 
        this.montoTotal = montoTotal; 
        this.fechaReporte = LocalDate.now(); 
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
    public LocalDate getFechaReporte(){
        return fechaReporte; 
    }

    @Override
    public String toString(){
        return 
        "\nFecha de generación de reporte: "+fechaReporte+ 
        "\nTotal de compras registradas: " + totalCompras +
        "\nTotal de compras de entradas individuales: "+ totalEntradas + 
        "\nTotal de compras de kits: "+ totalKits + 
        "\nMonto total recaudado: $"+ montoTotal; 
    }

}

import java.util.ArrayList;

public class KitCompra {
    private String codigoKit;
    private String nombre;
    private String descripcion;
    private ArrayList<String> codigoPartidos = new ArrayList<>();
    private double precio;
    private int cantidadDisponible;

    public KitCompra(String codigo, String nombre, String descripcion, ArrayList<String> codigoPartidos, double precio, int cantidadDisponible){
        this.codigoKit = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigoPartidos = codigoPartidos;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    //getters
    public String getCodigo() {
        return codigoKit;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public ArrayList<String> getCodigoPartidos() {
        return codigoPartidos;
    }
    public double getPrecio() {
        return precio;
    }
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public boolean validadStock(){
        return cantidadDisponible > 0;
    }

    public void reducirStock(int cantidad){
        if (validadStock() && cantidad <= cantidadDisponible){
            cantidadDisponible -= cantidad;
        }else{
            System.out.println("No hay suficiente stock disponible");
        }
    }
}   

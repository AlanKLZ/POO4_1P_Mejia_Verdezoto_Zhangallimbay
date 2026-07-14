import java.util.ArrayList;

public class KitCompra {
    private String codigoKit;
    private String nombre;
    private String descripcion;
    private ArrayList<String> codigoPartidos = new ArrayList<>();
    private double precio;
    private int cantidadDisponible;
//Constructor 
    public KitCompra(String codigo, String nombre, String descripcion, ArrayList<String> codigoPartidos, double precio, int cantidadDisponible){
        this.codigoKit = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigoPartidos = codigoPartidos;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

//Getters
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

    //Metodo de validarStock 
    public boolean validarStock(int cantidad){
        return cantidad>0 && cantidad <= cantidadDisponible;
    }
    //Metodo de reducirStock 
    public void reducirStock(int cantidad){
        if (validarStock(cantidad)){
            cantidadDisponible -= cantidad;
        }else{
            System.out.println("No hay suficiente stock disponible");
        }
    }
    @Override
    public String toString(){
        return "Kit: "+ nombre+
        "\nCódigo de Kit: "+ codigoKit+
        "\nDescripción: "+ descripcion+
        "\nCódigo de partidos incluidos: "+ codigoPartidos+
        "\nPrecio: $"+ precio; 
    }
}   

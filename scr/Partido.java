import java.time.LocalDate;

public class Partido {
    private String codigo; 
    private String seleccionLocal; 
    private String seleccionVisitante; 
    private LocalDate fecha; 
    private String estadio; 
    private String ciudad; 
    private int capacidad; 
    private int entradasGeneral; 
    private int entradasPreferencial; 
    private int entradasVIP; 
    private double precioGeneral; 
    private double precioPreferencial;
    private double precioVIP;
    private String fase; 
    
    //Constructor 
    public Partido(String codigo, String seleccionLocal, String seleccionVisitante, LocalDate fecha, String estadio,
            String ciudad, int capacidad, int entradasGeneral, int entradasPreferencial, int entradasVIP,
            double precioGeneral, double precioPreferencial, double precioVIP, String fase) {
        this.codigo = codigo;
        this.seleccionLocal = seleccionLocal;
        this.seleccionVisitante = seleccionVisitante;
        this.fecha = fecha;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.entradasGeneral = entradasGeneral;
        this.entradasPreferencial = entradasPreferencial;
        this.entradasVIP = entradasVIP;
        this.precioGeneral = precioGeneral;
        this.precioPreferencial = precioPreferencial;
        this.precioVIP = precioVIP;
        this.fase = fase;
    }
//Getters y setters 
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSeleccionLocal() {
        return seleccionLocal;
    }

    public void setSeleccionLocal(String seleccionLocal) {
        this.seleccionLocal = seleccionLocal;
    }

    public String getSeleccionVisitante() {
        return seleccionVisitante;
    }

    public void setSeleccionVisitante(String seleccionVisitante) {
        this.seleccionVisitante = seleccionVisitante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEntradasGeneral() {
        return entradasGeneral;
    }

    public void setEntradasGeneral(int entradasGeneral) {
        this.entradasGeneral = entradasGeneral;
    }

    public int getEntradasPreferencial() {
        return entradasPreferencial;
    }

    public void setEntradasPreferencial(int entradasPreferencial) {
        this.entradasPreferencial = entradasPreferencial;
    }

    public int getEntradasVIP() {
        return entradasVIP;
    }

    public void setEntradasVIP(int entradasVIP) {
        this.entradasVIP = entradasVIP;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }
    

    public double getPrecioGeneral() {
        return precioGeneral;
    }

    public void setPrecioGeneral(double precioGeneral) {
        this.precioGeneral = precioGeneral;
    }

    public double getPrecioPreferencial() {
        return precioPreferencial;
    }

    public void setPrecioPreferencial(double precioPreferencial) {
        this.precioPreferencial = precioPreferencial;
    }

    public double getPrecioVIP() {
        return precioVIP;
    }

    public void setPrecioVIP(double precioVIP) {
        this.precioVIP = precioVIP;
    }
//Metodo de validarStock 
    public boolean validarStock(Zona zona, int cantidad){
        if (cantidad <= 0){
            return false; 
        }
        switch (zona){
            case GENERAL: 
            return this.entradasGeneral >= cantidad; 
            case PREFERENCIAL: 
            return this.entradasPreferencial >= cantidad; 
            case VIP: 
            return this.entradasVIP >= cantidad; 
            default: 
            return false; 
            }
        }
//Metodo actualizarDisponibilidad 
//Se emplea el break porque el método no devuelve nada 
    public void actualizarDisponibilidad(Zona zona, int cantidad){
        if (!validarStock(zona, cantidad)){
            System.out.println("No hay stock suficiente"); 
        }else{
            switch (zona){
                case GENERAL: 
                this.entradasGeneral -= cantidad; 
                break; 
                case PREFERENCIAL: 
                this.entradasPreferencial -= cantidad; 
                break; 
                case VIP: 
                this.entradasVIP -= cantidad; 
                break; 
            }
        }

    }

//Metodo obtenerPrecioZona
//Se emplea un default porque el método obligatoriamente devuelve algo 
    public double obtenerPrecioZona(Zona zona){
        switch (zona) {
            case GENERAL:
                return this.precioGeneral; 
            case PREFERENCIAL: 
                return this.precioPreferencial; 
            case VIP: 
                return this.precioVIP; 
            default:
                return 0.0; 
        }
    }

    @Override
    public String toString(){
        return "Codigo: " + codigo+ 
                "\nPartido: " + seleccionLocal+ " vs "+ seleccionVisitante+
                "\nFecha: "+ fecha+
                "\nEstadio: "+ estadio+ 
                "\nCiudad: " + ciudad+
                "\nCapacidad: "+ capacidad+ 
                "\nFase: " + fase+
                "\nZonas Disponibles: "+ 
                "\nGENERAL | DISPONIBLES "+ entradasGeneral+ " |Precio: $"+ precioGeneral+
                "\nPREFERENCIAL | DISPONIBLES "+ entradasPreferencial+ " |Precio: $"+ precioPreferencial+
                "\nVIP | DISPONIBLES "+ entradasVIP +" |Precio: $"+precioVIP+
                "\n_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _"; 
    }
    }


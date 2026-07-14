import java.time.LocalDate;

public class Compra {
    public static int contador = 1;
    private String codigo;
    private String codigoReferencia;
    private TipoCompra tipoCompra;
    private LocalDate fechaCompra;
    private int cantidad;
    private double valorPagado;
    private String codigoAficionado;

    //Getters y setters 

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public void setCodigoReferencia(String codigoRef){
        this.codigoReferencia = codigoRef;
    }
    public void setTipoCompra(TipoCompra tipo){
        this.tipoCompra = tipo;
    }
    public void setFechaCompra(LocalDate fecha){
        this.fechaCompra = fecha;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setValorPagado(double valorPag){
        this.valorPagado = valorPag;
    }
    public void setCodigoAficionado(String codigoAficionado){
        this.codigoAficionado = codigoAficionado;
    }
    public String getCodigo(){
        return codigo;
    }
    public String getCodigoReferencia(){
        return codigoReferencia;
    }
    public TipoCompra getTipoCompra(){
        return tipoCompra;
    }
    public LocalDate getFechaCompra(){
        return fechaCompra;
    }
    public int getCantidad(){
        return cantidad;
    }
    public double getValorPagado(){
        return valorPagado;
    }
    public String getCodigoAficionado(){
        return codigoAficionado;
    }
    //Constructor 
    public Compra(TipoCompra tipoCompra, String codigoReferencia,  LocalDate fechaCompra, int cantidad, double valorPagado, String codigoAficionado){
        this.codigo = "C"+ String.format("%03d", contador);
        this.codigoReferencia = codigoReferencia;
        this.tipoCompra = tipoCompra;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.valorPagado = valorPagado;
        this.codigoAficionado = codigoAficionado;
        contador++;
    }

    @Override
    public String toString() {
        return "° Compra:"+
            "\n Código de compra    : " + codigo +
            "\n Código de referencia: " + codigoReferencia +
            "\n Tipo de compra      : " + tipoCompra +
            "\n Fecha de compra     : " + fechaCompra +
            "\n Cantidad            : " + cantidad +
            "\n Valor Pagado        : $" + String.format("%.2f", valorPagado) +
            "\n_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _"; 
    }
}

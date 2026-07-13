import java.time.LocalDate;
import java.util.ArrayList; 

public class Aficionado extends Usuario {

    private String celular;
    private String paisFavorito;

    public Aficionado(String codigoUnico,
                      String cedula,
                      String nombres,
                      String apellidos,
                      String usuario,
                      String contraseña,
                      String correo,
                      String celular,
                      String paisFavorito) {

        super(codigoUnico, cedula, nombres, apellidos,usuario, contraseña, correo,RolUsuario.AFICIONADO);
        this.celular = celular;
        this.paisFavorito = paisFavorito;
    }


    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPaisFavorito() {
        return paisFavorito;
    }

    public void setPaisFavorito(String paisFavorito) {
        this.paisFavorito = paisFavorito;
    }

    public void consultarPartidos(ArrayList <Partido> partidos){
        if (partidos.isEmpty()){
            System.out.println("No hay partidos disponibles"); 
        }else{
            System.out.println("Partidos Encontrados"); 
            for (Partido p : partidos){
                System.out.println(p); 
            }
        }
    }
    public Partido buscarPartido(ArrayList<Partido> partidos,String codigo){
        for (Partido p: partidos){
            if (p.getCodigo().equals(codigo)){
                return p;
            }
        }
        return null;
    }   

    public Compra comprar(Partido p, Zona zona, int cantidad, String numTarjeta){
        if (cantidad <=0){
            System.out.println("La cantidad debe ser mayor que cero");
            return null; 
        }
        
        if (!p.validarStock(zona, cantidad)){
            System.out.println("No hay suficiente stock en la zona seleccionada"); 
            return null; 
        }
        double precioUnitario = p.obtenerPrecioZona(zona); 
        double totalPago = precioUnitario * cantidad; 
        System.out.println("Total a pagar: $"+ totalPago);
        System.out.println("Procesando pago con la tarjeta ingresada..."); 
        System.out.println("Pago exitoso"); 

        Compra compraRealizada = new Compra(TipoCompra.ENTRADA,p.getCodigo(), LocalDate.now(), cantidad, totalPago, this.codigoUnico); 
        p.actualizarDisponibilidad(zona, cantidad);
        return compraRealizada; 
        
    }

    public Compra comprar(KitCompra kit, int cantidad, String numTarjeta){        
        if (kit.validarStock(cantidad)){
            kit.reducirStock(cantidad);
            double precioKit = kit.getPrecio();
            double totalPago = precioKit*cantidad;
            System.out.println("Total a pagar: $"+ totalPago);
            System.out.println("Procesando pago con la tarjeta ingresada..."); 
            System.out.println("Pago exitoso");                
            return new Compra(TipoCompra.KIT, kit.getCodigo(),LocalDate.now(),cantidad,totalPago,this.getCodigoUnico());         
        }
        else {
            System.out.println("No hay suficiente stock disponible");
        }
        return null;

    }


    @Override
    public void consultarEntradas(ArrayList<Compra> compras) {
        boolean encontroCompra= false; 
        for (Compra compra : compras) {
            if (compra.getCodigoAficionado().equals(this.codigoUnico)){
                System.out.println(compra); 
                encontroCompra= true; 
            }      
        }
        if (!encontroCompra){
            System.out.println("No tiene compras registradas"); 
        }
    }

    @Override
    public String toString() {
        return super.toString() + 
                "\nCelular: " + celular +
                "\nPais Favorito: " + paisFavorito; 
    }
}

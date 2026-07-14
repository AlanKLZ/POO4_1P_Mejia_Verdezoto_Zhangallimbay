import java.util.ArrayList;
import java.time.LocalDate; 
import java.util.Scanner;
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

    public Compra comprar(Partido p){
        Scanner sc = new Scanner(System.in);
        Zona zona = null;

    // Pedir una zona válida
        while (zona == null) {
        System.out.println("Seleccione la zona:");
        System.out.println("1. GENERAL");
        System.out.println("2. PREFERENCIAL");
        System.out.println("3. VIP");
        System.out.print("Ingrese una opción: ");

        if (sc.hasNextInt()) {
            int opcionZona = sc.nextInt();
            sc.nextLine();

            switch (opcionZona) {
                case 1:
                    zona = Zona.GENERAL;
                    break;
                case 2:
                    zona = Zona.PREFERENCIAL;
                    break;
                case 3:
                    zona = Zona.VIP;
                    break;
                default:
                    System.out.println("Opción de zona inválida.");
            }
        } else {
            System.out.println("Debe ingresar un número.");
            sc.nextLine();
        }
    }

    int cantidad = 0;

    // Pedir una cantidad válida
    while (cantidad <= 0) {
        System.out.print("Cantidad de entradas: ");

        if (sc.hasNextInt()) {
            cantidad = sc.nextInt();
            sc.nextLine();

            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que cero.");
            }
        } else {
            System.out.println("Debe ingresar un número.");
            sc.nextLine();
        }
    }

    // Validar stock
    if (!p.validarStock(zona, cantidad)) {
        System.out.println("No hay suficiente stock en la zona seleccionada.");
        return null;
    }

    // Pedir tarjeta
    System.out.print("Número de tarjeta: ");
    String numTarjeta = sc.nextLine();

    double precioUnitario = p.obtenerPrecioZona(zona);
    double totalPago = precioUnitario * cantidad;

    System.out.println("Total a pagar: $" + totalPago);
    System.out.println("Procesando pago con la tarjeta ingresada...");
    System.out.println("Pago exitoso");

    Compra compraRealizada = new Compra(
            TipoCompra.ENTRADA,
            p.getCodigo(),
            LocalDate.now(),
            cantidad,
            totalPago,
            this.codigoUnico
    );

    p.actualizarDisponibilidad(zona, cantidad);

    return compraRealizada;
}
    public Compra comprar(KitCompra kit){        
         Scanner sc = new Scanner(System.in);
        int cantidad = 0;

    // Pedir una cantidad válida
        while (cantidad <= 0) {
            System.out.print("Cantidad de kits: ");
            
            if (sc.hasNextInt()) {
                cantidad = sc.nextInt();
                sc.nextLine();
                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser mayor que cero.");
            }
        } else {
            System.out.println("Debe ingresar un número.");
            sc.nextLine();
        }
    }

    // Validar stock
    if (!kit.validarStock(cantidad)) {
        System.out.println("No hay suficiente stock disponible.");
        return null;
    }

    // Pedir tarjeta
    System.out.print("Número de tarjeta: ");
    String numTarjeta = sc.nextLine();

    double precioKit = kit.getPrecio();
    double totalPago = precioKit * cantidad;

    System.out.println("Total a pagar: $" + totalPago);
    System.out.println("Procesando pago con la tarjeta ingresada...");
    System.out.println("Pago exitoso");

    kit.reducirStock(cantidad);

    return new Compra(
            TipoCompra.KIT,
            kit.getCodigo(),
            LocalDate.now(),
            cantidad,
            totalPago,
            this.getCodigoUnico()
    );
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

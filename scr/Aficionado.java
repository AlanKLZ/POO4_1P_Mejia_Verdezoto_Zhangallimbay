import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Aficionado extends Usuario {

    private String celular;
    private String paisFavorito;

    //Constructor 
    public Aficionado(String codigoUnico,
            String cedula,
            String nombres,
            String apellidos,
            String usuario,
            String contraseña,
            String correo,
            String celular,
            String paisFavorito) {

        super(codigoUnico, cedula, nombres, apellidos, usuario, contraseña, correo, RolUsuario.AFICIONADO);
        this.celular = celular;
        this.paisFavorito = paisFavorito;
    }
    //Getters y setters 
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

    //Consultar partidos 
    public void consultarPartidos(ArrayList<Partido> partidos) {
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos disponibles");
        } else {
            System.out.println("Partidos Encontrados");
            for (Partido p : partidos) {
                System.out.println(p);
            }
        }
    }
    //Metodo de comprar entradas 
    public Compra comprar(Partido p,Zona zona) {
        Scanner sc = new Scanner(System.in);

        // Pedir en sistema una zona válida
        //Zona zona = validarZona();
        System.out.println("Elegió: "+zona);
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
            return null;  //Retorna vacio en caso no haya, y vuekve al ciclo en sistema.
        }

        // Pedir tarjeta
        System.out.print("Número de tarjeta: ");
        String numTarjeta = sc.nextLine();//Es referencial, no hay un sistema de dinero en este proyecto.

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
    //Metodo de comprar kit de entradas 

    public Compra comprar(KitCompra kitSeleccionado) {
        Scanner sc = new Scanner(System.in);
        int cantidad = 0;

        // Pedir una cantidad válida
        while (cantidad <= 0) {
            System.out.print("Cantidad de kits que desea comprar: ");

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
        if (!kitSeleccionado.validarStock(cantidad)) {
            System.out.println("No hay suficiente stock disponible.");
            return null;
        }

        // Pedir tarjeta
        System.out.print("Número de tarjeta: ");
        String numTarjeta = sc.nextLine(); //Nuevamente, solo es referencial.

        double precioKit = kitSeleccionado.getPrecio();
        double totalPago = precioKit * cantidad;

        System.out.println("Total a pagar: $" + totalPago);
        System.out.println("Procesando pago con la tarjeta ingresada...");
        System.out.println("Pago exitoso");

        kitSeleccionado.reducirStock(cantidad);

        return new Compra(
                TipoCompra.KIT,
                kitSeleccionado.getCodigo(),
                LocalDate.now(),
                cantidad,
                totalPago,
                this.getCodigoUnico()
        );
    }

    //Metodo de validación de zona 
    public Zona validarZona() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (true) {
            System.out.println("<Seleccione la zona de la compra>");
            System.out.println("1) Zona General");
            System.out.println("2) Zona Preferencial");
            System.out.println("3) Zona Vip");
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                sc.nextLine();
                if (i >= 1 && i <= 3) {
                    switch (i) {
                        case 1:
                            return Zona.GENERAL;
                        case 2:
                            return Zona.PREFERENCIAL;
                        case 3:
                            return Zona.VIP;
            }
                    break;
                } else {
                    System.out.println("\nOpción inválida.\n");
                }
            } else {
                System.out.println("\nError: Debe ingresar in numero.\n");
                sc.nextLine();
            }            
        }
        return null;
    }

    //Metodos para buscar partidos y kits apartir de un String 
    public Partido buscarPartido(ArrayList<Partido> partidos, String codigo) {
        for (Partido p : partidos) {
            if (p.getCodigo().equals(codigo.toUpperCase())) {
                return p;
            }
        }
        return null;
    }

    public KitCompra buscarKitCompra(ArrayList<KitCompra> kits, String codigo) {
        for (KitCompra k : kits) {
            if (k.getCodigo().equals(codigo.toUpperCase())) {
                return k;
            }
        }
        return null;
    }
    //Metodo de consultar entradas 

    @Override
    public void consultarEntradas(ArrayList<Compra> compras) {
        boolean encontroCompra = false;
        for (Compra compra : compras) {
            if (compra.getCodigoAficionado().equals(this.codigoUnico)) {
                System.out.println(compra);
                encontroCompra = true;
            }
        }
        if (!encontroCompra) {
            System.out.println("No tiene compras registradas");
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nCelular: " + celular
                + "\nPais Favorito: " + paisFavorito;
    }
}

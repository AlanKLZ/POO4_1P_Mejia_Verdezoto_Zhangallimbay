import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.Transport; 

public class Sistema {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Partido> partidos;
    private ArrayList<KitCompra> kitsCompra;
    private ArrayList<Compra> compras;
    public static boolean sesionIniciada;
    public static boolean sistemaActivo = true;

    public Sistema() {
        usuarios = new ArrayList<>();
        partidos = new ArrayList<>();
        kitsCompra = new ArrayList<>();
        compras = new ArrayList<>();
    }
    
    public Usuario validadInicioSesion(String usuario, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)) {
                return u;
            }
        }
        return null;
    }
    public void cerrarSesion() {
        sesionIniciada = false;
        String mensaje = "\n Volviendo al inicio de sesion.\n";
        System.out.println(mensaje);
    }

    public void iniciarSesion() {
        System.out.println("\nSistema de Venta y Gestión de Entradas para el Mundial\n");
        System.out.println("=========== INICIO DE SESIÓN ========== ");        
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = sc.nextLine();
        System.out.println("Usuario: " + usuario);
        System.out.println("Contraseña: "+"*".repeat(contraseña.length()));
        Usuario actual = validadInicioSesion(usuario, contraseña);
        if (actual != null)  {
            sesionIniciada = true;
            System.out.println("Usuario autenticado correctamente."); 
            mensajeDeVerificacion(actual);
            selectorMenu(actual);                    
        } 
        else {
            System.out.println("Usuario o contraseña incorrectos.");
        }

    }
    
    public void mensajeDeVerificacion(Usuario usuario){
        Scanner sc = new Scanner(System.in);
        String cierreSistema = "Saliendo del sistema...";
        System.out.println("\nRol detectado: "+ usuario.getRolUsuario()+"\n");

        //Sección para codigo que usa el Aficionado.
        if (usuario instanceof Aficionado){            
            Aficionado aficionado = (Aficionado) usuario;
            System.out.println("Bienvenid@, "+aficionado.getNombres()+" "+aficionado.getApellidos());
            System.out.println("Numero de celular registrado: "+ aficionado.getCelular());
            System.out.println("\n¿Es numero de teléfono es correcto? (S/N)");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("S")){
                System.out.println("\nIdentidad confirmada.");
            }
            else if (respuesta.equalsIgnoreCase("N")){
                System.out.println("\nVerificacion fallida.\nPor motivos de seguridad se cerrará la sesion.");
                System.out.println(cierreSistema);
                sistemaActivo = false;
                               
            }
        }
        //Seccion para el codigo que usa el Organizador.
        else if (usuario instanceof Organizador){
            Organizador organizador = (Organizador) usuario;
            System.out.println("Bienvenid@, "+organizador.getNombres()+" "+organizador.getApellidos());
            System.out.println("Empresa asignada: "+ organizador.getEmpresa());
            System.out.println("\n¿Esta empresa es correcta? (S/N)");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("S")){
                System.out.println("Identidad confirmada.");
            }
            else if (respuesta.equalsIgnoreCase("N")){
                System.out.println("Verificacion fallida.\nPor motivos de seguridad se cerrará la sesion.");
                System.out.println(cierreSistema);
                sistemaActivo = false;
            }
        }
    }
    public void selectorMenu(Usuario u){
        if(sistemaActivo){
            if (u instanceof Aficionado){
                mostrarMenuAficionado(u);
            }
            else if (u instanceof Organizador){
                mostrarMenuOrganizador(u);
            }
            else {
                System.out.println("Usuario no registrado");
            }
        }
    }
    //Metodo que se usara si el usuario es un aficionado
    public void mostrarMenuAficionado(Usuario usuario) {  
        Aficionado aficionado = (Aficionado) usuario;
        Scanner sc = new Scanner(System.in);
        while (sesionIniciada) {
            int opcion = 0;
            while(true){
            System.out.println("===== Menu de Aficionado =====");
            System.out.println("===== 1. CONSULTAR PARTIDOS =====");
            System.out.println("===== 2. COMPRAR ENTRADAS =====");
            System.out.println("===== 3. CONSULTAR KIT COMPRAS =====");
            System.out.println("===== 4. CONSULTAR ENTRADAS =====");
            System.out.println("===== 5. SALIR =====");
            System.out.print("Ingrese una opción: ");

            if (sc.hasNextInt()){
                    opcion = sc.nextInt();
                    sc.nextLine();
                    if(opcion >= 1 && opcion <= 5) {
                        break;
                    } else {
                        System.out.println("\nOpción inválida. Por favor, ingrese un número.\n");
                    }
                }
                else{
                    System.out.println("\nError: Debe ingresar un numero.\n");
                    sc.nextLine();
                }
            }

            switch (opcion) {
                case 1:{
                    //lógica para consultar partidos
                    aficionado.consultarPartidos(partidos);
                    break;
                }
                case 2:{                    
                    // Lógica para comprar entradas
                    System.out.println("Escriba los datos para proceder con el pago:");
                    Partido p = null;
                    while (p == null) {
                        System.out.print("Código de partido: ");
                        String codigo = sc.nextLine();
                        p = aficionado.buscarPartido(partidos, codigo);
                        if (p == null) {
                            System.out.println("Ingrese un código de partido válido.");
                        }
                    }
/*                     Compra compra = aficionado.comprar(p);  Descomentar luego que cambien el metodo comprar en lo de aficionado pls
                    if (compra != null) {
                        compras.add(compra);
                    } */
                    break;
                }
                case 3:{                    
                    // lógica para consultar kitcompras
                    consultarKits(aficionado);
                    break;
                }
                case 4:{                    
                    // lógica para consultar entradas
                    aficionado.consultarEntradas(compras);
                    break;
                }
                case 5:{                    
                    cerrarSesion();
                    break;
                }
            }
        }
    }
    public Zona validarZona(){
        Scanner sc = new Scanner(System.in);
        int i =0;
        while(true){
            System.out.println("<Seleccione la zona de la compra>");
            System.out.println("1) Zona General");
            System.out.println("2) Zona Preferencial");
            System.out.println("3) Zona Vip");
            if (sc.hasNextInt()){
                    i = sc.nextInt();
                    sc.nextLine();
                    if(i >= 1 && i <= 3) {
                        break;
                    } else {
                        System.out.println("\nOpción inválida.\n");
                    }
                }
                else{
                    System.out.println("\nError: Debe ingresar in numero.\n");
                    sc.nextLine();
                }
            switch (i){
                case 1:return Zona.GENERAL;
                case 2:return Zona.PREFERENCIAL;
                case 3:return Zona.VIP;
            }
        }
        return null;
    }
/*     Por como está el toString() va a imprimir los datos y luego
    la info de los enfrentamientos, si quieren lo cambian.Como está cumple su proposito */
    public void consultarKits(Aficionado a){
        for (KitCompra k : kitsCompra){
            k.toString();
            System.out.println("Prtidos incluidos:");
            for (String co: k.getCodigoPartidos()){
                Partido p = a.buscarPartido(partidos,co);
                System.out.println("- "+p.getSeleccionLocal()+" vs "+p.getSeleccionVisitante());
            }
        }

    }
    //Metodo que se usara si el usuario es un organizador
    public void mostrarMenuOrganizador(Usuario u) {  
        Organizador organizador = (Organizador) u;
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (sesionIniciada) {            
            while(true){
            System.out.println("===== Menu de Organizador =====");
            System.out.println("===== 1. CONSULTAR ENTRADAS =====");
            System.out.println("===== 2. GENERAR REPORTE =====");
            System.out.println("===== 3. SALIR =====");
            System.out.print("Ingrese una opción: ");
            if (sc.hasNextInt()){
                    opcion = sc.nextInt();
                    sc.nextLine();
                    if(opcion >= 1 && opcion <= 3) {
                        break;
                    } else {
                        System.out.println("\nOpción inválida. Por favor, ingrese un número.\n");
                    }
                }
                else{
                    System.out.println("\nError: Debe ingresar in numero.\n");
                    sc.nextLine();
                }
            }
            switch (opcion) {
                case 1:{
                    //lógica para consultar entradas
                    organizador.consultarEntradas(compras);
                    break;
                }
                case 2:{                    
                    // lógica para generar reporte
                    organizador.generarReporte(compras);
                    break;
                }
                case 3:{                    
                    cerrarSesion();
                    break;
                }
            }
        }
    }
    //Cargar datos de usuario.
    public void cargarUsuarios() {
        usuarios.clear();
        // ==========================
        // Leer usuarios.txt
        // ==========================
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("scr/texts/usuarios.txt");
        for (int i = 1; i < lineas.size(); i++) {
            String[] datos = lineas.get(i).split("\\|");
            if (datos.length != 8)
                continue;
            if (datos[7].equalsIgnoreCase("A")) {
                usuarios.add(new Aficionado(
                        datos[0], // Codigo
                        datos[1], // Cedula
                        datos[2], // Nombres
                        datos[3], // Apellidos
                        datos[4], // Usuario
                        datos[5], // Contraseña
                        datos[6], // Correo
                        "",       // Celular
                        ""        // PaisFavorito
                ));
            } else if (datos[7].equalsIgnoreCase("O")) {
                usuarios.add(new Organizador(
                        datos[0], // Codigo
                        datos[1], // Cedula
                        datos[2], // Nombres
                        datos[3], // Apellidos
                        datos[4], // Usuario
                        datos[5], // Contraseña
                        datos[6], // Correo
                        RolUsuario.ORGANIZADOR,
                        "",       // Empresa
                        ""        // Cargo
                ));
            }
        }
        // ==========================
        // Leer organizadores.txt
        // ==========================
        lineas = ManejoArchivos.LeeFichero("scr/texts/organizadores.txt");
        for (int i = 1; i < lineas.size(); i++) {
            String[] datos = lineas.get(i).split("\\|");
            if (datos.length != 6)
                continue;
            for (Usuario u : usuarios) {
                if (u instanceof Organizador && u.getCodigoUnico().equals(datos[0])) {
                    Organizador org = (Organizador) u;
                    org.setEmpresa(datos[4]);
                    org.setCargo(datos[5]);
                    break;
                }
            }
        }
        // ==========================
        // Leer aficionados.txt
        // ==========================
        lineas = ManejoArchivos.LeeFichero("scr/texts/aficionados.txt");
        for (int i = 1; i < lineas.size(); i++) {
            String[] datos = lineas.get(i).split("\\|");
            if (datos.length != 6)
                continue;
            for (Usuario u : usuarios) {
                if (u instanceof Aficionado && u.getCodigoUnico().equals(datos[0])) {
                    Aficionado afi = (Aficionado) u;
                    afi.setCelular(datos[4]);
                    afi.setPaisFavorito(datos[5]);
                    break;
                }
            }
        }
    }

    public void cargarPartidos() {
        partidos.clear();

        ArrayList<String> lineas =
                ManejoArchivos.LeeFichero("scr/texts/partidos.txt");

        for (int i = 1; i < lineas.size(); i++) {
            String[] datos = lineas.get(i).split("\\|");

            if (datos.length != 14) {
                continue;
            }

            LocalDate fecha = LocalDate.parse(datos[3]);

            Partido partido = new Partido(
                    datos[0], // Código
                    datos[1], // Local
                    datos[2], // Visitante
                    fecha, // Fecha
                    datos[4], // Estadio
                    datos[5], // Ciudad
                    Integer.parseInt(datos[6]), // Capacidad
                    Integer.parseInt(datos[7]), // General
                    Integer.parseInt(datos[8]), // Preferencial
                    Integer.parseInt(datos[9]), // VIP
                    Double.parseDouble(datos[10]), // Precio General
                    Double.parseDouble(datos[11]), // Precio Preferencial
                    Double.parseDouble(datos[12]),  // Precio VIP
                    datos[13] // Fase
            );

            partidos.add(partido);
        }
    }

    public void cargarKitCompra() {
        kitsCompra.clear();
         
        // Leer kits.txt
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("scr/texts/kits.txt");

        for (int i = 1; i < lineas.size(); i++) {
            String[] datos = lineas.get(i).split("\\|");
            
            if (datos.length != 6){
                continue;
            }
            ArrayList<String> codigoPartidos = new ArrayList<>();
            String[] partidos = datos[3].split(",");
            
            for (String codigo : partidos) {
                codigoPartidos.add(codigo);
            }

        // Crear el objeto KitCompra
            KitCompra kit = new KitCompra(
                datos[0], // Código
                datos[1], // Nombre
                datos[2], // Descripción
                codigoPartidos, // Partidos incluidos
                Double.parseDouble(datos[4]), // Precio
                Integer.parseInt(datos[5]) // Disponibles
        );

        kitsCompra.add(kit);
        }
    }

    //Configuración de envio de correos 
    //Correo y clave de aplicación del sistema
    private final String CORREO_EMISOR = "sistemamundialpoo@gmail.com"; 
    private final String CLAVE_APLICACION = "jiwsjoncstctwlfl"; 

    //Creación de la sesión
    private Session crearSesionCorreo() {
        Properties propiedades = new Properties();

        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.starttls.required", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");

        return Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CORREO_EMISOR, CLAVE_APLICACION);
            }
        });
        }
    //Creación del método de envio de correo 
    private void enviarCorreo(String destinatario,String asunto,String contenido) {
        try {
            Session sesion = crearSesionCorreo();
            MimeMessage mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(CORREO_EMISOR));
            mensaje.setRecipient(Message.RecipientType.TO,new InternetAddress(destinatario));
            mensaje.setSubject(asunto, "UTF-8");
            mensaje.setText(contenido, "UTF-8");
            Transport.send(mensaje);
            System.out.println("Correo enviado exitosamente"); 
        } catch (MessagingException e) {
            System.out.println("No se pudo enviar el correo: "+ e.getMessage());
        }
    }

    //metodos de notificar 
    public void notificar( Aficionado aficionado, Compra compraRealizada, Partido p, Zona zona){
        String asunto= "Compra de entrada realizada"; 
        String contenido= 
        "Estimado/a " + aficionado.getNombres() + " "+ aficionado.getApellidos()+","+
        "\nSu compra ha sido registrada exitosamente con el código "+ compraRealizada.getCodigo()+ " el día "+ compraRealizada.getFechaCompra()+"."+
        "\nPartido: "+ p.getSeleccionLocal() + " vs "+ p.getSeleccionVisitante()+
        "\nCódigo del partido: "+ p.getCodigo()+ 
        "\nZona: "+ zona+
        "\nCantidad: "+ compraRealizada.getCantidad()+
        "\nValor pagado: $"+ compraRealizada.getValorPagado()+
        "\nGracias por adquirir sus entradas para el Mundial. Recuerde conservar el código de compra para futuras consultas."; 

        enviarCorreo(aficionado.getCorreo(), asunto, contenido);
    }
    public void notificar (Aficionado aficionado, Compra compraRealizada, KitCompra kit){
        String asunto= "Compra de kits de entradas realizada"; 
        String contenido= 
        "Estimado/a " + aficionado.getNombres() + " "+ aficionado.getApellidos()+","+
        "\nSu compra ha sido registrada exitosamente con el código "+ compraRealizada.getCodigo()+ " el día "+ compraRealizada.getFechaCompra()+
        "\nEl kit adquirido es el siguiente: " + kit+
        "\nCantidad: "+ compraRealizada.getCantidad()+
        "\nValor pagado: $"+ compraRealizada.getValorPagado()+
        "\nGracias por adquirir su kit de entradas para el mundial. Recuerde conservar el código de compra para futuras consultas"; 
        enviarCorreo(aficionado.getCorreo(), asunto, contenido);
    }
    public void notificar(Organizador organizador, Reporte reporte){
        String asunto= "Reporte de compras registradas"; 
        String contenido= 
        "Estimado/a "+ organizador.getNombres()+ " "+ organizador.getApellidos()+","+ 
        "\nSe ha generado el reporte de compras del sistema."+
        reporte; 
        enviarCorreo(organizador.getCorreo(), asunto, contenido);
    }

}

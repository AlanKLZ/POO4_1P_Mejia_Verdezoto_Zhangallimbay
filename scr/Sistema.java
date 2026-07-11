import java.util.ArrayList;

public class Sistema {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Partido> partidos;
    private ArrayList<KitCompra> kitsCompra;
    private ArrayList<Compra> compras;
    private boolean sesionIniciada;

    public Sistema() {
        usuarios = new ArrayList<>();
        partidos = new ArrayList<>();
        kitsCompra = new ArrayList<>();
        compras = new ArrayList<>();
    }
    
    public boolean validadInicioSesion(String usuario, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public void iniciarSesion(String usuario, String contraseña) {
        //System.out.println("===== INICIO DE SESIÓN ===== ");
        System.out.println("Usuario: " + usuario);
        System.out.println("*".repeat(contraseña.length()));
        if (validadInicioSesion(usuario, contraseña)) {
            sesionIniciada = true;
            System.out.println("Usuario autenticado correctamente.");
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }

    }
    //Metodo que se usara si el usuario es un aficionado
    public void mostrarMenu(int opcion) {  //El parametro puede variar mas tarde si sobrecargamos el metodo
        while (sesionIniciada) {
            //Pendiente de implementar un scanner para leer la opción del usuario
            System.out.println("===== 1. CONSULTAR PARTIDOS =====");
            System.out.println("===== 2. COMPRAR ENTRADAS =====");
            System.out.println("===== 3. CONSULTAR KIT COMPRAS =====");
            System.out.println("===== 4. CONSULTAR ENTRADAS =====");
            System.out.println("===== 5. SALIR =====");            
            switch (opcion) {
                case 1:{
                    //lógica para consultar entradas
                    break;
                }
                case 2:{                    
                    // lógica para comprar entradas
                    break;
                }
                case 3:{                    
                    // lógica para consultar kitcompras
                }
                case 4:{                    
                    // lógica para consultar entradas
                    break;
                }
                case 5:{                    
                    sesionIniciada = false;
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
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("usuarios.txt");
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
        lineas = ManejoArchivos.LeeFichero("organizadores.txt");
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
        lineas = ManejoArchivos.LeeFichero("aficionados.txt");
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
}


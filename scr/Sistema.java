import java.util.ArrayList;
public class Sistema {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Partido> partidos;
    private ArrayList<KitCompra> kitsCompra;
    private ArrayList<Compra> compras;

    public Sistema() {
        usuarios = new ArrayList<>();
        partidos = new ArrayList<>();
        kitsCompra = new ArrayList<>();
        compras = new ArrayList<>();
    }

    public boolean validadIniciarSesion(String usuario, String contraseña){
        for (Usuario u : usuarios) {
            if (u.getusuario().equals(usuario) && u.getcontraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    
}

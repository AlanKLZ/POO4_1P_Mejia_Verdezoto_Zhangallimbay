import java.util.Scanner;
public class SistemaTest {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner sc = new Scanner(System.in);
        sistema.cargarUsuarios();
        while (!Sistema.sesionIniciada){
            sistema.iniciarSesion();
            //ejemplo aficionado: cmendoza / mundial2026
            //ejemplo organizador lpereza / admin2026
        }
    }
}

import java.util.Scanner;
public class SistemaTest {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner sc = new Scanner(System.in);
        sistema.cargarUsuarios();
        System.out.println("=======INICIAR SESION=======");
        System.out.println("Ingrese su usuario y contraseña para iniciar sesión");
        String usuario = sc.nextLine();
        String contraseña = sc.nextLine();
        sistema.iniciarSesion(); //funciona ej: cmendoza / mundial2026
    }
}

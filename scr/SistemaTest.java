import java.util.Scanner;
public class SistemaTest {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner sc = new Scanner(System.in);
        sistema.cargarUsuarios();
        sistema.cargarPartidos();
        sistema.cargarKitCompra();
        ManejoArchivos.EscribirArchivo("scr/texts/compras.txt", "CódigoCompra|CódigoReferencia|Tipo|FechaCompra|Cantidad|ValorPagado|CódigoAficionado");

        while (Sistema.sistemaActivo){
            sistema.iniciarSesion();
            //ejemplo aficionado: cmendoza / mundial2026
            //ejemplo organizador lpereza / admin2026
            //ejemplo para probar correo alazhang / POO4_1P
        }
    }
}

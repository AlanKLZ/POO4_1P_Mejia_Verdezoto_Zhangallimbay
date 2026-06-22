import java.util.ArrayList;

public class Aficionado extends Usuario {

    private String celular;
    private String paisFavorito;
}
public Aficionado(){
  super();
}

public Aficioando(
  String codigoUnico,
            String cedula,
            String nombres,
            String apellidos,
            String usuario,
            String contrasena,
            String correo,
            RolUsuario rol,
            String celular,
            String paisFavorito) {

        super(
                codigoUnico,
                cedula,
                nombres,
                apellidos,
                usuario,
                contrasena,
                correo,
                rol
        );
        
        this.celular = celular;
        this.paisFavorito = paisFavorito;

}

  



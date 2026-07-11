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



  

    @Override
    public void consultarEntradas(ArrayList<Compra> compras) {

        

        for (Compra compra : compras) {

            if (compra.getCodigoAficionado()
                    .equals(getCodigoUnico())) {

                System.out.println(compra);
            }
        }
    }

    @Override
    public String toString() {
        return "Aficionado{" +
                "celular='" + celular + '\'' +
                ", paisFavorito='" + paisFavorito + '\'' +
                '}';
    }
}

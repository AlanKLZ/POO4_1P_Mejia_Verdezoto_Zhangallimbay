import java.util.ArrayList;

abstract class Usuario{
    protected String codigoUnico;
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String contraseña;
    protected String correo;
    protected RolUsuario rol;

    public String getcodigoUnico(){
        return codigoUnico;
    }
    public String getcedula(){
        return cedula;
    }
    public String getnombres(){
        return nombres;
    }
    public String getapellidos(){
        return apellidos;
    }
    public String getusuario(){
        return usuario;
    }
    public String getcontraseña(){
        return contraseña;
    }
    public String getcorreo(){
        return correo;
    }
    public RolUsuario getrolUsuario(){
        return rol;
    }

    public void setCodigoUnico(String cod){
        this.codigoUnico = cod;
    }
    public void setnombres(String nombres){
        this.nombres = nombres;
    }
    public void setcedula(String cedula){
        this.cedula = cedula;
    }
    public void setapellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public void setusuario(String usuario){
        this.usuario = usuario;
    }
    public void setcontraseña(String contraseña){
        this.contraseña = contraseña;
    }
    public void setcorreo(String correo){
        this.correo = correo;
    }
    public void setRol(RolUsuario rol){
        this.rol = rol;
    }

    public Usuario(String codigoUnico,String cedula,String nombres, String apellidos,String usuario,String contraseña,String correo,RolUsuario rol){
        this.codigoUnico = codigoUnico;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
        this.rol = rol;
    }
    public abstract void consultarEntradas(ArrayList<Compra> compras);
    
    @Override
    public String toString(){
        return "Usuario";
    }
}


import java.util.ArrayList;

public abstract class Usuario{
    protected String codigoUnico;
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String contraseña;
    protected String correo;
    protected RolUsuario rol;

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

    public String getCodigoUnico(){
        return codigoUnico;
    }
    public String getCedula(){
        return cedula;
    }
    public String getNombres(){
        return nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getContraseña(){
        return contraseña;
    }
    public String getCorreo(){
        return correo;
    }
    public RolUsuario getRolUsuario(){
        return rol;
    }

    public void setCodigoUnico(String cod){
        this.codigoUnico = cod;
    }
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    public void setCedula(String cedula){
        this.cedula = cedula;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public void setRolUsuario(RolUsuario rol){
        this.rol = rol;
    }

    public abstract void consultarEntradas(ArrayList<Compra> compras);
    
    @Override
    public String toString(){
        return "Codigo unico: " +codigoUnico +
                "\nCedula: " + cedula +
                "\nNombres: "+ nombres+
                "\nApellidos: "+ apellidos+
                "\nUsuario: "+ usuario+
                "\nContraseña: "+ contraseña+
                "\nCorreo: "+ correo+ 
                "\nRol: "+ rol; 

    }
}


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
    public RolUsuario getrolUsuario(){
        return rol;
    }

    public void setCodigoUnico(String cod){
        this.codigoUnico = cod;
    }
    public void setnombres(String nombres){
        this.nombres = nombres;
    }

}


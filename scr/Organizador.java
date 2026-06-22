import java.util.ArrayList; 

public class Organizador extends Usuario{
    private String empresa; 
    private String cargo; 

    //constructor
    public Organizador(String codigoUnico,String cedula,String nombres, String apellidos,String usuario,String contraseña,String correo,RolUsuario rol, String empresa, String cargo){
        super(codigoUnico, cedula, nombres, apellidos, usuario, contraseña, correo, rol); 
        this.empresa = empresa; 
        this.cargo = cargo; 
    }
    //Getters y setters 

    public String getEmpresa(){
        return empresa; 
    }
    public void setEmpresa(String empresa){
        this.empresa = empresa; 
    }

    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargo){
        this.cargo = cargo; 
    }

    //consultar entradas 
    @Override 
    public void consultarEntradas(ArrayList <Compra> compras){
        System.out.println("Entradas registradas en el sistema"); 
        for(Compra c : compras){
            
        }
    }


}

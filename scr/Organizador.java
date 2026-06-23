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
        if (compras.isEmpty()){
            System.out.println("No hay compras registradas en el sistema"); 
        }else{
            System.out.println("Entradas registradas en el sistema"); 
            for(Compra c : compras){
                System.out.println(c.toString()); 
            } 
        }
    }
    //generar reporte de ventas 
    public void generarReporte(ArrayList<Compra> compras){
        int totalCompras = compras.size(); 
        int totalEntradas = 0; 
        int totalKits = 0; 
        double montoTotal = 0; 
        for (Compra c: compras){
            if(c.getTipoCompra() == TipoCompra.ENTRADA){
                totalEntradas++; 
            }else if(c.getTipoCompra() == TipoCompra.KIT){
                totalKits++; 
            }
            montoTotal+= c.getValorPagado(); 
        }
        Reporte reporte = new Reporte(totalCompras, totalEntradas, totalKits, montoTotal); 
        System.out.println("====GENERAR REPORTE DE VENTAS====="); 
        System.out.println(reporte.toString());
    }

}
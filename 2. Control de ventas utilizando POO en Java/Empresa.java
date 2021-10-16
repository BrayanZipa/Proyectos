package ControlVentas;

public class Empresa {
    
    private Empleado[] listaEmpleado;
    private Venta[] listaVentas;
    
    public Empresa(Empleado empleado){
        this.listaEmpleado = new Empleado[10];
        this.listaVentas = new Venta[20];
        this.listaEmpleado[0] = empleado;
    }

    public Empleado[] getListaEmpleado() {
        return listaEmpleado;
    }

    public Venta[] getListaVentas() {
        return listaVentas;
    }
    
    public void anadirEmpleado(Empleado empleado){   
        for (int i = 0; i < this.listaEmpleado.length; i++) {
            if(this.listaEmpleado[i] == null){
                this.listaEmpleado[i] = empleado;
                break;
            }
        }  
    }
    
    public void anadirVenta(Cliente cliente, Empleado empleado, Producto[] listaProductos){
        for (int i = 0; i < this.listaVentas.length; i++) {
            if(this.listaVentas[i] == null){
                this.listaVentas[i] = new Venta(cliente,empleado,listaProductos);
                break;
            }
        }
        
    }

}

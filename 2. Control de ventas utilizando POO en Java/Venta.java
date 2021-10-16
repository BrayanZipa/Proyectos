package ControlVentas;

public class Venta {
    
    private Cliente cliente;
    private Empleado empleado;
    private Producto[] listaProductos;

    public Venta(Cliente cliente, Empleado empleado, Producto[] listaProductos) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.listaProductos = listaProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public String getListaProductos() {
        String informe="";
        for (Producto producto : listaProductos) {
            
            informe += producto+" ";
        }    
        return informe;
    }

    @Override
    public String toString() {
        return "Venta{" + "cliente=" + cliente + ", empleado=" + empleado + ", listaProductos=" + getListaProductos() + '}';
    }

}

package ControlVentas;

// Programa que controla el número de empleados, el número de clientes, los productos comprados y el número 
// de ventas que se generan en un negocio, esto mediante clases y objetos generados de las mismas.

public class Principal {
    
    public static void main(String[] args) {
        
        Cargo cargo1 = new Cargo("Gerente", "Direccionar la compañia", "Administrativo");
        Cargo cargo2 = new Cargo ("Cajero", "Atender ventanilla de caja", "Ventas");
        
        Empleado empleado1 = new Empleado(cargo1, "Carrera 1 con calle 2", "Pedro", "45652666", 30);
        Empleado empleado2 = new Empleado(cargo2, "Carrera 1 con calle 40", "Paula", "5565666", 28);
        
        Cliente cliente1 = new Cliente("3138141299", "Armando", "56236565",30);
        
        Producto producto1 = new Producto("Chocorramo", 2000);
        Producto producto2 = new Producto("Papas", 1500);
        
        Producto[] listaProductos = new Producto[2];
        listaProductos[0] = producto1;
        listaProductos[1] = producto2;
        
        Empresa empresa = new Empresa(empleado1);
        empresa.anadirEmpleado(empleado2);
        empresa.anadirVenta(cliente1, empleado2, listaProductos);
        
        Venta[] ventas = empresa.getListaVentas();
        Empleado[] empleados = empresa.getListaEmpleado();
        
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
        
        System.out.println();
        System.out.println("****************************************************************************************");
        System.out.println();
        
        for (Venta venta : ventas) {      
            System.out.println(venta);  
        }             
    }   
}

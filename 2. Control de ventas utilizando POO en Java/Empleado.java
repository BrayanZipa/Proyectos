package ControlVentas;

public class Empleado extends Persona {
    
    private Cargo cargo;
    private String direccion;

    public Empleado(Cargo cargo, String direccion, String nombre, String dni, int edad) {
        super(nombre, dni, edad);
        this.direccion = direccion;
        if (cargo != null){
            this.cargo = cargo;
        }else{
            System.out.println("Cargo no puede ser nulo");
        } 
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Empleado{" + "cargo=" + cargo + ", direccion=" + direccion + ", nombre=" + super.nombre + ", dni=" + super.dni + ", edad=" + super.edad + '}';
    }
}

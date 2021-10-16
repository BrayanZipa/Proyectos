package ControlVentas;

public class Cliente extends Persona {
    
    private String telefono;

    public Cliente(String telefono, String nombre, String dni, int edad) {
        super(nombre, dni, edad);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return "El telefono del cliente es: "+telefono;
    }

    public void setTelefono(String telefono) {
        if(telefono.equals("")||telefono.length()>10){
            System.out.println("Valor incorrecto");
        }else{
            this.telefono = telefono;
        }   
    }

    @Override
    public String toString() {
        return "Cliente{" + "telefono=" + this.telefono + ", nombre" + super.nombre + ", dni=" + super.dni + ", edad=" + super.edad + '}';
    }
    
    
    
    
    
}

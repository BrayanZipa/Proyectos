package ControlVentas;

public class Persona {
    
    protected String nombre;
    protected String dni;
    protected int edad;

    public Persona(String nombre, String dni, int edad) {
        super();
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() {
        return "El nombre de la persona es: "+nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.equals("")){
            System.out.println("Valor incorrecto");
        }else{
            this.nombre = nombre;
        }   
    }

    public String getDni() {
        return "El dni de la persona es: "+dni;
    }

    public void setDni(String dni) {
        if(nombre.equals("")){
            System.out.println("Valor incorrecto");
        }else{
            this.dni = dni;
        }      
    }

    public String getEdad() {
        return "La edad de la persona es: "+edad;
    }

    public void setEdad(int edad) {
        if(edad < 0 || edad > 130){
           System.out.println("Valor incorrecto"); 
        }else{
            this.edad = edad;
        }
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + '}';
    }
}

package ControlVentas;

public class Cargo {
    
    private String cargo;
    private String funcion;
    private String areaTrabajo;

    public Cargo(String cargo, String funcion, String areaTrabajo) {
        this.cargo = cargo;
        this.funcion = funcion;
        this.areaTrabajo = areaTrabajo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    @Override
    public String toString() {
        return "Cargo{" + "cargo=" + cargo + ", funcion=" + funcion + ", areaTrabajo=" + areaTrabajo + '}';
    }     
}

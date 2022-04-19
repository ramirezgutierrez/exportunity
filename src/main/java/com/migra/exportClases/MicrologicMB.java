package com.migra.exportClases;

public class MicrologicMB {
    String salida;
    String ip;
    Double turno;
    String nombre;
    public MicrologicMB(String salida,String ip,Double turno,String nombre){
        this.salida=salida;
        this.ip=ip;
        this.turno=turno;
        this.nombre=nombre;
    }
    @Override
    public String toString() {
        return "MicrologicMB [ip=" + ip + ", nombre=" + nombre + ", salida=" + salida + ", turno=" + turno + "]";
    }
    
}

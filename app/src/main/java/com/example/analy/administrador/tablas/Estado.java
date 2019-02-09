package com.example.analy.administrador.tablas;

public class Estado {
    public String idestado;
    public String descripcion;

    public Estado(String idestado, String descripcion) {
        this.idestado = idestado;
        this.descripcion = descripcion;
    }

    public String getIdestado() {
        return idestado;
    }
    @Override
    public String toString() {
        return  descripcion ;
    }
    public void setIdestado(String idestado) {
        this.idestado = idestado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

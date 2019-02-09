package com.example.analy.administrador.tablas;

public class Derivado {
    public String idDerivado;
    public String descripcion;

    public Derivado(String idDerivado, String descripcion) {
        this.idDerivado = idDerivado;
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return  descripcion ;
    }
    public String getIdDerivado() {
        return idDerivado;
    }

    public void setIdDerivado(String idDerivado) {
        this.idDerivado = idDerivado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

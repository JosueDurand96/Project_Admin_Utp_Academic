package com.example.analy.administrador.tablas;

public class tabla1 {
    public String Descrip_tipo;
    public String Auladescripcion;
    public String nroaula;
    public String derivado_Des;
    public String Estado_Des;

    public String getDerivado_Des() {
        return derivado_Des;
    }

    public void setDerivado_Des(String derivado_Des) {
        this.derivado_Des = derivado_Des;
    }

    public String getEstado_Des() {
        return Estado_Des;
    }

    public void setEstado_Des(String estado_Des) {
        Estado_Des = estado_Des;
    }

    public tabla1(String descrip_tipo, String auladescripcion, String derivado_Des, String estado_Des) {
        Descrip_tipo = descrip_tipo;
        Auladescripcion = auladescripcion;
        this.derivado_Des = derivado_Des;
        Estado_Des = estado_Des;
    }

    public tabla1(String descrip_tipo, String auladescripcion, String nroaula) {
        Descrip_tipo = descrip_tipo;
        Auladescripcion = auladescripcion;
        this.nroaula = nroaula;
    }

    public String getDescrip_tipo() {
        return Descrip_tipo;
    }

    public void setDescrip_tipo(String descrip_tipo) {
        Descrip_tipo = descrip_tipo;
    }

    public String getAuladescripcion() {
        return Auladescripcion;
    }

    public void setAuladescripcion(String auladescripcion) {
        Auladescripcion = auladescripcion;
    }

    public String getNroaula() {
        return nroaula;
    }

    public void setNroaula(String nroaula) {
        this.nroaula = nroaula;
    }
}

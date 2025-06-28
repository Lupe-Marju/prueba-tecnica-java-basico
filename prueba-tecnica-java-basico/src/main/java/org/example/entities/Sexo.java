package org.example.entities;

public enum Sexo {
    F("femenino"),
    M("masculino"),
    O("otros");
    private final String descripcion;

    Sexo(String descripcion) {
        this.descripcion = descripcion;

    }


    public String getDescripcion() {
        return descripcion;
    }

}

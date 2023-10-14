package com.unip.pim.payctions.model;

import java.util.ArrayList;
import java.util.List;

public class Cargo {

    private Integer cdCargo;
    private Integer cargaHoraria;
    private String nomeCargo;
    private Double salarioBase;

    public static List<Cargo> cargoList;

    static {
        cargoList = new ArrayList<>();
        cargoList.add(new Cargo(1, 40, "Chefe de RH", 10234.56));
        cargoList.add(new Cargo(2, 40, "Programador", 1234.56));
    }

    public Cargo() {
    }

    public Cargo(Integer cdCargo, Integer cargaHoraria, String nomeCargo, Double salarioBase) {
        this.cdCargo = cdCargo;
        this.cargaHoraria = cargaHoraria;
        this.nomeCargo = nomeCargo;
        this.salarioBase = salarioBase;
    }

    public static Cargo getCargoByCdCargo(Integer cdCargo) {
        Cargo result = null;
        for (Cargo cargo : cargoList) {
            if (cargo.cdCargo.equals(cdCargo)) {
                result = cargo;
                break;
            }
        }
        return result;
    }

    public Integer getCdCargo() {
        return cdCargo;
    }

    public void setCdCargo(Integer cdCargo) {
        this.cdCargo = cdCargo;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }
}

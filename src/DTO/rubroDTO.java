package DTO;

import Modelo.rubroDatos;

import java.util.ArrayList;

public class rubroDTO {
    private String tipo;
    private ArrayList<Integer> provsXrubro;

    public rubroDTO(String tipo, ArrayList<Integer> provsXrubro){
        this.tipo = tipo;
        this.provsXrubro = provsXrubro;
    }

    public String getTipo(){
        return this.tipo;
    }

    public ArrayList<Integer> getProvsXrubro(){
        return this.provsXrubro;
    }

    public void asignarProveedor(int cuit){
        this.provsXrubro.add(cuit);
    }

    public void setTipo(String n){
        this.tipo = n;
    }

    public static rubroDatos toModel(rubroDTO dto){
        return new rubroDatos(dto.getTipo(),dto.getProvsXrubro());
    }

    public static rubroDTO toDto(rubroDatos p) {
        return new rubroDTO(p.getTipo(),p.getProvsXrubro());
    }
}

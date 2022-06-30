package Modelo;

import DTO.rubroDTO;

import java.util.ArrayList;

public class rubroDatos {
    private String tipo;
    private ArrayList<Integer> provsXrubro;

    public rubroDatos(String tipo, ArrayList<Integer> provsXrubro){
        this.tipo = tipo;
        this.provsXrubro = provsXrubro;
    }

    public String getTipo(){
        return this.tipo;
    }

    public ArrayList<Integer> getProvsXrubro(){
        return this.provsXrubro;
    }

    public rubroDTO toDTO(){
        rubroDTO dto = new rubroDTO(this.getTipo(),this.getProvsXrubro());
        return dto;
    }
}

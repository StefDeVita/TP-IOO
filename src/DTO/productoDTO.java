package DTO;

import Modelo.productoDatos;

import java.util.ArrayList;

public class productoDTO {
    private int precioXuni;
    private int tipoIva;
    private String tipoUnidad;
    private int codigo;
    private rubroDTO rubroAsociado;

    public rubroDTO getRubroAsociado() {
        return rubroAsociado;
    }

    public int getPrecioXuni() {
        return precioXuni;
    }

    public int getTipoIva() {
        return tipoIva;
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public productoDTO(int precioXuni, int tipoIva, String tipoUnidad, int codigo, rubroDTO rubroAsociado) {
        this.precioXuni = precioXuni;
        this.tipoIva = tipoIva;
        this.tipoUnidad = tipoUnidad;
        this.codigo = codigo;
        this.rubroAsociado = rubroAsociado;
    }


    public static productoDatos toModel(productoDTO dto){
        return new productoDatos(dto.getPrecioXuni(), dto.getTipoIva(), dto.getTipoUnidad(), dto.getCodigo(), dto.getRubroAsociado());
    }

    public static productoDTO toDTO(productoDatos modelo){
        return new productoDTO(modelo.getPrecioXuni(), modelo.getTipoIva(), modelo.getTipoUnidad(), modelo.getCodigo(), modelo.getRubroAsociado());
    }

    public static ArrayList<productoDatos> listToModel(ArrayList<productoDTO> lista) throws Exception {
        ArrayList<productoDatos> ModelList = new ArrayList<>();
        for (productoDTO p : lista) {
            ModelList.add(productoDTO.toModel(p));
        }
        return ModelList;
    }

    public static ArrayList<productoDTO> listToDTO(ArrayList<productoDatos> lista) throws Exception {
        ArrayList<productoDTO> ModelList = new ArrayList<>();
        for (productoDatos p : lista) {
            ModelList.add(toDTO(p));
        }
        return ModelList;
    }


}

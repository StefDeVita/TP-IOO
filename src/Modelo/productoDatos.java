package Modelo;

import DTO.productoDTO;
import DTO.rubroDTO;

public class productoDatos {
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


    public productoDatos(int precioXuni, int tipoIva, String tipoUnidad, int codigo, rubroDTO rubroAsociado) {
        this.precioXuni = precioXuni;
        this.tipoIva = tipoIva;
        this.tipoUnidad = tipoUnidad;
        this.codigo = codigo;
        this.rubroAsociado = rubroAsociado;
    }

    public productoDTO toDTO(){
        return new productoDTO(this.getPrecioXuni(), this.getTipoIva(), this.getTipoUnidad(), this.getCodigo(), this.getRubroAsociado());
    }
}

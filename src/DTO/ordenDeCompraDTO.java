package DTO;

import Modelo.ordenDeCompraDatos;


import java.util.Date;
import java.util.Set;

public class ordenDeCompraDTO {
    private String id;
    private int cuit;
    private Set productosSolicitados;
    private float importe;
    private Date fecha;
    private float tipoPorcentajeIVA;

    public ordenDeCompraDTO(String id,int cuit,Set productosSolicitados, float importe, Date fecha, float tipoPorcentajeIVA){
        this.id = id;
        this.cuit = cuit;
        this.productosSolicitados = productosSolicitados;
        this.importe = importe;
        this.fecha = fecha;
        this.tipoPorcentajeIVA = tipoPorcentajeIVA;
    }

    public static ordenDeCompraDatos toModel(ordenDeCompraDTO dto) {
        ordenDeCompraDatos datos = new ordenDeCompraDatos(dto.getId(),dto.getCuit(),dto.getProductosSolicitados(),dto.getImporte(),dto.getFecha(),dto.getTipoPorcentajeIVA());
        return datos;
    }

    public static ordenDeCompraDTO toDto(ordenDeCompraDatos p) {
        return new ordenDeCompraDTO(p.getId(),p.getCuit(),p.getProductosSolicitados(),p.getImporte(),p.getFecha(),p.getTipoPorcentajeIVA());
    }

    public String getId() {
        return id;
    }
    public Set getProductosSolicitados() {
        return productosSolicitados;
    }

    public float getImporte() {
        return importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getTipoPorcentajeIVA() {
        return tipoPorcentajeIVA;
    }

    public int getCuit() {
        return cuit;
    }
}

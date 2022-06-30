package Modelo;

import DTO.ordenDeCompraDTO;

import java.util.Date;
import java.util.Set;

public class ordenDeCompraDatos {

    private String id;
    private int cuit;
    private Set productosSolicitados;
    private float importe;
    private Date fecha;
    private float tipoPorcentajeIVA;

    public ordenDeCompraDatos(String id,int cuit,Set productosSolicitados, float importe, Date fecha, float tipoPorcentajeIVA){
        this.id = id;
        this.cuit = cuit;
        this.productosSolicitados = productosSolicitados;
        this.importe = importe;
        this.fecha = fecha;
        this.tipoPorcentajeIVA = tipoPorcentajeIVA;
    }

    public static ordenDeCompraDatos toModel(ordenDeCompraDTO modelo) {
        ordenDeCompraDatos datos = new ordenDeCompraDatos(modelo.getId(),modelo.getCuit(),modelo.getProductosSolicitados(),modelo.getImporte(),modelo.getFecha(),modelo.getTipoPorcentajeIVA());
        return datos;
    }

    public String getId() {
        return id;
    }

    public int getCuit(){ return cuit; }
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


    public ordenDeCompraDTO toDTO() {
        ordenDeCompraDTO dto = new ordenDeCompraDTO(this.getId(),this.getCuit(),this.getProductosSolicitados(),this.getImporte(),this.getFecha(),this.getTipoPorcentajeIVA());
        return dto;
    }
}

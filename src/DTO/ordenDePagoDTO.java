package DTO;

import Modelo.ordenDePagoDatos;

import java.util.Date;
import java.util.Set;

public class ordenDePagoDTO {
    private String id;
    private Set DocumentosAsociados;
    private float totalACancelar;
    private float retenciones;
    private Date fecha;
    private boolean pagado;


    public ordenDePagoDTO(String id, Set DocumentosAsociados, float totalACancelar, float retenciones, Date fecha, boolean pagado)
    {
        this.id = id;
        this.DocumentosAsociados = DocumentosAsociados;
        this.totalACancelar = totalACancelar;
        this.retenciones = retenciones;
        this.fecha = fecha;
        this.pagado = false;
    }

    public static ordenDePagoDatos toModel(ordenDePagoDTO dto) {
        ordenDePagoDatos datos = new ordenDePagoDatos(dto.getId(),dto.getDocumentosAsociados(),dto.getTotalACancelar(),dto.getRetenciones(),dto.getFecha());
        return datos;
    }

    public static ordenDePagoDTO toDto(ordenDePagoDatos p) {
        return new ordenDePagoDTO(p.getId(),p.getDocumentosAsociados(),p.getTotalACancelar(),p.getRetenciones(),p.getFecha(), p.getPagado());
    }

    public Set getDocumentosAsociados() {
        return DocumentosAsociados;
    }

    public float getTotalACancelar() {
        return totalACancelar;
    }

    public float getRetenciones() {
        return retenciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getId() {
        return id;
    }

    public boolean getPagado(){
        return pagado;
    }
}

package Modelo;

import DTO.ordenDePagoDTO;

import java.util.Date;
import java.util.Set;

public class ordenDePagoDatos {
    private String id;
    private Set DocumentosAsociados;
    private float totalACancelar;
    private float retenciones;
    private Date fecha;
    private boolean pagado;


    public ordenDePagoDatos(String id, Set DocumentosAsociados, float totalACancelar, float retenciones, Date fecha)
    {
        this.id = id;
        this.DocumentosAsociados = DocumentosAsociados;
        this.totalACancelar = totalACancelar;
        this.retenciones = retenciones;
        this.fecha = fecha;
        this.pagado = false;
    }

    public String getId(){ return id; }

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

    public boolean getPagado(){
        return pagado;
    }

    public ordenDePagoDTO toDTO() {
        ordenDePagoDTO dto = new ordenDePagoDTO(this.getId(),this.getDocumentosAsociados(),this.getTotalACancelar(),this.getRetenciones(),this.getFecha(), this.getPagado());
        return dto;
    }
}

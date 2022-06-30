package DTO;

import Modelo.documentosDatos;
import Modelo.tipoDocumento;
import DTO.ordenDeCompraDTO;


import java.util.Date;

public class documentosDTO {

    private String id;
    private tipoDocumento tipoDocumento;
    private Date fecha;
    private String Responsabilidad_IVA;
    private String razón_social;
    private String nombre_fantasía;
    private String direccion;
    private String correo;
    private int telefono;
    private int nro_ingresos_brutos;
    private Date inicio_actividades;
    private boolean pagado;
    private int cuit;

    private String OCAsociada;


    public documentosDTO(String id, tipoDocumento tipoDocumento, String Responsabilidad_IVA, String razón_social, String nombre_fantasía,
                           String direccion, String correo,int telefono, int nro_ingresos_brutos, Date inicio_actividades,
                           boolean pagado, int cuit, String OCAsociada)
    {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.Responsabilidad_IVA = Responsabilidad_IVA;
        this.fecha = new Date();
        this.razón_social = razón_social;
        this.nombre_fantasía = nombre_fantasía;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.nro_ingresos_brutos = nro_ingresos_brutos;
        this.inicio_actividades = inicio_actividades;
        this.pagado = pagado;
        this.cuit = cuit;
        this.OCAsociada = OCAsociada;
    }

    public static documentosDTO toDto(documentosDatos p) {
        return new documentosDTO(p.getId(),p.getTipoDocumento(),p.getResponsabilidad_IVA(),p.getRazón_social(),
                p.getNombre_fantasía(),p.getDireccion(),p.getCorreo(),p.getTelefono(),p.getNro_ingresos_brutos(),p.getInicio_actividades(),
                p.getPagado(),p.getCuit(),p.getOCAsociada());
    }

    public tipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }
    public Date getFecha() {
        return fecha;
    }
    public String getResponsabilidad_IVA() {
        return Responsabilidad_IVA;
    }

    public String getRazón_social() {
        return razón_social;
    }

    public String getNombre_fantasía() {
        return nombre_fantasía;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getNro_ingresos_brutos() {
        return nro_ingresos_brutos;
    }

    public Date getInicio_actividades() {
        return inicio_actividades;
    }

    public boolean getPagado() {
        return pagado;
    }

    public int getCuit() {
        return cuit;
    }

    public String getId() {
        return id;
    }

    public String getOCAsociada() {
        return OCAsociada;
    }

    public static documentosDatos toModel(documentosDTO dto){
        return new documentosDatos(dto.getId(),dto.getTipoDocumento(), dto.getResponsabilidad_IVA(), dto.getRazón_social(),
                dto.getNombre_fantasía(), dto.getDireccion(), dto.getCorreo(), dto.getTelefono(),
                dto.getNro_ingresos_brutos() ,dto.getInicio_actividades(), dto.getPagado(), dto.getCuit(), dto.getOCAsociada());
    }



}

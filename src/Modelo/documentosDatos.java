package Modelo;

import DTO.documentosDTO;


import java.util.Date;


public class documentosDatos {
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


    public documentosDatos(String id, tipoDocumento tipoDocumento, String Responsabilidad_IVA, String razón_social, String nombre_fantasía,
                           String direccion, String correo, int telefono, int nro_ingresos_brutos, Date inicio_actividades,
                           boolean pagado, int cuit, String OCAsociada)
    {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.fecha = new Date();
        this.Responsabilidad_IVA = Responsabilidad_IVA;
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

    public String getId(){
        return id;
    }

    public Modelo.tipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public Date getFecha() {
        return fecha;
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

    public String getOCAsociada() {
        return OCAsociada;
    }


    public documentosDTO toDTO(){
        documentosDTO dto = new documentosDTO(this.getId(), this.getTipoDocumento(), this.getResponsabilidad_IVA(), this.getRazón_social(),
                this.getNombre_fantasía(), this.getDireccion(), this.getCorreo(), this.getTelefono(),
                this.getNro_ingresos_brutos() ,this.getInicio_actividades(), this.getPagado(), this.getCuit(), this.getOCAsociada());
        return dto;
    }

    public String getResponsabilidad_IVA() {
        return Responsabilidad_IVA;
    }
}

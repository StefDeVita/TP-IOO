package Modelo;

import DTO.proveedorDTO;
import DTO.productoDTO;

import java.util.ArrayList;

public class proveedorDatos {
    private int cuit;
    private String razonSocial;
    private String nombreProveedor;
    private boolean certificadoNR;
    private ArrayList<productoDatos> productos;


    public proveedorDatos(proveedorDTO prov){
        this.cuit = prov.getCuit();
        this.nombreProveedor = prov.getNombre();
        this.razonSocial = prov.getRS();
        this.certificadoNR = prov.getCNR();
    }

    public proveedorDatos(int cuit, String razonSocial, String nombreProveedor, boolean certificadoNR, ArrayList<productoDatos> productos) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.nombreProveedor = nombreProveedor;
        this.certificadoNR = certificadoNR;
        this.productos = productos;
    }

    public void setCuit(int c){
        this.cuit = c;
    }

    public void setRS(String rs){
        this.razonSocial = rs;
    }

    public void setNombre(String n){
        this.nombreProveedor = n;
    }

    public void setCNR(boolean s){
        this.certificadoNR = s;
    }

    public proveedorDTO toDTO() throws Exception {
        proveedorDTO dto = new proveedorDTO(this.getCuit(), this.getRS(), this.getNombre(), this.getCNR(), productoDTO.listToDTO(this.getProductos()));
        return dto;
    }


    public int getCuit() {
        return cuit;
    }

    public String getRS() {
        return razonSocial;
    }

    public String getNombre() {
        return nombreProveedor;
    }

    public boolean getCNR() {
        return certificadoNR;
    }


    public ArrayList<productoDatos> getProductos() {
        return productos;
    }
}

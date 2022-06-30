package DTO;

import Modelo.productoDatos;
import Modelo.proveedorDatos;

import java.util.ArrayList;

public class proveedorDTO {
    private int cuit;
    private String razonSocial;
    private String nombreProveedor;
    private boolean certificadoNR;
    private ArrayList<productoDatos> productos;

    public proveedorDTO(int cuit, String razonSocial, String nombreProveedor, boolean certificadoNR, ArrayList<productoDatos> productos) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.nombreProveedor = nombreProveedor;
        this.certificadoNR = certificadoNR;
        this.productos = productos;
    }



    public int getCuit(){
        return this.cuit;
    }

    public String getRS(){
        return this.razonSocial;
    }

    public String getNombre(){
        return this.nombreProveedor;
    }

    public boolean getCNR(){
        return this.certificadoNR;
    }

    public ArrayList<productoDatos> getProductos() throws Exception {
        return productos;
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

    public static proveedorDatos toModel(proveedorDTO dto) throws Exception {
        return new proveedorDatos(dto.getCuit(), dto.getRS(), dto.getNombre(), dto.getCNR(), dto.getProductos());
    }
    public static proveedorDTO toDto(proveedorDatos p) {
        return new proveedorDTO(p.getCuit(), p.getRS(), p.getNombre(), p.getCNR(), p.getProductos());
    }

}

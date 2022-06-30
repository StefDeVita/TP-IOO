package Controladores;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import DAO.proveedorDAO;
import DTO.productoDTO;
import Modelo.proveedorDatos;
import DTO.proveedorDTO;

import static DTO.proveedorDTO.toModel;


public class proveedorController {

    private static proveedorController controlador = null;
    private static proveedorDAO proveedorDao;
    private static List<proveedorDatos> listadoProveedores;
    private proveedorController() throws Exception {
        proveedorDao = new proveedorDAO(proveedorDatos.class,getPathOutModel(proveedorDatos.class.getSimpleName()));
        listadoProveedores = proveedorDao.getAll(proveedorDatos.class);
    }

    public static synchronized proveedorController getInstances() throws Exception {
        if(controlador == null)
            controlador = new proveedorController();
        return controlador;
    }

    private static String getPathOutModel(String simpleName) {
        String dir = new File("").getAbsolutePath();
        return  new File(simpleName+".json").getPath();
    }

    public proveedorDTO getProveedor(int cuit){
        for(proveedorDatos p: listadoProveedores){
            if(p.getCuit() == cuit)
                return p.toDTO();
        }
        return null;
    }

    public void agregarProveedor(proveedorDTO dto) throws Exception {
        if(getByCuitProveedor(dto.getCuit()) == null){
            proveedorDao.save(toModel(dto));
        }
    }

    public proveedorDTO getByCuitProveedor(int cuit) throws Exception {
        for (proveedorDatos p: listadoProveedores) {
            if (p.getCuit() == cuit){
                return proveedorDTO.toDto(p);
            }
        }
        return null;
    }

    public ArrayList<productoDTO> getProductosxCuit(int cuit) throws Exception {
        ArrayList<productoDTO> array = new ArrayList<>();
        getByCuitProveedor(cuit).getProductos().forEach(producto -> array.add(producto.toDTO()));
        return array;
    }

    private proveedorDatos getByCuitProveedorInternal(int cuit) throws Exception {
        for (proveedorDatos p: listadoProveedores) {
            if (p.getCuit() == cuit){
                return p;
            }
        }
        return null;
    }
    public void eliminarProveedor(int cuit) throws Exception {
        int index = getIndex(cuit);
        if(index != -1){
            listadoProveedores.remove(getByCuitProveedorInternal(cuit));

            guardar();
        }
    }

    private int getIndex(int cuit){
        for (int i=0;i<listadoProveedores.size();i++){
            if(listadoProveedores.get(i).getCuit() == cuit){
                return i;
            }
        }
        return -1;
    }

    private static productos_servicios_controller controllerPS;

    static {
        try {
            controllerPS = productos_servicios_controller.getInstances();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int precioxProv(int cuit, int codigo) throws Exception {
        proveedorDTO prov = getByCuitProveedor(cuit);
        ArrayList<productoDTO> a = controllerPS.listaDTO(prov.getProductos());
        AtomicInteger b = new AtomicInteger(-1);
        a.forEach(producto -> {

            if (producto.getCodigo() == codigo)
                b.set(producto.getPrecioXuni());
        });
        return b.get();
    }



    public void modificarProveedor(proveedorDTO prov, int cuit, String razonSocial, String nombreProveedor, boolean cnr) throws Exception {
        int i = getIndex(cuit);
        if(i != -1){
            listadoProveedores.get(i).setCuit(cuit);
            listadoProveedores.get(i).setRS(razonSocial);
            listadoProveedores.get(i).setNombre(nombreProveedor);
            listadoProveedores.get(i).setCNR(cnr);
            guardar();
        }
    }

    public ArrayList<proveedorDTO> listarTodo(){
        ArrayList<proveedorDTO> listado = new ArrayList<proveedorDTO>();
        for(proveedorDatos p: listadoProveedores){
            listado.add(p.toDTO());
        }
        return listado;
    }

    public ArrayList<proveedorDTO> getAll() throws Exception {
        ArrayList<proveedorDTO> dtoList = new ArrayList<>();
        for (proveedorDatos p : proveedorDao.getAll(proveedorDatos.class)) {
            dtoList.add(proveedorDTO.toDto(p));
        }
        return dtoList;
    }

    public boolean existeProv(int cuit){
        for(proveedorDatos p: listadoProveedores){
            if(p.getCuit() == cuit)
                return true;
        }
        return false;
    }


    public void guardar(){
        try {
            proveedorDao.saveAll(listadoProveedores);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}

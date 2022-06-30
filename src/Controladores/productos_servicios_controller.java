package Controladores;

import DAO.rubroDAO;
import DAO.productoDAO;
import DTO.proveedorDTO;
import DTO.rubroDTO;
import DTO.productoDTO;
import Modelo.proveedorDatos;
import Modelo.rubroDatos;
import Modelo.productoDatos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class productos_servicios_controller {
    private static productos_servicios_controller controlador = null;
    private static rubroDAO rubroDao;

    private static productoDAO productoDao;
    private static List<rubroDatos> listadoRubros;
    private static List<productoDatos> listadoProductos;

    private productos_servicios_controller() throws Exception {
        rubroDao = new rubroDAO(rubroDatos.class,getPathOutModel(rubroDatos.class.getSimpleName()));
        listadoRubros = rubroDao.getAll(rubroDatos.class);
        productoDao = new productoDAO(productoDatos.class,getPathOutModel(productoDatos.class.getSimpleName()));
        listadoProductos = productoDao.getAll(productoDatos.class);
    }

    public static synchronized productos_servicios_controller getInstances() throws Exception {
        if(controlador == null)
            controlador = new productos_servicios_controller();
        return controlador;
    }

    private static String getPathOutModel(String simpleName) {
        String dir = new File("").getAbsolutePath();
        return  new File(simpleName+".json").getPath();
    }

    public void asignarProveedorARubro(int cuit, rubroDTO dto){
        dto.asignarProveedor(cuit);
        guardar();
    }



    public rubroDTO getRubro(String tipo){
        for(rubroDatos p: listadoRubros){
            if(p.getTipo() == tipo)
                return p.toDTO();
        }
        return null;
    }

    public rubroDTO getRubroByIndex(int index){
        for(int i=0;i<listadoRubros.size();i++){
            if(i == index)
                return listadoRubros.get(i).toDTO();
        }
        return null;
    }

    public void agregarRubro(rubroDTO dto) throws Exception {
        if(getByTipoRubro(dto.getTipo()) == null){
            rubroDao.save(rubroDTO.toModel(dto));
        }
    }

    public void agregarProducto(productoDTO dto) throws Exception {
        if(getByCodigoProducto(dto.getCodigo()) == null){
            productoDao.save(productoDTO.toModel(dto));
        }
    }



    private rubroDatos getByTipoRubroInternal(String tipo) throws Exception {
        for (rubroDatos p: listadoRubros) {
            if (p.getTipo() == tipo){
                return p;
            }
        }
        return null;
    }
    public rubroDTO getByTipoRubro(String tipo) throws Exception {
        for (rubroDatos p: listadoRubros) {
            if (p.getTipo() == tipo){
                return rubroDTO.toDto(p);
            }
        }
        return null;
    }

    public productoDTO getByCodigoProducto(int codigo) throws Exception {
        for (productoDatos p: listadoProductos) {
            if (p.getCodigo() == codigo){
                return productoDTO.toDTO(p);
            }
        }
        return null;
    }

    public void eliminarRubro(String tipo) throws Exception {
        int index = getIndex(tipo);
        if(index != -1){
            listadoRubros.remove(getByTipoRubroInternal(tipo));
            guardar();
        }
    }

    private int getIndex(String tipo){
        for (int i=0;i<listadoRubros.size();i++){
            if(listadoRubros.get(i).getTipo() == tipo){
                return i;
            }
        }
        return -1;
    }


    public ArrayList<rubroDTO> listarTodo(){
        ArrayList<rubroDTO> listado = new ArrayList<rubroDTO>();
        for(rubroDatos p: listadoRubros){
            listado.add(p.toDTO());
        }
        return listado;
    }

    public List<rubroDTO> getAllRubro() throws Exception {
        List<rubroDTO> dtoList = new ArrayList<>();
        for (rubroDatos p : rubroDao.getAll(rubroDatos.class)) {
            dtoList.add(rubroDTO.toDto(p));
        }
        return dtoList;
    }

    public ArrayList<productoDTO> getAllProducto() throws Exception {
        ArrayList<productoDTO> dtoList = new ArrayList<>();
        for (productoDatos p : productoDao.getAll(productoDatos.class)) {
            dtoList.add(productoDTO.toDTO(p));
        }
        return dtoList;
    }


    public void guardar() {
        try {
            rubroDao.saveAll(listadoRubros);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static ArrayList<productoDTO> listaDTO(ArrayList<productoDatos> a){
        ArrayList<productoDTO> dtoList = new ArrayList<>();
        for (productoDatos p : a) {
            dtoList.add(productoDTO.toDTO(p));
        }
        return dtoList;
    }
    public static ArrayList<productoDatos> listToModel(ArrayList<productoDTO> lista) throws Exception {
        ArrayList<productoDatos> ModelList = new ArrayList<>();
        for (productoDTO p : lista) {
            ModelList.add(productoDTO.toModel(p));
        }
        return ModelList;
    }
    public int cantRubros(){
        return listadoRubros.size();
    }
}

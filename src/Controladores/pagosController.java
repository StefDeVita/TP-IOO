package Controladores;

import DAO.ordenDeCompraDAO;
import DAO.ordenDePagoDAO;
import DTO.ordenDeCompraDTO;
import DTO.ordenDePagoDTO;
import Modelo.ordenDeCompraDatos;
import Modelo.ordenDePagoDatos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class pagosController {
    private static pagosController controlador = null;
    private static ordenDeCompraDAO ordenDeCompraDao;
    private static ordenDePagoDAO ordenDePagoDao;
    private static List<ordenDeCompraDatos> listadoOrdenesDeCompra;
    private static List<ordenDePagoDatos> listadoOrdenesDePago;
    private pagosController() throws Exception {
        ordenDeCompraDao = new ordenDeCompraDAO(ordenDeCompraDatos.class,getPathOutModel(ordenDeCompraDatos.class.getSimpleName()));
        listadoOrdenesDeCompra = ordenDeCompraDao.getAll(ordenDeCompraDatos.class);
        ordenDePagoDao = new ordenDePagoDAO(ordenDePagoDatos.class,getPathOutModel(ordenDePagoDatos.class.getSimpleName()));
        listadoOrdenesDePago = ordenDePagoDao.getAll(ordenDePagoDatos.class);
    }

    public static synchronized pagosController getInstances() throws Exception {
        if(controlador == null)
            controlador = new pagosController();
        return controlador;
    }

    private static String getPathOutModel(String simpleName) {
        String dir = new File("").getAbsolutePath();
        return  new File(simpleName+".json").getPath();
    }

    public ordenDePagoDTO getOrdenPago(String id){
        for(ordenDePagoDatos p: listadoOrdenesDePago){
            if(p.getId().equals(id))
                return p.toDTO();
        }
        return null;
    }

    public ordenDeCompraDTO getOrdenCompra(String id){
        for(ordenDeCompraDatos p: listadoOrdenesDeCompra){
            if(p.getId().equals(id))
                return p.toDTO();
        }
        return null;
    }

    public float calcularIVA(float importe, float iva){
        return importe+(importe*(iva/100));
    }

    public void agregarOrdenCompra(ordenDeCompraDTO dto) throws Exception {
        ordenDeCompraDao.save(ordenDeCompraDTO.toModel(dto));
    }

    public void agregarOrdenPago(ordenDePagoDTO dto) throws Exception {
        ordenDePagoDao.save(ordenDePagoDTO.toModel(dto));
    }


    private ordenDeCompraDatos getByIdOrdenCompra(String id) throws Exception {
        for (ordenDeCompraDatos p: listadoOrdenesDeCompra) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    private ordenDePagoDatos getByIdOrdenPago(String id) throws Exception {
        for (ordenDePagoDatos p: listadoOrdenesDePago) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }


    public void eliminarOrdenCompra(String id) throws Exception {
        int index = getIndexOrdenCompra(id);
        if(index != -1){
            listadoOrdenesDeCompra.remove(getByIdOrdenCompra(id));
            guardarOrdenCompra();
        }
    }

    public void eliminarOrdenPago(String id) throws Exception {
        int index = getIndexOrdenPago(id);
        if(index != -1){
            listadoOrdenesDePago.remove(getByIdOrdenPago(id));
            guardarOrdenPago();
        }
    }



    private int getIndexOrdenCompra(String id){
        for (int i=0;i<listadoOrdenesDeCompra.size();i++){
            if(listadoOrdenesDeCompra.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    private int getIndexOrdenPago(String id){
        for (int i=0;i<listadoOrdenesDePago.size();i++){
            if(listadoOrdenesDePago.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }


    public ArrayList<ordenDePagoDTO> listarTodoOrdenPago(){
        ArrayList<ordenDePagoDTO> listado = new ArrayList<ordenDePagoDTO>();
        for(ordenDePagoDatos p: listadoOrdenesDePago){
            listado.add(p.toDTO());
        }
        return listado;
    }

    public ArrayList<ordenDeCompraDTO> listarTodoOrdenCompra(){
        ArrayList<ordenDeCompraDTO> listado = new ArrayList<ordenDeCompraDTO>();
        for(ordenDeCompraDatos p: listadoOrdenesDeCompra){
            listado.add(p.toDTO());
        }
        return listado;
    }

    public ArrayList<ordenDeCompraDTO> getAllOrdenCompra() throws Exception {
        ArrayList<ordenDeCompraDTO> dtoList = new ArrayList<>();
        for (ordenDeCompraDatos p : ordenDeCompraDao.getAll(ordenDeCompraDatos.class)) {
            dtoList.add(ordenDeCompraDTO.toDto(p));
        }
        return dtoList;
    }

    public ArrayList<ordenDePagoDTO> getAllOrdenPago() throws Exception {
        ArrayList<ordenDePagoDTO> dtoList = new ArrayList<>();
        for (ordenDePagoDatos p : ordenDePagoDao.getAll(ordenDePagoDatos.class)) {
            dtoList.add(ordenDePagoDTO.toDto(p));
        }
        return dtoList;
    }

    public void guardarOrdenCompra() {
        try {
            ordenDeCompraDao.saveAll(listadoOrdenesDeCompra);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarOrdenPago() {
        try {
            ordenDePagoDao.saveAll(listadoOrdenesDePago);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int cantOC(){
        return listadoOrdenesDeCompra.size();
    }

    public int cantOP() {
        return listadoOrdenesDePago.size();
    }
}

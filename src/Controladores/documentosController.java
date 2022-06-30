package Controladores;

import DAO.documentosDAO;
import DTO.documentosDTO;
import Modelo.documentosDatos;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class documentosController {
    private static documentosController controlador = null;
    private static documentosDAO documentosDao;
    private static List<documentosDatos> listadoDocumentos;
    private documentosController() throws Exception {
        documentosDao = new documentosDAO(documentosDatos.class,getPathOutModel(documentosDatos.class.getSimpleName()));
        listadoDocumentos = documentosDao.getAll(documentosDatos.class);
    }

    public static synchronized documentosController getInstances() throws Exception {
        if(controlador == null)
            controlador = new documentosController();
        return controlador;
    }

    private static String getPathOutModel(String simpleName) {
        String dir = new File("").getAbsolutePath();
        return  new File(simpleName+".json").getPath();
    }

    public documentosDTO getDoc(String id){
        for(documentosDatos p: listadoDocumentos){
            if(p.getId() == id)
                return p.toDTO();
        }
        return null;
    }

    public void agregarDoc(documentosDTO dto) throws Exception {
        if(getByIdDocumento(dto.getId()) == null){
            documentosDao.save(documentosDTO.toModel(dto));
        }
    }


    private documentosDatos getByIdDocumento(String id) throws Exception {
        for (documentosDatos p: listadoDocumentos) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void eliminarDoc(String id) throws Exception {
        int index = getIndex(id);
        if(index != -1){
            listadoDocumentos.remove(getByIdDocumento(id));
            guardar();
        }
    }

    private int getIndex(String id){
        for (int i=0;i<listadoDocumentos.size();i++){
            if(listadoDocumentos.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<documentosDTO> listarTodo(){
        ArrayList<documentosDTO> listado = new ArrayList<documentosDTO>();
        for(documentosDatos p: listadoDocumentos){
            listado.add(p.toDTO());
        }
        return listado;
    }

    public ArrayList<documentosDTO> getAll() throws Exception {
        ArrayList<documentosDTO> dtoList = new ArrayList<>();
        for (documentosDatos p : documentosDao.getAll(documentosDatos.class)) {
            dtoList.add(p.toDTO());
        }
        return dtoList;
    }

    public List<documentosDTO> getAllxProveedor(int cuit){
        List<documentosDTO> docList = new ArrayList<>();
        for(documentosDatos d: listadoDocumentos){
            if(d.getCuit() == cuit)
                docList.add(d.toDTO());
        }
        return docList;
    }

    public void guardar(){
        try {
            documentosDao.saveAll(listadoDocumentos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int cantDocs(){
        return listadoDocumentos.size();
    }

    public List<documentosDTO> getAllxDate(Date fecha) {
        List<documentosDTO> docList = new ArrayList<>();
        for(documentosDatos d: listadoDocumentos){
            Calendar fechaDoc = Calendar.getInstance();
            fechaDoc.setTime(d.getFecha());
            fechaDoc.set(Calendar.HOUR_OF_DAY, 0);
            Calendar fechaReq = Calendar.getInstance();
            fechaReq.setTime(fecha);
            fechaReq.set(Calendar.HOUR_OF_DAY, 0);
            if((fechaDoc.get(Calendar.DATE) == (fechaReq.get(Calendar.DATE))
                    && (fechaDoc.get(Calendar.MONTH) == (fechaReq.get(Calendar.MONTH))
                    && (fechaDoc.get(Calendar.YEAR) == (fechaReq.get(Calendar.YEAR))))))
                docList.add(d.toDTO());
        }
        return docList;
    }
}


package DAO;

import Modelo.proveedorDatos;
import Utils.GenericDAO;

public class proveedorDAO extends GenericDAO<proveedorDatos> {
    public proveedorDAO(Class<proveedorDatos> clase, String file) throws Exception {
        super(clase, file);
    }
}

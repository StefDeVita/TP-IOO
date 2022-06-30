package DAO;

import Modelo.proveedorDatos;
import Modelo.rubroDatos;
import Utils.GenericDAO;

public class rubroDAO extends GenericDAO<rubroDatos> {
    public rubroDAO(Class<rubroDatos> clase, String file) throws Exception {
        super(clase, file);
    }
}

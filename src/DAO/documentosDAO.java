package DAO;

import Modelo.documentosDatos;
import Utils.GenericDAO;

public class documentosDAO extends GenericDAO<documentosDatos> {
    public documentosDAO(Class<documentosDatos> clase, String file) throws Exception {
        super(clase, file);
    }
}

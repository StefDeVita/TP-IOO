package DAO;

import Modelo.productoDatos;
import Utils.GenericDAO;

public class productoDAO extends GenericDAO<productoDatos> {
    public productoDAO(Class<productoDatos> clase, String file) throws Exception {
        super(clase, file);
    }
}

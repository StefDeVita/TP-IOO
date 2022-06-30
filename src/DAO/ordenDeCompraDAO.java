package DAO;

import Modelo.ordenDeCompraDatos;
import Utils.GenericDAO;


public class ordenDeCompraDAO extends GenericDAO<ordenDeCompraDatos> {

    public ordenDeCompraDAO(Class<ordenDeCompraDatos> clase, String file) throws Exception {
        super(clase, file);
    }

}
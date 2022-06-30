package DAO;

import Modelo.ordenDePagoDatos;
import Utils.GenericDAO;


public class ordenDePagoDAO extends GenericDAO<ordenDePagoDatos> {

    public ordenDePagoDAO(Class<ordenDePagoDatos> clase, String file) throws Exception {
        super(clase, file);
    }
}

package UI;

import Controladores.productos_servicios_controller;
import Controladores.proveedorController;
import DTO.documentosDTO;
import DTO.productoDTO;
import DTO.proveedorDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class frmMostrarCompulsaProducto extends JDialog {
    private JPanel pnlMostrarCompulsaProducto;
    private JTable table1;
    private productos_servicios_controller controllerProductosServicios;
    private proveedorController controllerProveedor;

    public frmMostrarCompulsaProducto(Window owner, String titulo, int producto) throws Exception {
        super(owner, titulo);
        this.setContentPane(this.pnlMostrarCompulsaProducto);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        controllerProductosServicios = productos_servicios_controller.getInstances();
        controllerProveedor = proveedorController.getInstances();

        Object[][] data = convertDtoToData(controllerProductosServicios.getAllProducto(),controllerProveedor.getAll(), producto, controllerProveedor);
        DefaultTableModel model = new DefaultTableModel(data,new String[]{"CUIT","Codigo","Importe"});
        table1.setModel(model);
    }




    public Object[][] convertDtoToData(ArrayList<productoDTO> listProd, ArrayList<proveedorDTO> listProv, int codigo, proveedorController cont) throws Exception {
        Object[][] data = new Object[listProd.size()][3];
        int j = 0;
        for (int i = 0; i < listProv.size(); i++) {
            if(controllerProveedor.precioxProv(listProv.get(i).getCuit(), codigo) != -1) {
                data[i][0] = listProv.get(i).getCuit();
                data[i][1] = codigo;
                data[i][2] = controllerProveedor.precioxProv(listProv.get(i).getCuit(), codigo);
            }
        }
        return data;
    }




    /*
    public Object[][] convertDtoToData(ArrayList<proveedorDTO> listProv, productoDTO producto) throws Exception {
        Object[][] data = new Object[listProv.size()][3];
        for (int i = 0; i < listProv.size(); i++) {
            // Se comprueba si para cada proveedor se comercializa el producto seleccionado
            ArrayList<productoDTO> prods = controllerProveedor.getProductosxCuit(listProv.get(i).getCuit());
            for (int j = 0; j < prods.size(); j++) {
                if(prods.get(j).getCodigo() == (producto.getCodigo())) {
                    data[i][0] = listProv.get(i).getCuit();
                    data[i][1] = listProv.get(i).getNombre();
                    data[i][2] = producto.getPrecioXuni();
                }
            }
        }
        return data;
    }
    */

}

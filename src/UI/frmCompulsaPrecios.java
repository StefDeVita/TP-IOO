package UI;

import Controladores.productos_servicios_controller;
import Controladores.proveedorController;

import DTO.productoDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class frmCompulsaPrecios extends JDialog {
    private JPanel pnlCompulsaPrecios;
    private JTable table1;

    private productos_servicios_controller controllerProductosServicios;
    private proveedorController controllerProveedor;

    private frmCompulsaPrecios self;

    public frmCompulsaPrecios(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setContentPane(this.pnlCompulsaPrecios);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        controllerProductosServicios = productos_servicios_controller.getInstances();
        controllerProveedor = proveedorController.getInstances();


        Object[][] data = convertDtoToData(controllerProductosServicios.getAllProducto());
        table1.setModel(new DefaultTableModel(data, new String[]{"Rubro","Codigo"}));
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table1.getSelectedRow();
                frmMostrarCompulsaProducto frame = null;
                try {
                    productoDTO producto = controllerProductosServicios.getByCodigoProducto(((Integer) table1.getValueAt(row, 1)));
                    frame = new frmMostrarCompulsaProducto(self,"", (Integer) table1.getValueAt(row, 1));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            }
        });
    }



    public Object[][] convertDtoToData(ArrayList<productoDTO> listProd) throws Exception {
        Object[][] data = new Object[listProd.size()][2];
        Set visitados = new HashSet();
        int j = 0;
        for (int i = 0; i < listProd.size(); i++) {
            if(!visitados.contains(listProd.get(i).getCodigo())) {
                data[j][0] = listProd.get(i).getRubroAsociado().getTipo();
                data[j][1] = listProd.get(i).getCodigo();
                visitados.add(listProd.get(i).getCodigo());
                j++;
            }
        }
        return data;
    }
}

package UI;

import Controladores.pagosController;
import Controladores.productos_servicios_controller;
import DTO.ordenDeCompraDTO;
import DTO.productoDTO;
import Controladores.proveedorController;
import Modelo.ordenDeCompraDatos;
import Modelo.productoDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.valueOf;

public class frmCargarOrdenDeCompra extends JDialog {
    private JPanel pnlCargarOrdenDeCompra;
    private JTextField textField1;
    private JTable table1;
    private JButton buscarProductosButton;
    private JButton siguienteButton;
    private productos_servicios_controller productosServiciosController;

    private pagosController controllerPagos;

    public frmCargarOrdenDeCompra(String titulo) throws Exception {
        this.setContentPane(this.pnlCargarOrdenDeCompra);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        proveedorController provController = proveedorController.getInstances();
        try {
            productosServiciosController = productos_servicios_controller.getInstances();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        controllerPagos = pagosController.getInstances();

        buscarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[][] data = new Object[0][];
                try {
                    data = convertDtoToData(provController.getProductosxCuit(valueOf(textField1.getText())));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                DefaultTableModel model = new DefaultTableModel(data,new String[]{"Codigo","Precio","Seleccionar producto"})
                {
                    @Override
                    public Class getColumnClass(int column)
                    {
                        return column != 2 ? String.class : Boolean.class;
                    }
                };
                table1.setModel(model);

            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float importe = 0;
                Set<productoDTO> productos = new HashSet<productoDTO>();

                for(int i = 0; i < table1.getRowCount(); i++){
                    if(table1.getValueAt(i,2) == Boolean.TRUE){
                        importe = (float) (importe + (Integer.valueOf((Integer) table1.getValueAt(i,1))));
                        try {
                            productos.add(productosServiciosController.getByCodigoProducto((Integer) table1.getValueAt(i,0)));
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                Date fecha = new Date();

                int j = controllerPagos.cantOC() + 1;
                String idGen = "OC"+j;
                ordenDeCompraDTO ordenCompra = new ordenDeCompraDTO(idGen,valueOf(textField1.getText()), productos, importe, fecha, (float)27);
                try {
                    controllerPagos.agregarOrdenCompra(ordenCompra);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }


    public Object[][] convertDtoToData(ArrayList<productoDTO> list) {
        Object[][] data = new Object[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getCodigo();
            data[i][1] = list.get(i).getPrecioXuni();
            data[i][2] = Boolean.FALSE;
        }
        return data;
    }
}

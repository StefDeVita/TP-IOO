package UI;

import Controladores.pagosController;
import Controladores.documentosController;
import Controladores.proveedorController;
import DTO.documentosDTO;
import DTO.ordenDePagoDTO;
import DTO.productoDTO;
import Modelo.documentosDatos;
import Modelo.ordenDePagoDatos;
import Modelo.productoDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.valueOf;

public class frmCargarOrdenDePago extends JDialog{

    private JPanel pnlCargarOrdenDePago;
    private JTextField textField1;
    private JTable table1;
    private JButton crearOrdenDePagoButton;
    private pagosController controllerPagos;
    private documentosController controllerDocumentos;

    public frmCargarOrdenDePago(String titulo) throws Exception {
        this.setContentPane(this.pnlCargarOrdenDePago);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        proveedorController provController = proveedorController.getInstances();
        try {
            controllerPagos = pagosController.getInstances();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        controllerDocumentos = documentosController.getInstances();

        Object[][] data = new Object[0][];
        try {
            data = convertDtoToData(controllerDocumentos.getAll());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        DefaultTableModel model = new DefaultTableModel(data,new String[]{"ID","OC asociada","Responsabilidad IVA","Tipo documento", "Seleccionar producto"}) {
            @Override
            public Class getColumnClass(int column) {
                return column != 4 ? String.class : Boolean.class;
            }
        };
        table1.setModel(model);

        crearOrdenDePagoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float importe = 0;
                Set<documentosDTO> docs = new HashSet<documentosDTO>();
                for (int i = 0; i < table1.getRowCount(); i++) {
                    if (table1.getValueAt(i, 4) == Boolean.TRUE) {
                        importe = (float) ((float) (importe + controllerPagos.getOrdenCompra((String) table1.getValueAt(i,1)).getImporte()) * 1.27);
                        try {
                            docs.add(controllerDocumentos.getDoc((String) table1.getValueAt(i, 0)));
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                int j = controllerPagos.cantOP() + 1;
                String idGen = "OC" + j;
                ordenDePagoDTO op = new ordenDePagoDTO(idGen, docs, importe, (float) 0.0, new Date(), false);
                try {
                    controllerPagos.agregarOrdenPago(op);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public Object[][] convertDtoToData(ArrayList<documentosDTO> list) {
        Object[][] data = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getOCAsociada();
            data[i][2] = list.get(i).getResponsabilidad_IVA();
            data[i][3] = list.get(i).getTipoDocumento();
            data[i][4] = Boolean.FALSE;
        }
        return data;
    }
}

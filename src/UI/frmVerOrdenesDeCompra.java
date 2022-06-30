package UI;

import Controladores.pagosController;
import DTO.ordenDeCompraDTO;
import DTO.proveedorDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class frmVerOrdenesDeCompra extends JDialog{
    private JPanel pnlVerOrdenesDeCompra;
    private JTable table1;
    private pagosController controllerPagos;

    public frmVerOrdenesDeCompra() throws Exception {
        this.setContentPane(this.pnlVerOrdenesDeCompra);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        controllerPagos = pagosController.getInstances();
        Object[][] data = convertDtoToData(controllerPagos.getAllOrdenCompra());
        table1.setModel(new DefaultTableModel(data, new String[]{"CUIT", "Importe", "Tipo IVA"}));
    }



    public Object[][] convertDtoToData(List<ordenDeCompraDTO> list) {
        Object[][] data = new Object[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getCuit();
            data[i][1] = list.get(i).getImporte();
            data[i][2] = list.get(i).getTipoPorcentajeIVA();
        }
        return data;
    }
}

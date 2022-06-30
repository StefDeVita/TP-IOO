package UI;

import Controladores.pagosController;
import DTO.ordenDeCompraDTO;
import DTO.ordenDePagoDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class pnlListadoOrdenesDePago extends JDialog{
    private JPanel pnlListadoOrdenesDePago;
    private JTable table1;
    private pagosController controllerPagos;

    public pnlListadoOrdenesDePago() throws Exception {
        this.setContentPane(this.pnlListadoOrdenesDePago);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        controllerPagos = pagosController.getInstances();
        Object[][] data = convertDtoToData(controllerPagos.getAllOrdenPago());
        table1.setModel(new DefaultTableModel(data, new String[]{"Pagado SI/NO", "ID", "Total"}));
    }




    public Object[][] convertDtoToData(List<ordenDePagoDTO> list) {
        Object[][] data = new Object[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getPagado();
            data[i][1] = list.get(i).getId();
            data[i][2] = list.get(i).getTotalACancelar();
        }
        return data;
    }
}

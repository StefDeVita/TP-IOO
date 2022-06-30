package UI;

import Controladores.documentosController;
import Controladores.proveedorController;
import Controladores.pagosController;
import DTO.documentosDTO;
import DTO.productoDTO;
import DTO.proveedorDTO;
import Modelo.proveedorDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import static DTO.proveedorDTO.toModel;

public class frmLibroIVA extends JDialog {
    private JPanel pnlLibroIVA;
    private JTable table1;
    private documentosController controllerDoc;
    private proveedorController controllerProv;
    private pagosController controllerPagos;
    public frmLibroIVA(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setContentPane(this.pnlLibroIVA);
        this.setSize(900, 500);
        this.setLocationRelativeTo(null);
        controllerDoc = documentosController.getInstances();
        controllerProv = proveedorController.getInstances();
        controllerPagos = pagosController.getInstances();

        Object[][] data = convertDtoToData(controllerProv.getAll(), controllerDoc.getAll());
        DefaultTableModel model = new DefaultTableModel(data,new String[]{"CUIT","Nombre (proveedor)","Fecha","Tipo documento","IVA","Importe"});
        table1.setModel(model);
    }



    public Object[][] convertDtoToData(ArrayList<proveedorDTO> listProv, ArrayList<documentosDTO> listDoc) throws Exception {
        Object[][] data = new Object[listDoc.size()][6];
        float iva = 27.0F;
        for (int i = 0; i < listDoc.size(); i++) {
            proveedorDTO prov = controllerProv.getByCuitProveedor(listDoc.get(i).getCuit());
            data[i][0] = listDoc.get(i).getCuit();
            data[i][1] = prov.getNombre();
            data[i][2] = listDoc.get(i).getFecha();
            data[i][3] = listDoc.get(i).getTipoDocumento();
            data[i][4] = iva + "%";
            if(listDoc.get(i).getOCAsociada() != null)
                data[i][5] = controllerPagos.calcularIVA(controllerPagos.getOrdenCompra(listDoc.get(i).getOCAsociada()).getImporte(), iva);
            else
                data[i][5] =0;
        }
        return data;
    }
}

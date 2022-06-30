package UI;


import Controladores.documentosController;
import DTO.documentosDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


import static java.lang.Integer.valueOf;

public class frmInternaVerDocsxProveedor extends JInternalFrame {
    private JTextField textField1;
    private JButton buscarDocumentosPorCUITButton;
    private JPanel pnlPrincipalVerDocsxProv;
    private JTable tablaDocs;

    private documentosController controllerDocumentos = documentosController.getInstances();

    public frmInternaVerDocsxProveedor(String titulo) throws Exception {
        super(titulo);
        this.setContentPane(this.pnlPrincipalVerDocsxProv);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);

        buscarDocumentosPorCUITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[][] data = convertDtoToData(controllerDocumentos.getAllxProveedor(valueOf(textField1.getText())));
                tablaDocs.setModel(new DefaultTableModel(data,new String[]{"Nombre fantasia","Nro ingresos brutos","Pagado","Responsabilidad IVA","Tipo documento"}));
            }
        });
    }


    public Object[][] convertDtoToData(List<documentosDTO> list) {
        Object[][] data = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getNombre_fantasía();
            data[i][1] = list.get(i).getNro_ingresos_brutos();
            data[i][2] = list.get(i).getPagado();
            data[i][3] = list.get(i).getResponsabilidad_IVA();
            data[i][4] = list.get(i).getTipoDocumento();
        }
        return data;
    }
}
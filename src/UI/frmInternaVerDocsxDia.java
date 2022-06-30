package UI;

import Controladores.documentosController;
import DTO.documentosDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmInternaVerDocsxDia extends JInternalFrame {

    private JPanel pnlPrincipalVerDocsxDia;
    private JButton buscarDocumentosButton;
    private JTextField textField1;
    private JTable table1;
    private documentosController controllerDocumentos;

    public frmInternaVerDocsxDia(String titulo) throws Exception {
        super(titulo);
        this.setContentPane(this.pnlPrincipalVerDocsxDia);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        controllerDocumentos = documentosController.getInstances();

        buscarDocumentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date fecha;
                try {
                    fecha = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(textField1.getText()));
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                Object[][] data = convertDtoToData(controllerDocumentos.getAllxDate(fecha));
                table1.setModel(new DefaultTableModel(data,new String[]{"Nombre fantasia","Nro ingresos brutos","Pagado","Responsabilidad IVA","Tipo documento"}));
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

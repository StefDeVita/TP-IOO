package UI;

import Controladores.productos_servicios_controller;
import DTO.rubroDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class frmInternaS2 extends JInternalFrame{
    private JTextField textField1;
    private JButton SldButton;
    private JPanel pnlPrinInternaS2;
    private JTable table1;

    public frmInternaS2(String titulo, productos_servicios_controller productosServiciosController) throws Exception {

        super(titulo);
        this.setContentPane(this.pnlPrinInternaS2);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,500);
        Object[][] data = convertDtoToData(productosServiciosController.getAllRubro());
        table1.setModel(new DefaultTableModel(data, new String[]{"Tipo","Proveedores asociados (CUIT)"}));

        SldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> nu = new ArrayList<Integer>();
                rubroDTO rubro = new rubroDTO(textField1.getText(), nu);
                try {
                    productosServiciosController.agregarRubro(rubro);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int s = table1.getSelectedRow();
                frmAsociarRubro frame = new frmAsociarRubro(s,productosServiciosController);
                frame.setVisible(true);
            }
        });
    }

    public Object[][] convertDtoToData(List<rubroDTO> list) {
        Object[][] data = new Object[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getTipo();
            data[i][1] = list.get(i).getProvsXrubro().toString();
        }
        return data;
    }
}

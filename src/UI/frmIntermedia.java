package UI;

import Controladores.proveedorController;
import Controladores.productos_servicios_controller;
import DTO.proveedorDTO;
import Modelo.proveedorDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmIntermedia extends JInternalFrame{
    private JPanel pnlPrincipalInte;
    private JButton button1;
    private JTable tablaProv;


    public frmIntermedia(String titulo, proveedorController c, productos_servicios_controller productosServiciosController) throws Exception {
        super(titulo);
        this.setContentPane(this.pnlPrincipalInte);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Object[][] data = convertDtoToData(c.getAll());
        tablaProv.setModel(new DefaultTableModel(data,new String[]{"CUIT","Nombre","Razon social","CNR"}));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmInternaS1 frame = new frmInternaS1(c,productosServiciosController);
                frame.setVisible(true);
            }
        });
    }

    public Object[][] convertDtoToData(List<proveedorDTO> list) {
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getCuit();
            data[i][1] = list.get(i).getNombre();
            data[i][2] = list.get(i).getRS();
            data[i][3] = list.get(i).getCNR();
        }
        return data;
    }
}

package UI;

import Controladores.proveedorController;
import Controladores.productos_servicios_controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmInternaS1 extends JDialog{
    private JPanel pnlPrinInternaS1;
    private JButton altaProveedorButton;
    private JButton bajaProveedorButton;
    private JButton modificarProveedorButton;

    public frmInternaS1(proveedorController controllerProveedor, productos_servicios_controller productosServiciosController) {
        this.setContentPane(this.pnlPrinInternaS1);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        altaProveedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAltaProveedor frame = null;
                try {
                    frame = new frmAltaProveedor(controllerProveedor);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            }
        });
        bajaProveedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmBajaProveedor frame2 = new frmBajaProveedor(controllerProveedor);
                frame2.setVisible(true);
            }
        });
        modificarProveedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmModProveedor frame3 = new frmModProveedor(controllerProveedor);
                frame3.setVisible(true);
            }
        });
    }
}

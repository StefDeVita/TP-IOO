package UI;

import Controladores.proveedorController;
import Controladores.productos_servicios_controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class proveedor extends JDialog{
    private JPanel pnlPrincipalProv;
    private JTabbedPane tabbedPane1;
    private JDesktopPane desktopPaneInternaS1;
    private JDesktopPane desktopPaneInternaS2;
    private proveedor self;
    private proveedorController controllerProveedor;
    private productos_servicios_controller prodServController;

    public proveedor(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setContentPane(this.pnlPrincipalProv);
        this.setSize(500,500);
        //no permite volver a la pantalla anterior antes de cerrar esta
        //this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.self = this;

        controllerProveedor = proveedorController.getInstances();

        prodServController = productos_servicios_controller.getInstances();

        frmIntermedia frameS1 = new frmIntermedia("Vista proveedor",controllerProveedor, prodServController);
        frameS1.setVisible(true);
        desktopPaneInternaS1.add(frameS1);

        frmInternaS2 frameS2 = new frmInternaS2("Vista rubro", prodServController);
        frameS2.setVisible(true);
        desktopPaneInternaS2.add(frameS2);
    }
}

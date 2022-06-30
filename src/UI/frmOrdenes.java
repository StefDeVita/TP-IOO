package UI;

import javax.swing.*;
import java.awt.*;
import Controladores.proveedorController;

public class frmOrdenes extends JDialog{
    private JPanel pnlPrincipalOrdenes;
    private JTabbedPane tabbedPane1;
    private JDesktopPane JDesktopPaneCompra;
    private JDesktopPane JDesktopPanePago;
    private frmOrdenes self;

    public frmOrdenes(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setContentPane(this.pnlPrincipalOrdenes);
        this.setSize(500, 500);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.self = this;

        frmInternaOrdenDeCompra frameS1 = new frmInternaOrdenDeCompra("Ordenes de compra");
        frameS1.setVisible(true);
        JDesktopPaneCompra.add(frameS1);

        frmInternaOrdenDePago frameS2 = new frmInternaOrdenDePago("Ordenes de pago");
        frameS2.setVisible(true);
        JDesktopPanePago.add(frameS2);
    }
}

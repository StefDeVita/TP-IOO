package UI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmInternaOrdenDeCompra extends JInternalFrame {
    private JPanel pnlPrinInternaOrdenDeCompra;
    private JButton verOrdenesDeCompraButton;
    private JButton cargarOrdenDeCompraButton;

    public frmInternaOrdenDeCompra(String titulo) throws Exception {
        super(titulo);
        this.setContentPane(this.pnlPrinInternaOrdenDeCompra);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        cargarOrdenDeCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmCargarOrdenDeCompra frame =  null;
                try {
                    frame = new frmCargarOrdenDeCompra("");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            }
        });
        verOrdenesDeCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmVerOrdenesDeCompra frame2 =  null;
                try {
                    frame2 = new frmVerOrdenesDeCompra();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame2.setVisible(true);
            }
        });
    }
}

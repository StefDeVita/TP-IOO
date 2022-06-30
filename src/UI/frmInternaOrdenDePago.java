package UI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmInternaOrdenDePago extends JInternalFrame {
    private JPanel pnlPrinInternaOrdenDeCompra;
    private JButton cargarOrdenDePagoButton;
    private JButton pagarOrdenDePagoButton;
    private JButton listadoOrdenesDePagoButton;

    public frmInternaOrdenDePago(String titulo) throws Exception {
        super(titulo);
        this.setContentPane(this.pnlPrinInternaOrdenDeCompra);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        cargarOrdenDePagoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmCargarOrdenDePago frame;
                try {
                    frame = new frmCargarOrdenDePago("");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            }
        });
        listadoOrdenesDePagoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlListadoOrdenesDePago frame = null;
                try {
                    frame = new pnlListadoOrdenesDePago();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            }
        });
    }
}

package UI;

import Controladores.documentosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class documentosVista extends JDialog{
    private JPanel pnlPrincipalDoc;
    private JButton verDocumentosButton;
    private JButton cargarDocumentosButton;
    private JButton ordenesDeCompraPagoButton;
    private documentosVista self;

    public documentosVista(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setContentPane(this.pnlPrincipalDoc);
        this.setSize(500, 500);

        //no permite volver a la pantalla anterior antes de cerrar esta
        //this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.self = this;

        verDocumentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmVerDocs frame = null;
                try {
                    frame = new frmVerDocs(self,"");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            }
        });
        cargarDocumentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmCargarDocs frame2 = null;
                try {
                    frame2 = new frmCargarDocs(self, "");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame2.setVisible(true);
            }
        });
        ordenesDeCompraPagoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmOrdenes frame3 = null;
                try {
                    frame3 = new frmOrdenes(self,"");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame3.setVisible(true);
            }
        });
    }
}

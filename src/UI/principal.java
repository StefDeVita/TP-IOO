package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class principal extends JFrame {
    private JPanel pnlPrincipal;
    private JButton button1;
    private JButton documentosButton;
    private JButton libroIVAButton;
    private JButton compulsaPreciosButton;
    private principal self;

    public principal(String titulo){
        super(titulo);
        this.setContentPane(this.pnlPrincipal);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        this.asociarEventos();
        this.self = this;

        compulsaPreciosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        compulsaPreciosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmCompulsaPrecios frame4 = null;
                try {
                    frame4 = new frmCompulsaPrecios(self, "");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame4.setVisible(true);
            }
        });
    }

    private void asociarEventos(){
        libroIVAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmLibroIVA frame3 = null;
                try {
                    frame3 = new frmLibroIVA(self,"");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame3.setVisible(true);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proveedor frame = null;
                try {
                    frame = new proveedor(self, "demo proveedor");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            }
        });
        documentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                documentosVista frame2 = null;
                try {
                    frame2 = new documentosVista(self, "documentos");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame2.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        principal frame = new principal("programa");
        frame.setVisible(true);
    }
}

package UI;

import Controladores.proveedorController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.valueOf;

public class frmModProveedor extends JDialog{
    private JPanel pnlPrincipalMP;
    private JTextField textField1;
    private JButton ingresarButton;

    public frmModProveedor(proveedorController c) {
        this.setContentPane(this.pnlPrincipalMP);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(c.getByCuitProveedor(valueOf(textField1.getText())) != null){
                        frmModProveedorVerificado frame = new frmModProveedorVerificado(c);
                        frame.setVisible(true);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}

package UI;

import Controladores.proveedorController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.valueOf;

public class frmBajaProveedor extends JDialog {
    private JPanel pnlPrincipalBP;
    private JTextField textField1;
    private JButton darDeBajaButton;


    public frmBajaProveedor(proveedorController c) {
        this.setContentPane(this.pnlPrincipalBP);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);

        darDeBajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(c.getByCuitProveedor(valueOf(textField1.getText())) != null){
                        c.eliminarProveedor(valueOf(textField1.getText()));
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}

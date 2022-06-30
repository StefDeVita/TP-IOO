package UI;

import Controladores.proveedorController;
import Modelo.proveedorDatos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.valueOf;

public class frmModProveedorVerificado extends JDialog{
    private JPanel pnlPrincipalMPVer;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton actualizarDatosButton;
    private JComboBox comboBox1;

    public frmModProveedorVerificado(proveedorController c) {
        this.setContentPane(this.pnlPrincipalMPVer);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        actualizarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean cnr = false;
                String certificado = comboBox1.getSelectedItem().toString();
                if (certificado == "Si")
                    cnr = true;
                else
                    cnr = false;
                try {
                    c.modificarProveedor(c.getByCuitProveedor(valueOf(textField1.getText())),valueOf(textField1.getText()),textField2.getText(),textField3.getText(),cnr);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}

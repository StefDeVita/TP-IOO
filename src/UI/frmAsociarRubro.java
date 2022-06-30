package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controladores.productos_servicios_controller;
import Controladores.proveedorController;

import static java.lang.Integer.valueOf;

public class frmAsociarRubro extends JDialog{
    private JPanel pnlPrincipalAsociarRubro;
    private JButton asociarButton;
    private JTextField textField1;
    private proveedorController controllerProveedor;

    public frmAsociarRubro(int indiceRubro, productos_servicios_controller c) {
        this.setContentPane(this.pnlPrincipalAsociarRubro);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        asociarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controllerProveedor.existeProv(valueOf(textField1.getText())))
                    c.asignarProveedorARubro(valueOf(textField1.getText()),c.getRubroByIndex(indiceRubro));
            }
        });
    }
}

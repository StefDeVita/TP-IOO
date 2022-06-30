package UI;

import DTO.productoDTO;
import DTO.proveedorDTO;
import DTO.rubroDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Controladores.proveedorController;
import Controladores.productos_servicios_controller;

import static java.lang.Integer.valueOf;

public class frmAltaProveedor extends JDialog {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton subirDatosButton;
    private JPanel pnlPrincipalAP;
    private JComboBox comboBox1;

    private productos_servicios_controller productosServiciosController = productos_servicios_controller.getInstances();


    public frmAltaProveedor(proveedorController controllerProveedor) throws Exception {
        this.setContentPane(this.pnlPrincipalAP);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        subirDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean cnr = false;
                String certificado = comboBox1.getSelectedItem().toString();
                if (certificado == "Si")
                    cnr = true;
                else
                    cnr = false;
                ArrayList<productoDTO> nu = null;
                try {
                    nu = productos();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                proveedorDTO a = null;
                try {
                    a = new proveedorDTO(valueOf(textField1.getText()), textField2.getText(), textField3.getText(), cnr, productosServiciosController.listToModel(nu));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    controllerProveedor.agregarProveedor(a);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public ArrayList<productoDTO> productos() throws Exception {
        ArrayList<productoDTO> lista = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < 5; i++) {
            Random sn = new Random();
            if(sn.nextInt(0, 3) != 0) {
                // Se genera el precio aleatoriamente
                Random r = new Random();
                int precio = valueOf(r.nextInt(10, 500));
                // Se genera el rubro asociado aleatoriamente
                Random r2 = new Random();
                int indice = valueOf(r.nextInt(0, productosServiciosController.cantRubros()));
                List<rubroDTO> rubros = productosServiciosController.getAllRubro();
                productoDTO producto = new productoDTO(precio, 27, "hora", j, rubros.get(indice));
                j++;
                lista.add(producto);
                productosServiciosController.agregarProducto(producto);
            }
        }
        return lista;
    }

}

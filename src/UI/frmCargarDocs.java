package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import DTO.documentosDTO;
import DTO.ordenDeCompraDTO;
import DTO.proveedorDTO;
import Modelo.ordenDeCompraDatos;
import Modelo.tipoDocumento;

import Controladores.pagosController;
import Controladores.documentosController;
import Modelo.documentosDatos;

import static DTO.ordenDeCompraDTO.toModel;
import static java.lang.Integer.valueOf;

public class frmCargarDocs extends JDialog{

    private frmCargarDocs self;
    private JPanel pnlPrincipalVerDocs;
    private JTextField Responsabilidad_IVA;
    private JTextField razón_social;
    private JTextField nombre_fantasía;
    private JTextField direccion;
    private JTextField correo;
    private JTextField telefono;
    private JTextField nro_ingresos_brutos;
    private JTextField inicio_actividades;
    private JTextField cuit;
    private JComboBox comboTipo_doc;
    private JButton cargarButton;
    private JComboBox booleanPagado;
    private JComboBox comboOrdenDeCompra;
    private pagosController controllerPagos;
    private documentosController controllerDocumentos;

    public frmCargarDocs(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setContentPane(this.pnlPrincipalVerDocs);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.self = this;
        controllerDocumentos = documentosController.getInstances();
        comboTipo_doc.setModel(new DefaultComboBoxModel<tipoDocumento>(tipoDocumento.values()));

        controllerPagos = pagosController.getInstances();
        String[] data = convertDtoToData(controllerPagos.getAllOrdenCompra());
        comboOrdenDeCompra.setModel(new DefaultComboBoxModel<String>(data));
        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean pago;
                String pagado = booleanPagado.getSelectedItem().toString();
                if (pagado == "Si")
                    pago = true;
                else
                    pago = false;
                tipoDocumento tipo_de_doc;
                String tipo = comboTipo_doc.getSelectedItem().toString();
                switch (tipo) {
                    case "factura":
                        tipo_de_doc = tipoDocumento.factura;
                        break;
                    case "nota_de_debito":
                        tipo_de_doc = tipoDocumento.nota_de_debito;
                        break;
                    case "nota_de_credito":
                        tipo_de_doc = tipoDocumento.nota_de_credito;
                        break;
                    default:
                        tipo_de_doc = tipoDocumento.remito;
                        break;
                }

                // Se asigna inicio de actividades a una variable tipo Date
                Date fecha;
                try {
                    fecha = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(inicio_actividades.getText()));
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                // Se comprueba si se selecciono una orden de compra asociada o no
                String ordenC = null;
                if ((String) comboOrdenDeCompra.getSelectedItem() != "Sin orden de compra")
                    ordenC = (String) comboOrdenDeCompra.getSelectedItem();

                // se genera un codigo para el doc
                int j = controllerDocumentos.cantDocs() + 1;
                String idGen = "DOC" + j;
                // se asignan los valores y se los guarda
                documentosDTO a = new documentosDTO(idGen, tipo_de_doc, Responsabilidad_IVA.getText(), razón_social.getText(),
                        nombre_fantasía.getText(), direccion.getText(), correo.getText(), Integer.valueOf(telefono.getText()), Integer.valueOf(nro_ingresos_brutos.getText()),
                        fecha, pago, Integer.valueOf(cuit.getText()), ordenC);
                try {
                    controllerDocumentos.agregarDoc(a);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public String[] convertDtoToData(List<ordenDeCompraDTO> list) {
        String[] data = new String[list.size() + 1];
        for (int i = 0; i < list.size(); i++) {
            data[i] = list.get(i).getId();
        }
        data[list.size()] = "Sin orden de compra";
        return data;
    }
}

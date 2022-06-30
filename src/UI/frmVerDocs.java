package UI;

import Controladores.documentosController;
import DTO.documentosDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.lang.Integer.valueOf;

public class frmVerDocs extends JDialog{
    private JTextField textField1;
    private JTable tablaDocs;
    private JPanel pnlPrincipalVerDocs;
    private JTabbedPane tabbedPane1;
    private JDesktopPane JDesktopProv;
    private JDesktopPane JDesktopDia;
    private frmVerDocs self;

    public frmVerDocs(Window owner, String titulo) throws Exception {
        super(owner, titulo);
        this.setContentPane(this.pnlPrincipalVerDocs);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.self = this;

        frmInternaVerDocsxProveedor frameS1 = new frmInternaVerDocsxProveedor("");
        frameS1.setVisible(true);
        JDesktopProv.add(frameS1);

        frmInternaVerDocsxDia frameS2 = new frmInternaVerDocsxDia("");
        frameS2.setVisible(true);
        JDesktopDia.add(frameS2);
    }
}

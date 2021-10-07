package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Access.*;
import modelo.*;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JToolBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JTree;
import java.awt.Button;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class frmQuery extends clsMensajero{

	private JFrame frmQuery;
	private JTextField txfQuery;
	private JTextField txfUsuario;
	private JPasswordField txfPassword;
	clsDatabase varDatabase = new clsDatabase();
	private PaisModel varPaisModel;
	private PaisDAO varPaisDAO = new PaisDAO();
	private String varTexto = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQuery window = new frmQuery();
					window.frmQuery.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmQuery() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		
		// frmQuery
		frmQuery = new JFrame();
		frmQuery.setResizable(false);
		frmQuery.setTitle("MVC Java - Oracle (Query)");
		frmQuery.setBackground(Color.LIGHT_GRAY);
		frmQuery.setBounds(100, 100, 900, 350);
		frmQuery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JLabel
		JLabel lblStatus = new JLabel("No conectado a la base de datos");
		JLabel lblUsuario = new JLabel("Usuario");
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		JLabel lblTabla = new JLabel("Tabla");
		JLabel lblOpcion = new JLabel("Opcion");
		
		// txfQuery
		txfQuery = new JTextField();
		txfQuery.requestFocus();
		txfQuery.setBackground(SystemColor.inactiveCaptionBorder);
		txfQuery.setEnabled(false);
		txfQuery.setToolTipText("");
		txfQuery.setColumns(10);

		// txfUsuario
		txfUsuario = new JTextField();
		txfUsuario.setBackground(SystemColor.inactiveCaption);
		txfUsuario.setText("HojaDeVida");
		txfUsuario.setToolTipText("Usuario");
		txfUsuario.setColumns(10);

		// txfPassword
		txfPassword = new JPasswordField();
		txfPassword.setBackground(SystemColor.inactiveCaption);
		txfPassword.setToolTipText("Contrase\u00F1a");
				
		// btnExecute
		JButton btnExecute = new JButton("Execute");
		btnExecute.setBackground(SystemColor.inactiveCaption);
		btnExecute.setEnabled(false);
		
		// btnConectar
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setBackground(SystemColor.inactiveCaption);
		
		// cbTabla
		JComboBox cbTabla = new JComboBox();
		cbTabla.setEnabled(false);
		cbTabla.setToolTipText("Seleccione la tabla");
		cbTabla.setModel(new DefaultComboBoxModel(new String[] {"-", "Pais", "Departamento", "Municipio"}));
		cbTabla.setBackground(SystemColor.inactiveCaption);
		
		// cbOpcion
		JComboBox cbOpcion = new JComboBox();
		cbOpcion.setEnabled(false);
		cbOpcion.setModel(new DefaultComboBoxModel(new String[] {"-", "Insert", "Update", "Delete", "Select"}));
		cbOpcion.setBackground(SystemColor.inactiveCaption);
		
		// JTextArea
		JTextArea textArea = new JTextArea();
		
		// Actions
		frmQuery.getContentPane().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblStatus.requestFocus();
			}
		});
		btnConectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(varDatabase.connect(txfUsuario.getText(), new String(txfPassword.getPassword()))) {
					txfQuery.setEnabled(true);
					cbTabla.setEnabled(true);
					cbOpcion.setEnabled(true);
					btnExecute.setEnabled(true);
				}
				lblStatus.setText(clsMensajero.darMensaje());
			}
		});
		btnExecute.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cbTabla.getSelectedIndex() == 1) {
					if (cbOpcion.getSelectedIndex() == 1) {
						varPaisModel = new PaisModel(1, "Estados Unidos");
						varPaisDAO.setVarDatabase(varDatabase);
						varPaisDAO.agregarPais(varPaisModel);
						lblStatus.setText(atrMensaje);
					} else if(cbOpcion.getSelectedIndex() == 2) {
						varPaisModel = new PaisModel(1, "United States");
						varPaisDAO.setVarDatabase(varDatabase);
						varPaisDAO.actualizarPais(varPaisModel);
						lblStatus.setText(atrMensaje);
					} else if (cbOpcion.getSelectedIndex() == 4) {
						varPaisDAO.setVarDatabase(varDatabase);
						for (PaisModel iPais : varPaisDAO.obtenerPaises()) {
							varTexto += "Codigo: " + iPais.getPAI_CODIGO() + "\nNombre: " + iPais.getPAI_NOMBRE() + "\n------------------------------\n";
						}
						textArea.setText(varTexto);
						lblStatus.setText(atrMensaje);
					}
				}
			}
		});
		
		// Group Layout
		GroupLayout groupLayout = new GroupLayout(frmQuery.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
						.addComponent(lblStatus, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblUsuario)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblPassword)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txfPassword, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
							.addComponent(lblTabla)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbTabla, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblOpcion)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbOpcion, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(txfQuery, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExecute, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword)
						.addComponent(txfPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbOpcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOpcion)
						.addComponent(cbTabla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTabla))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txfQuery, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblStatus)
					.addContainerGap())
		);
		frmQuery.getContentPane().setLayout(groupLayout);
	}
}

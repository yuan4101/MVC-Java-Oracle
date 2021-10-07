package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modelo.clsDatabase;
import modelo.clsMensajero;

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

public class frmQuery {

	private JFrame frmQuery;
	private JTextField txfQuery;
	private JTextField txfUsuario;
	private JPasswordField txfPassword;

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
	private void initialize() {
		
		clsDatabase varDatabase = new clsDatabase();
		
		frmQuery = new JFrame();
		frmQuery.setResizable(false);
		frmQuery.setTitle("MVC Java - Oracle (Query)");
		frmQuery.setBackground(Color.LIGHT_GRAY);
		frmQuery.setBounds(100, 100, 850, 350);
		frmQuery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txfQuery = new JTextField();
		txfQuery.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txfQuery.setText("PAI_CODIGO, PAI_NOMBRE");
			}
			@Override
			public void focusGained(FocusEvent e) {
				txfQuery.setText(null);
			}
		});
		txfQuery.setBackground(SystemColor.inactiveCaptionBorder);
		txfQuery.setEnabled(false);
		txfQuery.setToolTipText("");
		txfQuery.setColumns(10);
		
		JLabel lblStatus = new JLabel("No conectado a la base de datos");
		JLabel lblUsuario = new JLabel("Usuario");
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.setBackground(SystemColor.inactiveCaption);
		btnExecute.setEnabled(false);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setBackground(SystemColor.inactiveCaption);
		btnConectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(varDatabase.connect(txfUsuario.getText(), new String(txfPassword.getPassword()))) {
					txfQuery.setEnabled(true);
					btnExecute.setEnabled(true);
				}
				lblStatus.setText(clsMensajero.darMensaje());
			}
		});
		
		frmQuery.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStatus.requestFocus();
			}
		});
		
		txfUsuario = new JTextField();
		txfUsuario.setBackground(SystemColor.inactiveCaption);
		txfUsuario.setText("HojaDeVida");
		txfUsuario.setToolTipText("Usuario");
		txfUsuario.setColumns(10);
		
		txfPassword = new JPasswordField();
		txfPassword.setBackground(SystemColor.inactiveCaption);
		txfPassword.setToolTipText("Contrase\u00F1a");
		
		JTextArea textArea = new JTextArea();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Seleccione la tabla");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-", "Pais", "Departamento", "Municipio"}));
		comboBox.setBackground(SystemColor.inactiveCaption);
		
		JLabel lblTabla = new JLabel("Tabla");
		
		JLabel lblOpcion = new JLabel("Opcion");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-", "Insert", "Update", "Delete", "Select"}));
		comboBox_1.setBackground(SystemColor.inactiveCaption);
		
		
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
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblOpcion)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOpcion)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Access.PaisDAO;
import Access.clsMensajero;
import modelo.PaisModel;
import modelo.clsDatabase;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class frmMain extends clsMensajero{

	private JFrame frmMain;
	private JTextField txfUsuario;
	private JPasswordField txfPassword;
	clsDatabase varDatabase = new clsDatabase();
	private PaisModel varPaisModel;
	private PaisDAO varPaisDAO = new PaisDAO();
	private String varTexto = "";
	private String varConexionExitosa;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain window = new frmMain();
					window.frmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// frmMain
		frmMain = new JFrame();
		frmMain.setBackground(Color.LIGHT_GRAY);
		frmMain.setTitle("MVC Java - Oracle");
		frmMain.setResizable(false);
		frmMain.setBounds(100, 100, 900, 500);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JLabel
		JLabel lblStatusCRUD = new JLabel("No conectado a la base de datos");
		JLabel lblConsulta1 = new JLabel("No conectado a la base de datos");
		JLabel lblConsulta2 = new JLabel("No conectado a la base de datos");
		JLabel lblConsulta3 = new JLabel("No conectado a la base de datos");
		JLabel lblConsulta4 = new JLabel("No conectado a la base de datos");
		JLabel lblUsuario = new JLabel("Usuario");
		JLabel lblPassword = new JLabel("Contrase\u00F1a");

		// tabbedPane
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmMain.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		// txfUsuario
		txfUsuario = new JTextField();
		txfUsuario.setToolTipText("Usuario");
		txfUsuario.setText("HojaDeVida");
		txfUsuario.setColumns(10);
		txfUsuario.setBackground(SystemColor.inactiveCaption);

		// txtPassword
		txfPassword = new JPasswordField();
		txfPassword.setToolTipText("Contrase\u00F1a");
		txfPassword.setBackground(SystemColor.inactiveCaption);

		// btnConectar
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setBackground(SystemColor.inactiveCaption);

		// panCRUD
		JPanel panCRUD = new JPanel();
		panCRUD.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("CRUD", null, panCRUD, null);

		// panConsulta1
		JPanel panConsulta1 = new JPanel();
		panConsulta1.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Consulta 1", null, panConsulta1, null);

		// panConsulta2
		JPanel panConsulta2 = new JPanel();
		panConsulta2.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Consulta 2", null, panConsulta2, null);

		// panConsulta3
		JPanel panConsulta3 = new JPanel();
		panConsulta3.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Consulta 3", null, panConsulta3, null);

		// panConsulta4
		JPanel panConsulta4 = new JPanel();
		panConsulta4.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Consulta 4", null, panConsulta4, null);
		
		// Menu
		JMenuBar menuBar = new JMenuBar();
		frmMain.setJMenuBar(menuBar);
		JPanel panMenu = new JPanel();
		menuBar.add(panMenu);

		// gl_panCRUD
		GroupLayout gl_panCRUD = new GroupLayout(panCRUD);
		gl_panCRUD.setHorizontalGroup(gl_panCRUD.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panCRUD.createSequentialGroup().addContainerGap()
						.addComponent(lblStatusCRUD, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE).addGap(712)));
		gl_panCRUD.setVerticalGroup(
				gl_panCRUD.createParallelGroup(Alignment.TRAILING).addGroup(gl_panCRUD.createSequentialGroup()
						.addContainerGap(381, Short.MAX_VALUE).addComponent(lblStatusCRUD).addContainerGap()));
		panCRUD.setLayout(gl_panCRUD);

		// gl_panConsulta1
		GroupLayout gl_panConsulta1 = new GroupLayout(panConsulta1);
		gl_panConsulta1.setHorizontalGroup(
			gl_panConsulta1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panConsulta1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsulta1, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addGap(702))
		);
		gl_panConsulta1.setVerticalGroup(
			gl_panConsulta1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panConsulta1.createSequentialGroup()
					.addContainerGap(381, Short.MAX_VALUE)
					.addComponent(lblConsulta1)
					.addContainerGap())
		);
		panConsulta1.setLayout(gl_panConsulta1);
		
		// gl_panConsulta2
		GroupLayout gl_panConsulta2 = new GroupLayout(panConsulta2);
		gl_panConsulta2.setHorizontalGroup(
			gl_panConsulta2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panConsulta2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsulta2, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addGap(702))
		);
		gl_panConsulta2.setVerticalGroup(
			gl_panConsulta2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panConsulta2.createSequentialGroup()
					.addContainerGap(381, Short.MAX_VALUE)
					.addComponent(lblConsulta2)
					.addContainerGap())
		);
		panConsulta2.setLayout(gl_panConsulta2);
		
		//gl_panConsulta3
		GroupLayout gl_panConsulta3 = new GroupLayout(panConsulta3);
		gl_panConsulta3.setHorizontalGroup(
			gl_panConsulta3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panConsulta3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsulta3, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addGap(702))
		);
		gl_panConsulta3.setVerticalGroup(
			gl_panConsulta3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panConsulta3.createSequentialGroup()
					.addContainerGap(381, Short.MAX_VALUE)
					.addComponent(lblConsulta3)
					.addContainerGap())
		);
		panConsulta3.setLayout(gl_panConsulta3);
		
		// gl_panConsulta4
		GroupLayout gl_panConsulta4 = new GroupLayout(panConsulta4);
		gl_panConsulta4.setHorizontalGroup(
			gl_panConsulta4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panConsulta4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsulta4, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addGap(702))
		);
		gl_panConsulta4.setVerticalGroup(
			gl_panConsulta4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panConsulta4.createSequentialGroup()
					.addContainerGap(381, Short.MAX_VALUE)
					.addComponent(lblConsulta4)
					.addContainerGap())
		);
		panConsulta4.setLayout(gl_panConsulta4);
		
		// gl_panMenu
		GroupLayout gl_panMenu = new GroupLayout(panMenu);
		gl_panMenu.setHorizontalGroup(
			gl_panMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panMenu.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txfPassword, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(356, Short.MAX_VALUE))
		);
		gl_panMenu.setVerticalGroup(
			gl_panMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panMenu.createParallelGroup(Alignment.BASELINE, false)
					.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(txfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblPassword)
					.addComponent(txfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		);
		panMenu.setLayout(gl_panMenu);
		
		// Actions
		btnConectar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(varDatabase.connect(txfUsuario.getText(), new String(txfPassword.getPassword()))) {
					varConexionExitosa = clsMensajero.darMensaje();
				}
				lblStatusCRUD.setText(clsMensajero.darMensaje());
				lblConsulta1.setText(clsMensajero.darMensaje());
			}
		});
	}
}

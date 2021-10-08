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

import Access.clsConnection;
import Access.clsMensajero;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Toolkit;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;

public class frmMain extends clsMensajero{

	private JFrame frmMain;
	private JTextField txfUsuario;
	private JPasswordField txfPassword;
	clsConnection varDatabase = new clsConnection();
	private String varTexto = "";
	private String varConexionExitosa;
	private JTextField txtfCRUD;
	

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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {

		// frmMain
		frmMain = new JFrame();
		frmMain.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\frmMainIcon.png"));
		frmMain.setBackground(Color.LIGHT_GRAY);
		frmMain.setTitle("MVC Java - Oracle");
		frmMain.setResizable(false);
		frmMain.setBounds(100, 100, 900, 500);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JLabel
		JLabel lblStatusCRUD = new JLabel("No conectado a la base de datos");
		JLabel lblStatusConsulta4 = new JLabel("No conectado a la base de datos");
		JLabel lblUsuario = new JLabel("Usuario");
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		JLabel lblOpcion = new JLabel("Opcion");
		lblOpcion.setEnabled(false);

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
		JLabel lblStatusConsulta1 = new JLabel("No conectado a la base de datos");
		
				// panConsulta1
				JPanel panConsulta1 = new JPanel();
				panConsulta1.setBackground(SystemColor.inactiveCaption);
				tabbedPane.addTab("Consulta 1", null, panConsulta1, null);
				
				JLabel lblConsulta1_1 = new JLabel("Mostrar el nombre de los departamentos del pais con codigo 57");
				lblConsulta1_1.setEnabled(false);
				lblConsulta1_1.setToolTipText("");
				
				JLabel lblConsulta1_2 = new JLabel("Mostrar el codigo y el nombre de los paises con codigo mayor a 55");
				lblConsulta1_2.setEnabled(false);
				lblConsulta1_2.setToolTipText("");
				
				JButton btnConsulta1_1 = new JButton("Execute");
				btnConsulta1_1.setEnabled(false);
				
				btnConsulta1_1.setBackground(SystemColor.inactiveCaptionBorder);
				
				JButton btnConsulta1_2 = new JButton("Execute");
				btnConsulta1_2.setEnabled(false);
				
				btnConsulta1_2.setBackground(SystemColor.inactiveCaptionBorder);
				
				JScrollPane spConsulta1 = new JScrollPane();
				
						// gl_panConsulta1
						GroupLayout gl_panConsulta1 = new GroupLayout(panConsulta1);
						gl_panConsulta1.setHorizontalGroup(
							gl_panConsulta1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panConsulta1.createSequentialGroup()
									.addContainerGap(199, Short.MAX_VALUE)
									.addGroup(gl_panConsulta1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblConsulta1_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblConsulta1_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(40)
									.addGroup(gl_panConsulta1.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnConsulta1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnConsulta1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addContainerGap(275, Short.MAX_VALUE))
								.addGroup(gl_panConsulta1.createSequentialGroup()
									.addGap(139)
									.addComponent(spConsulta1, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(167, Short.MAX_VALUE))
								.addGroup(gl_panConsulta1.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblStatusConsulta1, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
									.addContainerGap())
						);
						gl_panConsulta1.setVerticalGroup(
							gl_panConsulta1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panConsulta1.createSequentialGroup()
									.addGap(21)
									.addGroup(gl_panConsulta1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblConsulta1_1)
										.addComponent(btnConsulta1_1))
									.addGap(18)
									.addGroup(gl_panConsulta1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblConsulta1_2)
										.addComponent(btnConsulta1_2))
									.addGap(38)
									.addComponent(spConsulta1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
									.addGap(53)
									.addComponent(lblStatusConsulta1)
									.addContainerGap())
						);
						
						JTextArea txtaConsulta1 = new JTextArea();
						txtaConsulta1.setEnabled(false);
						spConsulta1.setViewportView(txtaConsulta1);
						txtaConsulta1.setEditable(false);
						txtaConsulta1.setBackground(new Color(244, 247, 252));
						panConsulta1.setLayout(gl_panConsulta1);
						
						JLabel lblStatusConsulta2 = new JLabel("No conectado a la base de datos");
		
				// panConsulta2
				JPanel panConsulta2 = new JPanel();
				panConsulta2.setBackground(SystemColor.inactiveCaption);
				tabbedPane.addTab("Consulta 2", null, panConsulta2, null);
				
				JLabel lblConsulta2_1 = new JLabel("Mostrar el nombre de los departamentos y el nombre de sus municipios");
				lblConsulta2_1.setEnabled(false);
				lblConsulta2_1.setToolTipText("");
				
				JButton btnConsulta2_1 = new JButton("Execute");
				btnConsulta2_1.setEnabled(false);
				
				btnConsulta2_1.setBackground(SystemColor.inactiveCaptionBorder);
				
				JLabel lblConsulta2_2 = new JLabel("Mostrar el nombre de los paises y el nombre de sus departamentos");
				lblConsulta2_2.setEnabled(false);
				lblConsulta2_2.setToolTipText("");
				
				JButton btnConsulta2_2 = new JButton("Execute");
				btnConsulta2_2.setEnabled(false);
				
				btnConsulta2_2.setBackground(SystemColor.inactiveCaptionBorder);
				
				JLabel lblConsulta2_3 = new JLabel("Mostrar todos los paises, nombre de los departamentos y nombre de los municipios respectivamente");
				lblConsulta2_3.setEnabled(false);
				lblConsulta2_3.setToolTipText("");
				
				JButton btnConsulta2_3 = new JButton("Execute");
				btnConsulta2_3.setEnabled(false);
				
				btnConsulta2_3.setBackground(SystemColor.inactiveCaptionBorder);
				
				JScrollPane spConsulta2 = new JScrollPane();
				
				// gl_panConsulta2
				GroupLayout gl_panConsulta2 = new GroupLayout(panConsulta2);
				gl_panConsulta2.setHorizontalGroup(
					gl_panConsulta2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panConsulta2.createSequentialGroup()
							.addGap(82)
							.addGroup(gl_panConsulta2.createParallelGroup(Alignment.LEADING)
								.addComponent(spConsulta2, GroupLayout.PREFERRED_SIZE, 662, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panConsulta2.createSequentialGroup()
									.addGroup(gl_panConsulta2.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panConsulta2.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblConsulta2_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblConsulta2_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
										.addComponent(lblConsulta2_1, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panConsulta2.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnConsulta2_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnConsulta2_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnConsulta2_1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
									.addGap(146)))
							.addContainerGap())
						.addGroup(gl_panConsulta2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblStatusConsulta2, GroupLayout.PREFERRED_SIZE, 869, GroupLayout.PREFERRED_SIZE))
				);
				gl_panConsulta2.setVerticalGroup(
					gl_panConsulta2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panConsulta2.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_panConsulta2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConsulta2_1)
								.addComponent(btnConsulta2_1))
							.addGap(18)
							.addGroup(gl_panConsulta2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConsulta2_2)
								.addComponent(btnConsulta2_2))
							.addGap(18)
							.addGroup(gl_panConsulta2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConsulta2_3)
								.addComponent(btnConsulta2_3))
							.addGap(34)
							.addComponent(spConsulta2, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(lblStatusConsulta2)
							.addContainerGap())
				);
				
				JTextArea txtaConsulta2 = new JTextArea();
				txtaConsulta2.setEnabled(false);
				txtaConsulta2.setEditable(false);
				txtaConsulta2.setBackground(SystemColor.inactiveCaptionBorder);
				spConsulta2.setViewportView(txtaConsulta2);
				panConsulta2.setLayout(gl_panConsulta2);
		JLabel lblStatusConsulta3 = new JLabel("No conectado a la base de datos");
		
				// panConsulta3
				JPanel panConsulta3 = new JPanel();
				panConsulta3.setBackground(SystemColor.inactiveCaption);
				tabbedPane.addTab("Consulta 3", null, panConsulta3, null);
				
				JLabel lblConsulta3_1 = new JLabel("Mostrar el codigo y nombre de los departamentos del pais con nombre \"Colombia\"");
				lblConsulta3_1.setEnabled(false);
				lblConsulta3_1.setToolTipText("");
				
				JLabel lblConsulta3_2 = new JLabel("Mostrar el nombre de los municipios del departamento con nombre \"Cauca\"");
				lblConsulta3_2.setEnabled(false);
				lblConsulta3_2.setToolTipText("");
				
				JButton btnConsulta3_1 = new JButton("Execute");
				btnConsulta3_1.setEnabled(false);
				
				btnConsulta3_1.setBackground(SystemColor.inactiveCaptionBorder);
				
				JButton btnConsulta3_2 = new JButton("Execute");
				btnConsulta3_2.setEnabled(false);
				
				btnConsulta3_2.setBackground(SystemColor.inactiveCaptionBorder);
				
				JScrollPane spConsulta3 = new JScrollPane();
				
				//gl_panConsulta3
				GroupLayout gl_panConsulta3 = new GroupLayout(panConsulta3);
				gl_panConsulta3.setHorizontalGroup(
					gl_panConsulta3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panConsulta3.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblStatusConsulta3, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
							.addGap(702))
						.addGroup(gl_panConsulta3.createSequentialGroup()
							.addGap(59)
							.addGroup(gl_panConsulta3.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblConsulta3_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblConsulta3_1, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
							.addGap(78)
							.addGroup(gl_panConsulta3.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnConsulta3_1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
								.addComponent(btnConsulta3_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap(223, Short.MAX_VALUE))
						.addGroup(gl_panConsulta3.createSequentialGroup()
							.addGap(125)
							.addComponent(spConsulta3, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(181, Short.MAX_VALUE))
				);
				gl_panConsulta3.setVerticalGroup(
					gl_panConsulta3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panConsulta3.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_panConsulta3.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnConsulta3_1)
								.addComponent(lblConsulta3_1))
							.addGap(30)
							.addGroup(gl_panConsulta3.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnConsulta3_2)
								.addComponent(lblConsulta3_2))
							.addGap(18)
							.addComponent(spConsulta3, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
							.addComponent(lblStatusConsulta3)
							.addContainerGap())
				);
				
				JTextArea txtaConsulta3 = new JTextArea();
				txtaConsulta3.setEnabled(false);
				txtaConsulta3.setEditable(false);
				txtaConsulta3.setBackground(SystemColor.inactiveCaptionBorder);
				spConsulta3.setViewportView(txtaConsulta3);
				panConsulta3.setLayout(gl_panConsulta3);

		// panConsulta4
		JPanel panConsulta4 = new JPanel();
		panConsulta4.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Consulta 4", null, panConsulta4, null);
		
		// Menu
		JMenuBar menuBar = new JMenuBar();
		frmMain.setJMenuBar(menuBar);
		JPanel panMenu = new JPanel();
		menuBar.add(panMenu);
		
		JLabel lblTabla = new JLabel("Tabla");
		lblTabla.setEnabled(false);
		
		JComboBox cbTabla = new JComboBox();
		cbTabla.setEnabled(false);
		cbTabla.setBackground(SystemColor.inactiveCaptionBorder);
		cbTabla.setModel(new DefaultComboBoxModel(new String[] {"-", "Pais", "Departamento", "Municipio"}));
		
		
		JComboBox cbOpcion = new JComboBox();
		cbOpcion.setEnabled(false);
		cbOpcion.setBackground(SystemColor.inactiveCaptionBorder);
		cbOpcion.setModel(new DefaultComboBoxModel(new String[] {"-", "Insertar", "Modificar", "Eliminar"}));
		
		txtfCRUD = new JTextField();
		txtfCRUD.setEnabled(false);
		txtfCRUD.setBackground(SystemColor.inactiveCaptionBorder);
		txtfCRUD.setColumns(10);
		
		JLabel lblTxtfCRUD = new JLabel(" ");
		
		JButton btnCRUD = new JButton("Execute");
		btnCRUD.setEnabled(false);
		btnCRUD.setBackground(SystemColor.inactiveCaptionBorder);
		
		JLabel lblInfoCRUD = new JLabel("(Separar los datos por comas, usar comillas simples para valores de texto)");
		lblInfoCRUD.setEnabled(false);

		// gl_panCRUD
		GroupLayout gl_panCRUD = new GroupLayout(panCRUD);
		gl_panCRUD.setHorizontalGroup(
			gl_panCRUD.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panCRUD.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStatusCRUD, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
					.addGap(633))
				.addGroup(gl_panCRUD.createSequentialGroup()
					.addGap(41)
					.addComponent(lblTxtfCRUD, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
					.addGap(254))
				.addGroup(gl_panCRUD.createSequentialGroup()
					.addGroup(gl_panCRUD.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panCRUD.createSequentialGroup()
							.addGap(136)
							.addGroup(gl_panCRUD.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panCRUD.createSequentialGroup()
									.addComponent(lblTabla, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(cbTabla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(80)
									.addComponent(lblOpcion)
									.addGap(18)
									.addComponent(cbOpcion, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtfCRUD, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addComponent(btnCRUD))
						.addGroup(gl_panCRUD.createSequentialGroup()
							.addGap(185)
							.addComponent(lblInfoCRUD)))
					.addContainerGap(241, Short.MAX_VALUE))
		);
		gl_panCRUD.setVerticalGroup(
			gl_panCRUD.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panCRUD.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_panCRUD.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOpcion)
						.addComponent(cbOpcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbTabla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTabla))
					.addGap(60)
					.addComponent(lblInfoCRUD)
					.addGap(18)
					.addGroup(gl_panCRUD.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtfCRUD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCRUD))
					.addGap(18)
					.addComponent(lblTxtfCRUD)
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addComponent(lblStatusCRUD)
					.addContainerGap())
		);
		panCRUD.setLayout(gl_panCRUD);
		
		JLabel lblConsulta4_1 = new JLabel("Agregar columna Direccion a la tabla Universidad");
		lblConsulta4_1.setEnabled(false);
		lblConsulta4_1.setToolTipText("");
		
		JLabel lblConsulta4_2 = new JLabel("Elimiar la columna Direccion de la tabla Universidad");
		lblConsulta4_2.setEnabled(false);
		lblConsulta4_2.setToolTipText("");
		
		JButton btnConsulta4_1 = new JButton("Execute");
		btnConsulta4_1.setEnabled(false);
		
		btnConsulta4_1.setBackground(SystemColor.inactiveCaptionBorder);
		
		JButton btnConsulta4_2 = new JButton("Execute");
		btnConsulta4_2.setEnabled(false);
		
		btnConsulta4_2.setBackground(SystemColor.inactiveCaptionBorder);
		
		JScrollPane spConsulta4 = new JScrollPane();
		
		// gl_panConsulta4
		GroupLayout gl_panConsulta4 = new GroupLayout(panConsulta4);
		gl_panConsulta4.setHorizontalGroup(
			gl_panConsulta4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panConsulta4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStatusConsulta4, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addGap(702))
				.addGroup(gl_panConsulta4.createSequentialGroup()
					.addGap(134)
					.addGroup(gl_panConsulta4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblConsulta4_1, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConsulta4_2, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(gl_panConsulta4.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnConsulta4_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConsulta4_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(276, Short.MAX_VALUE))
				.addGroup(gl_panConsulta4.createSequentialGroup()
					.addGap(119)
					.addComponent(spConsulta4, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_panConsulta4.setVerticalGroup(
			gl_panConsulta4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panConsulta4.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panConsulta4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsulta4_1)
						.addComponent(btnConsulta4_1))
					.addGap(36)
					.addGroup(gl_panConsulta4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsulta4_2)
						.addComponent(btnConsulta4_2))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(spConsulta4, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblStatusConsulta4)
					.addContainerGap())
		);
		
		JTextArea txtaConsulta4 = new JTextArea();
		txtaConsulta4.setEnabled(false);
		txtaConsulta4.setEditable(false);
		txtaConsulta4.setBackground(SystemColor.inactiveCaptionBorder);
		spConsulta4.setViewportView(txtaConsulta4);
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
					// panCRUD
					lblTabla.setEnabled(true);
					cbTabla.setEnabled(true);
					lblOpcion.setEnabled(true);
					cbOpcion.setEnabled(true);
					lblInfoCRUD.setEnabled(true);
					txtfCRUD.setEnabled(true);
					btnCRUD.setEnabled(true);
					
					// panConsulta1
					lblConsulta1_1.setEnabled(true);
					btnConsulta1_1.setEnabled(true);
					lblConsulta1_2.setEnabled(true);
					btnConsulta1_2.setEnabled(true);
					txtaConsulta1.setEnabled(true);
					
					// panConsulta2
					lblConsulta2_1.setEnabled(true);
					btnConsulta2_1.setEnabled(true);
					lblConsulta2_2.setEnabled(true);
					btnConsulta2_2.setEnabled(true);
					lblConsulta2_3.setEnabled(true);
					btnConsulta2_3.setEnabled(true);
					txtaConsulta2.setEnabled(true);
					
					// panConsulta3
					lblConsulta3_1.setEnabled(true);
					btnConsulta3_1.setEnabled(true);
					lblConsulta3_2.setEnabled(true);
					btnConsulta3_2.setEnabled(true);
					txtaConsulta3.setEnabled(true);
					
					// panConsulta4
					lblConsulta4_1.setEnabled(true);
					btnConsulta4_1.setEnabled(true);
					lblConsulta4_2.setEnabled(true);
					btnConsulta4_2.setEnabled(true);
					txtaConsulta4.setEnabled(true);
				} else {
					// panCRUD
					lblTabla.setEnabled(false);
					cbTabla.setEnabled(false);
					lblOpcion.setEnabled(false);
					cbOpcion.setEnabled(false);
					lblInfoCRUD.setEnabled(false);
					txtfCRUD.setEnabled(false);
					btnCRUD.setEnabled(false);
					
					// panConsulta1
					lblConsulta1_1.setEnabled(false);
					btnConsulta1_1.setEnabled(false);
					lblConsulta1_2.setEnabled(false);
					btnConsulta1_2.setEnabled(false);
					txtaConsulta1.setEnabled(false);
					
					// panConsulta2
					lblConsulta2_1.setEnabled(false);
					btnConsulta2_1.setEnabled(false);
					lblConsulta2_2.setEnabled(false);
					btnConsulta2_2.setEnabled(false);
					lblConsulta2_3.setEnabled(false);
					btnConsulta2_3.setEnabled(false);
					txtaConsulta2.setEnabled(false);
					
					// panConsulta3
					lblConsulta3_1.setEnabled(false);
					btnConsulta3_1.setEnabled(false);
					lblConsulta3_2.setEnabled(false);
					btnConsulta3_2.setEnabled(false);
					txtaConsulta3.setEnabled(false);
					
					// panConsulta4
					lblConsulta4_1.setEnabled(false);
					btnConsulta4_1.setEnabled(false);
					lblConsulta4_2.setEnabled(false);
					btnConsulta4_2.setEnabled(false);
					txtaConsulta4.setEnabled(false);
				}
				lblStatusCRUD.setText(clsMensajero.darMensaje());
				lblStatusConsulta1.setText(clsMensajero.darMensaje());
				lblStatusConsulta2.setText(clsMensajero.darMensaje());
				lblStatusConsulta3.setText(clsMensajero.darMensaje());
				lblStatusConsulta4.setText(clsMensajero.darMensaje());
			}
		});
		cbOpcion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch (cbOpcion.getSelectedIndex()) {
				case 0:
					lblTxtfCRUD.setText(" ");
					break;
				case 1:
					lblTxtfCRUD.setText("Escriba los valores");
					break;
				case 2:
					lblTxtfCRUD.setText("Columna a buscar, valor de la columna de busqueda, Columna a cambiar, valor de la columna a cambiar");
					break;
				case 3:
					lblTxtfCRUD.setText("Escriba la Primary Key");
					break;
				}
			}
		});
		
		btnConsulta1_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					lblStatusConsulta1.setText(varConexionExitosa);
					varTexto = "";
					txtaConsulta1.setText(varTexto);
					String varSql = "SELECT DEP_NOMBRE FROM Departamento WHERE PAI_CODIGO = 57 ORDER BY DEP_NOMBRE";
					PreparedStatement varStatement = varDatabase.varConnection.prepareStatement(varSql);
					ResultSet varResultado = varStatement.executeQuery(varSql);
					varTexto += varSql + "\n";
					varTexto += "\nDepartamento\n------------------------------------------------------------------------------------------------------------------------\n";
					while (varResultado.next()) {
						varTexto += varResultado.getString("DEP_NOMBRE") + "\n";
					}
					txtaConsulta1.setText(varTexto);
				} catch (SQLException e1) {
					lblStatusConsulta1.setText("ERROR: " + e1.getMessage());
				}
			}
		});
		btnConsulta1_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					lblStatusConsulta1.setText(varConexionExitosa);
					varTexto = "";
					txtaConsulta1.setText(varTexto);
					String varSql = "SELECT * FROM Pais WHERE PAI_CODIGO > 55 ORDER BY PAI_CODIGO";
					PreparedStatement varStatement = varDatabase.varConnection.prepareStatement(varSql);
					ResultSet varResultado = varStatement.executeQuery(varSql);
					varTexto += varSql + "\n";
					varTexto += "\nCodigo\tPais\n------------------------------------------------------------------------------------------------------------------------\n";
					while (varResultado.next()) {
						varTexto += varResultado.getInt("PAI_CODIGO") + "\t" + varResultado.getString("PAI_NOMBRE") + "\n";
					}
					txtaConsulta1.setText(varTexto);
				} catch (SQLException e1) {
					lblStatusConsulta1.setText("ERROR: " + e1.getMessage());
				}
			}
		});
		btnConsulta2_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					lblStatusConsulta2.setText(varConexionExitosa);
					varTexto = "";
					txtaConsulta2.setText(varTexto);
					String varSql = "SELECT DEP_NOMBRE, MUN_NOMBRE FROM Departamento INNER JOIN Municipio ON Departamento.DEP_CODIGO = Municipio.DEP_CODIGO ORDER BY DEP_NOMBRE";
					PreparedStatement varStatement = varDatabase.varConnection.prepareStatement(varSql);
					ResultSet varResultado = varStatement.executeQuery(varSql);
					varTexto += varSql + "\n";
					varTexto += "\nDepartamento\t\tMunicipio\n------------------------------------------------------------------------------------------------------------------------\n";
					while (varResultado.next()) {
						varTexto += varResultado.getString("DEP_NOMBRE") + "\t\t" + varResultado.getString("MUN_NOMBRE") + "\n";
					}
					txtaConsulta2.setText(varTexto);
				} catch (SQLException e1) {
					lblStatusConsulta2.setText("ERROR: " + e1.getMessage());
				}
			}
		});
		btnConsulta2_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					lblStatusConsulta2.setText(varConexionExitosa);
					varTexto = "";
					txtaConsulta2.setText(varTexto);
					String varSql = "SELECT PAI_NOMBRE, DEP_NOMBRE FROM Pais INNER JOIN Departamento ON Pais.PAI_CODIGO = Departamento.PAI_CODIGO ORDER BY PAI_NOMBRE";
					PreparedStatement varStatement = varDatabase.varConnection.prepareStatement(varSql);
					ResultSet varResultado = varStatement.executeQuery(varSql);
					varTexto += varSql + "\n";
					varTexto += "\nPais\tDepartamento\n------------------------------------------------------------------------------------------------------------------------\n";
					while (varResultado.next()) {
						varTexto += varResultado.getString("PAI_NOMBRE") + "\t" + varResultado.getString("DEP_NOMBRE") + "\n";
					}
					txtaConsulta2.setText(varTexto);
				} catch (SQLException e1) {
					lblStatusConsulta2.setText("ERROR: " + e1.getMessage());
				}
			}
		});
		btnConsulta2_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					lblStatusConsulta2.setText(varConexionExitosa);
					varTexto = "";
					txtaConsulta2.setText(varTexto);
					String varSql = "SELECT PAI_NOMBRE, DEP_NOMBRE, MUN_NOMBRE FROM Pais INNER JOIN Departamento ON Pais.PAI_CODIGO = Departamento.PAI_CODIGO INNER JOIN Municipio ON Departamento.DEP_CODIGO = Municipio.DEP_CODIGO ORDER BY PAI_NOMBRE, DEP_NOMBRE, MUN_NOMBRE";
					PreparedStatement varStatement = varDatabase.varConnection.prepareStatement(varSql);
					ResultSet varResultado = varStatement.executeQuery(varSql);
					varTexto += varSql + "\n";
					varTexto += "\nPais\tDepartamento\t\tMunicipio\n------------------------------------------------------------------------------------------------------------------------\n";
					while (varResultado.next()) {
						varTexto += varResultado.getString("PAI_NOMBRE") + "\t" + varResultado.getString("DEP_NOMBRE") + "\t\t" + varResultado.getString("MUN_NOMBRE") + "\n";
					}
					txtaConsulta2.setText(varTexto);
				} catch (SQLException e1) {
					lblStatusConsulta2.setText("ERROR: " + e1.getMessage());
				}
			}
		});
		btnConsulta3_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					lblStatusConsulta3.setText(varConexionExitosa);
					varTexto = "";
					txtaConsulta3.setText(varTexto);
					String varSql = "SELECT * FROM Departamento WHERE Departamento.PAI_CODIGO = (SELECT PAI_CODIGO FROM Pais WHERE PAI_NOMBRE = 'Colombia')";
					PreparedStatement varStatement = varDatabase.varConnection.prepareStatement(varSql);
					ResultSet varResultado = varStatement.executeQuery(varSql);
					varTexto += varSql + "\n";
					varTexto += "\nCodigo\tDepartamento\n------------------------------------------------------------------------------------------------------------------------\n";
					while (varResultado.next()) {
						varTexto += varResultado.getString("DEP_CODIGO") + "\t" + varResultado.getString("DEP_NOMBRE") + "\n";
					}
					txtaConsulta3.setText(varTexto);
				} catch (SQLException e1) {
					lblStatusConsulta3.setText("ERROR: " + e1.getMessage());
				}
			}
		});
		btnConsulta3_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					lblStatusConsulta3.setText(varConexionExitosa);
					varTexto = "";
					txtaConsulta3.setText(varTexto);
					String varSql = "SELECT MUN_NOMBRE FROM Municipio WHERE Municipio.DEP_CODIGO = (SELECT DEP_CODIGO FROM Departamento WHERE DEP_NOMBRE = 'Cauca')";
					PreparedStatement varStatement = varDatabase.varConnection.prepareStatement(varSql);
					ResultSet varResultado = varStatement.executeQuery(varSql);
					varTexto += varSql + "\n";
					varTexto += "\nMunicipio\n------------------------------------------------------------------------------------------------------------------------\n";
					while (varResultado.next()) {
						varTexto += varResultado.getString("MUN_NOMBRE") + "\n";
					}
					txtaConsulta3.setText(varTexto);
				} catch (SQLException e1) {
					lblStatusConsulta3.setText("ERROR: " + e1.getMessage());
				}
			}
		});
		btnConsulta4_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					lblStatusConsulta4.setText(varConexionExitosa);
					varTexto = "";
					txtaConsulta4.setText(varTexto);
					String varSql = "ALTER TABLE Universidad ADD Direccion VARCHAR(20)";
					PreparedStatement varStatement = varDatabase.varConnection.prepareStatement(varSql);
					int varRowsAffected = varStatement.executeUpdate(varSql);
					varTexto += varSql + "\n\nTabla Universidad alterada";
					txtaConsulta4.setText(varTexto);
					lblStatusConsulta4.setText(varRowsAffected + " rows affected");
				} catch (SQLException e1) {
					lblStatusConsulta4.setText("ERROR: " + e1.getMessage());
				}
			}
		});
		btnConsulta4_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					lblStatusConsulta4.setText(varConexionExitosa);
					varTexto = "";
					txtaConsulta4.setText(varTexto);
					String varSql = "ALTER TABLE Universidad DROP COLUMN Direccion";
					PreparedStatement varStatement = varDatabase.varConnection.prepareStatement(varSql);
					int varRowsAffected = varStatement.executeUpdate(varSql);
					varTexto += varSql + "\n\nTabla Universidad alterada";
					txtaConsulta4.setText(varTexto);
					lblStatusConsulta4.setText(varRowsAffected + " rows affected");
				} catch (SQLException e1) {
					lblStatusConsulta4.setText("ERROR: " + e1.getMessage());
				}
			}
		});
		btnCRUD.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblStatusCRUD.setText(varConexionExitosa);
				int varOpOpcion = cbOpcion.getSelectedIndex();
				String[] varTxtfCRUDTexto = txtfCRUD.getText().split(",");
				String varSql = "";
				switch (cbTabla.getSelectedIndex()) {
				case 1: // Pais
					switch (varOpOpcion) {
					case 1:
						try {
							varSql = "INSERT INTO Pais(PAI_CODIGO, PAI_NOMBRE) VALUES('" + varTxtfCRUDTexto[0] + "', '" + varTxtfCRUDTexto[1] + "')";
							Statement varStatement = varDatabase.varConnection.createStatement();
							int varRowsAffected = varStatement.executeUpdate(varSql);
							lblStatusCRUD.setText(varRowsAffected + " rows affected");
						} catch (SQLException e1) {
							lblStatusCRUD.setText("ERROR: " + e1.getMessage());
						}
						break;
					case 2:
						try {
							varSql = "UPDATE Pais SET " + varTxtfCRUDTexto[2] + " = " + varTxtfCRUDTexto[3] + " WHERE " + varTxtfCRUDTexto[0] + " = " + varTxtfCRUDTexto[1];
							Statement varStatement = varDatabase.varConnection.createStatement();
							int varRowsAffected = varStatement.executeUpdate(varSql);
							lblStatusCRUD.setText(varRowsAffected + " rows affected");
						} catch (SQLException e1) {
							lblStatusCRUD.setText("ERROR: " + e1.getMessage());
						}
						break;
					case 3:
						try {
							varSql = "DELETE FROM Pais WHERE PAI_CODIGO = " + varTxtfCRUDTexto[0];
							Statement varStatement = varDatabase.varConnection.createStatement();
							int varRowsAffected = varStatement.executeUpdate(varSql);
							lblStatusCRUD.setText(varRowsAffected + " rows affected");
						} catch (SQLException e1) {
							lblStatusCRUD.setText("ERROR: " + e1.getMessage());
						}
						break;
					}
					break;
				case 2: // Departamento
					switch (varOpOpcion) {
					case 1:
						try {
							varSql = "INSERT INTO Departamento(DEP_CODIGO, DEP_NOMBRE, PAI_CODIGO) VALUES('" + varTxtfCRUDTexto[0] + "', '" + varTxtfCRUDTexto[1] + "', '" + varTxtfCRUDTexto[2] + "')";
							Statement varStatement = varDatabase.varConnection.createStatement();
							int varRowsAffected = varStatement.executeUpdate(varSql);
							lblStatusCRUD.setText(varRowsAffected + " rows affected");
						} catch (SQLException e1) {
							lblStatusCRUD.setText("ERROR: " + e1.getMessage());
						}
						break;
					case 2:
						try {
							varSql = "UPDATE Departamento SET " + varTxtfCRUDTexto[2] + " = " + varTxtfCRUDTexto[3] + " WHERE " + varTxtfCRUDTexto[0] + " = " + varTxtfCRUDTexto[1];
							Statement varStatement = varDatabase.varConnection.createStatement();
							int varRowsAffected = varStatement.executeUpdate(varSql);
							lblStatusCRUD.setText(varRowsAffected + " rows affected");
						} catch (SQLException e1) {
							lblStatusCRUD.setText("ERROR: " + e1.getMessage());
						}
						break;
					case 3:
						try {
							varSql = "DELETE FROM Departamento WHERE DEP_CODIGO = " + varTxtfCRUDTexto[0];
							Statement varStatement = varDatabase.varConnection.createStatement();
							int varRowsAffected = varStatement.executeUpdate(varSql);
							lblStatusCRUD.setText(varRowsAffected + " rows affected");
						} catch (SQLException e1) {
							lblStatusCRUD.setText("ERROR: " + e1.getMessage());
						}
						break;
					}
					break;
				case 3: //Municipio
					switch (varOpOpcion) {
					case 1:
						try {
							varSql = "INSERT INTO Municipio(MUN_CODIGO, MUN_NOMBRE, DEP_CODIGO) VALUES('" + varTxtfCRUDTexto[0] + "', '" + varTxtfCRUDTexto[1] + "', '" + varTxtfCRUDTexto[2] + "')";
							Statement varStatement = varDatabase.varConnection.createStatement();
							int varRowsAffected = varStatement.executeUpdate(varSql);
							lblStatusCRUD.setText(varRowsAffected + " rows affected");
						} catch (SQLException e1) {
							lblStatusCRUD.setText("ERROR: " + e1.getMessage());
						}
						break;
					case 2:
						try {
							varSql = "UPDATE Municipio SET " + varTxtfCRUDTexto[2] + " = " + varTxtfCRUDTexto[3] + " WHERE " + varTxtfCRUDTexto[0] + " = " + varTxtfCRUDTexto[1];
							Statement varStatement = varDatabase.varConnection.createStatement();
							int varRowsAffected = varStatement.executeUpdate(varSql);
							lblStatusCRUD.setText(varRowsAffected + " rows affected");
						} catch (SQLException e1) {
							lblStatusCRUD.setText("ERROR: " + e1.getMessage());
						}
						break;
					case 3:
						try {
							varSql = "DELETE FROM Municipio WHERE MUN_CODIGO = " + varTxtfCRUDTexto[0];
							Statement varStatement = varDatabase.varConnection.createStatement();
							int varRowsAffected = varStatement.executeUpdate(varSql);
							lblStatusCRUD.setText(varRowsAffected + " rows affected");
						} catch (SQLException e1) {
							lblStatusCRUD.setText("ERROR: " + e1.getMessage());
						}
						break;
					}
					break;
				}
			}
		});
	}
}

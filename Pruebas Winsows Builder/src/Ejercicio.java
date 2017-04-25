import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio window = new Ejercicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tfNombre = new JTextField();
		tfNombre.setColumns(10);

		tfApellido = new JTextField();
		tfApellido.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numCols = table.getModel().getColumnCount();
				Object[] fila = new Object[numCols];
				fila[0] = tfNombre.getText();
				fila[1] = tfApellido.getText();

				((DefaultTableModel) table.getModel()).addRow(fila);
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(
								Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(47)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 326,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, 121,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
												.addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, 121,
														GroupLayout.PREFERRED_SIZE)
												.addGap(59))))
						.addGroup(groupLayout.createSequentialGroup().addGap(55).addComponent(btnAadir).addGap(49)
								.addComponent(btnEliminar).addGap(36).addComponent(btnModificar)
								.addContainerGap(73, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addContainerGap(335, Short.MAX_VALUE).addComponent(btnSalir).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(37)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnAadir)
								.addComponent(btnEliminar).addComponent(btnModificar))
						.addGap(3).addComponent(btnSalir).addContainerGap()));

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Nombre", "Apellido" }));
		scrollPane.setViewportView(table);

		frame.getContentPane().setLayout(groupLayout);
	}
}

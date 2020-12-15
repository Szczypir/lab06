package Client;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Client.FClient.Client;

public class ClientTablePanel extends JPanel {
	private static final long serialVersionUID = -3763287887732310823L;
	private JTable table;

	public JTable getTable() {
		return table;
	}
	
	public ClientTablePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
	    List<Client> data = new ArrayList<Client>();
		table = new JTable();
		table.setModel(new ClientTableModel(data));
		scrollPane.setViewportView(table);
	}
}

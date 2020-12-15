package Taxi;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Taxi.FTaxi.Taxi;

public class TaxiTablePanel extends JPanel {
	private static final long serialVersionUID = -3763287887732310823L;
	private JTable table;

	public JTable getTable() {
		return table;
	}
	
	public TaxiTablePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
	    List<Taxi> data = new ArrayList<Taxi>();
		table = new JTable();
		table.setModel(new TaxiTableModel(data));
		scrollPane.setViewportView(table);
	}
}

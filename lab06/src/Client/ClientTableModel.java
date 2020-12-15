package Client;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import Client.FClient.Client;

public class ClientTableModel extends AbstractTableModel {
    
	private static final long serialVersionUID = 8970616837430913970L;
    private String[] columnNames = {
            "ID", "From", "To", "Time", "Accepted"
    };
    private List<Client> data = new ArrayList<Client>();
	
    public ClientTableModel(List<Client> data) {
		super();
		this.data = data;
	}
	
	public List<Client> getData() {
		return data;
	}

	public void setStationList(List<Client> data) {
		this.data = data;
	}

	public void add(Client client) {
		this.data.add(client);
		this.fireTableRowsInserted(data.size()-1, data.size());
	}
	public void removeRow(int row) {
		this.data.remove(row);
		this.fireTableRowsInserted(row, data.size());
	}
	public int getColumnCount() {
		return columnNames.length;
	}
	public int getRowCount() {
		return data.size();
	}
	public String getColumnName(int col) {
        return columnNames[col];
    }
    public Class<?> getColumnClass(int c){
    	return getValueAt(0,c).getClass();
    }
    public boolean isCellEditable(int row, int col) {
    	if (col==0) return false;
    	else return true;
    }
    public void setValueAt(Object value, int row, int col) {
    	if (col == 0){data.get(row).setId((int)value);
        }
        else if (col == 1) {data.get(row).setFrom((String)value);
        }
        else if (col == 2) {data.get(row).setTo((String)value);	
        }
        else if (col == 3) {data.get(row).setTime((String)value);	
        }
        else {data.get(row).getTaken();	
        }
    	this.fireTableCellUpdated(row, col);
    }
    public Object getValueAt(int row, int col) {
        if (col == 0){return data.get(row).getId();
        }
        else if (col == 1) {return data.get(row).getFrom();
        }
        else if (col == 2) {return data.get(row).getTo();	
        }
        else if (col == 3) {return data.get(row).getTime();	
        }
        else {return data.get(row).getTaken();	
        }
    }
}

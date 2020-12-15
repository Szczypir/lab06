package Taxi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import Client.FClient.Client;
import Taxi.FTaxi.Taxi;

public class TaxiTableModel extends AbstractTableModel {
    
	private static final long serialVersionUID = 8970616837430913970L;
    private String[] columnNames = {
            "ID", "Taken", "Client ID"
    };
    private List<Taxi> data = new ArrayList<Taxi>();
	
    public TaxiTableModel(List<Taxi> data) {
		super();
		this.data = data;
	}
	
	public List<Taxi> getData() {
		return data;
	}

	public void setStationList(List<Taxi> data) {
		this.data = data;
	}

	public void add(Taxi taxi) {
		this.data.add(taxi);
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
        else if (col == 1) {data.get(row).setTaken((Boolean)value);
        }
        else {data.get(row).setCurrentClient((Client)value);	
        }
    	this.fireTableCellUpdated(row, col);
    }
    public Object getValueAt(int row, int col) {
        if (col == 0){return data.get(row).getId();
        }
        else if (col == 1) {return data.get(row).getTaken();
        }
        else {return data.get(row).getCurrentClient();	
        }
    }
}

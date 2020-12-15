package Taxi;
import Client.FClient.*;
import lab06.Serializator;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FTaxi extends JFrame {

	private static final long serialVersionUID = -4994864113004125422L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FTaxi frame = new FTaxi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FTaxi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton accept = new JButton("Accept");
		accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		accept.setBounds(205, 42, 123, 19);
		contentPane.add(accept);
		
		JLabel time = new JLabel("time of arrival");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setBounds(15, 131, 114, 19);
		contentPane.add(time);
		
		JLabel end = new JLabel("end of the route");
		end.setHorizontalAlignment(SwingConstants.CENTER);
		end.setBounds(15, 74, 114, 19);
		contentPane.add(end);
		
		JLabel start = new JLabel("start of the route");
		start.setHorizontalAlignment(SwingConstants.CENTER);
		start.setBounds(15, 16, 123, 19);
		contentPane.add(start);
		
		JLabel confirmation = new JLabel("confirmation of acceptance");
		confirmation.setHorizontalAlignment(SwingConstants.CENTER);
		confirmation.setBounds(205, 19, 180, 13);
		contentPane.add(confirmation);
		
		JLabel time_1 = new JLabel("------------------------");
		time_1.setHorizontalAlignment(SwingConstants.CENTER);
		time_1.setBounds(15, 159, 114, 19);
		contentPane.add(time_1);
		
		JLabel end_1 = new JLabel("------------------");
		end_1.setHorizontalAlignment(SwingConstants.CENTER);
		end_1.setBounds(15, 103, 114, 19);
		contentPane.add(end_1);
		
		JLabel start_1 = new JLabel("-------------------");
		start_1.setHorizontalAlignment(SwingConstants.CENTER);
		start_1.setBounds(15, 45, 123, 19);
		contentPane.add(start_1);
		
		JButton decline = new JButton("Decline");
		decline.setBounds(205, 71, 123, 19);
		contentPane.add(decline);
		
		JButton endButton = new JButton("End route");
		endButton.setBounds(205, 131, 180, 47);
		contentPane.add(endButton);
	}
	public static class Taxi{
		private int id = 1;	
		private boolean taken = false;
		private Client currentClient = null;
		public Taxi() {
			super();
			Serializator<Integer> ser = new Serializator<Integer>();
		    List<Integer> ids = ser.Deserialization("ids.ser");
			this.id = ids.size()+1;
			ids.add(id);
			ser.Serialization("ids.ser", ids);
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public boolean getTaken() {
			return taken;
		}
		public void setTaken(boolean taken) {
			this.taken = taken;
		}
		public Client getCurrentClient() {
			return currentClient;
		}
		public void setCurrentClient(Client currentClient) {
			this.currentClient = currentClient;
		}
		
	}
}

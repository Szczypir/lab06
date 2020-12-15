package Client;

import java.awt.EventQueue;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lab06.Serializator;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class FClient extends JFrame {

	private static final long serialVersionUID = -1305742902876232741L;
	private JPanel contentPane;
	private JTextField startInput;
	private JTextField endInput;
	private JTextField timeInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FClient frame = new FClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		startInput = new JTextField();
		startInput.setBounds(10, 39, 110, 19);
		contentPane.add(startInput);
		startInput.setColumns(10);
		
		endInput = new JTextField();
		endInput.setBounds(10, 96, 110, 19);
		contentPane.add(endInput);
		endInput.setColumns(10);
		
		JLabel start = new JLabel("start of the route");
		start.setHorizontalAlignment(SwingConstants.CENTER);
		start.setBounds(10, 10, 110, 19);
		contentPane.add(start);
		
		JLabel end = new JLabel("end of the route");
		end.setHorizontalAlignment(SwingConstants.CENTER);
		end.setBounds(10, 68, 110, 19);
		contentPane.add(end);
		
		JLabel time = new JLabel("time of arrival");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setBounds(10, 125, 110, 19);
		contentPane.add(time);
		
		timeInput = new JTextField();
		timeInput.setColumns(10);
		timeInput.setBounds(10, 153, 110, 19);
		contentPane.add(timeInput);
		
		JLabel confirmation = new JLabel("confirmation of acceptance");
		confirmation.setHorizontalAlignment(SwingConstants.CENTER);
		confirmation.setBounds(170, 13, 180, 13);
		contentPane.add(confirmation);
		
		JLabel decision = new JLabel("------------------------------");
		decision.setHorizontalAlignment(SwingConstants.CENTER);
		decision.setBounds(170, 42, 180, 13);
		contentPane.add(decision);
		
		JButton send = new JButton("Send");
		send.setBounds(10, 182, 110, 19);
		contentPane.add(send);
	}
	public static class Client{
		private int id = 1;
		private Boolean taken = false;
		private String from = "";
		private String to = "";
		private LocalTime time = null;
		 
		public Client(Boolean taken, String from, String to, String time) throws IOException {
			super();
			Serializator<Integer> ser = new Serializator<Integer>();
		    List<Integer> ids = ser.Deserialization("ids.ser");
			this.id = ids.size()+1;
			ids.add(id);
			ser.Serialization("ids.ser", ids);
			this.taken = taken;
			this.from = from;
			this.to = to;
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
			this.time = LocalTime.parse(time,dtf);
		}
		public int getId() {
			return id;
		}
		void setId(int id) {
			this.id = id;
		}
		public Boolean getTaken() {
			return taken;
		}
		public void setTaken(Boolean taken) {
			this.taken = taken;
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public LocalTime getTime() {
			return time;
		}
		public void setTime(String time) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
			this.time = LocalTime.parse(time,dtf);
		}
	}
}

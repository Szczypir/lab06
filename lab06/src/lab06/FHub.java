package lab06;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.ClientTablePanel;

import javax.swing.JTable;
import java.awt.GridLayout;
import Taxi.TaxiTablePanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FHub extends JFrame {

	private JPanel contentPane;
	private JTextField inputClientID;
	private JTextField inputTaxiID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FHub frame = new FHub();
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
	public FHub() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TaxiTablePanel taxiTablePanel = new TaxiTablePanel();
		taxiTablePanel.setBounds(5, 5, 150, 170);
		contentPane.add(taxiTablePanel);
		
		JLabel lblNewLabel = new JLabel("Taxis");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		taxiTablePanel.add(lblNewLabel, BorderLayout.NORTH);
		
		ClientTablePanel clientTablePanel = new ClientTablePanel();
		clientTablePanel.setBounds(165, 5, 266, 170);
		contentPane.add(clientTablePanel);
		
		JLabel lblNewLabel_1 = new JLabel("Clients");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientTablePanel.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Send new Client");
		lblNewLabel_2.setBounds(15, 185, 140, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Client ID");
		lblNewLabel_3.setBounds(10, 208, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Taxi ID");
		lblNewLabel_4.setBounds(70, 208, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		inputClientID = new JTextField();
		inputClientID.setBounds(5, 234, 50, 19);
		contentPane.add(inputClientID);
		inputClientID.setColumns(10);
		
		inputTaxiID = new JTextField();
		inputTaxiID.setColumns(10);
		inputTaxiID.setBounds(65, 234, 50, 19);
		contentPane.add(inputTaxiID);
		
		JButton send = new JButton("Send");
		send.setBounds(125, 233, 55, 21);
		contentPane.add(send);
		
		JLabel sendTaxi = new JLabel("Taxi no. ");
		sendTaxi.setBounds(196, 185, 120, 13);
		contentPane.add(sendTaxi);
		
		JLabel sendClient = new JLabel("Client no.");
		sendClient.setBounds(196, 208, 120, 13);
		contentPane.add(sendClient);
		
		JLabel decision = new JLabel("Decision");
		decision.setBounds(196, 234, 120, 13);
		contentPane.add(decision);
	}
}

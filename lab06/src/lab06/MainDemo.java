package lab06;

import java.io.IOException;
import Client.FClient.Client;
import Taxi.FTaxi.Taxi;
public class MainDemo {
	public static void main(String[] args) {
		Client client = null;
		try {
			client = new Client(false, "S³owackiego 3", "Dworcowa 15", "15:33");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(client.getId());
		Taxi taxi = null;
		taxi = new Taxi();
		System.out.println(taxi.getId());
		Taxi taxi2 = null;
		taxi2 = new Taxi();
		System.out.println(taxi2.getId());
		taxi.setCurrentClient(client);
		System.out.println(taxi.getCurrentClient().getId());
		try{System.out.println(taxi2.getCurrentClient().getId());}
		catch(NullPointerException e){System.out.println("Brak pasa¿era");}
	}
}
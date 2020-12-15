package lab06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serializator<T>{
	public void Serialization(String filename, List<T> t) {
	    try {    
	        FileOutputStream file = new FileOutputStream(filename); 
	        ObjectOutputStream out = new ObjectOutputStream(file); 
	        out.writeObject(t);
	        out.close(); 
	        file.close(); 
	    }  catch(IOException ex) { 
	        System.out.println("Wyj¹tek IOException");
	    } 
	}
	public List<T> Deserialization(String filename) {
		List<T> t = new ArrayList<T>();
   	    try{    
	        FileInputStream file = new FileInputStream(filename); 
	        ObjectInputStream in = new ObjectInputStream(file); 
	        t = (List<T>)in.readObject();
	        in.close(); 
	        file.close(); 
	    } catch(IOException ex) { 
	    	try{ 
		    	FileOutputStream file = new FileOutputStream(filename); 
		        ObjectOutputStream out = new ObjectOutputStream(file); 
		        out.writeObject(new ArrayList<T>());
		        out.close(); 
		        file.close();
	    	}catch(IOException ioex) { 
		    	System.out.println("Wyj¹tek IOException");
	    	}
	    } catch(ClassNotFoundException e) { 
		    System.out.println("Wyj¹tek ClassNotFoundException"); 
		} 
	    return t;
	}
}


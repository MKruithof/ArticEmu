/**
 * 
 * @author Merijn
 * 
 */

import Storage.Database;

public class Artic {

	public static Database DatabaseConnection;
	
	public static void main(String[] args) {
		
		
		if (args.length < 1) {
			
			System.out.println("ArticEmu Rev 1.0\n"
					+ "Developed by Merijn K");
			
			System.out.println("------------------------------------\n");
			
			System.out.println("Trying to initialise BoneCP..");
			
			DatabaseConnection.Init();
		}

	}
	

}

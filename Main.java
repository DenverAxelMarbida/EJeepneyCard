package ejeepneyCard;

import java.util.Scanner;

//Menu Looping
public class Main {
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		EJeepneyCard card = new EJeepneyCard();
		
		
		int choice;

		do {
			System.out.println("\n\n\nWelcome To QC E-JEEPNEY Card!\n\n" + card.toString());
			System.out.println("\n>>>>> QC E-JEEPNEY Card Menu <<<<<\n");
			System.out.println("1. Create New Card");
			System.out.println("2. Load Money");
			System.out.println("3. Tap for Ride");
			System.out.println("4. Check Balance");
			System.out.println("5. Exit");
			System.out.print("\nEnter input: ");
			choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				card = new EJeepneyCard();
				System.out.printf("\nHere's your new Card Number!\n\nCard Number:[%s]\n\n", card.getCardNumber());
				break;
			case 2: 
				System.out.printf("\nEnter Amount to Load: Php");
				double load = scan.nextDouble();
				card.loadMoney(load);
				break;
			case 3: 
				System.out.print("\nEnter Fare Amount: Php");
				double fare = scan.nextDouble();
				card.tap(fare);
				break;
			case 4: 
				card.checkBalance();
				break;
			case 5: 
				System.out.println("\nThank you for using QC E-JEEPNEY Card!");
				break;
			}
		}
		while(choice != 5);
		
		
	}

}

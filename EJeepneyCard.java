package ejeepneyCard;
import java.util.*;

public class EJeepneyCard {
	
//private attributes
private String cardNumber;
private double balance;
private static int uniqueNum = 1;


//Card Number Attributes
public EJeepneyCard() {
	this.cardNumber = generateCardNum();
	this.balance = 0.0;
}

//Generates unique Card Number
private String generateCardNum() {
	return "QCEJEEP" + (uniqueNum++);
}

//Returns balance
public double checkBalance() {
	System.out.printf("\nCurrent Balance: Php[%.2f]\n\n", balance);
    return balance;
}

//Returns Card Number
public String getCardNumber() {
	 return cardNumber;	
}

//Returns Card Details
@Override
public String toString() {
return String.format("Card Number:[%s]  Balance: Php[%.2f]", cardNumber, balance);	
}

//Method to load money
public void loadMoney(double amount) {
    if (amount < 0) {
        System.out.println("\nInvalid load amount. Amount must be greater than zero\n");
        return;
    }
    else {
	  balance += amount;	
	  System.out.println(String.format("\nLoaded Php[%.2f]  New Balance: Php[%.2f]\n", amount, balance));
    }
	}

//Method to tap for ride
public boolean tap(double fare) {
	if (balance >= fare) {
		balance-=fare;
		System.out.printf("\nFare of Php[%.2f] is paid successfully!  Remaining Balance: Php[%.2f]\n\n", fare, balance);
		return true;
	}
	
	else if (fare < 0) {
		System.out.println("\nInvalid fare amount. Amount must be greater than zero\n");
		return false;
	}
	
	else {
		System.out.println("\nInsufficient Balance!\n");
		return false;
	}
}


//Output
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

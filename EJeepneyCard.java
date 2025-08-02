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





}

package fox.driving;

import java.util.*;
import javafx.util.*;

public class Payment {
    Scanner s = new Scanner (System.in);
    public int choice; 
    public String IC;
    public double depositBalance;
    public double unpaid;
    public int foundICrow;

    public static Member latestDetails = new Member("","",0,0,"");
	
    public void PrintReceipt(ArrayList<Member> Data) {
	System.out.print("Please enter your IC: ");
	IC = s.nextLine();
		
	Pair<Integer, Integer> p = search(IC, Data);
	choice = p.getKey();
	foundICrow =p.getValue();
	long currDate = System.currentTimeMillis();
	java.sql.Date date = new java.sql.Date(currDate);

            if(choice == 1){
            latestDetails = Data.get(foundICrow);
            System.out.println("-------------------------RECEIPT-----------------------------");
            System.out.println("Date: " + date + "Time: " + java.time.LocalTime.now());
            System.out.println("           9-1, Jalan PJS 8/12, Dataran Mentari,             ");
            System.out.println("               46150 Petaling Jaya, Selangor                 ");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Name: " + latestDetails.name);
            System.out.println("IC: " + latestDetails.IC);
            System.out.println("Instructor: " + latestDetails.iName);
            System.out.println("Instructor ID: " + latestDetails.iId);
                if(latestDetails.category == 1) {
                    System.out.println("Caterogy: Test");
                    System.out.println("Total hours: " + latestDetails.totalHours);
                    depositBalance = 200.00 - (latestDetails.totalHours * 25);
                    unpaid = (depositBalance * -1);
                    if(depositBalance < 0) {
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("Deposit balance: RM0");
                        System.out.println("Total unpaid: RM" + String.format("&.2f", unpaid));
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("\n");
                    }
                    else{
			System.out.println("-------------------------------------------------------------");
			System.out.println("Deposit balance: RM" + String.format("%.2f", depositBalance));
			System.out.println("Total unpaid: RM0");
			System.out.println("-------------------------------------------------------------");
			System.out.println("\n");
                    }
		}
		else {
                    System.out.println("Category: No Test");
                    System.out.println("Total hours: " + latestDetails.totalHours);
                    depositBalance = 200.00 - (latestDetails.totalHours * 15);
                    unpaid = (depositBalance * -1);
                    if(depositBalance < 0) {
			System.out.println("-------------------------------------------------------------");
                        System.out.println("Deposit balance: RM0");
                        System.out.println("Total unpaid: RM" + String.format("&.2f", unpaid));
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("\n");
                    }
                    else{
			System.out.println("-------------------------------------------------------------");
			System.out.println("Deposit balance: RM" + String.format("%.2f", depositBalance));
			System.out.println("Total unpaid: RM0");
			System.out.println("-------------------------------------------------------------");
			System.out.println("\n");
                    }
		}
            }
	}
            
	public static Pair<Integer, Integer> search (String searchIC, ArrayList<Member> Data) {
            Scanner s = new Scanner(System.in);
            int arraylistsize = Data.size();
            int foundICrow = 0;
            int choice = 1;
            int found = 0;
            int counter = arraylistsize -1;
            while(counter >= 0){
		Member IC_row = Data.get(counter);
		if(searchIC.equals(IC_row.IC)) {
                    found = 1;
                    foundICrow = counter;
                    break;
		}
		counter = counter - 1;
            }
            while(found != 1) {
                System.out.println("IC not found. Press 1 to Reenter IC or back to main menu. Press 2 to go back main menu.");
		choice = s.nextInt();
		while(choice != 1 && choice != 2){
                    System.out.println("Invalid option");
                    System.out.println("Press 1 to REenter IC or back to main menu. Press 2 to go back main menu.");
                    choice = s.nextInt();
		}
		if(choice == 1) {
                    System.out.print("Please REenter your IC:");
                    s.nextLine();
                    searchIC = s.nextLine();
		}
		else{
                    break;
		}
		
		counter = arraylistsize - 1;
		
		while(counter >= 0) {
                    Member IC_row = Data.get(counter);
                    if(searchIC.equals(IC_row.IC)) {
			found = 1;
			foundICrow = counter;
			break;
                    }
                    counter = counter - 1;
		}
            }   
            return new Pair<Integer, Integer>(choice, foundICrow);
    }
}
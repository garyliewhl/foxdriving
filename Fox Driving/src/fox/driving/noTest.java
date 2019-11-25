package fox.driving;

import java.text.*;
import java.util.*;

public class noTest{
	Scanner s = new Scanner(System.in);
        public double pricePerClass;
	public int noOfClass;
	public String date;
	public String detailsOfDay = " ";
	public String time;
	public int noOfHours;
	public int totalHours = 0;
	
	public void noTest() {
		noOfClass = 0;
		date = " ";
		detailsOfDay = " ";
		time = " ";
		noOfHours = 1;
		totalHours = 0;
		
		pricePerClass = 18.00;
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println("You chosed category Test (RM18 per class)");
		System.out.println("Each class is 1 hour");   
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Please select how many class you want. (At least 5 classes)");
		
		noOfClass = s.nextInt();
		while(noOfClass<5) {
			System.out.println("You must join at least 5 classes. Please try again: ");
			noOfClass = s.nextInt();
		}
		s.nextLine();
		for(int i=1; i<=noOfClass; i++){
		
			DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
			df.setLenient(false);
			
			int datetrue;
			do{
				datetrue = i;
				System.out.println("Please enter the date (dd/mm/yyyy):");
				date = s.nextLine();
				System.out.println("The date you have entered is: " + date + "\n");
				
				try {
					Date d = new Date();
					d=df.parse(date);
				}
				catch(ParseException e) {
					System.out.println("Unable to parse the date: " + date);
					datetrue=0;
				}
			}while(datetrue == 0);
			
			DateFormat tf = new SimpleDateFormat("hh:mm");
			int timetrue;
			
			do{
				timetrue = 1;
				System.out.println("Please enter the time you would like to start(in hh:mm 24 hour format)");
				time = s.nextLine();
				try{
					Date t = new Date();
					t=tf.parse(time);
					System.out.println("The time is " + time + "\n");
				}
				catch(ParseException e) {
					System.out.println("Invalid time ");
					timetrue = 0;
				}
			}while (timetrue == 0);
			System.out.println("How mant hours you wiuld like to have on " + date);
			noOfHours = s.nextInt();
			totalHours = totalHours + noOfHours;
			s.nextLine();
			
			if(i<noOfClass){
				detailsOfDay = detailsOfDay + "|\t\t\t\t\t\t\t |\n" + " You have class on " + date + " at " + time 
                                + "for 1 hour " + "\n|" + "\t\t\t\t\t\t\t |\n" + "----------------------------------------------" + "\n";
			}else{
				detailsOfDay = detailsOfDay + "|\t\t\t\t\t\t\t |\n" + " You have class on " + date + " at " + time 
                                + "for 1 hour " + "\n|" + "\t\t\t\t\t\t\t |\n" + "----------------------------------------------" + "\n";
			}
		}
		System.out.println("---------------TIMETABLE FOR CLASSES---------------");
		System.out.println(detailsOfDay);
	}
}
		

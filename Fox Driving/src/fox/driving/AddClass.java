package fox.driving;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javafx.util.Pair;

public class AddClass {
    Scanner s = new Scanner(System.in);
    public String IC;
    public int numofhours;
    public String date;
    public int choice;
    public int numofclasses;
    public String time;
    public String detailsOfday = "";
    
    
    public static Member latestDetails;
    
    public ArrayList<Member> AddClass(ArrayList<Member> Data){
        date= "";
        time = "";
        detailsOfday = "";
        System.out.println("----------------------------------Add Class Form----------------------------------");
        System.out.print("Please insert your IC Number for add class purpose: ");
        IC = s.nextLine();
        
        Pair<Integer, ArrayList<Member>> p = searchAndAdd(IC, Data);
        choice = p.getKey(); //return choice as integer
        Data = p.getValue(); 
        
        
        if(choice == 1){
            latestDetails = Data.get(Data.size() - 1);
            if(latestDetails.category == 1){
                numofhours = 1;
                System.out.println("Your category is Test");
                System.out.println("How many classes you would like to add");
                numofclasses = s.nextInt();
                s.nextLine();
                for(int i=1; i<=numofclasses; i++){
            
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);

                int datetrue;
                do{
                    datetrue = 1;
                    System.out.println("Please enter the date(DD/MM/YYYY)");
                    date = s.nextLine();
                    System.out.println("The date you have entered is: " + date + "\n"); 

                    try {
                        Date d = new Date(); 
                        d=df.parse(date);
                    }
                    catch(ParseException e) {
                        System.out.println("Unable to parse " + date);
                        datetrue = 0;
                    }
                }while(datetrue == 0);

                DateFormat tf = new SimpleDateFormat("hh:mm");
                int timetrue;
                do{
                    timetrue = 1;
                    System.out.println("Please enter the time you would like to start(in HH:MM 24 hour format)");
                    time = s.nextLine();
                    
                try{
                    Date t = new Date();
                    t=tf.parse(time);
                    System.out.println("The time is " + time +"\n");
                }
                catch(ParseException e){
                    System.out.println("Invalid time ");
                    timetrue = 0;
                }
                }while(timetrue == 0);
                
                latestDetails.totalHours = latestDetails.totalHours + 1;                
                detailsOfday = detailsOfday + "|\t\t\t\t\t\t\t   |\n" + "   You have class on " + date + " @ " 
                        + time + " for 1 hour " + "\n|" +"\t\t\t\t\t\t\t   |\n" + "------------------------------------------------------------" + "\n" ;
               
                }
            }
            else{
                numofhours = 0;
                System.out.println("Your category is No Test");
                System.out.println("How many classes you would like to add");
                numofclasses = s.nextInt();
                s.nextLine();
                for(int i=1; i<=numofclasses; i++){

                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);

                int datetrue;
                do{
                    datetrue = 1;
                    System.out.println("Please enter the date(DD/MM/YYYY)");
                    date = s.nextLine();
                    System.out.println("The date you have entered is: " + date + "\n"); 

                    try {
                        Date d = new Date(); 
                        d=df.parse(date);
                    }
                    catch(ParseException e) {
                        System.out.println("Unable to parse " + date);
                        datetrue = 0;
                    }
                }while(datetrue == 0);
                
                DateFormat tf = new SimpleDateFormat("hh:mm");
                int timetrue;
                
                do{
                    timetrue = 1;
                    System.out.println("Please enter the time you would like to start(in HH:MM 24 hour format)");
                    time = s.nextLine();
                    
                    try{
                        Date t = new Date();
                        t=tf.parse(time);                        
                        System.out.println("The time is: " + time + "\n");               
                    }   
                    catch(ParseException e){
                        System.out.println("Invalid time ");
                        timetrue = 0;
                    }
                }while(timetrue == 0);
                System.out.println("How many hours you would like to have on " + date);
                numofhours = s.nextInt();
                latestDetails.totalHours = latestDetails.totalHours + numofhours;
                s.nextLine();
                detailsOfday = detailsOfday + "|\t\t\t\t\t\t\t   |\n" + "   You have class on " + date + " @ " 
                        + time + " for " + numofhours + " hour(s)" + "\n|" +"\t\t\t\t\t\t\t   |\n" + "------------------------------------------------------------" + "\n" ;
                }
            }
            latestDetails.detailsOfDay = detailsOfday + latestDetails.detailsOfDay;
            System.out.println("--------------DATE AND TIME SLOTS FOR CLASSES---------------");
            System.out.println(latestDetails.detailsOfDay);
            
            Data.get(Data.size() - 1).setDetailsOfDay(latestDetails.detailsOfDay);
            Data.get(Data.size() - 1).setTotalHours(latestDetails.totalHours);
        }

        return Data;
    }
    public static Pair<Integer, ArrayList<Member>> searchAndAdd(String searchIC, ArrayList<Member> Data){
        Scanner s = new Scanner(System.in);
        int arraylistsize = Data.size();
        int foundICrow;   
        int choice = 1;
        int found = 0;
        int counter = arraylistsize - 1;
        while(counter >= 0) {
            Member IC_row = Data.get(counter);      
            if(searchIC.equals(IC_row.IC)) {
                found = 1;
                foundICrow = counter;
                System.out.println("Your current total hours: " + IC_row.totalHours);
                Data.add(IC_row);
                break;
            }
            counter = counter - 1;
        }
        while(found != 1) {
            System.out.println("IC not found. Would you like to REinsert IC or back to main menu for registration\n -Enter 1 for REinsert IC\n -Enter 2 to go back main menu");
            choice = s.nextInt();
            while(choice != 1 && choice != 2){
                System.out.println("Invalid option");
                System.out.println(" -Enter 1 for REinsert IC\n -Enter 2 to go back main menu");
                choice = s.nextInt();
            }
            if(choice == 1){
                System.out.print("Please REinsert your IC: ");
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
                    System.out.println("Your current total hours: " + IC_row.totalHours);
                    Data.add(IC_row);

                    break;
                }
                counter = counter - 1;
            }
            
        }
        return new Pair<Integer, ArrayList<Member>>(choice, Data);
    }
}


			
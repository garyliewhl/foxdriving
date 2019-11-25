package fox.driving;

import java.util.*;

public class Register {
    public String name, IC;
    public int instructor, category, balance = 210;
    public Instructor inst = new Instructor();
    public Test testInfo = new Test();
    public noTest noTestInfo = new noTest();
    
    Scanner s = new Scanner(System.in);
    
    public void Register(){
        System.out.println("------------Register Form------------");
        System.out.print("Name: ");
        name = s.nextLine();
        System.out.print("IC: ");
        IC = s.nextLine();
        System.out.println("----------Instructor's Info----------");
        inst.printInfo();
        System.out.println("-------------------------------------");
        System.out.println("Please enter the Instructor ID: ");
        instructor = s.nextInt();
        while(instructor !=11111 && instructor !=11222 && instructor !=11333){
            System.out.println("Wrong Instructor ID. Please try again: ");
            instructor = s.nextInt();
        }
        findInstructor(instructor);
        
        System.out.println("Please choose a category: ");
        System.out.println("----------Class Category----------");
        System.out.println("Enter 1 for Test (RM25)");
        System.out.println("Enter 2 for No Test (RM18)");
        System.out.println("----------------------------------");
        category = s.nextInt();
        while(category !=1 && category !=2){
            System.out.println("Wrong category. Please try again:");
            category = s.nextInt();
        }
        if(category == 1){
            testInfo.Test();
        }
        else if(category == 2){
            noTestInfo.noTest();
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Please pay RM200 as deposit and RM10 for registration fee");
        System.out.println("---------------------------------------------------------");
        s.nextLine();
    }
    
    public void findInstructor(int instId){
        if(instId == 11111){
            inst.abu();
        }
        else if(instId == 11222){
            inst.chong();
        }
        else{
            inst.mutu();
        }
    }
}

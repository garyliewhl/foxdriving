package fox.driving;

import java.io.*;
import java.util.*;
/**
 * @author Gary
 */

public class FoxDriving {
    static final String FILE = "member.txt";
    public static int mainMenu;
    public static Scanner s = new Scanner(System.in);
    public static Action action1 = new Action();
    static ArrayList<Member> Data = new ArrayList<Member>();
    public static void main(String[] args) throws FileNotFoundException {
        readMember(); 
        mainMenu(); 
        addMember();
        writeMember();
        }   
    public static ArrayList<Member> storeData(String name, String IC, int instructor, int category, double balance, String iName, int iId,
            double pricePerClass, int noOfClass, String detailsOfDay, int totalHours, ArrayList<Member> Data){
        
        Member saveMemberInfo = new Member("","",0,0,"");
        saveMemberInfo.name = name;
        saveMemberInfo.IC = IC;
        saveMemberInfo.instructor = instructor;
        saveMemberInfo.category = category;
        saveMemberInfo.balance = balance;
        saveMemberInfo.iName = iName;
        saveMemberInfo.iId = iId;
        saveMemberInfo.pricePerClass = pricePerClass;
        saveMemberInfo.noOfClass = noOfClass;
        saveMemberInfo.detailsOfDay = detailsOfDay;
        saveMemberInfo.totalHours = totalHours;
        Data.add(saveMemberInfo);
        return Data;
    }
    public static void mainMenu(){
        do{
            System.out.println("-------------------------------FOX DRIVING ACADEMY-----------------------------------");
            System.out.println("|                                                                                   |");
            System.out.println("|                      9-1, Jalan PJS 8/12, Dataran Mentari,                        |");
            System.out.println("|                         46150 Petaling Jaya, Selangor                             |");
            System.out.println("|                                                                                   |");
            System.out.println("|                                BUSINESS HOURS                                     |");
            System.out.println("|                                MONDAY - SUNDAY                                    |");
            System.out.println("|                               9.00 AM - 5.00 PM                                   |");
            System.out.println("|                                                                                   |");
            System.out.println("|                                 CONTACT NUMBER                                    |");
            System.out.println("|                                  03-58871495                                      |"); 
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("1. Register\n2. Add Class\n3. Bill Payment/Print receipt\n4. Exit\nPlease enter the number(Example: 1): ");
            mainMenu = s.nextInt(); //read the option that users entered in main menu
            while((mainMenu != 1) && (mainMenu != 2) && (mainMenu != 3) && (mainMenu != 4)){
                System.out.println("Invalid option\nEnter 1 for registration\nEnter2 for Add Class\nEnter 3 for payment/receipt\nEnter 4 to exit");
                mainMenu = s.nextInt();
            }
            if(mainMenu == 1){
                action1.register.Register();
                if(action1.register.category == 1){
                    Data = storeData(action1.register.name, action1.register.IC, action1.register.category, 
                           action1.register.instructor, action1.register.balance, action1.register.inst.iName,
                           action1.register.inst.iId, action1.register.testInfo.pricePerClass, action1.register.testInfo.noOfClass,  
                           action1.register.testInfo.detailsOfDay, action1.register.testInfo.totalHours, Data);

                }
                else{
                    Data = storeData(action1.register.name, action1.register.IC, action1.register.category, 
                           action1.register.instructor, action1.register.balance, action1.register.inst.iName,
                           action1.register.inst.iId, action1.register.testInfo.pricePerClass, action1.register.testInfo.noOfClass,  
                           action1.register.testInfo.detailsOfDay, action1.register.testInfo.totalHours, Data);
                }
            }
            else if(mainMenu == 2){
                Data = action1.addclass.AddClass(Data);
            }
            else if(mainMenu == 3){
                action1.bill.PrintReceipt(Data);
            }
        }while(Integer.valueOf(mainMenu) != Integer.valueOf(4));
    }
    public static void readMember() throws FileNotFoundException{
        Scanner s = new Scanner(new FileReader("member.txt"));

        while(s.hasNext()){
            String name = s.nextLine();
            String strIc = s.nextLine();
            String iName = s.nextLine();
            String strCategory = s.nextLine();
            String strTotalhours = s.nextLine();

            String IC = String.valueOf(strIc);                
            int category = Integer.parseInt(strCategory);
            int totalHours = Integer.parseInt(strTotalhours);

            Member MemberData = new Member(name,IC,category,totalHours,iName);

            Data.add(MemberData); //add data into arraylist
        }
        s.close();
    } 
    public static void addMember(){
        try (PrintWriter write = new PrintWriter(FILE)) {
            for (Member m : Data) {
                write.println(m);
            }
        }
    catch (FileNotFoundException ex) {
        System.out.println("File not found.");
        }
    }
    public static void writeMember() throws FileNotFoundException{
        PrintWriter p = new PrintWriter("member.txt");
        for(Member m : Data){
            p.println(m);
        }
        p.close();
    } 
 }  

    

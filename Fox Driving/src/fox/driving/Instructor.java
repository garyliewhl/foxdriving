package fox.driving;

public class Instructor{
   public String iName, iContact;  
   public int iId;

   public void abu(){
       iName = "Abu Bakar";
       iId = 11111;
       iContact = "0123456789";
   }
   public void chong(){
       iName = "Chong Ah Mao";
       iId = 11222;
       iContact = "0183456729";
   }
   public void mutu(){
       iName = "Mutu Sami";
       iId = 11333;
       iContact = "0123562675";
   }
   
   public void printInfo(){
       System.out.println("-------------------------");
       System.out.println("Name:    Abu Bakar");
       System.out.println("ID:      " + 11111);
       System.out.println("Contact: 0123456789");
       System.out.println("-------------------------");
       System.out.println("Name:    Chong Ah Mao");
       System.out.println("ID:      " + 11222);
       System.out.println("Contact: 0183456729");
       System.out.println("-------------------------");
       System.out.println("Name:    Mutu Sami");
       System.out.println("ID:      " + 11333);
       System.out.println("Contact: 0123562675");
       System.out.println("-------------------------");
   }
}
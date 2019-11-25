package fox.driving;

public class Member {
    public String name;
    public String IC;
    public int instructor;
    public int category;
    public double balance;
    public int totalHours;
    public double pricePerClass;
    public int noOfClass;
    public String detailsOfDay = "";
    public String iName;
    public String iContact;
    public int iId;
    
    public void setDetailsOfDay(String detailsOfDay){
        this.detailsOfDay = detailsOfDay;
    }
    
    public void setTotalHours(int totalHours){
        this.totalHours = totalHours;
    }
    
    public Member(String name, String IC, int category, int totalHours, String iName){
        this.name = name;
        this.IC = IC;
        this.category = category;
        this.totalHours = totalHours;
        this.iName = iName;
    }
    
    @Override
    public String toString(){
        return String.format("%s\r\n%s\r\n%d\r\n%d\r\n%s", name, IC, category, totalHours, iName);
    } 
}


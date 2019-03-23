import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Voter {
	
	private String firstName;
    private String lastName;
    private char middleInitial;
    private int age;
    private String location;
    private String phoneNumber;
    private String dateLastContacted; //YYYYMMDD
    
    private String currentYear;
    private String currentMonth;
    private String currentDay;
    
    public Voter(String name, int a, String loc, String phone, String lastCtc){
        
        String[] items = name.split("\\s+");
        ArrayList<String> nameList = new ArrayList<String>();
        for(String n : items){
            nameList.add(n);
        }
        
        if(nameList.size() == 2){ //no middleInitial
            firstName = nameList.get(0);
            lastName = nameList.get(1);
        }
        if(nameList.size() == 3){
            firstName = nameList.get(0);
            String miString = nameList.get(1);
            middleInitial = miString.charAt(0);
            lastName = nameList.get(2);
        }
        
        age = a;
        location = loc;
        phoneNumber = phone;
        dateLastContacted = lastCtc;
        
    }
    
    public void dateLastContactedChanged() {
    	Date date = new Date();
    	String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
    	
    	currentYear = modifiedDate.substring(0,3);
    	currentMonth = modifiedDate.substring(5,6);
    	currentDay = modifiedDate.substring(8,9);
    	
    	dateLastContacted = currentYear+currentMonth+currentDay;
    }
    
    public String toString() {
    	
    	String name = "Name: "+firstName+" "+middleInitial+""+lastName;
    	String ageOfVoter = "Age: "+age;
    	String locationOfVoter = "Location: "+location;
    	String phoneNumberOfVoter = "Phone: "+phoneNumber;
    	String dateLastCtcOfVoter = "Date Last Contacted: "+dateLastContacted;
    	String voter = name+" | "+ageOfVoter+" | "+locationOfVoter+" | "+phoneNumberOfVoter+" | "+dateLastCtcOfVoter;
    	
    	return voter;
    }
    
}

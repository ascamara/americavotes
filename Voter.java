import java.util.ArrayList;

public class Voter {
	
	private String firstName;
    private String lastName;
    private char middleInitial;
    private int age;
    private String location;
    private String phoneNumber;
    private String dateLastContacted; //YYYYMMDD
    
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
    
    public String toString() {
    	
    	String name = "Name: "+firstName+" "+middleInitial+""+lastName;
    	String ageOfVoter = "Age: "+age;
    	String locationOfVoter = "Location: "+location;
    	String phoneNumberOfVoter = "Phone: "+phoneNumber;
    	String dateLastCtcOfVoter = "Date Last Contacted: "+dateLastContacted;
    	String voter = name+"\n"+ageOfVoter+"\n"+locationOfVoter+"\n"+phoneNumberOfVoter+"\n"+dateLastCtcOfVoter;
    	
    	return voter;
    }
    
}

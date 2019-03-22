import java.util.*;
import java.text.*;

public class Volunteer {

	private String firstName;
    private String lastName;
    private char middleInitial;
    private String dob; //MMDDYYYY
    private int age;
    private boolean phone;
    private boolean canvasing;
    
    private int currentYear;
    private int currentMonth;
    private int currentDay;
    
    public Volunteer(String fn, String ln, char mi, String birthday, boolean ph, boolean canvas){
        
    	Date date = new Date();
    	String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
    	
    	currentYear = Integer.parseInt(modifiedDate.substring(0,3));
    	currentMonth = Integer.parseInt(modifiedDate.substring(5,6));
    	currentDay = Integer.parseInt(modifiedDate.substring(8,9));
    	
        firstName = fn;
        lastName = ln;
        middleInitial = mi;
        dob = birthday;
        age = this.dobToAge();
        phone = ph;
        canvasing = canvas;
       
    }
    
    public int dobToAge(){
        
        int month = Integer.parseInt(dob.substring(0,1));
        int day = Integer.parseInt(dob.substring(2,3));
        int year = Integer.parseInt(dob.substring(4,7));
        
        int age = currentYear-year;
        if(month>currentMonth){
            return age-1;
        }
        else if(month == currentMonth){
            if(day>=currentDay){
                return age-1;
            }
            else{
                return age;
            }
        }
        else{
            return age;
        }
     
    }
    
    public int compareTo(Volunteer v){ //By last, then first, then MI, then DOB
        
        if(0 != (this.lastName.compareTo(v.lastName))){
            return this.lastName.compareTo(v.lastName);
        }
        
        else if(0 != (this.firstName.compareTo(v.firstName))){
            return this.firstName.compareTo(v.firstName);
        }
        
        else if(this.middleInitial != v.middleInitial){
            Character initial1 = this.middleInitial;
            Character initial2 = v.middleInitial;
            return initial1.compareTo(initial2);
        }
        
        else if(this.dob != v.dob){
            return this.dob.compareTo(v.dob);
        }
        
        else{ //identical ppl
            return 0;
        }
        
    }
    
    //GET METHODS!
	
}

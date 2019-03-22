import java.util.*;
import java.io.*;
public class MichiganVote {
	
	public ArrayList<Volunteer> allVols;
	public ArrayList<Voter> allVoters;
	
	public MichiganVote() {
		
		ArrayList<Volunteer> allVols = new ArrayList<>();
		ArrayList<Voter> allVoters = new ArrayList<>();
		
	}
	
	public void matchup() {
		
		PrintWriter writer;
		try {
			writer = new PrintWriter("vols", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println(allVols.get(0));
		
	}

}

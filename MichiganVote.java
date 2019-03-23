import java.util.*;
import java.io.*;
public class MichiganVote {
	
	ArrayList<Volunteer> allVols;
	ArrayList<Voter> allVoters;
	
	public MichiganVote() {
		
		ArrayList<Volunteer> allVols = new ArrayList<>();
		ArrayList<Voter> allVoters = new ArrayList<>();
		
	}
	
	public void matchup() {
		
		PrintWriter writer;
		writer = new PrintWriter("vols", "UTF-8");
		writer.println(allVols.get(0));
		writer.close();
		
	}

}

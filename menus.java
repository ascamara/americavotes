import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

public class menus {

	protected Shell shlMichiganVotes;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	ArrayList<Volunteer> allVols = new ArrayList<>();
	ArrayList<Voter> allVoters = new ArrayList<>();
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			menus window = new menus();
			window.open();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMichiganVotes.open();
		shlMichiganVotes.layout();
		while (!shlMichiganVotes.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		} 
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMichiganVotes = new Shell();
		shlMichiganVotes.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		shlMichiganVotes.setSize(450, 300);
		shlMichiganVotes.setText("Michigan Votes!");
		
		Button btnNewButton = new Button(shlMichiganVotes, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				MakeVoter boxVots = new MakeVoter(shlMichiganVotes, 0);	
				try {
				Voter v = boxVots.open();
				allVoters.add(v);
				}
				catch(IndexOutOfBoundsException e1) {
					System.out.print("No voter made.");
					boxVots.shutdown();
				}
				catch(NumberFormatException e2) {
					System.out.print("No voter made.");
					boxVots.shutdown();
				}
								
			}
		});
		btnNewButton.setBounds(10, 10, 139, 49);
		btnNewButton.setText("Create new voter");
		
		Button btnNewButton_1 = formToolkit.createButton(shlMichiganVotes, "Create new volunteer", SWT.NONE);
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				MakeVolunteer boxVols = new MakeVolunteer(shlMichiganVotes, 0);
				try {
				Volunteer v = boxVols.open();
				allVols.add(v);
				}
				catch(IndexOutOfBoundsException e1) {
					System.out.print("No volunteer made.");
					boxVols.shutdown();
				}
				catch(NumberFormatException e2) {
					System.out.print("No volunteer made.");
					boxVols.shutdown();
				}
				
			}
		});
		btnNewButton_1.setBounds(10, 65, 155, 49);
		
		Button btnAssignVolunteers = formToolkit.createButton(shlMichiganVotes, "Assign volunteers!", SWT.NONE);
		btnAssignVolunteers.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnAssignVolunteers.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {				
				
				try{
					matchup();
				}
				catch(ArithmeticException e0) {
					System.out.println("No volunteers!");
				}
				catch(FileNotFoundException e1){
					System.out.println("There's an issue");
				}
				catch(UnsupportedEncodingException e2) {
					System.out.println("There's an issue again");
				}
				
			}
		});
		btnAssignVolunteers.setBounds(285, 197, 139, 49);

	}
	
	private void matchup() throws FileNotFoundException, UnsupportedEncodingException {
		
		int noVoters = allVoters.size();
		int noVols = allVols.size();
		int votersPerVol = noVoters/noVols;
		int votersToBeAssigned = noVoters%noVols;
		
		for(int i=0; i<allVols.size(); i++) {
			
			PrintWriter pw = new PrintWriter(new File("volunteer"+i+".txt"));
			pw.println(allVols.get(i));
			pw.println("===");
			for(int j=0; j<votersPerVol; j++) {
				pw.println(allVoters.get(0));
				allVoters.get(0).dateLastContactedChanged();
				allVoters.add(allVoters.remove(0)); //Acts as a queue for voters
			}
			if(votersToBeAssigned !=0) {
				pw.println(allVoters.get(0));
				allVoters.get(0).dateLastContactedChanged();
				allVoters.add(allVoters.remove(0));
				votersToBeAssigned--;
			}
			pw.close();
		}
			
	}
}

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class menus {

	protected Shell shell;
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		} 
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				MakeVoter boxVots = new MakeVoter(shell, 0);				
				Voter v = boxVots.open();
				allVoters.add(v);
								
			}
		});
		btnNewButton.setBounds(10, 10, 139, 49);
		btnNewButton.setText("Create new voter");
		
		Button btnNewButton_1 = formToolkit.createButton(shell, "Create new volunteer", SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				MakeVolunteer boxVols = new MakeVolunteer(shell, 0);
				Volunteer v = boxVols.open();
				allVols.add(v);
				
			}
		});
		btnNewButton_1.setBounds(10, 65, 155, 49);
		
		Button btnAssignVolunteers = formToolkit.createButton(shell, "Assign volunteers!", SWT.NONE);
		btnAssignVolunteers.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Divide voters by volunteers, assign each to each
				
				
				matchup();
				
				
			}
		});
		btnAssignVolunteers.setBounds(285, 197, 139, 49);

	}
	
	private void matchup() {
		
		
		
		
		
	}
}

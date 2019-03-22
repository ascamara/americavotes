import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Form;

public class menus {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	MichiganVote mi;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			menus window = new menus();
			window.open();
			MichiganVote mi = new MichiganVote();
			
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
				
				MakeVoter boxVots = new MakeVoter(shell, 1);
				mi.allVoters.add(boxVots.open());
				
			}
		});
		btnNewButton.setBounds(10, 10, 139, 49);
		btnNewButton.setText("Create new voter");
		
		Button btnNewButton_1 = formToolkit.createButton(shell, "Create new volunteer", SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				MakeVolunteer boxVols = new MakeVolunteer(shell, 1);
				mi.allVols.add(boxVols.open());
				
			}
		});
		btnNewButton_1.setBounds(10, 65, 155, 49);
		
		Button btnAssignVolunteers = formToolkit.createButton(shell, "Assign volunteers!", SWT.NONE);
		btnAssignVolunteers.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Divide voters by volunteers, assign each to each
				
				mi.matchup();
				
				
			}
		});
		btnAssignVolunteers.setBounds(285, 197, 139, 49);

	}
}

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MakeVolunteer extends Dialog {

	protected Object result;
	protected Shell shlMakeAVolunteer;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Volunteer v;
	private boolean canv;
	private boolean call; 

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public MakeVolunteer(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Volunteer open() {
		createContents();
		canv=false;
		call=false;
		shlMakeAVolunteer.open();
		shlMakeAVolunteer.layout();
		Display display = getParent().getDisplay();
		while (!shlMakeAVolunteer.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return v;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlMakeAVolunteer = new Shell(getParent(), getStyle());
		shlMakeAVolunteer.setSize(450, 300);
		shlMakeAVolunteer.setText("Make a volunteer!");
		
		Label lblFirstName = new Label(shlMakeAVolunteer, SWT.NONE);
		lblFirstName.setBounds(10, 10, 86, 21);
		lblFirstName.setText("First Name");
		
		text = new Text(shlMakeAVolunteer, SWT.BORDER);
		text.setBounds(10, 37, 130, 24);
		
		Label lblMiddleInitial = new Label(shlMakeAVolunteer, SWT.NONE);
		lblMiddleInitial.setBounds(153, 10, 100, 21);
		lblMiddleInitial.setText("Middle Initial");
		
		text_1 = new Text(shlMakeAVolunteer, SWT.BORDER);
		text_1.setBounds(174, 37, 43, 24);
		
		Label lblLastName = new Label(shlMakeAVolunteer, SWT.NONE);
		lblLastName.setBounds(251, 10, 69, 21);
		lblLastName.setText("Last Name");
		
		text_2 = new Text(shlMakeAVolunteer, SWT.BORDER);
		text_2.setBounds(251, 37, 139, 24);
		
		Label lblDateOfBirth = new Label(shlMakeAVolunteer, SWT.NONE);
		lblDateOfBirth.setBounds(10, 67, 194, 24);
		lblDateOfBirth.setText("Date of Birth (MMDDYYYY)");
		
		text_3 = new Text(shlMakeAVolunteer, SWT.BORDER);
		text_3.setBounds(10, 97, 130, 24);
		
		Button btnIdLikeTo = new Button(shlMakeAVolunteer, SWT.CHECK);
		btnIdLikeTo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				call = true;
			}
		});
		btnIdLikeTo.setBounds(10, 127, 207, 24);
		btnIdLikeTo.setText("I'd like to make calls!");
		
		Button btnCheckButton = new Button(shlMakeAVolunteer, SWT.CHECK);
		btnCheckButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				canv = true;
			}
		});
		btnCheckButton.setBounds(10, 153, 226, 24);
		btnCheckButton.setText("I'd like to knock on doors!");
		
		Button btnDone = new Button(shlMakeAVolunteer, SWT.NONE);
		btnDone.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String fn = text.getText();
				String miString = text_1.getText();
				char mi = miString.charAt(0);
				String ln = text_2.getText();
				String bday = text_3.getText();
				boolean phone = call;
				boolean canvas = canv;
				
				v = new Volunteer(fn, ln, mi, bday, phone, canvas);
			}
		});
		btnDone.setBounds(10, 233, 85, 26);
		btnDone.setText("Done");

	}
}

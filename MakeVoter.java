import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MakeVoter extends Dialog {

	protected Shell shlCreateAVoter;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Button btnDone;
	private Voter v;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public MakeVoter(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Voter open() {
		createContents();
		shlCreateAVoter.open();
		shlCreateAVoter.layout();
		Display display = getParent().getDisplay();
		while (!shlCreateAVoter.isDisposed()) {
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
		shlCreateAVoter = new Shell(getParent(), getStyle());
		shlCreateAVoter.setSize(479, 343);
		shlCreateAVoter.setText("Create a voter");
		
		text = new Text(shlCreateAVoter, SWT.BORDER);
		text.setBounds(10, 37, 300, 24);
		
		Label lblName = new Label(shlCreateAVoter, SWT.NONE);
		lblName.setBounds(10, 10, 69, 21);
		lblName.setText("Name");
		
		Label lblAge = new Label(shlCreateAVoter, SWT.NONE);
		lblAge.setBounds(10, 67, 69, 21);
		lblAge.setText("Age");
		
		text_1 = new Text(shlCreateAVoter, SWT.BORDER);
		text_1.setBounds(10, 94, 43, 24);
		
		Label lblLocation = new Label(shlCreateAVoter, SWT.NONE);
		lblLocation.setBounds(10, 124, 69, 21);
		lblLocation.setText("Location");
		
		text_2 = new Text(shlCreateAVoter, SWT.BORDER);
		text_2.setBounds(10, 151, 203, 24);
		
		Label lblPhoneNumber = new Label(shlCreateAVoter, SWT.NONE);
		lblPhoneNumber.setBounds(10, 181, 170, 24);
		lblPhoneNumber.setText("Phone Number");
		
		text_3 = new Text(shlCreateAVoter, SWT.BORDER);
		text_3.setBounds(10, 211, 203, 24);
		
		Label lblDateLastContacted = new Label(shlCreateAVoter, SWT.NONE);
		lblDateLastContacted.setBounds(10, 241, 258, 24);
		lblDateLastContacted.setText("Date Last Contacted (YYYYMMDD)");
		
		text_4 = new Text(shlCreateAVoter, SWT.BORDER);
		text_4.setBounds(10, 271, 203, 24);
		
		btnDone = new Button(shlCreateAVoter, SWT.NONE);
		btnDone.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String name = text.getText();
				int age = Integer.parseInt(text_1.getText());
				String location = text_2.getText();
				String phone = text_3.getText();
				String dateLC = text_4.getText();
				
				v = new Voter(name, age, location, phone, dateLC);
				shlCreateAVoter.dispose();
			}
		});
		btnDone.setBounds(381, 276, 85, 26);
		btnDone.setText("Done");

	}
	
	public void shutdown() {
		shlCreateAVoter.dispose();
	}
}

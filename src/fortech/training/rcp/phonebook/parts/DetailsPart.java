package fortech.training.rcp.phonebook.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import fortech.training.rcp.phonebook.model.Person;

public class DetailsPart {
	private Text firstNameText;
	private Text secondNameText;
	private Text adressText;
	private Text phoneText;
	private TableViewer tableViewer;
	private int id;
	private Person personSelected;
	@Inject
	private MDirtyable dirty;
	
	@PostConstruct
	public void createComposite(Composite parent) {

		parent.setLayout(new GridLayout(2, false));

		Label firstNameLabel = new Label(parent, SWT.NONE);
		firstNameLabel.setText("First Name: ");
		firstNameLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));

		firstNameText = new Text(parent, SWT.BORDER);
		firstNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label secondNameLabel = new Label(parent, SWT.NONE);
		secondNameLabel.setText("Second Name: ");
		secondNameLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));

		secondNameText = new Text(parent, SWT.BORDER);
		secondNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label adressLabel = new Label(parent, SWT.NONE);
		adressLabel.setText("Adress: ");
		adressLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));

		adressText = new Text(parent, SWT.BORDER);
		adressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label phoneLabel = new Label(parent, SWT.NONE);
		phoneLabel.setText("Phone: ");
		phoneLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));

		phoneText = new Text(parent, SWT.BORDER);
		phoneText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));


	}

	@Focus
	public void setFocus() {
		tableViewer.getTable().setFocus();
	}

	@Persist
	public void save() {
		dirty.setDirty(false);
	}
	public void changeTest(String str) {
		firstNameText.setText("asdasadasda");
	}
}

package fortech.training.rcp.phonebook.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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
	private Person person;
	@Inject
	private MDirtyable dirty;

	@PostConstruct
	public void createComposite(Composite parent) {

		parent.setLayout(new GridLayout(2, false));
		if (person != null) {
			constructPersonDetails(person, parent);
		} else {
			constructPersonDetails(new Person("-"), parent);
		}
		constructButtons(parent);
		bindValues();
	}

	@Focus
	public void setFocus() {
		tableViewer.getTable().setFocus();
	}

	@Persist
	public void save() {
		dirty.setDirty(false);
	}

	public void constructPersonDetails(Person p, Composite parent) {

		Label firstNameLabel = new Label(parent, SWT.NONE);
		firstNameLabel.setText("First Name: ");
		firstNameLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		firstNameText = new Text(parent, SWT.BORDER);
		firstNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		firstNameText.setText(p.getFirstName());

		Label secondNameLabel = new Label(parent, SWT.NONE);
		secondNameLabel.setText("Second Name: ");
		secondNameLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		secondNameText = new Text(parent, SWT.BORDER);
		secondNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		secondNameText.setText(p.getLastName());

		Label adressLabel = new Label(parent, SWT.NONE);
		adressLabel.setText("Adress: ");
		adressLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		adressText = new Text(parent, SWT.BORDER);
		adressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		adressText.setText(p.getAddress());

		Label phoneLabel = new Label(parent, SWT.NONE);
		phoneLabel.setText("Phone: ");
		phoneLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		phoneText = new Text(parent, SWT.BORDER);
		phoneText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		phoneText.setText(p.getPhoneNumber());
	}

	public void constructButtons(Composite parent) {
		Button saveButton = new Button(parent, SWT.PUSH);
		saveButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		saveButton.setText("Save");
		saveButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(person.getFirstName());
				person.setFirstName("aa");
			}
		});

		Button cancelButton = new Button(parent, SWT.PUSH);
		cancelButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		cancelButton.setText("Cancel");
		cancelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateDetails(person);
			}
		});
	}

	public void setPerson(Person p) {
		this.person = p;
		updateDetails(p);
	}

	public void updateDetails(Person p) {
		firstNameText.setText(p.getFirstName());
		secondNameText.setText(p.getLastName());
		adressText.setText(p.getAddress());
		phoneText.setText(p.getPhoneNumber());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void bindValues() {
		System.out.println("binding");
		DataBindingContext ctx = new DataBindingContext();
		IObservableValue widgetValue = WidgetProperties.text(SWT.Modify).observe(firstNameText);
		IObservableValue modelValue = BeanProperties.value(Person.class, "firstName").observe(person);
		ctx.bindValue(widgetValue, modelValue);
		
	}
}
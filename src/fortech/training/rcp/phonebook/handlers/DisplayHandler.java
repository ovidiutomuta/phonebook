package fortech.training.rcp.phonebook.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class DisplayHandler {

	@Execute
	public void execute(Shell shell) {
		MessageDialog.openInformation(shell, "About", "PhoneBook");
	}
}

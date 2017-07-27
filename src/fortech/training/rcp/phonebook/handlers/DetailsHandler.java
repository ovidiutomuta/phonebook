package fortech.training.rcp.phonebook.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

import fortech.training.rcp.phonebook.model.Person;
import fortech.training.rcp.phonebook.parts.DetailsPart;

public class DetailsHandler {
	@Inject
	EPartService partService;

	@Inject
	@Optional
	void logging2(@UIEventTopic("open_details") Person p) {
		createNewPart(p);
	}

	@Execute
	public void execute() {
		createNewPart(new Person("*", "*", "*", "*"));
	}

	private DetailsPart createNewPart(Person p) {
		MPart part = partService.createPart("fortech.training.rcp.phonebook.partdescriptor.details");
		return (DetailsPart) partService.showPart(part, PartState.ACTIVATE).getObject();
	}

}

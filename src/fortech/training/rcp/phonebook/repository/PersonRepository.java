package fortech.training.rcp.phonebook.repository;

import java.util.ArrayList;
import java.util.List;

import fortech.training.rcp.phonebook.model.Person;

public class PersonRepository {

	private static List<Person> container = new ArrayList<Person>();

	public PersonRepository() {

		container.add(new Person("Ovidiu", "Tomuta", "Alverna 67 Cluj", "0753784622"));
		container.add(new Person("Andrei", "Rus", "Alverna 67 Cluj", "0753784623"));
		container.add(new Person("Ionela", "Pop", "Alverna 67 Cluj", "0753784624"));
	}

	public List<Person> getAllPerson() {
		return container;
	}

	public List<String> getAllPersonString() {
		List<String> result = new ArrayList<String>();
		for (Person p : container) {
			result.add(p.toString());
		}
		return result;
	}

	public List<String> getAllPersonByName(String name) {
		List<String> result = new ArrayList<String>();
		for (Person p : container) {
			if (p.getFirstName().toUpperCase().contains(name.toUpperCase())
					|| p.getLastName().toUpperCase().contains(name.toUpperCase())) {
				result.add(p.toString());
			}
		}
		return result;
	}
}

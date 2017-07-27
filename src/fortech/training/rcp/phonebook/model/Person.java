package fortech.training.rcp.phonebook.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Person extends ModelObject {

	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private static final AtomicInteger count = new AtomicInteger(0);

	public Person(String firstName) {
		super();
		this.id = count.incrementAndGet();
		this.firstName = firstName;
		this.lastName = "-";
		this.address = "-";
		this.phoneNumber = "-";
	}

	public Person(String firstName, String lastName, String address, String phoneNumber) {
		super();
		this.id = count.incrementAndGet();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		firePropertyChange("name", this.firstName, this.firstName = firstName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.address;
	}

}

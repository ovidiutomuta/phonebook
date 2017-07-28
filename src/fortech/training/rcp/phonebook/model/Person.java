package fortech.training.rcp.phonebook.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.atomic.AtomicInteger;

public class Person implements PropertyChangeListener {

	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private static final AtomicInteger count = new AtomicInteger(0);

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public Person() {

	}

	public Person(String firstName) {
		super();
		this.id = count.incrementAndGet();
		this.setFirstName(firstName);
		this.setLastName("-");
		this.setAddress("-");
		this.setPhoneNumber("-");
	}

	public Person(String firstName, String lastName, String address, String phoneNumber) {
		super();
		this.id = count.incrementAndGet();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		propertyChangeSupport.firePropertyChange("firstName", this.firstName, this.firstName = firstName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		propertyChangeSupport.firePropertyChange("lastName", this.lastName, this.lastName = lastName);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		propertyChangeSupport.firePropertyChange("address", this.address, this.address = address);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		propertyChangeSupport.firePropertyChange("phoneNumber", this.phoneNumber, this.phoneNumber = phoneNumber);
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.address + " " + this.phoneNumber;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		propertyChangeSupport.firePropertyChange("firstName", null, firstName);
	}

}

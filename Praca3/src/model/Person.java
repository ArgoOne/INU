package model;

public class Person {

	private String firstName; 
	private String lastName; 
	private String room;
	private String rozp;
	private String zak;
	
	public Person (String firstName, String lastName, String room, String rozp, String zak){
		this.firstName=firstName;
		this.lastName=lastName;
		this.room=room;
		this.rozp=rozp;
		this.zak=zak;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getRozp() {
		return rozp;
	}

	public void setRozp(String rozp) {
		this.rozp = rozp;
	}

	public String getZak() {
		return zak;
	}

	public void setZak(String zak) {
		this.zak = zak;
	}

}

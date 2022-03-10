package Vehicles;

public class Car extends Vehicle {

	/*
	 *	Encapsulation - Hidden 'private' data such as color set upon constructing an object, Can only be
	 * 					Read using a predefined 'get' method, to be protected from unconventional changes.
	 */
	private final String color;

	public Car(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

}

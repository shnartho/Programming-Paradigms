package Vehicles;

public class SportCar extends Vehicle {

	private final String[] colorGradient;

	public SportCar(int hp, String color1, String color2) {
		horsePower = hp;
		colorGradient = new String[]{color1, color2};
	}

	public String getColor() {
		return colorGradient[0] + " Mixed with " + colorGradient[1];
	}

}

package Vehicles;

public class SuperCar extends Vehicle {

	private final boolean madeOfGold;

	public SuperCar(int hp, boolean madeOfGold) {
		horsePower = hp;
		this.madeOfGold = madeOfGold;
	}

	public String isMadeOfGold() {
		return madeOfGold ? "Yes, And it's very shiny." : "Nope, But still fast and expensive";
	}

}

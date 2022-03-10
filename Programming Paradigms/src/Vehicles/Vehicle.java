package Vehicles;

/*
 *	Inheritance - Common object methods are inherited from this abstract class
 */
public abstract class Vehicle {

	protected int horsePower = 120;
	protected double engineTemperature = 0;

	/*
	 *	Abstraction - Vital inner system information is hidden from the user, to avoid unnecessary damage
	 * 				  To the system. The software will handle background tasks, Instead mask them with simple
	 *                Actions such as "Start car" or "Stop car".
	 */
	private boolean fuelInjectorRunning = false;
	private boolean radiatorRunning = false;
	private boolean carIsUpsideDown = false;

	public void start() {
		engineTemperature = 90;
		fuelInjectorRunning = true;
		radiatorRunning = true;
	}

	public void stop() {
		engineTemperature = 25;
		fuelInjectorRunning = false;
		radiatorRunning = false;
	}

	int getHorsePower() {
		return horsePower;
	}
	double getEngineTemperature() {
		return engineTemperature;
	}

}

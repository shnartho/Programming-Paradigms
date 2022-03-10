package Shapes;

public class Circle implements Shape {

	private final int radius;

	Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return (radius * radius) * Math.PI;
	}

}

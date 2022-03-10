package Shapes;

public class Square implements Shape {

	private final double width;
	private final double height;

	Square(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

}

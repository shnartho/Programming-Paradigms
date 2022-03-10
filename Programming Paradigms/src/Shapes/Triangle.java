package Shapes;

import java.util.stream.DoubleStream;

public class Triangle implements Shape {

	private final double[] vertices;

	Triangle(double length) {
		vertices = new double[]{length, length, length};
	}

	Triangle(double length1, double length2, double length3) {
		vertices = new double[]{length1, length2, length3};
	}

	@Override
	public double getArea() {
		return (DoubleStream.of(vertices).sum()) / 2;
	}

}

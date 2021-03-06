//Name: Eden Schwartz
//ID: 315685461
//HW1

package HW1_EdenSchwartz;

import java.util.Scanner;

public class Circle extends Shape implements Radius {

	private int radius;

	public Circle() throws ColorException, RadiusException {
		super(null);
		this.radius = 0;
		validValues();
	}
	
	public Circle(String color, int radius) {
		super(color);
		this.radius = radius;
	}

	private void validValues() throws ColorException, RadiusException {

		boolean validColor;
		boolean validRadius;
		boolean radiusChecked;
		Scanner scanner = new Scanner(System.in);

		do {
			validColor = true;
			validRadius = true;
			radiusChecked = false;
			System.out.println("Please enter color and then radius for the first circle:");
			color = scanner.nextLine();
			try {
				radius = Integer.parseInt(scanner.next());
				try {
					for (String invalidColor : invaldColors) {
						if ((color.equalsIgnoreCase(invalidColor))) {
							validColor = false;
							throw new ColorException();
						}
					}
				} catch (ColorException e) {
					validRadius = false;
					System.out.println(e.getMessage());
				}
			} catch (IllegalArgumentException e) {
				validRadius = false;
				System.out.println("Only integer is allowed here..");
				radiusChecked = true;
			}
			if (validColor && !radiusChecked) {
				validRadius = radiusCheck(radius);
			}
			scanner.nextLine(); // clean buffer
		} while (!validColor || !validRadius);
	}

	@Override
	public double getArea() {
		return (Math.PI * radius * radius);
	}

	@Override
	public String toString() {
		return "Circle, " + super.color + ", " + radius + ", area = " + getArea();
	}

	@Override
	public boolean radiusCheck(int radius) throws RadiusException {
		try {
			if (radius > 500 || radius < 0)
				throw new RadiusException(radius);
		} catch (RadiusException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}

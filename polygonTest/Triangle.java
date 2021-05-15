package polygonTest;

public class Triangle {
	// 5.1 Member field of triangle's each side 
	public double a, b, c;
	
	// 5.2 Get each side's length through three points
	public Triangle(Point first, Point second, Point third) {
		this.a = Point.getDistance(first, second);
		this.b = Point.getDistance(second, third);
		this.c = Point.getDistance(third, first);
	}
	
	// 5.3 Get area through Heron's theory
	public static double GetArea(double a, double b, double c) {
		double s;
		s = (a + b + c) / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	// 5.5 Override toString default method --> showing each edge of triangle and area
	@Override
	public String toString() {
		String mention;
		mention = "Edges of this triangle is each " + this.a + "," + this.b + "," + this.c + ", \nand Area of triangle is " + GetArea(this.a, this.b, this.c); 
		return mention;
	}
}

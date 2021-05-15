package polygonTest;

public class Bound {
	private Point bottomLeft;
	private Point bottomRight;
	private Point topLeft;
	private Point topRight;

	public Bound()	{
		this(new Point(0.0, 0.0), 1.0, 1.0);
	}

	// Get bound from original point and parameters
	public Bound(Point origin, double width, double height)	{
		this.bottomLeft = origin;
		this.bottomRight = new Point(origin.getX() + width, origin.getY());
		this.topLeft = new Point(origin.getX(), origin.getY() + height);
		this.topRight = new Point(origin.getX() + width, origin.getY() + height);
	}
	
	// Get bound from two bottom points and parameters
	public Bound(double x, double y, double width, double height) {
		this.bottomLeft = new Point(x, y);
		this.bottomRight = new Point(x + width, y);
		this.topLeft = new Point(x, y + height);
		this.topRight = new Point(x + width, y + height);
	}
	
	// Get bound from bottom left point to top right point
	public Bound(Point bottomLeft, Point topRight) {
		this.bottomLeft = bottomLeft;
		this.bottomRight = new Point(topRight.getX(), bottomLeft.getY());
		this.topLeft = new Point(bottomLeft.getX(), topRight.getY());
		this.topRight = topRight;
	}

	// Default getter & setter
	public Point getBottomLeft() {
		return bottomLeft;
	}

	public Point getBottomRight() {
		return bottomRight;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public Point getTopRight() {
		return topRight;
	}

	public double getWidth() {
		return topRight.getX() - bottomLeft.getX();
	}

	public double getHeight() {
		return topRight.getY() - bottomLeft.getY();
	}

	
	// Finding bound by looping array of Point
	public static Bound findBound(Point[] points) {
		if (points == null) return null;
		double xmin = points[0].getX();
		double xmax = points[0].getX();
		double ymin = points[0].getY();
		double ymax = points[0].getY();
		for (int i = 0; i < points.length; i++) {
			xmin = Math.min(points[i].getX(), xmin);
			xmax = Math.max(points[i].getX(), xmax);
			ymin = Math.min(points[i].getY(), ymin);
			ymax = Math.max(points[i].getY(), ymax);
		}
		return new Bound(xmin, ymin, xmax - xmin, ymax - ymin);
	}

	@Override
	public String toString() {
		return "Bound [bottomLeft=" + bottomLeft + ", bottomRight=" + bottomRight + ", topLeft=" + topLeft
				+ ", topRight=" + topRight + "]";
	}
}

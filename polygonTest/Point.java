package polygonTest;

public class Point {
	private double x;
	private double y;
	private static int count = 0;
	private static final Point Zero = new Point(0.0, 0.0);
	private static final Point One = new Point(1.0, 1.0);

	// Default Constructor --> 0,0 as default
	public Point() { 
		this(0.0, 0.0);
	}
	
	// Set point by each of x & y coordinate
	public Point(double x, double y) { 
		set(x, y); 
		count++; 
	}
    // Set point by getting length 2 array
	public Point(double[] xy) { 
		set(xy); 
		count++; 
	}

	// Set point by another point
	public Point(Point other) { 
		set(other);
		count++; 
	}
	
	// Default getter & setter
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public static Point getZero() {
		return Zero;
	}

	public static Point getOne() {
		return One;
	}

	public static int getCount() {
    	return count; 
	}
	    
	public static void setCount(int count) {
		Point.count = count;
	}

	// Override object's method 'clone'
	public Point clone() {
		Point p = new Point(this.x, this.y);
		System.out.println("Point clone(): " + p.toString());
		return p;
	}

	// Create array by x & y coordinate
	public double[] get() {
		double[] xy = new double[2];
		xy[0] = this.x;
		xy[1] = this.y;
		//System.out.println("get(): " + "(" + xy[0] + ", " + xy[1] + ")");
		return xy;
	}

	// Separate array to x & y coordinate
	public void set(double[] xy) {
		if (xy.length == 2) {
			this.x = xy[0];
			this.y = xy[1];
			//System.out.println("set(xy[]): " + this);    		
		}
	}

	public void set(double x, double y) { 
		this.x = x; 
		this.y = y; 
		//System.out.println("Point::set(x,y): " + this);
	}

	public void set() {
		this.x = 1.0f;
		this.y = 2.0f;
		//System.out.println("Point::set(): " + this);
	}
    
	public void set(Point other) {
		this.x = other.x;
		this.y = other.y;
		//System.out.println("Point::set(Point): " + this);
	}

	public Point set(double d) {
		Point point = new Point(d, d);
		//System.out.println("Point::set(i): " + point.toString());
		return point;
	}

	public void move(double x, double y) { 
		this.x += x; 
		this.y += y; 
	}

	public void move(Point other) { 
		this.x += other.x; 
		this.y += other.y; 
	}
 
	public static double getDistance(Point p, Point q) { 
		return Math.sqrt((p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y)); 
	}
	
	public double getDistance(Point other) { 
		return getDistance(this, other); 
	}

	public double getMagnitude() {
		return getDistance(this, Zero);
	}

	// 2. Create swap method
	public static void swap(Point p, Point q) { 
		Point temp = new Point(p);
		p.set(q);
		q.set(temp);
	}

	// Method overloading. 
	// Redefine pre-defined object's toString method
	// If did not override, result might be the address of objects.
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}


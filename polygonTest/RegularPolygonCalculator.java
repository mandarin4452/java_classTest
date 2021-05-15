package polygonTest;

public class RegularPolygonCalculator {
	private int degree = 5;
	private double radius;
	private Point center;
	private double angle;
	private Point[] points;
   
	public RegularPolygonCalculator(int degree) {
		this(degree, 1.0, Point.getZero());
	}
    
    public RegularPolygonCalculator(int degree, double radius) {
        this(degree, radius, Point.getZero());
    }
    
    public RegularPolygonCalculator(int degree, double radius, Point center) {
        this.degree = Math.max(3, Math.min(8, degree));
        this.radius = radius;
        this.center = center;       
    	this.angle = 2 * Math.PI / degree;
        this.points = createPoints();        
    }
    
    private Point[] createPoints() {
        Point[] points = new Point[degree];

        double radian = Math.PI / 2.0; // -90
        for (int i = 0; i < degree; i++) {
        	points[i] = getPoint(radian, radius, center);
        	radian += angle;
        }
        return points;
    }
    
    private static Point getPoint(double radian, double radius, Point offset) {
        return new Point(radius * Math.cos(radian) + offset.getX(), radius * Math.sin(radian) + offset.getY());
    }
    
    public PolygonType getPolygonType() {
    	return PolygonType.valueOf(degree);
    }
    
    public Point[] getPoints() {
    	return points;
    }
    
    public Bound getBound() {
    	return Bound.findBound(points);
    }

    public double getArea() {
        return radius * radius * degree * Math.sin(angle) / 2.0;
    }
    
    @Override
    public String toString() { 
    	String s = getPolygonType().toString() + " [radius=" + radius + ", center=" + center.toString() + "]\n";
        for (int i = 0; i < degree; i++) {
        	s += (points[i].toString() + "\n");
        }
    	return s; 
    }    
}

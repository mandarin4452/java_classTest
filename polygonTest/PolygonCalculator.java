package polygonTest;

public class PolygonCalculator {
	private int degree;
	// 6.1 points and triangles member field
	private Point[] points;
	private Triangle[] triangles;
	private static Point[][] polygons = {
			{ new Point(1,0), new Point(0, 3), new Point(-4, 0) },
			{ new Point(1,0), new Point(-1, 4), new Point(0, 3), new Point(-4, 0) },
			{ new Point(2,0), new Point(2, 2), new Point(0, 4), new Point(-2, 2), new Point(-2, 0) },
			{ new Point(4,0), new Point(2, 2), new Point(-2, 2), new Point(-4, 0), new Point(-2, -2), new Point(2, -2) }
	};
	
	// 6.2 Create default constructor using given points & Send it to 'findTriangles' to add triangles to array
	public PolygonCalculator(Point[] points) {
		this.points = points;
		this.degree = points.length;
		this.triangles = findTriangles(points);

	}
	
	// 6.3 Create array of triangles using given points
	public Triangle[] findTriangles(Point[] points) {
		Triangle[] triangles = new Triangle[degree - 2];
		Point standard = points[0];
		
		for (int i = 0; i < degree - 2; i++) {
			triangles[i] = new Triangle(standard, points[i + 1], points[i + 2]);
		}
		return triangles;
	}

	// 6.4 Create getPoints method (Default constructor)
	public Point[] getPoints() {
		return points;
	}

	public void setPoints(Point[] points) {
		this.points = points;
	}
	
	// 6.5 Create getTriangles method (Default constructor);
	public Triangle[] getTriangles() {
		return triangles;
	}
	
	// 6.6 Create getPolygonType method
	public PolygonType getPolygonType() {
		return PolygonType.valueOf(this.degree);
	}
	
	// 6.7 Create getBound method
	public Bound getBound() {
		return Bound.findBound(points);
	}
	
	// 6.8 Create getArea method
	public double getArea() {
		double areaSum = 0;
		for(Triangle triangle : triangles) {
			areaSum += Triangle.GetArea(triangle.a, triangle.b, triangle.c);
			
		}
		return areaSum;
	}
	
	// 6.9 Overriding toString method
	@Override
	public String toString() { 
    	String s = getPolygonType().toString() + "\n";
   
        for (int i = 0; i < degree; i++) {
        	s += (points[i].toString() + "\n");
        }
        
        s+= "Area is " + getArea();
    	return s; 
    }

	public static Point[][] getPolygons() {
		return polygons;
	}

	public static void setPolygons(Point[][] polygons) {
		PolygonCalculator.polygons = polygons;
	}   
}

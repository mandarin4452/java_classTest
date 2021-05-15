package polygonTest;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// 1.1 PolygonType Testing
		System.out.println("=== 1.1 Testing PolygonType method from type 3 to 8 ===\n");
		System.out.println(PolygonType.valueOf(3));
		System.out.println(PolygonType.valueOf(4));
		System.out.println(PolygonType.valueOf(5));
		System.out.println(PolygonType.valueOf(6));
		System.out.println(PolygonType.valueOf(7));
		System.out.println(PolygonType.valueOf(8));
		
		// 1.2 Point methods Testing
		
		System.out.println("=== 1.2 Testing Point methods (Constructor, move, getDistance) ===\n");
		double[] arr = {3.0, 3.0};
		double tempDist;
		Point point0 = new Point(); // Set point as (0,0)
		Point point1 = new Point(1.0,1.0); // Set point as given parameters
		Point point2 = new Point(arr); // Set point as array
		Point point3 = new Point(point0); // Set point as another point
		System.out.println(point0);
		System.out.println(point1);
		System.out.println(point2);
		System.out.println(point3);
		point3.move(point1); // Move point (0,0) to (1,1)
		System.out.println(point3);
		tempDist = Point.getDistance(point1, point2); // Get distance between (1,1) and (3,3)
		System.out.println("Distance between point1 (1,1) and point2 (3,3) is : " + tempDist);
		System.out.println(point0);
		System.out.println(point1);
		
		// 1.3 Bound methods Testing
		System.out.println("=== 1.3 Testing Bound methods ===\n");
		Bound defBound = new Bound(); // Default bound : (0,0), (0,1), (1,0), (1,1)
		System.out.println(defBound);  
		Point[] tempPoints = new Point[4];
		Point p1 = new Point();
		Point p2 = new Point(3.0, 0);
		Point p3 = new Point(4.0, 4.0);
		Point p4 = new Point(0, 3.0);
		
		tempPoints[0] = p1;
		tempPoints[1] = p2;
		tempPoints[2] = p3;
		tempPoints[3] = p4;
		System.out.println(Bound.findBound(tempPoints)); // Test findBound method by creating array of points
		
		// 1.4 RegularPolygonCalculator methods Testing
		System.out.println("=== 1.4 Testing RegularPolygonCalculator methods ===\n");
		RegularPolygonCalculator tempCalc0 = new RegularPolygonCalculator(5); // Create pentagon with rad = 1, center = 0,0
		RegularPolygonCalculator tempCalc1 = new RegularPolygonCalculator(6,2); // Create hexagon with rad = 2, center = 0,0
		RegularPolygonCalculator tempCalc2 = new RegularPolygonCalculator(7,2,p1); // Create heptagon with rad = 2, center = 0,0 
		
		System.out.println(tempCalc0);
		System.out.println(tempCalc1);
		System.out.println(tempCalc2);
		
		// 2. Test swap method in main class
		Point.swap(point0, point1); // Swap point0 (0,0) and point1 (1,1)
		
		// 3. Explaining method overloading
		// By default, without overloading 'toString' method, result of 
		// System.out.println(point); 
		// might be the address of point object.
		// But by redefining toString method, 
		// we could get customized result from statement below.
		System.out.println(point1);
		
		// 4. Testing RegularPolygonCalculator using user input
		
		System.out.println("=== 4. Testing RegularPolygonCalculator using user input ===\n");
		int degree = 5;
		double radius;
		Point point_4 = new Point();
		
		System.out.print("Which kind of polygon do you like to create? \n Enter the degree of polygon. (Default : 5) : ");
		try {
			degree = sc.nextInt();
		}catch (Exception e) {
			degree = 5;
		}
		System.out.print("\nRadious ? (Default : 1) : ");
		try {
			radius = sc.nextInt();	
		}catch (Exception e) {
			radius = 1;
		}
		
		System.out.print("\nWant custom center ? (Y | N) : ");
		String s = sc.next();
		char option = s.charAt(0);
		
		if (option == 'Y' || option == 'y') {
			System.out.print("\n Ener  x,y sequentially. (ex. 1 1) : ");
			point_4.set(new Point(sc.nextDouble(), sc.nextDouble()));
		}
		else {
			point_4.set(new Point(0,0));
		}
		
		
		RegularPolygonCalculator calc_4 = new RegularPolygonCalculator(degree, radius, point_4);
		
		System.out.println(calc_4);
		System.out.println(calc_4.getArea());
		
		// 5.6 Testing class Triangle using preloaded points
		
		System.out.println("\n=== 5.6 Testing Triangle class using points (0,0), (1,1), (0,2)===\n");
		Point point_5_6_1 = new Point();
		Point point_5_6_2 = new Point(1.0,1.0);
		Point point_5_6_3 = new Point(0,2.0);
		
		Triangle triangle_5_6 = new Triangle(point_5_6_1,point_5_6_2,point_5_6_3);
		System.out.println(triangle_5_6);
		
		// 5.7 Testing class Triangle using user's points
		System.out.println("\n=== 5.7 Testing Triangle class using user defined points ===\n");
		
		System.out.println("Enter x1, y1, x2, y2, x3, y3 sequentially. (Each points are seperated by enter.  ex. 1 1 enter) :");		
		
		Point point_5_7_1 = new Point(sc.nextDouble(), sc.nextDouble());
		Point point_5_7_2 = new Point(sc.nextDouble(), sc.nextDouble());
		Point point_5_7_3 = new Point(sc.nextDouble(), sc.nextDouble());
		
		Triangle triangle_5_7 = new Triangle(point_5_7_1, point_5_7_2, point_5_7_3);
		
		System.out.println(triangle_5_7);
		
		// 6.10 Testing with given data
		System.out.println("\n=== 6.10 Testing PolygonCalculator using given data ===\n");
		
		Point[][] polygons = PolygonCalculator.getPolygons();
		
		for (int i = 0; i < polygons.length; i++) {
			Point[] temp = polygons[i];
			PolygonCalculator tempCalc = new PolygonCalculator(temp);
			System.out.println(tempCalc);
		}
		
		// 6.11 Testing with user input
		System.out.println("\n=== 6.11 Testing PolygonCalculator with user input ===\n");
		int degree_6_11;
		System.out.print("Degree? : ");
		degree_6_11 = sc.nextInt();
		
		Point[] points_6_11 = new Point[degree_6_11];
		for (int i = 0; i < degree_6_11; i++) {
			if (i == 0) {
				System.out.print("\nEnter first coordinate (ex. 1 1) : ");
			}
			else if (i == 1) {
				System.out.print("\nEnter second coordinate (ex. 1 1) : ");
			}
			else if (i == 2) {
				System.out.print("\nEnter third coordinate (ex. 1 1) : ");
			}
			else {
				System.out.print("\nEnter " + (i + 1) + " th coordinate (ex. 1 1) : ");
			}
			points_6_11[i] = new Point(sc.nextDouble(), sc.nextDouble());
		}
		
		PolygonCalculator calc_6_11 = new PolygonCalculator(points_6_11);
		System.out.println(calc_6_11);
		
		// 7. Compare area with RegularPolygonCalculator and PolygonCalculator
		System.out.println("\n=== 7 Compare RegularPolygonCalculator's Area and PolygonCalculator's Area ===\n");
		int degree_7 = 5;
		double radius_7;
		Point point_7 = new Point();
		
		System.out.print("Which kind of polygon do you like to create? \n Enter the degree of polygon. (Default : 5) : ");
		try {
			degree_7 = sc.nextInt();
		}catch (Exception e) {
			degree_7 = 5;
		}
		System.out.print("\nRadious ? (Default : 1) : ");
		try {
			radius_7 = sc.nextInt();	
		}catch (Exception e) {
			radius_7 = 1;
		}
		
		System.out.print("\nWant custom center ? (Y | N) : ");
		String tempString = sc.next();
		char option_7 = tempString.charAt(0);
		
		if (option_7 == 'Y' || option_7 == 'y') {
			System.out.print("\n Ener  x,y sequentially. (ex. 1 1) : ");
			point_7.set(new Point(sc.nextDouble(), sc.nextDouble()));
		}
		else {
			point_7.set(new Point(0,0));
		}
		
		RegularPolygonCalculator reg_calc_7 = new RegularPolygonCalculator(degree_7, radius_7, point_7);
		
		Point[] points_7 = reg_calc_7.getPoints();
		PolygonCalculator calc_7 = new PolygonCalculator(points_7);
		
		System.out.print("\n\nArea of RegularPolygonCalculator --> " + reg_calc_7.getArea());
		System.out.print("\nArea of PolygonCalculator --> " + calc_7.getArea());
		
	}
}

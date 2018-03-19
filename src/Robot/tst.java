package Robot;

public class tst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point P1 = new Point (2,1);
		Point P2 = new Point (2,1);
		Point P3 = new Point (2,1);
		Robot R = new Robot();
		Robot R1 = new Robot(5);
		/*P1.add(P3);
		P3=Point.add(P1, P2);*/
		String s="";
		System.out.println(Point.add(P1, P2));
		System.out.println(Point.mul(P1, 5));
	}

}

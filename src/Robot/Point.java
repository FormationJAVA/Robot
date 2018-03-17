package Robot;

public class Point {
	
		public int x;
		public int y;
		
		public Point ()
		{
			this.x =0;
			this.y =0;
		}
		public Point (int a, int b )
		{
			this.x =a;
			this.y =b;
		}
		
		public void add (Point P)
		{
			this.x+= P.x;
			this.y+= P.y;

		}
		public static Point add (Point P1,Point P2)
		{
			Point resultat = new Point();
			resultat.x= P1.x+P2.x;
			resultat.y= P1.y+P2.y;
			return resultat;
		}
		public void mul (double a)
		{
			this.x*= a;
			this.y*= a;

		}
		public static Point mul (Point P,double a)
		{
			Point resultat = new Point();
			resultat.x=(int) Math.round(P.x*a);
			resultat.y=(int) Math.round(P.y*a);
			return resultat;
		}
		public static double getDistance(Point P1,Point P2 )
		{
			double D;
			D= Math.pow( P1.x-P2.x,2);
			D+=Math.pow( P1.y-P2.y,2);
			D= Math.sqrt(D);
			return D;
		}
		public void setPoint (Point P)
		{
			this.x= P.x;
			this.y= P.y;
		}
		public String toString()
		{
			return "("+this.x+", "+this.y+")";
		}
}

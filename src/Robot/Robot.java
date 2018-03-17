package Robot;

import java.util.LinkedList;

public class Robot {
		public LinkedList<Point> Articulations;
		public int []distance;
		private int SomDist=0;
		public Robot ()
		{
			this.Articulations = new LinkedList <Point>();
			distance = new int [1];
			distance [0] =50;
			SomDist = distance [0];
			this.Articulations.add( new Point(0,0) );
			this.Articulations.add( new Point(0,distance [0]) );
			
		}
		public Robot (int n)
		{
			this.Articulations = new LinkedList <Point>();
			distance = new int [n-1];
			this.Articulations.add( new Point(0,0) );
			for (int i=0;i<n-1;i++)
			{
				distance [i] =50;
				SomDist += distance [i];
				this.Articulations.add( new Point(0,(i+1)*distance [i]) );
			}
		}
		public Robot (int[] dist)
		{
			int n = dist.length;
			this.Articulations = new LinkedList <Point>();
			distance = new int [n];
			this.Articulations.add( new Point(0,0) );
			for (int i=0;i<n;i++)
			{
				distance [i] =dist[i];
				SomDist += distance [i];
				this.Articulations.add( new Point(0,(i+1)*distance [i]) );
			}
		}
		
		public boolean InvKin (Point target)
		{
			double d= Point.getDistance(this.Articulations.getFirst(),target);
			if (d>this.SomDist)
				{
				NonAccessible(target);
				return false;//Non Accessible
				}
			else 
			{
				
			}
			return true;//Accessible
		}
		private void NonAccessible(Point target)
		{
			int n = this.Articulations.size();
			double lamda, r;
			Point resultat;
			for (int i = 0;i <n-1;i++)
			{
				r = Point.getDistance(target, this.Articulations.get(i));
				lamda = this.distance[i]/r;
				resultat =Point.mul(this.Articulations.get(i),
						            (1.0-lamda));
				resultat = Point.add(resultat, 
									Point.mul(target,
						            lamda) );
				this.Articulations.get(i).setPoint(resultat);
				
			}
		}
}

package Robot;

import java.util.LinkedList;

public class Robot {
	
		public LinkedList<Point> Articulations;
		public int []distance;
		private int SomDist=0;
		private Point base;
		public Robot ()
		{
			this.Articulations = new LinkedList <Point>();
			distance = new int [1];
			distance [0] =50;
			SomDist = distance [0];
			base = new Point ();
			this.Articulations.add( new Point(0,0) );
			this.Articulations.add( new Point(0,distance [0]) );
			
		}
		public Robot (Point base, int n)
		{
			this.Articulations = new LinkedList <Point>();
			distance = new int [n-1];
			this.base = base;
			this.Articulations.add(new Point(this.base.x,this.base.y) );
			
			Point tmp=new Point ();
			for (int i=0;i<n-1;i++)
			{
				distance [i] =50;
				SomDist += distance [i];
				tmp =new Point(0,(i+1)*distance [i]);
				this.Articulations.add( Point.add(this.base, tmp) );
			}
		}
		public Robot (Point base,int[] dist)
		{
			int n = dist.length;
			this.base = base;
			Point tmp=new Point ();
			this.Articulations = new LinkedList <Point>();
			distance = new int [n];
			this.Articulations.add(new Point(this.base.x,this.base.y) );
			for (int i=0;i<n;i++)
			{
				distance [i] =dist[i];
				SomDist += distance [i];
				tmp =new Point(0,(i+1)*distance [i]);
				this.Articulations.add( Point.add(this.base, tmp) );
			}
		}
		
		public boolean InvKin (Point target)
		{
			int n= this.Articulations.size();

			double d= Point.getDistance(this.Articulations.getFirst(),target);
			if (d>this.SomDist)
				{
				NonAccessible(target);
				return false;//Non Accessible
				}
			else 
			{//Cible Accessible
				double erreur = Point.getDistance(target, 
												  this.Articulations.getLast());
				double tol = 0.01;
				int itr =0;
				while (erreur>tol && itr <20)
				{
					ForwardStep(target);
					BackwardStep(this.base);
					erreur = Point.getDistance(target, 
							  this.Articulations.getLast());
					itr++;
				}
				
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
				this.Articulations.get(i+1).setPoint(resultat);
				
			}
		}
		private void ForwardStep (Point target)
		{ 
			int n = this.Articulations.size();
			double r,lamda;
			Point resultat;
			
			this.Articulations.getLast().setPoint(target);//Pn = t;
			
			for ( int i = n-2 ; i>=0 ; i--)
			{ 
				r = Point.getDistance( this.Articulations.get(i), 
						               this.Articulations.get(i+1));
				lamda = this.distance[i]/r;
				//resultat = (1-lamda) * Pi+1
				resultat =Point.mul(this.Articulations.get(i+1),(1.0-lamda));
				//resultat = resultat + lamda*Pi
				resultat = Point.add(resultat, Point.mul(this.Articulations.get(i),lamda) );
				this.Articulations.get(i).setPoint(resultat); //Pi=resultat
			}
		}
		private void BackwardStep (Point base)
		{
			int n = this.Articulations.size();
			double r,lamda;
			Point resultat;
			
			this.Articulations.getFirst().setPoint(base);//P1 = base;
			
			for ( int i = 0 ; i<n-1 ; i++)
			{ 
				r = Point.getDistance( this.Articulations.get(i), 
						               this.Articulations.get(i+1));
				lamda = this.distance[i]/r;
				//resultat = (1-lamda) * Pi+1
				resultat =Point.mul(this.Articulations.get(i),(1.0-lamda));
				//resultat = resultat + lamda*Pi
				resultat = Point.add(resultat, Point.mul(this.Articulations.get(i+1),lamda) );
				this.Articulations.get(i+1).setPoint(resultat); //Pi=resultat
			}
		}
}

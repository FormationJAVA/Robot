package Affichage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import Robot.*;
public class Pan extends JPanel implements MouseMotionListener {
	private Robot R;
	private Point target;
	Pan ()
	{
		R = new Robot(new Point (300,300),5);
		target = new Point();
		this.addMouseMotionListener(this);
	}
	
	public void paintComponent (Graphics g)
	{
		int n = R.Articulations.size();
		Point P1,P2 = new Point();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.GREEN);
		for (int i =0; i< n-1;i++)
		{
			P1 = R.Articulations.get(i);
			P2 = R.Articulations.get(i+1);
			g.drawLine(P1.x, P1.y, P2.x, P2.y);
			g.fillOval(P1.x-10, P1.y-10, 20, 20);
		}
		g.fillOval(P2.x-10, P2.y-10, 20, 20);
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		target.x = e.getX();
		target.y = e.getY();
		System.out.println(target);
		R.InvKin(target);
		   repaint();

	}

}

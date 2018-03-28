package Affichage;

import javax.swing.JFrame;

public class winRobot extends JFrame {
	Pan Pn;
	public winRobot ()
	{
		Pn = new Pan();
		this.setSize(800,600);
		this.setTitle("Mon Robot");
		this.setContentPane(Pn);
		this.setVisible(true);
	}
	public static void main(String[] args) {

		winRobot wr = new winRobot ();
	}

}

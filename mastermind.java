import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class mastermind extends JFrame implements MouseListener
{

	

	public static void main(String args[]) 
	{
		new mastermind();
	}

	mastermind() 
	{
		setSize(300, 600);
		setTitle("Mastermind");
		getContentPane().setBackground(Color.lightGray);
		
		addMouseListener(this);
		setVisible(true);
	}

	public void paint(Graphics g) {

		
	}

	//Overridden Methods from MouseListener Interface
	//These methods are called automatically when corresponding mouse
	//event occurs 
	/////////////////////////////////////////////////
	public void mousePressed(MouseEvent e) 
	{
	   
	}
	
	public void mouseReleased(MouseEvent e)
	{
	    
	}
	
	public void mouseEntered(MouseEvent e) 
	{
	   
	}
	
	public void mouseExited(MouseEvent e) 
	{
	    
	}
	
	public void mouseClicked(MouseEvent e) 
	{
		
	}
	
	public Ellipse2D returnGuessEllipse(int turn, int column) {
		return new Ellipse2D.Double((column*60)+30,(turn*60)+30,50,50);	
	}

	public Ellipse2D returnResponseEllipse(int turn, int index) {
		if (index == 0) {
			return new Ellipse2D.Double((4*60)+15,(turn*60)+15,25,25);	
		}
		else if (index == 1) {
			return new Ellipse2D.Double((4*60)+45,(turn*60)+15,25,25);	
		}
		else if (index == 2) {
			return new Ellipse2D.Double((4*60)+15,(turn*60)+45,25,25);	
		}
		else if (index == 3) {
			return new Ellipse2D.Double((4*60)+45,(turn*60)+45,25,25);	
		}
		return new Ellipse2D.Double(0,0,0,0);
	}
	
	public Color returnColorForCharacter(char c){
		if (c == 'r'){
			return Color.red;
		}
		else if (c == 'g'){
			return Color.green;
		}
		else if (c == 'b'){
			return Color.blue;
		}
		else if (c == 'w'){
			return Color.white;
		}
		else if (c == 'y'){
			return Color.yellow;
		}
		else if (c == 'o'){
			return Color.orange;
		}
		else{
			return Color.lightGray;
		}
	}
	
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mastermind extends JFrame implements MouseListener
{

	public JLabel label;

	public static void main(String args[]) 
	{
		new mastermind();
	}

	mastermind() 
	{
		setSize(300, 600);
		setTitle("Mastermind");

		label = new JLabel("No Mouse Event Captured", JLabel.CENTER);
		add(label);

		addMouseListener(this);
		setVisible(true);
	}

	public void paint(Graphics g) {

		label.setText("Drawn");
	}

	//Overridden Methods from MouseListener Interface
	//These methods are called automatically when corresponding mouse
	//event occurs 
	/////////////////////////////////////////////////
	public void mousePressed(MouseEvent e) 
	{
	   label.setText("Mouse Pressed");
	}
	
	public void mouseReleased(MouseEvent e)
	{
	    label.setText("Mouse Released");
	}
	
	public void mouseEntered(MouseEvent e) 
	{
	    label.setText("Mouse Entered");
	}
	
	public void mouseExited(MouseEvent e) 
	{
	    label.setText("Mouse Exited");
	}
	
	public void mouseClicked(MouseEvent e) 
	{
	    label.setText("Mouse Clicked");
	}
}

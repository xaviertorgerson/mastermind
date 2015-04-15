import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class mastermind extends JFrame implements MouseListener
{

	code[] guessArray;
	code[] responseArray;
	
	int turn = 0;

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

		//Initialize variables
		guessArray = new code[10]();
		responseArray = new code[(guessArray.length-1)]();
		
		guessArray[(guessArray.length-1)] = new code({'w','w','w','w'); // Genterate random code	

	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);


		for (int row = 0; row <= turn; row++) {
			for(int i = 0; i < 4; i++) {		
				g2d.setColor(returnColorForCharacter(guessArray[turn].getColorAtIndex(i)));	
				g2d.fill(returnGuessEllipse(row,i));
				g2d.setColor(returnForCharacter(responserArray[turn].getColorAtIndex(i)));	
				g2d.fill(returnResponseEllipse(row,i));
			}
		}

		for(int i = 0; i < 4; i++) {
			g2d.setColor(returnColorForCharacter(guessArray[guessArray.length-1].getColorAtIndex(i)));	
			g2d.fill(returnGuessEllipse((guessArray.length-1),i));
		}

		g2d.setColor(Color.red);	
		g2d.fill(new Rectangle2D.Double(((4*60)+30,((guessArray.length-1)*60)+30,60,60));


	}

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

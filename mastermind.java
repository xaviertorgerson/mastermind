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
		guessArray = new code[10];
		responseArray = new code[(guessArray.length-1)];
		
		char[] defaultGuess = {'w','w','w','w'};
		guessArray[(guessArray.length-1)] = new code(defaultGuess);	

	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		
		for (int row = 0; row < turn; row++) {
			for(int i = 0; i < 4; i++) {		
				char col = guessArray[turn].getColorAtIndex(i);
				g2d.setColor(returnColorForCharacter(col));	
				g2d.fill(returnGuessEllipse(row,i));
				
				col = responseArray[turn].getColorAtIndex(i);
				g2d.setColor(returnColorForCharacter(col));
				g2d.fill(returnResponseEllipse(row,i));
			}
		}
		

		for(int i = 0; i < 4; i++) {
			g2d.setColor(returnColorForCharacter(guessArray[guessArray.length-1].getColorAtIndex(i)));	
			g2d.fill(returnGuessEllipse((guessArray.length-1),i));
		}
		

		g2d.setColor(Color.red);	
		g2d.fill(new Rectangle2D.Double((4*60),(guessArray.length-1)*60,60,60));


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
		if (e.getButton() == 1) {
			Rectangle2D rect = new Rectangle2D.Double((4*60),(guessArray.length-1)*60,60,60);
			if (rect.contains(e.getX(), e.getY())) {
				//Enter button
				//Check for turn
				//Add guess to list
				//Compare Guess
				//Add response to list
				//Repaint

				System.out.println("GO");
			}
			else if (returnGuessEllipse((guessArray.length-1),0).contains(e.getX(), e.getY()) ) {
				char currentColor = guessArray[guessArray.length-1].getColorAtIndex(0);
				char newColor = returnNextColor(currentColor);
				guessArray[guessArray.length-1].setColorAtIndex(0,newColor);
			}	
			else if (returnGuessEllipse((guessArray.length-1),1).contains(e.getX(), e.getY()) ) {
				char currentColor = guessArray[guessArray.length-1].getColorAtIndex(1);
				char newColor = returnNextColor(currentColor);
				guessArray[guessArray.length-1].setColorAtIndex(1,newColor);
			}	
			else if (returnGuessEllipse((guessArray.length-1),2).contains(e.getX(), e.getY()) ) {
				char currentColor = guessArray[guessArray.length-1].getColorAtIndex(2);
				char newColor = returnNextColor(currentColor);
				guessArray[guessArray.length-1].setColorAtIndex(2,newColor);
			}	
			else if (returnGuessEllipse((guessArray.length-1),3).contains(e.getX(), e.getY()) ) {
				char currentColor = guessArray[guessArray.length-1].getColorAtIndex(3);
				char newColor = returnNextColor(currentColor);
				guessArray[guessArray.length-1].setColorAtIndex(3,newColor);
			}	
		}
	}

	public Ellipse2D returnGuessEllipse(int turn, int column) {
		return new Ellipse2D.Double(column*60,turn*60,50,50);	
	}

	public Ellipse2D returnResponseEllipse(int turn, int index) {
		if (index == 0) {
			return new Ellipse2D.Double((4*60),(turn*60),25,25);	
		}
		else if (index == 1) {
			return new Ellipse2D.Double((4*60)+30,(turn*60),25,25);	
		}
		else if (index == 2) {
			return new Ellipse2D.Double((4*60),(turn*60)+30,25,25);	
		}
		else if (index == 3) {
			return new Ellipse2D.Double((4*60)+30,(turn*60)+30,25,25);	
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

	public char returnNextColor(char c){
		char [] col = new char[6];
		col[0] = 'r';
		col[1] = 'g';
		col[2] = 'b';
		col[3] = 'w';
		col[4] = 'y';
		col[5] = 'o';
		
		if(c == 'o'){
			return col[0];
		}
		for(int i = 0; i < col.length-2; i++){
			if(c == col[i]){
				return col[i+1];
			}
		}
		
		return col[0];
	}
	
	
	
}

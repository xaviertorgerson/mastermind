import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

public class mastermind extends JFrame implements MouseListener
{

	code[] guessArray;
	code[] responseArray;

	code cpuCode;

	int turn = -2;

	final char[] col = {'r','g','b','w','y','o'}; 
    
    BufferedImage menuImage, winImage, loseImage;

	boolean win = false;

	public static void main(String args[]) 
	{
		new mastermind();
	}
	
	/**
	Constructor method sets up the window and initializes variables
	*/
	mastermind() 
	{
		setSize(300, 622);
		setTitle("Mastermind");
		getContentPane().setBackground(Color.lightGray);

		addMouseListener(this);
		setVisible(true);

	}
	
	public void initialize() {
	
		//Initialize variables
		guessArray = new code[10];
		responseArray = new code[(guessArray.length-1)];

		char[] defaultGuess = {'w','w','w','w'};
		guessArray[(guessArray.length-1)] = new code(defaultGuess);	

		char[] randCode = new char[4];
		Random rand = new Random();
		randCode[0] = col[rand.nextInt(6)]; 
		randCode[1] = col[rand.nextInt(6)]; 
		randCode[2] = col[rand.nextInt(6)]; 
		randCode[3] = col[rand.nextInt(6)]; 
		cpuCode = new code(randCode);
 
 		try {
			menuImage = ImageIO.read(new File("menu.png"));
			winImage = ImageIO.read(new File("win.png"));
			loseImage = ImageIO.read(new File("lose.png"));

    	} catch (IOException e) {
    	}
		
	
	
	
	}
	
	/**
	This method renders the pegs.
	*/ 
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		if (turn == -2) {
			this.initialize();
		}
		
		for (int row = 0; row <= turn; row++) {
			for(int i = 0; i < 4; i++) {		
				char col = guessArray[row].getColorAtIndex(i);
				g2d.setColor(returnColorForCharacter(col));	
				g2d.fill(returnGuessEllipse(row,i));

				col = responseArray[row].getColorAtIndex(i);
				g2d.setColor(returnColorForCharacter(col));
				g2d.fill(returnResponseEllipse(row,i));
			}
		}

		for(int i = 0; i < 4; i++) {
			g2d.setColor(returnColorForCharacter(guessArray[guessArray.length-1].getColorAtIndex(i)));	
			g2d.fill(returnGuessEllipse((guessArray.length-1),i));
			
			
		}
		
		g2d.setColor(Color.red);	
		g2d.fill(new Rectangle2D.Double((4*60),((guessArray.length-1)*60)+22,60,60));

		if(turn == -2) {
			g2d.drawImage(menuImage, 0, 0, null);
		}
		else if(turn == guessArray.length-2) {
			if(win) {
				g2d.drawImage(winImage, 0, 0, null);
			}
			else {
				g2d.drawImage(loseImage, 0, 0, null);
			}
		}
	

	}
	
	/**
	Listeners for different mouse events.
	*/
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
	
	/**
	This method determines where the mouse clicked, and what function to perform
	depending on it's coordinates. Using the click of the mouse, you can change the
	color of the guessing ellipsis and input the answer. 
	@parameter A class that describes mouse click.
	*/
	public void mouseClicked(MouseEvent e) 
	{
			if (e.getButton() == 1) {
				if(turn == -2){
					turn++;
				}
				else if(turn == guessArray.length - 2){
					turn=-2;
				}
				else {
				Rectangle2D rect = new Rectangle2D.Double((4*60),((guessArray.length-1)*60)+22,60,60);
				if (rect.contains(e.getX(), e.getY())) {

					turn++;

					guessArray[turn] = new code(guessArray[guessArray.length-1]);

					code response = new code();

					int redCount = guessArray[turn].sameColorSamePosition(cpuCode);	
					int whiteCount = guessArray[turn].sameColor(cpuCode) - guessArray[turn].sameColorSamePosition(cpuCode);

					for(int i = 0; i < redCount; i++) {
						response.append('r');
					}

					for(int i = 0; i < whiteCount; i++) {
						response.append('w');
					}

					responseArray[turn] = new code(response);


					char[] winCode = {'r','r','r','r'};
					if(responseArray[turn].sameColorSamePosition(new code(winCode)) == 4) {
						win = true;
					}
					else if(turn >= guessArray.length - 2) {
						win = false;
					}

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
				repaint();	
			
			}

	}
	
	/**
	Return the user's guess ellipse.
	@param turn The row the elipse will be drawn. 
	@param column The column the elipse will be drawn.
	@return The user's guess ellipse.
	*/
	public Ellipse2D returnGuessEllipse(int turn, int column) {
		return new Ellipse2D.Double((column*60)+5,(turn*60)+27,50,50);	
	}

	/**
	This method returns an ellipse for the red/white matching code indicators.
	@param turn Determines the height of the position.
	@param index Determines which position the ellipse is in.
	@return An ellipse for the red/white matching code indicators.
	*/
	public Ellipse2D returnResponseEllipse(int turn, int index) {
		if (index == 0) {
			return new Ellipse2D.Double((4*60)+2.5,(turn*60)+29.5,25,25);	
		}
		else if (index == 1) {
			return new Ellipse2D.Double((4*60)+32.5,(turn*60)+29.5,25,25);	
		}
		else if (index == 2) {
			return new Ellipse2D.Double((4*60)+2.5,(turn*60)+61.5,25,25);	
		}
		else if (index == 3) {
			return new Ellipse2D.Double((4*60)+32.5,(turn*60)+61.5,25,25);	
		}
		return new Ellipse2D.Double(0,0,0,0);
	}

	/**
	This method returns the color of an ellipse.
	@param c is the character representing the color of the code button.
	@return Color of an ellipse in proper form.
	*/
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
	
	/**
	This method changes the color of the button in the user's guessing code.
	@param c is the character representing the color of the code button.
	@return The new color reference character. 
	*/
	public char returnNextColor(char c){
		
		if(c == 'o'){
			return col[0];
		}
		for(int i = 0; i < col.length-1; i++){
			if(c == col[i]){
				return col[i+1];
			}
		}
		
		return col[0];
	}
	
	
	
}

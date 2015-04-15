import java.util.*;

public class code {
	
	private char[] colors;

	code() {
		colors = new char[4];
		setColorAtIndex(0,'n');
		setColorAtIndex(1,'n');
		setColorAtIndex(2,'n');
		setColorAtIndex(3,'n');
	}

	code(char[] c) {
		colors = new char[4];
		setColorAtIndex(0,c[0]);
		setColorAtIndex(1,c[1]);
		setColorAtIndex(2,c[2]);
		setColorAtIndex(3,c[3]);
	}

	code(code c) {
		colors = new char[4];
		setColorAtIndex(0,c.colors[0]);
		setColorAtIndex(1,c.colors[1]);
		setColorAtIndex(2,c.colors[2]);
		setColorAtIndex(3,c.colors[3]);
	}

	public void setColorAtIndex(int i, char val) {
		this.colors[i] = val;
	}

	public char getColorAtIndex(int i) {
		
		return colors[i];
	
	}

	public char[] getColors() {
		char[] returnColors = new char[4];
		returnColors[0] = getColorAtIndex(0);
		returnColors[1] = getColorAtIndex(1);
		returnColors[2] = getColorAtIndex(2);
		returnColors[3] = getColorAtIndex(3);
		
		return returnColors;
	}

	public int sameColor(code c) {
		int count = 0;
		boolean[] matched = {false,false,false,false};
		
		for (int i = 0; i < colors.length; i++) {
			for (int k = 0; k < c.colors.length; k++) {
				if (colors[i] == c.colors[k]) {
					if (matched[k] == false) {
						matched[k] = true;
						count++;
						k = c.colors.length;
					}
				}
			}
		}

		return count;
	}

	public int sameColorSamePosition(code c) {
		int count = 0;
		
		for (int i = 0; i < colors.length; i++) {
			if (colors[i] == c.colors[i]) {
				count++;
			}
		}

		return count;
	}

	public boolean append(char c) {
		for (int i = 0; i < colors.length; i++) {
			if(colors[i] == 'n') 
			{
				colors[i] = c;
				return false;
			}
		}
		return true;
	}

	public String toString() {
		return "Code: " + colors[0] + colors[1] + colors[2] + colors[3] + " at address: " + colors;
	}

}

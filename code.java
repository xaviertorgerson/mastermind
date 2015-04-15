public class code {
	
	char[] colors;

	code() {
		colors = new char[4];
	}

	code(char[] colors) {
		this.colors = colors;
	}

	code(code c) {
		this.colors = c.colors;
	}

	public void setColorAtIndex(int i, char val) {
		colors[i] = val;
	}

	public char getColorAtIndex(int i) {
		return colors[i];
	
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
}

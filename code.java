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
	
	public int sameColor(code c) {
		int count = 0;
		boolean[4] matched = {false,false,false,false};
		
		for (int i = 0; i < colors.length; i++) {
			for (int k = 0; k < c.colors.length; k++) {
				if (colors[i] = c.colors[k]) {
					if (matched[k] == false) {
						matched[k] = true;
						count++;
						k = c.colors.length;
					}
				}
			}
		}
	}

	public int sameColorSamePosition(code c) {
		int count = 0;
		
		for (int i = 0; i < colors.length; i++) {
			if (colors[i] = c.colors[i]) {
				count++;
			}
		}
	}
}

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
}	

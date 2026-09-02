package bingo.model;

public class Player {
	private String name;
	private String mode;

	public Player(String name) {
		this.name = name;
		this.mode = "NORMAL";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}

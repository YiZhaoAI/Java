import java.util.Random;

public class Grid {

	private int gridX, gridY;
	private int gridType = 13;

	public Grid(Player p) {
		if (p.getScoreTotal() >= Thre.trophyThre) {
			this.setGridType(12);
		} else {
			Random t = new Random();
			this.setGridType((t.nextInt(12)) + 1);
		}

		int x = p.getPlayerX();
		int y = p.getPlayerY();
		Random r = new Random();

		if (x == 0 && y == 0) {
			switch (r.nextInt(3)) {
			case 0:
				this.setGridX(x + 50);
				this.setGridY(y);
				break;
			case 1:
				this.setGridX(x + 50);
				this.setGridY(y + 50);
				break;
			case 2:
				this.setGridX(x);
				this.setGridY(y + 50);
				break;
			}
		} else if (x == 0 && (y >= 50 && y <= 400)) {
			switch (r.nextInt(5)) {
			case 0:
				this.setGridX(x + 50);
				this.setGridY(y);
				break;
			case 1:
				this.setGridX(x + 50);
				this.setGridY(y + 50);
				break;
			case 2:
				this.setGridX(x);
				this.setGridY(y + 50);
				break;
			case 3:
				this.setGridX(x);
				this.setGridY(y - 50);
				break;
			case 4:
				this.setGridX(x + 50);
				this.setGridY(y - 50);
				break;
			}
		} else if (x == 0 && y == 450) {
			switch (r.nextInt(3)) {
			case 0:
				this.setGridX(x + 50);
				this.setGridY(y);
				break;
			case 1:
				this.setGridX(x + 50);
				this.setGridY(y - 50);
				break;
			case 2:
				this.setGridX(x);
				this.setGridY(y - 50);
				break;
			}
		} else if ((x >= 50 && x <= 400) && y == 450) {
			switch (r.nextInt(5)) {
			case 0:
				this.setGridX(x + 50);
				this.setGridY(y);
				break;
			case 1:
				this.setGridX(x + 50);
				this.setGridY(y - 50);
				break;
			case 2:
				this.setGridX(x);
				this.setGridY(y - 50);
				break;
			case 3:
				this.setGridX(x - 50);
				this.setGridY(y);
				break;
			case 4:
				this.setGridX(x - 50);
				this.setGridY(y - 50);
				break;
			}

		} else if (x == 450 && y == 450) {
			switch (r.nextInt(3)) {
			case 0:
				this.setGridX(x - 50);
				this.setGridY(y);
				break;
			case 1:
				this.setGridX(x - 50);
				this.setGridY(y - 50);
				break;
			case 2:
				this.setGridX(x);
				this.setGridY(y - 50);
				break;
			}
		} else if (x == 450 && (y >= 50 && y <= 400)) {
			switch (r.nextInt(5)) {
			case 0:
				this.setGridX(x - 50);
				this.setGridY(y);
				break;
			case 1:
				this.setGridX(x - 50);
				this.setGridY(y - 50);
				break;
			case 2:
				this.setGridX(x);
				this.setGridY(y - 50);
				break;
			case 3:
				this.setGridX(x - 50);
				this.setGridY(y + 50);
				break;
			case 4:
				this.setGridX(x);
				this.setGridY(y + 50);
				break;
			}
		} else if (x == 450 && y == 0) {
			switch (r.nextInt(3)) {
			case 0:
				this.setGridX(x - 50);
				this.setGridY(y);
				break;
			case 1:
				this.setGridX(x - 50);
				this.setGridY(y + 50);
				break;
			case 2:
				this.setGridX(x);
				this.setGridY(y + 50);
				break;
			}
		} else if (y == 0 && (x >= 50 && x <= 400)) {
			switch (r.nextInt(5)) {
			case 0:
				this.setGridX(x - 50);
				this.setGridY(y);
				break;
			case 1:
				this.setGridX(x + 50);
				this.setGridY(y);
				break;
			case 2:
				this.setGridX(x);
				this.setGridY(y + 50);
				break;
			case 3:
				this.setGridX(x - 50);
				this.setGridY(y + 50);
				break;
			case 4:
				this.setGridX(x + 50);
				this.setGridY(y + 50);
				break;
			}
		} else {
			switch (r.nextInt(8)) {
			case 0:
				this.setGridX(x - 50);
				this.setGridY(y);
				break;
			case 1:
				this.setGridX(x + 50);
				this.setGridY(y);
				break;
			case 2:
				this.setGridX(x - 50);
				this.setGridY(y - 50);
				break;
			case 3:
				this.setGridX(x);
				this.setGridY(y - 50);
				break;
			case 4:
				this.setGridX(x + 50);
				this.setGridY(y - 50);
				break;
			case 5:
				this.setGridX(x - 50);
				this.setGridY(y + 50);
				break;
			case 6:
				this.setGridX(x);
				this.setGridY(y + 50);
				break;
			case 7:
				this.setGridX(x + 50);
				this.setGridY(y + 50);
				break;
			}
		}

	}

	public int getGridY() {
		return gridY;
	}

	public void setGridY(int gridY) {
		this.gridY = gridY;
	}

	public int getGridX() {
		return gridX;
	}

	public void setGridX(int gridX) {
		this.gridX = gridX;
	}

	public int getGridType() {
		return gridType;
	}

	public void setGridType(int gridType) {
		this.gridType = gridType;
	}

}

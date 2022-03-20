package setUp;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;


public class Board extends JPanel {
	
	//random generated serialVersionUID to stop errors
	private static final long serialVersionUID = -5692653319999289818L;
	
	private Random rnd = new Random();
	private int boardType;
	private Tile[][] board;
	private int rows;
	private int cols;
	
	
	private String[] board1 = {"board level 1"};
	private String[] board2 = {"board level 2"};
	private String[] board3 = {"board level 3"};
	
	
	public Board(int boardType, int rows, int cols) {
		this.boardType = boardType;
		this.board = new Tile[rows][cols];
		this.rows = rows;
		this.cols = cols;
		
		setLayout(new GridLayout(rows, cols));
		loadBoard();
	}
	
	
	public void printBoard() {
		if (boardType==1) {
			for (String row : board1) {
				System.out.println(row);
			}
		} else if (boardType==2) {
			for (String row : board2) {
				System.out.println(row);
			}
		} else if (boardType==3) {
			for (String row : board3) {
				System.out.println(row);
			}
		} //must check that difficulty level is range 1-3...
	}
	
	//borrowed from example project and changed for testing.
	private void loadBoard() {
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				Tile t = new Tile(getRandomTileType());
				board[j][i] = t;
				add(t);
			}
		}
	}
	
	//also borrowed from example code
	private TileType getRandomTileType() {
		double val = rnd.nextDouble();
		if (val < 0.88) {
			return TileType.OPEN_FLOOR;
		} else if (val < 0.92) {
			return TileType.PIT;
		} else if (val < 0.96) {
			return TileType.ACID;
		} else {
			return TileType.RADIATION;
		}
	}
	
}

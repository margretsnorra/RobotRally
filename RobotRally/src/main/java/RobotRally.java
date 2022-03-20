
import javax.swing.JFrame;

import setUp.Board;

import java.awt.FlowLayout;


public class RobotRally {
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame("RobotRalley game");
		
		Board board = new Board(1, 10, 10);
		
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		f.add(board);
		f.setSize(700, 700);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}

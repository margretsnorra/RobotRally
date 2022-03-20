package setUp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Tile extends JPanel {
	
	//random generated serialVersionUID to stop errors 
	private static final long serialVersionUID = 5745157799262473507L;

	public static final int PIXEL_SIZE = 66;
	
	private TileType type;
	private BufferedImage image;
	
	public Tile(TileType type) {
		super(true);
		
		this.type = type;
		
		try {
			this.image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(this.type.getPictureFile()));
		} catch (IOException e) {
			this.image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
			System.out.println("oops");
		}
		
		setMinimumSize(new Dimension(PIXEL_SIZE, PIXEL_SIZE));
		setPreferredSize(getMinimumSize());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, null);
	}
}

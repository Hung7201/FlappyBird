package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {
	static int i = 1;
	GamePanel gp;
	public Tile [] tiles;
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tiles = new Tile[20];
		getTileImage();
	}
	
	public void getTileImage() {
		try {
			tiles[0] = new Tile();
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/background.png"));
			
			tiles[1] = new Tile();
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ground_1.png"));
			
			tiles[2] = new Tile();
			tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ground_2.png"));
			
			tiles[3] = new Tile();
			tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ground_3.png"));
			
			tiles[4] = new Tile();
			tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ground_4.png"));
			
			tiles[5] = new Tile();
			tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ground_5.png"));
			
			tiles[6] = new Tile();
			tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ground_6.png"));
			
			tiles[7] = new Tile();
			tiles[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ground_7.png"));
			
			tiles[8] = new Tile();
			tiles[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ground_8.png"));
			
			tiles[9] = new Tile();
			tiles[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ground_9.png"));
			
			tiles[10] = new Tile();
			tiles[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ground_10.png"));
			
			tiles[11] = new Tile();
			tiles[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ground_11.png"));
			
			tiles[12] = new Tile();
			tiles[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Ground_12.png"));
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(tiles[0].image, 0, 0, gp.screenWidth, gp.screenHeight, null);
		g2.drawImage(tiles[i].image, 0, gp.screenHeight - tiles[i].image.getHeight(), gp.screenWidth,tiles[i].image.getHeight(), null);
		i++; 
		if(i == 13) i = 1;
	}
}

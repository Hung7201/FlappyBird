package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		setDefault();
		getPlayerImage();
	}
	
	public void setDefault() {
		x = 200;
		y = 200;
		speed = 5;
		dir = "normal";
	}
	
	public void getPlayerImage()  {	
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/player/bird_up.png"));
			nor = ImageIO.read(getClass().getResourceAsStream("/player/bird_normal.png"));
			//down = ImageIO.read(getClass().getResourceAsStream("/player/bird_down.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		if(keyH.space == true) {
			y -= speed + 6; 
			dir = "up";
		}
		else {
			y += speed + 2;
			dir = "normal";
		}
	}
	
	public void draw(Graphics g2) {
		BufferedImage image = null;
		if(dir == "up") image = up;
		else image = nor;
		g2.drawImage(image, x, y, gp.TileSize, gp.TileSize, null);
	}
}

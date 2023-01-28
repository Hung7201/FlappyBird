package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Pipe extends Entity{
	
	public BufferedImage upPipe, downPipe;
//	GamePanel gp;
//	
//	
//	
//	public Pipe(GamePanel gp) {
//		this.gp = gp;
//		getPipe();
//	}
//	
//	public void getPipe() {
//		try {
//			upPipe = ImageIO.read(getClass().getResourceAsStream("/pipe/pipe_1_rs.png"));
//			downPipe = ImageIO.read(getClass().getResourceAsStream("/pipe/pipe_2_rs.png"));
//		} catch (IOException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//	
//	public void draw(Graphics2D g2) {
//		g2.drawImage(upPipe, 300, 0 - gp.TileSize, upPipe.getWidth() , upPipe.getHeight(), null);
//		g2.drawImage(downPipe, 300, gp.screenHeight , downPipe.getWidth() , downPipe.getHeight() - 350, null);
//	}
//	
}

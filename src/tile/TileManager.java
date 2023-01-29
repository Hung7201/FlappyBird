package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Pipe;
import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	public Tile [] tiles;
	public Pipe upperPipe, lowerPipe;
	public Pipe[] upp, low;
	
	
	
	static int i = 1;
	//static int des = 5;
	
	int countDown = 100; // khoảng thời gian cột tiếp theo xuất hiện
	int next = 1, begin = 0;
	
	final int gap = 180; // Khoảng cách giữa hai cột 
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tiles = new Tile[20];
		getTileImage();
		getPipe();
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
	
	public void getPipe() {
		try {
			upperPipe = new Pipe(gp.screenWidth); 
			lowerPipe = new Pipe(gp.screenWidth );
			upperPipe.img = ImageIO.read(getClass().getResourceAsStream("/pipe/pipe_1_rs.png"));
			lowerPipe.img = ImageIO.read(getClass().getResourceAsStream("/pipe/pipe_2_rs.png"));
			
			// 1 dãy pipe
			upp = new Pipe[1005];
			low = new Pipe[1005];
			for(int j = 0; j < 1005; j++) {
				upp[j] = new Pipe(gp.screenWidth);
				low[j] = new Pipe(gp.screenWidth);
				upp[j].img = upperPipe.img;
				low[j].img = lowerPipe.img;
				ramdom(upp[j]);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
	}
}
	
	public void ramdom(Pipe p) {
		p.y = (int) ((Math.random() * (-50 +300) - 300)); // tạo random vị trí của cột trên
	}
	
	public void draw(Graphics2D g2) {
		
		g2.drawImage(tiles[0].image, 0, 0, gp.screenWidth, gp.screenHeight, null); // background
	
		countDown--;
		if(countDown < 0) {
			next++;
			countDown = 100;
		}

		for(int j = begin;j < next; j++) {
			g2.drawImage(upp[j].img, upp[j].x, upp[j].y, upp[j].img.getWidth(), upp[j].img.getHeight(), null ); //upperPipe
			g2.drawImage(low[j].img, low[j].x,upp[j].y + upp[j].img.getHeight() + gap, upp[j].img.getWidth(), low[j].img.getHeight(), null ); // lowerPipe
			if(upp[begin].x < -200) begin++; 
			upp[j].x -= upp[j].speed;
			low[j].x -= upp[j].speed;
		}
		
		g2.drawImage(tiles[i].image, 0, gp.screenHeight - tiles[i].image.getHeight(), gp.screenWidth,tiles[i].image.getHeight(), null); // Ground
		i++; 
		if(i == 13) i = 1;
//		upperPipe.x -= des;
//		lowerPipe.x -= des;
	}
}

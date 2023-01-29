package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entity.Pipe;
import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
		// SCREEN SETTINGS
		
		final int originTileSize = 16;
		final int scale = 3;
		
		public final int TileSize = originTileSize * scale; // 48 X 48 tile 
		final int maxScreenCol = 18;
		final int maxScreenRow = 14;
		
		public final int screenWidth = maxScreenCol * TileSize; //864 pixels
		public final int screenHeight = maxScreenRow * TileSize;	// 672 pixels
		
		//FPS
		int FPS = 60;
		
		//BACKGROUND
		TileManager tileM = new TileManager(this);
		
		
		// Key Handler
		KeyHandler key = new KeyHandler();
		
		//Player
		Player player = new Player(this, key);

		//Thread
		Thread gameThread;
		
		public void startGame() {
			gameThread = new Thread(this);
			gameThread.start();
		}
		
		public GamePanel() {
			this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		    this.setBackground(Color.black);
			this.setDoubleBuffered(true);
			this.addKeyListener(key);
			this.setFocusable(true);
		}
		

		@Override
		// GAME LOOP
		public void run() {
			double drawInterval = 1e9 / FPS;
			double nextDraw = System.nanoTime() + drawInterval;
			while(gameThread != null) {
				update();
				repaint();
				
				try {
					double remanning = nextDraw - System.nanoTime();
					remanning /= 1e6;
					if(remanning < 0) remanning = 0;
					gameThread.sleep((long) remanning);
					nextDraw += drawInterval;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(player.y + TileSize + tileM.tiles[1].image.getHeight() >= screenHeight) {
					gameOver();
					break;
				}
			}
		}
		
		public void update() {
			player.update();
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			tileM.draw(g2);
			player.draw(g2);
	
		}
		
		
		// GAME OVER
		public void gameOver() {
			JOptionPane.showMessageDialog(this, "YOU LOST !!","Inform", JOptionPane.WARNING_MESSAGE);
		}
		
		
}

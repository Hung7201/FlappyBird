package entity;

import java.awt.image.BufferedImage;

import javax.sql.rowset.RowSetMetaDataImpl;

public class Pipe extends Entity{
	
	public BufferedImage img;
	
	public Pipe(int x) {
		setDefault(x);
	}
	
	// SET DEFAULT
	public void setDefault(int x) {
		this.x = x;
		speed = 3;
	}
}

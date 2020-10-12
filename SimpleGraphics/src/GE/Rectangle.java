package GE;

import java.awt.Color;
import java.awt.Graphics;

class Rectangle extends Shape {

	public Rectangle(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		super.type = "Rectangle";
	}
	
	public Rectangle(int x, int y) {
		super(x, y, 50, 70, Color.blue);
		super.type = "Rectangle";
	}

	@Override
	public Shape copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, width, height);
		
	}

	@Override
	public boolean isOn(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resize(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		
	}

}

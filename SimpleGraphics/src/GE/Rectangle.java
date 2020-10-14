package GE;

import java.awt.Color;
import java.awt.Graphics;

class Rectangle extends Shape {
	
	private int centerX, centerY;

	public Rectangle(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		super.type = "Rectangle";
		centerX = x-w/2;
		centerY = y-h/2;
	}
	
	public Rectangle(int x, int y) {
		super(x, y, 50, 70, Color.blue);
		super.type = "Rectangle";
		centerX = x-50/2;
		centerY = y-70/2;
		
	}

	@Override
	public Shape copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(centerX, centerY, width, height);
		
	}

	@Override
	public boolean isOn(int xc, int yc) {
		if(Math.abs(xc-x) <= width/2 &&  Math.abs(yc-y) <= height/2){
			System.out.println("true");
			return true;
		}
		return false;
	}

	@Override
	public void resize(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		
	}

}

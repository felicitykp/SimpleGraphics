package GE;

import java.awt.Color;
import java.awt.Graphics;

class Rectangle extends Shape {
	
	private int UpperLeftX, UpperLeftY;

	public Rectangle(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		super.type = "Rectangle";
		//x and y are center coordinates
		UpperLeftX = x-w/2;
		UpperLeftY = y-h/2;
	}
	
	public Rectangle(int x, int y, Color c) {
		super(x, y, 0, 0, c);
		super.type = "Rectangle";
		UpperLeftX = x;
		UpperLeftY = y;
		
	}

	@Override
	public Shape copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		UpperLeftX = x-width/2;
		UpperLeftY = y-height/2;
		g.setColor(c);
		g.fillRect(UpperLeftX, UpperLeftY, width, height);
		
	}

	@Override
	public boolean isOn(int mouseX, int mouseY) {
		if(Math.abs(mouseX-x) <= width/2 &&  Math.abs(mouseY-y) <= height/2){
			System.out.println("true");
			return true;
		}
		return false;
	}

	@Override
	public void resize(int x1, int y1, int x2, int y2) {
		width = Math.abs(x1-x)*2;
		height = Math.abs(y1-y)*2;
		UpperLeftX = x-width/2;
		UpperLeftY = y-height/2;
		
	}

}

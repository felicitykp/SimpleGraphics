package GE;

import java.awt.Color;
import java.awt.Graphics;

class Line extends Shape {
	
	private int startX, startY, endX, endY;
	//this constructor won't not be used
	public Line(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		super.type = "Line";
	}
	//x, y will be the starting x,y coordinates of the line
	public Line(int x, int y, Color c) {
		super(0, 0, 0, 0, c);
		startX = x;
		startY = y;
		endX = x;
		endY = y;
		super.type = "Line";		
	}

	@Override
	public Shape copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.drawLine(startX, startY, endX, endY);
	}

	@Override
	public boolean isOn(int mouseX, int mouseY) {
		int midX = (startX+endX)/2;
		int midY = (startY+endY)/2;
		int LineWidthX = Math.abs(endX-startX);
		double slope = (double)(endY-startY)/(endX-startX);
		if(mouseX <= (midX+(LineWidthX/2)) && mouseX >= (midX-(LineWidthX/2))){
			if( mouseY <= (slope*(mouseX-midX)+midY+15) && mouseY >= (slope*(mouseX-midX)+midY-15)){
				System.out.println(slope);
				System.out.println("true");
				return true;
			}
		}
		return false;
	}

	@Override
	public void resize(int x1, int y1, int x2, int y2) {
		endX = x1;
		endY = y1;
	}

}

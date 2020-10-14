package GE;
import java.awt.Color;
import java.awt.Graphics;

class Circle extends Shape{
	
	private int diameter, centerX, centerY;

	public Circle(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		super.type = "Circle";
		diameter = width;
		centerX = x-diameter/2;
		centerY = y-diameter/2;

	}
	
	public Circle(int x, int y) {
		super(x, y, 60, 60, Color.ORANGE);
		super.type = "Circle";
		diameter = width;
		centerX = x-diameter/2;
		centerY = y-diameter/2;
	}

	@Override
	public Shape copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(centerX, centerY, width, height);
	}

	@Override
	public boolean isOn(int xc, int yc) {
		if(Math.sqrt((Math.abs(xc-x)*Math.abs(xc-x) + Math.abs(yc-y)*Math.abs(yc-y))) <= diameter/2){
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

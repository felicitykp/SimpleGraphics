package GE;
import java.awt.Color;
import java.awt.Graphics;

class Circle extends Shape{
	
	private int UpperLeftX, UpperLeftY;
	//width is set as the diameter. height is not used.

	public Circle(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		super.type = "Circle";
		//x and y are center coordinates
		UpperLeftX = x-width/2;
		UpperLeftY = y-width/2;

	}
	
	public Circle(int x, int y, Color c) {
		super(x, y, 0, 0, c);
		super.type = "Circle";
		//x and y are center coordinates
		UpperLeftX = x-width/2;
		UpperLeftY = y-width/2;
	}

	@Override
	public Shape copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		UpperLeftX = x-width/2;
		UpperLeftY = y-width/2;
		g.setColor(c);
		g.fillOval(UpperLeftX, UpperLeftY, width, width);
	}

	@Override
	public boolean isOn(int mouseX, int mouseY) {
		if(Math.sqrt((mouseX-x)*(mouseX-x)+(mouseY-y)*(mouseY-y)) <= width/2){
			System.out.println("true");
			return true;
		}
			
		return false;
	}

	@Override
	public void resize(int x1, int y1, int x2, int y2) {
		width = (int) (Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y)))*2;
		UpperLeftX = x-width/2;
		UpperLeftY = y-width/2;
		
	}

}

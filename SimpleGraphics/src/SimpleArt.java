import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

// we will extend JPanel (a built-in Java class). A panel will 
// have the graphics capabilities we want (namely paint).
public class SimpleArt extends JPanel  {
	
	// constants that are predefined and won't change 
	// don't use 'magic numbers' in your code!!!

	
	// the width/height of our window - note I set this 
	// final bc I didn't allow the window size to change
	private final int width = 800, height = 600;
 
	// this is where we do the graphics initializations
	public SimpleArt() {
		
		// the frame holds the panel. A frame is simply a container,
		// it does nothing but hold panels and other graphics tools
		JFrame frame = new JFrame();
		
		// set the window size - notice, no magic numbers!
		frame.setSize(width, height);
		
		// this ends the program when the close button is pressed
		// probably always a good idea to use this
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add our customized panel to the container
		frame.add(this);
		
		// this line centers the window upon startup
		frame.setLocationRelativeTo(null);
		
		// decide whether the user can resize the window - 
		// sometimes this is good, sometimes bad.
		// if you choose to set this true, make sure to be 
		// careful with your height/width variables!!
		frame.setResizable(false);
		
		// we need to tell the computer to make your frame and 
		// its contents visible (I don't know why this is automatically
		// set to false...)
		frame.setVisible(true);
		
		// decide whether you will need focus in your program.
		// focus is the ability for the program to pay attention 
		// to just one component - for example, if you have multiple 
		// text input boxes, we need to know which box to focus on
		// at all times
		this.setFocusable(true);
		
		// get our functionality going (if we have any)
		run();
	}

	// This is what we want the code to do as the panel is open.
	public void run() {

		// note - I don't have anything besides graphics setup in
		// this code, so my program won't actually 'do' anything.
		// If I wanted to 'do something', this is where I would do that
	}
	
	// defines how to paint our panel - this is called 
	// note that I never call this directly.
	// If I want to update my original graphics display, I call repaint()
	public void paint(Graphics g) {
	
		// draw a red 50x50 rectangle - note I use 
		// fillRect(), not drawRect()
		// also note that I use magic numbers here, just 
		// because its an example - do not do this in a real project!
		Font myFont = new Font("Skia", Font.ITALIC, 20);
		int squarelength = 500;
		int squareX = width/8;
		int squareY = height/9;
		g.setColor(new Color(175, 70, 50));
		g.fill3DRect(squareX, squareY, squarelength, squarelength, true);
		g.setColor(new Color(100, 140, 175));
		g.fillArc(squareX+40, squareY+40, squarelength-80, squarelength-80, 270, 180);
		g.setColor(new Color(230, 230, 210));
		g.fillArc(squareX+40, squareY+40, squarelength-80, squarelength-80, 90, 180);
		g.setColor(new Color(230, 200, 100));
		g.fillArc(squareX+140, squareY+140, squarelength-280, squarelength-280, 270, 180);
		g.setColor(Color.BLACK);
		g.fillArc(squareX+140, squareY+140, squarelength-280, squarelength-280, 90, 180);
		g.setColor(new Color(200, 139, 118));
		g.fillArc(squareX+190, squareY+190, squarelength-380, squarelength-380, 270, 180);
		g.setFont(myFont);
		g.drawString("ARTISTIC", 8*width/10, 27*height/32);
		g.setColor(new Color(100, 140, 175));
		g.drawString("Replication", 8*width/10, 7*height/8);


		


		
		


		
		
		
		// there are tons of graphics drawing methods - check them out!
	}
	
	// very simple main method - create our graphics object
	public static void main(String[] args) {
		new SimpleArt(); 
	}
}



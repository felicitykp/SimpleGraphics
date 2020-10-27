package GE;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Editor{
	private final int width=800, height=800;
	private String function;
	private int x, y;
	private JFrame frame;
	private JPanel DrawPanel;
	private ArrayList<Shape> Shapes;
	private Shape TempShape;
	private Color SelectedColor;
	
	public Editor(){
		SelectedColor = Color.magenta;
		Shapes = new ArrayList<Shape>();
	//MainPanel
		JPanel Panel = new JPanel();
		BoxLayout layout = new BoxLayout(Panel, BoxLayout.Y_AXIS);
	
	//BUTTONS
		//rectangle button
		JButton RectangleButton = new JButton("Rectangle");
		RectangleButton.setPreferredSize(new Dimension (100, 30));
		RectangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function = "rectangle";
			}
		});
		//circle button
		JButton CircleButton = new JButton("Circle");
		CircleButton.setPreferredSize(new Dimension (100, 30));
		CircleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function = "circle";
			}
		});
		//circle button
		JButton OvalButton = new JButton("Oval");
		OvalButton.setPreferredSize(new Dimension (100, 30));
		OvalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function = "oval";
			}
		});
		//delete button
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.setPreferredSize(new Dimension (100, 30));
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function = "delete";
			}
		});
		//move button
		JButton MoveButton = new JButton("Move");
		MoveButton.setPreferredSize(new Dimension (100, 30));
		MoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function = "move";
			}
		});
		//resize button
		JButton ResizeButton = new JButton("Resize");
		ResizeButton.setPreferredSize(new Dimension (100, 30));
		ResizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function = "resize";
			}
		});
		//color button
		JButton ColorButton = new JButton("Color");
		ColorButton.setPreferredSize(new Dimension (100, 30));
		ColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Choose Color");
				JColorChooser jc = new JColorChooser();
				SelectedColor = jc.showDialog(null, "Choose Color", Color.magenta);
				System.out.println(SelectedColor);
			}
		});
		//text button
				JButton TextButton = new JButton("Text");
				TextButton.setPreferredSize(new Dimension (100, 30));
				TextButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TempShape = new Text (SelectedColor);
						function = "text";
					}
				});
		//line button
		JButton LineButton = new JButton("Line");
		LineButton.setPreferredSize(new Dimension (100, 30));
		LineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function = "line";
			}
		});
		//save file button
		JButton SaveButton = new JButton("Save");
		SaveButton.setPreferredSize(new Dimension (100, 30));
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveFile();
			}
		});
		//button layout
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.add(RectangleButton);
		ButtonPanel.add(CircleButton);
		ButtonPanel.add(OvalButton);
		ButtonPanel.add(DeleteButton);
		ButtonPanel.add(MoveButton);
		ButtonPanel.add(ResizeButton);
		ButtonPanel.add(ColorButton);
		ButtonPanel.add(TextButton);
		ButtonPanel.add(LineButton);
		ButtonPanel.add(SaveButton);
		ButtonPanel.setPreferredSize(new Dimension (width-50, 3*height/22));
		ButtonPanel.setBorder(BorderFactory.createTitledBorder("Control Panel"));
		Panel.add(ButtonPanel);
		
	//DrawPanel
		DrawPanel = new JPanel(){
			public void paint(Graphics g){
				for(Shape s: Shapes){
					s.draw(g);
				}	
			}
		};
		DrawPanel.setPreferredSize(new Dimension (width-50, 17*height/22));
		DrawPanel.setBorder(BorderFactory.createTitledBorder("Draw"));
		DrawPanel.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				MousePressedAction();
				frame.getContentPane().repaint();

			}
			public void mouseReleased(MouseEvent e) {
				//make sure nothing is selected when user clicks in blank area and
				//tries to perform move, resize functions, etc
				TempShape = null;
			}
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		DrawPanel.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				//perform action only when a shape is selected
				if(TempShape != null){
					if (function == "rectangle"){
						TempShape.resize(e.getX(), e.getY(), 0, 0);
						frame.getContentPane().repaint();
					}else if (function == "circle"){
						TempShape.resize(e.getX(), e.getY(), 0, 0);
						frame.getContentPane().repaint();
					}else if (function == "oval"){
						TempShape.resize(e.getX(), e.getY(), 0, 0);
						frame.getContentPane().repaint();
					}else if (function == "line"){
						TempShape.resize(e.getX(), e.getY(), 0, 0);
						frame.getContentPane().repaint();
					}else if (function == "move"){
						//different operation for line bc the line does not use x, y
						if(TempShape.type == "Line"){
							Line TempLine = (Line) TempShape;
							int DraggedDistanceX = e.getX()-x;
							int DraggedDistanceY = e.getY()-y;
							x = e.getX();
							y = e.getY();
							TempLine.startX += DraggedDistanceX;
							TempLine.endX += DraggedDistanceX;
							TempLine.startY += DraggedDistanceY;
							TempLine.endY += DraggedDistanceY;

							
						}
						//operation for all other shapes, text
						TempShape.x = e.getX();
						TempShape.y = e.getY();
						frame.getContentPane().repaint();
					}else if (function == "resize"){
						//mouse distanceX and distanceY from center when clicked
						int OriginalDistanceX = Math.abs(x-TempShape.x);
						int OriginalDistanceY = Math.abs(y-TempShape.y);
						x = e.getX();
						y = e.getY();
						//new distanceX and distanceY from the center after dragged
						int DraggedDistanceX = Math.abs(e.getX()-TempShape.x);
						int DraggedDistanceY = Math.abs(e.getY()-TempShape.y);
						//update width and height
						TempShape.width += DraggedDistanceX-OriginalDistanceX;
						TempShape.height += DraggedDistanceY-OriginalDistanceY;
						frame.getContentPane().repaint();
					}
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}
			
		});
		Panel.add(DrawPanel);
		
	//Layout
		Panel.setBorder(BorderFactory.createTitledBorder("Graphic Editor 1.1"));
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.add(Panel);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

	public void MousePressedAction(){
		//CODE***
		System.out.println(function);
		//rectangle
		if (function == "rectangle"){
			Shapes.add(new Rectangle (x,y,SelectedColor));
			TempShape = Shapes.get(Shapes.size()-1);
		}
		//text
		else if (function == "text"){
			Shapes.add(TempShape);
			TempShape = Shapes.get(Shapes.size()-1);
		}
		//circle
		else if (function == "circle"){
			Shapes.add(new Circle (x,y,SelectedColor));
			TempShape = Shapes.get(Shapes.size()-1);
		}
		//oval
		else if (function == "oval"){
			Shapes.add(new Oval (x,y,SelectedColor));
			TempShape = Shapes.get(Shapes.size()-1);
		}
		//line
		else if (function == "line"){
			Shapes.add(new Line (x,y,SelectedColor));
			TempShape = Shapes.get(Shapes.size()-1);
		}
		//delete
		else if (function == "delete"){
			for(int i = Shapes.size(); i > 0; i--){
				Shape s = Shapes.get(i-1);
				if(s.isOn(x, y) == true){
					Shapes.remove(s);
					break;
				}
			}
		}	
		//move, resize
		else if (function == "move" || function == "resize"){
			for(int i = Shapes.size(); i > 0; i--){
				Shape s = Shapes.get(i-1);
				if(s.isOn(x, y) == true){
					TempShape = s;
					break;
				}
			}
		}
	}

	public void SaveFile(){
		JFileChooser FileChooser = new JFileChooser();
		int i = FileChooser.showSaveDialog(null);
		if(i==JFileChooser.APPROVE_OPTION){
			File file = FileChooser.getSelectedFile();
		BufferedImage image = new BufferedImage(DrawPanel.getWidth(), DrawPanel.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		DrawPanel.paint(image.getGraphics());
		try {
			ImageIO.write(image, "png", file.getAbsoluteFile());
			System.out.println("Saved");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		}
	}
	
	
	public static void main(String[] args){
		Editor editor = new Editor();
	}
}

package GE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Editor{
	private final int width=800, height=800;
	private String function;
	private int x, y;
	private JFrame frame;
	private JPanel DrawPanel;
	private ArrayList<Shape> Shapes;
	
	public Editor(){
		Shapes = new ArrayList<Shape>();
	//MainPanel
		JPanel Panel = new JPanel();
		BoxLayout layout = new BoxLayout(Panel, BoxLayout.Y_AXIS);
	
	//BUTTON
		//rectangle button
		JButton RectangleButton = new JButton("Rectangle");
		RectangleButton.setPreferredSize(new Dimension (100, 30));
		RectangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function = "rectangle";
				//CODE***
			}
		});
		//circle button
		JButton CircleButton = new JButton("Circle");
		CircleButton.setPreferredSize(new Dimension (100, 30));
		CircleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function = "circle";
				//CODE***
			}
		});
		//delete button
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.setPreferredSize(new Dimension (100, 30));
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function = "delete";
				//CODE***
			}
		});
		//button layout
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.add(RectangleButton);
		ButtonPanel.add(CircleButton);
		ButtonPanel.add(DeleteButton);
		ButtonPanel.setPreferredSize(new Dimension (width-50, height/11));
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
		DrawPanel.setPreferredSize(new Dimension (width-50, 9*height/11));
		DrawPanel.setBorder(BorderFactory.createTitledBorder("Draw"));
		DrawPanel.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				run();
				frame.getContentPane().repaint();

			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
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

	public void run(){
		//CODE***
		System.out.println(function);
		if (function == "rectangle"){
			Shapes.add(new Rectangle (x,y));
		}else if (function == "circle"){
			Shapes.add(new Circle (x,y));
		}else if (function == "delete"){
			for(Shape s: Shapes){
				if(s.isOn(x, y) == true){
					Shapes.remove(s);
				}
			}	
		}
	}
	

	
	
	
	public static void main(String[] args){
		Editor editor = new Editor();
	}
}

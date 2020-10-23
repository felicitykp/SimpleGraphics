package GE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class Text extends Shape{
	
	private String text, nameoffont, style;
	private int fontsize;
	private int BottomLeftX, BottomLeftY;
	private JFrame frame;
	private int FrameWidth = 500, FrameHeight = 500;
	private Font font;

	public Text(Color c) {
		super(200, 200, 0, 0, c);
		//Text input area
		JTextArea input = new JTextArea();
		input.setPreferredSize(new Dimension(FrameWidth-50, 3*FrameHeight/5));
		input.setEditable(true);
		input.setBackground(Color.white);
		//Combo box for font selection
		JComboBox fontselector = new JComboBox<String>();
		GraphicsEnvironment graphicsenvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();  
		String[] fontname = graphicsenvironment.getAvailableFontFamilyNames();
		for(int i = 0; i < fontname.length; i++){
			fontselector.addItem(fontname[i]);
		}
		//Font style selector
		JComboBox styleselector = new JComboBox<String>();
		styleselector.addItem("Plain");
		styleselector.addItem("Italic");
		styleselector.addItem("Bold");
		styleselector.addItem("Italic&Bold");
		//Font size selector
		JTextArea FontSizeSelector = new JTextArea();
		FontSizeSelector.setPreferredSize(new Dimension(50,20));
		FontSizeSelector.setEditable(true);
		FontSizeSelector.setBackground(Color.white);
		//Confirm button (set user selected variables)
		JButton ConfirmButton = new JButton("Confirm");
		ConfirmButton.setPreferredSize(new Dimension (100, 30));
		ConfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ADD MORE ERROR PROOF***
				nameoffont = fontselector.getSelectedItem().toString();
				text = input.getText().trim();
				fontsize = Integer.parseInt(FontSizeSelector.getText());
				style = styleselector.getSelectedItem().toString();
				//set font
				if(style == "Plain"){
					font = new Font(nameoffont, Font.PLAIN, fontsize);
				}else if(style == "Italic"){
					font = new Font(nameoffont, Font.ITALIC, fontsize);
				}else if(style == "Bold"){
					font = new Font(nameoffont, Font.BOLD, fontsize);
				}else if(style == "Italic&Bold"){
					font = new Font(nameoffont, Font.ITALIC + Font.BOLD, fontsize);
				}
				System.out.println("Font: " + nameoffont + "\nFont Size: " + fontsize + "\nStyle: " + style + "\nText: " + text);
				frame.dispose();
			}
		});
		//Control panel (font, font size, and confirm)
		JPanel ControlPanel = new JPanel();
		ControlPanel.setPreferredSize(new Dimension (FrameWidth-50, FrameHeight/5));
		ControlPanel.add(fontselector);
		ControlPanel.add(styleselector);
		ControlPanel.add(FontSizeSelector);
		ControlPanel.add(ConfirmButton);
		//MainPanel
		JPanel Panel = new JPanel();
		BoxLayout layout = new BoxLayout(Panel, BoxLayout.Y_AXIS);
		Panel.add(ControlPanel);
		Panel.add(input);
		Panel.setBorder(BorderFactory.createTitledBorder("Set TextBox"));
		//Frame setup
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FrameWidth, FrameHeight);
		frame.add(Panel);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public Shape copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		g.setFont(font);
		FontMetrics metrics = g.getFontMetrics();
		height = metrics.getHeight() + 5;
		width = metrics.stringWidth(text) + 5;
		BottomLeftX = x-width/2;
		BottomLeftY = y+height/2;
		g.setColor(c);
		g.drawString(text, BottomLeftX, BottomLeftY);
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
		// TODO Auto-generated method stub
		
	}

}

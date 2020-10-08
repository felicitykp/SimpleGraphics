import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChatBot {
	private final int height=800, width=1000;
	private JTextArea display, input;
	private String[] marksAnswer = {"I see, I will help you with the litigation", "This seems interesting, tell me more.", "No worries, I know the judge quite well. \n          The jury will be of no concern."};
	
	public ChatBot(){
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setBorder(BorderFactory.createTitledBorder("RealTime Law Consultant"));
		
		display = new JTextArea();
		display.setEditable(false);
		display.setPreferredSize(new Dimension(width-100, height/2-50));
		input = new JTextArea();
		input.setEditable(true);
		input.setPreferredSize(new Dimension(width-100, height/2-50));

		
		input.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n')
					displayText();
				}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});
		
		JButton sendButton = new JButton("Send");
		sendButton.setPreferredSize(new Dimension (width-500, 30));
		sendButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				displayText();
			}
		});
		
		panel.add(display);
		panel.add(input);
		panel.add(sendButton);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setFocusable(true);
		frame.setResizable(false);
		frame.add(panel);
		frame.setVisible(true);
		
		display.setText("Welcome to real time law consultant. \n Our best lawyer will be with you momentarily. \n Please briefly describe your case.");;
	}
	
	public void displayText(){
		
		if (!input.getText().trim().equals("")){
			display.setText(input.getText());
			run();
		}
		
		input.setText("");
		
	}
	
	public void run(){
			
				try {Thread.sleep(500);}
				catch (InterruptedException e) {}
				int rand = new Random().nextInt(marksAnswer.length);
				display.setText("You: " + display.getText()+"\nMark: "+ marksAnswer[rand]);
			
		}
	
	public static void main(String [] args){
		new ChatBot();
	}
	

}

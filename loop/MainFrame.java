package loop;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
	private int width, height;
	public MainFrame(int width, int height){
		this.width = width;
		this.height = height;
		
		BasicGameComponent bgc = new BasicGameComponent(width, height);
		this.getContentPane().add(bgc);
		bgc.startThread();
		
		setSize(new Dimension(width, height));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

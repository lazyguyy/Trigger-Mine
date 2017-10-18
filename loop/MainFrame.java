package loop;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	private int width, height;

	public MainFrame(int width, int height) {
		this.width = width;
		this.height = height;
		setSize(new Dimension(width, height));
		setVisible(true);
		
		Insets insets = this.getInsets();
		BasicGameComponent bgc = new BasicGameComponent(width - insets.left - insets.right, 
													    height - insets.top - insets.bottom);
		this.getContentPane().add(bgc);
		bgc.startThread();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

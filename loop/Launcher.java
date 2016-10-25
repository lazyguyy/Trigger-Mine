package loop;

import javax.swing.SwingUtilities;

public class Launcher {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new MainFrame(800, 800);
			}
		});
	}
}

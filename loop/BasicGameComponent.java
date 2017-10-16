package loop;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class BasicGameComponent extends JPanel implements Runnable{
	private final int FPS = 60;
	private final int MAX_EXCESS_FRAMES = 5;
	private final boolean DEBUG_MODE = true;

	private BufferedImage renderedImage;	
	private boolean stopGame = false;
	private int currentFps;
	private int width, height;
	
	public BasicGameComponent(int width, int height){
		this.width = width;
		this.height = height;
		renderedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}
	
	private void updateGame(){
		
	}
	
	private void render(){
		//System.out.println("rerendering");
		Graphics g = renderedImage.getGraphics();
		g.clearRect(0, 0, renderedImage.getWidth(), renderedImage.getHeight());
		if (DEBUG_MODE){
			g.setColor(Color.red);
			g.drawString(currentFps + " / " + FPS + " fps", 100, 50);
		}
	}
	
	private void paintScreen(){
		Graphics g = this.getGraphics();
		g.drawImage(renderedImage, 0, 0, this.getWidth(), this.getHeight(), null);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	public void startThread(){
		new Thread(this).start();
	}
	public void run(){
		long period = (long) 1000000000/FPS;
		System.out.println(period);
		int skippedFrames = 0;
		long startTime = 0L;
		long endTime = 0L;
		long overTime = 0L;
		
		while (!stopGame){
			startTime = System.nanoTime();
			skippedFrames = 0;
			
			//update the game, render everything and make it visible on screen.
			updateGame();
			render();
			paintScreen();
			
			//Calculate the time needed.
			endTime = System.nanoTime();
			overTime = endTime - startTime - period;
			//System.out.println(startTime + ", " + endTime + ", " + overTime);
			
			//In case it took to long, skip a few screen-updates, but update the game anyway to reduce lag.
			while (overTime > 0 && skippedFrames < MAX_EXCESS_FRAMES){
				updateGame();
				overTime -= period;
				skippedFrames++;
			}
			
			//Finally, give other Threads at least a little time to do some processing.
			if (overTime > 0){
				Thread.yield();
			}
			else{
				try {
					Thread.sleep(-overTime/1000000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
			currentFps = (int) ((1+skippedFrames)*1000000000.0/(System.nanoTime() - startTime));
			//System.out.println(((1+skippedFrames)*1000000000.0/(System.nanoTime() - startTime)));
		}
	}
}

package loop;

public class BasicGameComponent implements Runnable{
	private final int FPS = 60;
	private final int MAX_EXCESS_FRAMES = 5;

	private boolean stopGame;
	private int currentFps;
	
	private void updateGame(){
		
	}
	
	private void render(){
		
	}
	
	private void paintScreen(){
		
	}
	
	public void run(){
		long period = (long) 10E9/FPS;
		int skippedFrames = 0;
		long startTime = 0L;
		long endTime = 0L;
		long overTime = 0L;
		
		while (!stopGame){
			startTime = System.nanoTime();
			
			//update the game, render everything and make it visible on screen.
			updateGame();
			render();
			paintScreen();
			
			//Calculate the time needed.
			endTime = System.nanoTime();
			overTime = endTime - startTime - period;
			
			//In case it took to long, skip a few screen-updates, but update the game anyway to reduce lag.
			while (overTime > 0 && skippedFrames < MAX_EXCESS_FRAMES){
				updateGame();
				overTime -= period;
				skippedFrames++;
			}
			
			currentFps = (int) ((1+skippedFrames)*10E9/period);
			
			//Finally, give other Threads at least a little time to do some processing.
			if (overTime > 0){
				Thread.yield();
			}
			else{
				try {
					Thread.sleep(-overTime*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
		}
	}
}

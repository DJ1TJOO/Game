package Main;



import GameState.GameStateManager;
import Modules.ModuleHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -6278825781006112087L;
	private Thread thread;
	public static JFrame frame;
	private boolean running;

	public static float sx,sy;

	public static final int PIX_WIDTH = 1448, PIX_HEIGHT = 795;
	public static final int GAME_WIDTH = 1358, GAME_HEIGHT = 750;
	public static int WIDTH, HEIGHT;

	private GameStateManager gsm;
	private ModuleHandler handler;

	public Game() {
        gsm = new GameStateManager();
		handler = new ModuleHandler(gsm, this);
		frame = new JFrame();
		new Window(PIX_WIDTH, PIX_HEIGHT, "Steven and Thomas", this, frame);
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		running = false;
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			WIDTH = frame.getWidth();
			HEIGHT = frame.getHeight();
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		//System.err.println(WIDTH + " | " + HEIGHT);
		handler.tick();
		gsm.tick();

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		AffineTransform tx = new AffineTransform();
		tx.concatenate(g.getTransform());
		float sx = (float)(WIDTH - GAME_WIDTH - 40)/GAME_WIDTH + 1f;
		float sy = (float)(HEIGHT - GAME_HEIGHT - 40)/GAME_HEIGHT + 1f;
		/*System.out.println(PIX_WIDTH + " | " + PIX_HEIGHT);
		System.out.println(WIDTH + " | " + HEIGHT);
		System.out.println((WIDTH - PIX_WIDTH) + " | " + (HEIGHT - PIX_HEIGHT));
		System.out.println(sx + " | " + sy);*/
		this.sx = sx;
		this.sy = sy;
		tx.scale(sx,sy);
		g.transform(tx);
		g.setColor(Color.black);
		g.fillRect(0,0, WIDTH, HEIGHT);

		gsm.render(g);
		
		g.dispose();
		bs.show();
	}

	public static void main(String args[]) {
		new Game();
	}

	public static void sys(String s){
		System.err.println(s);
	}

}

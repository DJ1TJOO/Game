package main;



import javax.swing.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -6278825781006112087L;
	public static final int PIX_WIDTH = 955, PXI_HEIGHT = 540;
	public static int WIDTH, HEIGHT;
	private Thread thread;
	private boolean running;
	private JFrame frame;

	public Game() {
		frame = new JFrame();
		new Window(PIX_WIDTH, PXI_HEIGHT, "Steven and Thomas", this, frame);
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
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {

		WIDTH = frame.getWidth();
		HEIGHT = frame.getHeight();
		System.err.println(WIDTH + " | " + HEIGHT);

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.dispose();
		bs.show();
	}

	public static void main(String args[]) {
		new Game();
	}

}

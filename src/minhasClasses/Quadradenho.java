package minhasClasses;

import gameMain.GamePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Quadradenho extends Componente {

	public BufferedImage img;
	public int alt;
	public int larg;
	public float x;
	public int y;
	public float dx;
	public boolean parado;
	public Color cor;
	public float velocidade;
	public float veloMax;
	public int limiteAtual = 100;
	public int limiteMax = 1000;
	public int vidaMax;
	public int vidaAtual;
	Barra barraVida;
	Barra barraTempo;
	public int dano;

	public Quadradenho(int x, int y, int larg, int alt, Color cor, int vidaMax, int limiteMax, int dano) {
		super(x, y);

		this.x = x;
		this.y = y;
		this.larg = larg;
		this.alt = alt;
		this.cor = cor;
		this.velocidade = 0;
		veloMax = 0.2f;
		dx = 0;
		this.dano = dano;

		this.vidaMax = vidaMax;
		this.vidaAtual = vidaMax;
		this.limiteMax = limiteMax;
		barraVida = new Barra(x, y - 350, 30, 150, Color.RED);
		barraTempo = new Barra(x, y - 319, 20, 150, Color.GREEN);

	}

	@Override
	public void update(float time, int cameraX, int cameraY) {

		barraVida.update(0, vidaAtual, vidaMax);
		barraTempo.update(0, limiteAtual, limiteMax);

		if (limiteAtual > 0) {
			x += dx;
		}

		if (x <= 0) {
			x = 0;
		}
		if (x + larg >= 1080) {
			x = 1080 - larg;

		}

	}

	@Override
	public void draw(Graphics2D dbg, float xMundo, float yMundo) {
		barraVida.draw(dbg, xMundo, yMundo);
		barraTempo.draw(dbg, xMundo, yMundo);
		// dbg.setFont(new Font("arial", 40, 40));
		// dbg.setColor(Color.RED);
		// dbg.drawString("" + vidaAtual, (int) x, (int) y);
		dbg.setColor(cor);
		dbg.fillRect((int)x, y, larg, alt);
		// dbg.setColor(Color.RED);
		// dbg.drawString("" + limiteAtual, (int) x, (int) y + 50);

	}

}

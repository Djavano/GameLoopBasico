package minhasClasses;

import gameMain.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;

public class Pow extends Componente {
	public float dx;
	public float dy;
	public static int jogador;
	public int tamanho;
	public Color cor;

	public Pow(float x, float y, float dx, float dy, int jogador, int tamanho, Color cor) {
		super(x, y);
		this.dx = dx;
		this.dy = dy;
		this.jogador = jogador;
		this.tamanho = tamanho;
		this.cor = cor;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float time, int cameraX, int cameraY) {
		// TODO Auto-generated method stub
		x += dx * time;
		y += dy * time;
		
		
		
		if(y<=20){
			dy = -dy;
		}
		
		//
//		if(dy >= GamePanel.PHEIGHT -20){
//			dx = 0;
//			dy = 0;
//		}

	}
	
	public boolean colideJogador(Quadradenho a) {
		if (x >= a.x && x <= a.x + a.larg) {
			if (y >= a.y && y <= a.y + a.alt) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void draw(Graphics2D dbg, float xMundo, float yMundo) {
		dbg.setColor(cor);
		dbg.fillOval((int)x,(int)y, tamanho, tamanho);

	}

}

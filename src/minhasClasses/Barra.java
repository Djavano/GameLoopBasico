package minhasClasses;

import java.awt.Color;
import java.awt.Graphics2D;

public class Barra extends Componente {
	public int alt;
	public int larg;
	public Color cor;
	
	public int larguraAtual;

	public Barra(float x, float y, int alt, int larg, Color cor) {
		super(x, y);
		this.larg = larg;
		this.alt = alt;
		this.cor = cor;
		this.larguraAtual = larg-10;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float time, int atual, int max) {
		// TODO Auto-generated method stub
		larguraAtual = (larg-10)*atual/max;
		
	}

	@Override
	public void draw(Graphics2D dbg, float xMundo, float yMundo) {
		// TODO Auto-generated method stub
		//borda da barra
		dbg.setColor(Color.GRAY);
		dbg.fillRect((int)x, (int)y, larg, alt);
		//barra
		dbg.setColor(cor);
		dbg.fillRect((int)x+5, (int)y+5, larguraAtual, alt-10);
		
		
		
	}

}

package minhasClasses;

import java.awt.Color;
import java.awt.Graphics2D;

public class Tabuleiro extends Componente{
	
	public int largura;
	public int altura;
	
	public int colunas;
	public int linhas;
	public int quaX, quaY;
	public int quaT;

	public Tabuleiro(float x, float y, int largura, int altura, int colunas, int linhas) {
		super(x, y);
		this.altura=altura;
		this.largura=largura;
		this.colunas=colunas;
		this.linhas=linhas;
		quaT=37;
	}

	public boolean colideTabuleirinho(int mousex, int mousey){
		if(mousex<x+largura&& mousex>x)
			if(mousey<y+altura&& mousey>y)
				return true;
				
		return false;
	}
	
	@Override
	public void update(float time, int cameraX, int cameraY) {
		quaX=cameraX;
		quaY=cameraY;
		
		
		
	}

	@Override
	public void draw(Graphics2D dbg, float xMundo, float yMundo) {
		// TODO Auto-generated method stub
		dbg.setColor(Color.ORANGE);
		if(colideTabuleirinho(quaX, quaY)){
		dbg.fillRect(quaX, quaY, quaT, quaT);
		}else dbg.fillRect(quaX-quaT/2, quaY-quaT/2, quaT, quaT);
		
		
		
		//bördas
		dbg.drawRect((int)x, (int)y, largura, altura);
		//colinhas
		int auy=0;
		for (int i = 0; i < linhas; i++) {
			dbg.drawLine((int)x, (int)y+auy, largura+(int)x, (int) y+auy);
			auy+=altura/linhas;
		}
		int aux=0;
		for (int i = 0; i < colunas; i++) {
			dbg.drawLine((int)x+aux, (int)y, (int)x+aux, (int) y+altura);
			aux+=largura/colunas;
		}
		System.out.println("floats x: "+(int)x+"floats y: "+(int)y);
	}

}

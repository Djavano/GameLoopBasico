package minhasClasses;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Square extends  Componente{
	public int value;
	public int tamanho;

	public Square(int x, int y, int value) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.value = value;
		tamanho = 100;
	}

	@Override
	public void update(float time, int cameraX, int cameraY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D dbg, float xMundo, float yMundo) {
		// TODO Auto-generated method stub
		dbg.setStroke(new BasicStroke(10));
		if(value==1){
			dbg.drawLine((int)x, (int)y, (int)x+tamanho, (int)y+tamanho);
			dbg.drawLine((int)x+tamanho, (int)y, (int)x, (int)y+tamanho);
		}else if(value == 2){
			dbg.drawOval((int)x, (int)y, tamanho, tamanho);
		}
		dbg.setStroke(new BasicStroke(1));
	}
	public boolean colidemouse(int mousex, int mousey){
		if(mousex<x+tamanho && mousex>x){
			if(mousey<y+tamanho && mousey>y){
				return true;
			}
		}
			
		
		return false;	
	}
	
	
	

}

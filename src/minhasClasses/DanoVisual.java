package minhasClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class DanoVisual extends Componente{
	
	public float tempo;
	public String texto;
	public float aux;
	public boolean isVivo;
	public float sobe;
	public int alpha;
	
	
	
	
	
	
	public DanoVisual(float x, float y, float tempo, String texto,float sobe) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.tempo = tempo;
		this.texto= texto;
		isVivo = true;
		aux = 0;
		this.sobe = sobe;
		alpha = 255;
		
	}

	@Override
	public void update(float time, int cameraX, int cameraY) {
		//TEMPORIZADOR
		aux+=time;
		y+=sobe;
		alpha--;
		if(alpha<0){
			alpha = 0;
		}
		if(aux>=tempo){
			isVivo = false;
			
			
			
			
		}
		
		
	}

	@Override
	public void draw(Graphics2D dbg, float xMundo, float yMundo) {
		// TODO Auto-generated method stub
		dbg.setFont(new Font("arial", 50, 50));;
		dbg.setColor(new Color(255,0,0,alpha));
		dbg.drawString(texto, x, y);
		
	}

}

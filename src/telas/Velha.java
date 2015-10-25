package telas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import minhasClasses.Square;
import minhasClasses.Tabuleiro;

public class Velha implements Screen {
	
	Square squares[][];
	boolean turno;
	
	
	
	
	

	public Velha() {
		
		
		
		squares = new Square[3][3];
		int aux = 100;
		int auy = 50;
		for(int i = 0; i<3; i++){
			for (int j = 0; j < 3; j++) {
				squares[i][j] = new Square(aux, auy,0);
				aux+=100;
				
			}
			auy+=100;
			aux=100;
		}
		turno = false;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Jogo da Velha!";
	}

	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
		float timeCerto = time;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMousePressed(MouseEvent e) {
		
		if(e.getButton()==1){
			for(int i =0;i <3;i++){
				for (int j = 0; j < 3; j++) {
					
				
				if(squares[i][j].colidemouse(e.getX(),e.getY())
						&&squares[i][j].value==0){
					System.out.println(i+":"+j);
					if(turno) squares[i][j].value=2;
					else squares[i][j].value=1;
					
					if(turno)turno=false;
					
					else turno = true;
				}
			}
		}
		}
	}

	@Override
	public void onMouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseMove(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D dbg) {
		
		/*
		//desenha tabuleiro
		dbg.drawRect(100,50,300,300);
		//divisórias
		dbg.drawLine(100,150,400,150);
		dbg.drawLine(100,250,400,250);
		dbg.drawLine(200,50,200,350);
		dbg.drawLine(300,50,300,350);
		//desenha squares
		for(int i= 0; i< 3; i++){
			for(int j= 0; j< 3; j++){
				squares[i][j].draw(dbg,0,0);
			}
		}
		
		
		
	}
	}
}
*/
	}
}

package telas;


import gameMain.GamePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import minhasClasses.Barra;
import minhasClasses.DanoVisual;
import minhasClasses.Poligono;
import minhasClasses.Pow;
import minhasClasses.Quadradenho;
import stuff.Button;
import stuff.ButtonManager;

public class Jogo implements Screen {

	public Quadradenho quadrado;
	public Quadradenho quadrado2;
	int vez;
	ArrayList<Pow> listaDePows;
	boolean gameOver = false;
	
	String mensagem;
	ButtonManager gerenteDeBotoes;
	ArrayList<DanoVisual> danosVisuais;
	

	public Jogo() {
		gerenteDeBotoes = new ButtonManager();
		
		gerenteDeBotoes.add(new Button(500, 500,// x e y 
				100, 50, // altura e largura
				1, "RECOMEÇAR", // tarefa e o  texto
				Color.GREEN, false,// cor e o estado dele(vivo ou morto)
				null));//imagem
		
		init();
	}
	
	public void init(){
		mensagem = "||||||||||||";
		quadrado = new Quadradenho(20, 420, 80, 80, Color.BLUE,100,100,23);
		quadrado2 = new Quadradenho(800, 420, 80, 80, Color.YELLOW,100,100,30);
		vez = 1;
		listaDePows = new ArrayList<Pow>();
		gameOver = false;
		gerenteDeBotoes.setVisible(false,0);
		danosVisuais = new ArrayList<DanoVisual>();
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "JOGUENHO";
	}

	@Override
	
		
	
	public void update(long time) {
		
		for (int i = 0; i < danosVisuais.size(); i++) {
			danosVisuais.get(i).update(time,0,0);
			if(!danosVisuais.get(i).isVivo){
				danosVisuais.remove(i);
				break;
			}
		}
		
		
		
	
		switch (gerenteDeBotoes.TASK) {
		case 1:
			GamePanel.screen = new Menu();;
			gerenteDeBotoes.TASK=0;
			break;
			

		default:
			break;
		}
		
		if(!gameOver){
		mensagem = "" + vez;
		if (vez == 1) {
			quadrado.update(time, 0, 0);

		}

		else if (vez == 2) {
			quadrado2.update(time, 0, 0);

		}

		// for (int i = 0; i < listaDePows.size(); i++) {
		// listaDePows.get(i).update(time,0,0);
		// //verificar se ele bateu no chao ou no inimigo
		// //primeiro o chao
		//
		// }

		for (Pow pow : listaDePows) {
			pow.update(time, 0, 0);
			if(pow.jogador==1){
				if(pow.colideJogador(quadrado2)){
					listaDePows.remove(pow);
					danosVisuais.add(new DanoVisual(quadrado2.x, quadrado2.y, 2000, "" + quadrado.dano,-0.2f));
					quadrado2.vidaAtual-=50;
					vez= 2;
					break;
				}
			}
			else {
				if(pow.colideJogador(quadrado)){
					listaDePows.remove(pow);
					danosVisuais.add(new DanoVisual(quadrado.x, quadrado2.y, 2000, "" + quadrado2.dano,-0.2f));
					quadrado.vidaAtual -=50;
					vez= 1;
					
					break;
				}
			}
			// verificar se ele bateu no chao ou no inimigo
			// primeiro o chao
			if (pow.y > 500) {
				if(pow.jogador==1){
					vez= 2;
				}else{
					vez=1;
				}
				listaDePows.remove(pow);
				
				break;
			}
		}
		
		System.out.println(quadrado.velocidade);
	}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (vez == 1) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				quadrado.dx = 0.2f;
				quadrado.limiteAtual-=1;

			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				quadrado.dx = -0.2f;
				quadrado.limiteAtual-=1;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				listaDePows.add(new Pow(quadrado.x + 70, quadrado.y, 0.2f,
						-0.2f, 1,10, quadrado.cor));
				vez=3;
				quadrado.limiteAtual = 100;

			}

		} else if (vez == 2) {

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				quadrado2.dx = 0.2f;
				quadrado2.limiteAtual-=1;

			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				quadrado2.dx = -0.2f;
				quadrado2.limiteAtual-=1;

			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				listaDePows.add(new Pow(quadrado2.x, quadrado.y, -0.2f, -0.2f,
						2,10, quadrado2.cor));
			vez=3;
			quadrado2.limiteAtual = 100;

			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			quadrado.dx = 0;
			
			quadrado2.dx = 0;

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			quadrado.dx = 0;
			quadrado2.dx = 0;
		}
	}

	@Override
	public void onMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		gerenteDeBotoes.pressed(e.getX(), e.getY());
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
		
		for (int i = 0; i < danosVisuais.size(); i++) {
			danosVisuais.get(i).draw(dbg, 0, 0);
			
		}
		
		
		
		if(!gameOver){
		if(quadrado.vidaAtual <=0){
			gameOver = true;
			gerenteDeBotoes.setVisible(true,0);
			
		}
		if(quadrado2.vidaAtual <=0){
			gameOver = true;
			gerenteDeBotoes.setVisible(true,0);
		}
		dbg.setFont(new Font("arial", 10, 10));
		dbg.setColor(Color.BLACK);
		dbg.drawString("TURNO JOGADOR: " + mensagem, 10, 30);
		dbg.drawLine(0, 500, 1100, 500);
		for (int i = 0; i < listaDePows.size(); i++) {
			listaDePows.get(i).draw(dbg, 0, 0);

		}
		for (int i = 0; i < listaDePows.size(); i++) {
			listaDePows.get(i).draw(dbg, 0, 0);

		}
		quadrado.draw(dbg, 0, 0);
		quadrado2.draw(dbg, 0, 0);

	}else{
		dbg.setColor(Color.WHITE);
		dbg.fillRect(0, 0, GamePanel.PWIDTH, GamePanel.PHEIGHT);
		if(quadrado.vidaAtual <=0){
			dbg.setFont(new Font("arial", 50, 50));
			dbg.setColor(Color.BLACK);
			dbg.drawString("Jogador 2 venceu!", 350, 200);
		
		}
		if(quadrado2.vidaAtual <=0){
			dbg.setFont(new Font("arial", 50, 50));;
			dbg.setColor(Color.BLACK);
			dbg.drawString("Jogador 1 venceu!", 350, 200);
	}
		dbg.setFont(new Font("arial", 10, 10));
		gerenteDeBotoes.draw(dbg, 0, 0);
	
		
	}
	}
}

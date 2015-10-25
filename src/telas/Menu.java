package telas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameMain.GamePanel;
import stuff.Button;
import stuff.ButtonManager;

public class Menu implements Screen {
	
	ButtonManager gerenteDeBotoes;
	 BufferedImage menu;
	
	
	public Menu(){
		
		menu = AbreImagem("/imagens/menu.png");
		
		
		//inicializa os gerenciador de botoes
		gerenteDeBotoes = new ButtonManager();
		
		gerenteDeBotoes.add(new Button(430, 140,// x e y 
				200, 50, // altura e largura
				1, "JOGAR", // tarefa e o  texto
				Color.RED, true,// cor e o estado dele(vivo ou morto)
				null));//imagem
		
		gerenteDeBotoes.add(new Button(200, 400,// x e y 
				200, 100, // altura e largura
				2, "SAIR", // tarefa e o  texto
				Color.RED, true,// cor e o estado dele(vivo ou morto)
				null));//imagem
		
		gerenteDeBotoes.add(new Button(400, 350,// x e y 
				250, 50, // altura e largura
				4, "CRÉDITOS", // tarefa e o  texto
				Color.RED, true,// cor e o estado dele(vivo ou morto)
				null));//imagem
		
		
	}
	
	 public BufferedImage AbreImagem(String path){
			BufferedImage image = null;
			try {
				BufferedImage imgtmp = ImageIO.read( getClass().getResource(path) );
				image = new BufferedImage(imgtmp.getWidth(), imgtmp.getHeight(), BufferedImage.TYPE_INT_ARGB);
				image.getGraphics().drawImage(imgtmp, 0,0,null);
				imgtmp = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return image;
		}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "botao menu";
	}

	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
		//define as funções 
		switch (gerenteDeBotoes.TASK) {
		case 1:
			GamePanel.screen = new Jogo();
			
		
			gerenteDeBotoes.TASK=0;
			break;
		case 2:
			GamePanel.GameOver = true;
			
		
			gerenteDeBotoes.TASK=0;
			break;
		case 3:
			GamePanel.screen = new Menu();
			
		
			gerenteDeBotoes.TASK=0;
			break;
		case 4:
			GamePanel.screen = new Creditos();
			
		
			gerenteDeBotoes.TASK=0;
			break;
		


		default:
			break;
		}
		
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
		
		// TODO Auto-generated method stub
		dbg.drawImage(menu, -1000, -750,null);
	
	}

}

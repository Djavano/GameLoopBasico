package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameMain.GamePanel;
import stuff.Button;
import stuff.ButtonManager;


public class Creditos implements Screen {
	
	ButtonManager gerenteDeBotoes;
	 BufferedImage creditos;
	
	public Creditos(){
		
		creditos = AbreImagem("/imagens/creditos.png");
        
		gerenteDeBotoes = new ButtonManager();
		
		gerenteDeBotoes.add(new Button(200, 400,// x e y 
				200, 100, // altura e largura
				1, "VOLTAR", // tarefa e o  texto
				Color.GREEN, false,// cor e o estado dele(vivo ou morto)
				null));//imagem
		
		gerenteDeBotoes.setVisible(false,0);
		
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
		return null;
	}

	@Override
	public void update(long time) {
		// TODO Auto-generated method stub
		switch (gerenteDeBotoes.TASK) {
		case 1:
			GamePanel.screen = new Menu();;
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
		//DESENHA O BOTAO
		
		gerenteDeBotoes.setVisible(true,0);
		dbg.setFont(new Font("arial", 10, 10));
		gerenteDeBotoes.draw(dbg, 0, 0);
		
		//DESENHA OS CRÉDITOS
		dbg.drawImage(creditos, -838, -615,null);
		
		
		
	}

}

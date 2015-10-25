/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import gameMain.GamePanel;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import minhasClasses.Bola;
import minhasClasses.Personagem;
import minhasClasses.Plataforma;
import minhasClasses.Poligono;
import minhasClasses.Tabuleiro;
/**
 *
 * @author Eduardo
 */
public class Game implements Screen{
    
    public String name = "Game";
    Random rnd = new Random();
    int x=0;
    Bola bola;
    
    int minX=100,maxX=500,minY,maxY;
    int cameraX=0,cameraY=0;
    
    boolean movePer = true;
    
    int limiteCameraD=925;
    int limiteCameraE=-190;
    BufferedImage img;
    
    boolean teste=false;
    ArrayList<Bola> listaDeObjetos;
    
    ArrayList<Poligono> ListaDePoligonos;
    BufferedImage sonic;
    int indexAnimation;
    float timerAnimation;
    float aux;
  
  //tabuleirinho
  	Tabuleiro tabu;
  	int mouseX, mouseY;
    public Game() {
    	//INIT
    	indexAnimation = 0;
    	timerAnimation=500; // tempo em milisegundos
    	aux = 0;
    	tabu= new Tabuleiro(50, 50, 400, 400, 10, 10);
    	
    	listaDeObjetos = new ArrayList<Bola>();
    	 ListaDePoligonos = new ArrayList<Poligono>();
    	 sonic = AbreImagem("/imagens/walk.png");
    	 
    	 for (int i = 0; i < 100; i++) {
			
		
    	 Polygon poly = new Polygon();
    	 poly.addPoint(10,40);
    	 poly.addPoint(40,40);
    	 poly.addPoint(50,10);
    	 poly.addPoint(60,40);
    	 poly.addPoint(90,40);
    	 poly.addPoint(65,60);
    	 poly.addPoint(75,90);
    	 poly.addPoint(50,70);
    	 poly.addPoint(25,90);
    	 poly.addPoint(35,60);
    
    	 ListaDePoligonos.add(new Poligono(rnd.nextInt(100)+100, rnd.nextInt(100)+100
    			 , poly, 100,rnd.nextFloat(), rnd.nextFloat(), new Color(rnd.nextInt(254)+1,
     					rnd.nextInt(254)+1,rnd.nextInt(254)+1)));
    	 
    	 }
    	 
    	 
    	 
    	 
    	/*for(int i =0; i<800; i++){
    	listaDeObjetos.add (new Bola(rnd.nextInt(100)+100, rnd.nextInt(100)+100
    			,rnd.nextInt(25) , rnd.nextFloat(),rnd.nextFloat() ,new Color(rnd.nextInt(254)+1,
    					rnd.nextInt(254)+1,rnd.nextInt(254)+1,rnd.nextInt(254))));
    					
    	
    	
    	
    	}
    	*/
    	
        img = AbreImagem("/imagens/walk.png");
        bola = new Bola(150, 150, 25, 0.5f, 0.5f, Color.GREEN);
        //plata = new Plataforma(1500, 20, 300, 400);
       // hue = new Bola(500,400,20,1,0,Color.RED);
       // fim = new Plataforma(20, 600, 2000, 200);
       // inicio = new Plataforma(20, 600, -200, 200);
       // System.out.println(img);
    }
    
    public void reset(){
        
    }
    

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(long time) {
    	//simula as tretas
        float timeCerto = time;
       tabu.update(timeCerto, mouseX, mouseY);
       
       if(tabu.colideTabuleirinho(mouseX, mouseY)){
   		int squareSize = (tabu.largura/tabu.colunas);
   		int indexX = (squareSize*(tabu.quaX/squareSize));
   	}
       
        
        for (int i = 0; i < listaDeObjetos.size(); i++) {
    		listaDeObjetos.get(i).update(timeCerto,0,0);
        }

       
       bola.update(timeCerto,0,0);
       
       
       
       // for muito loko que faz a porra toda
       for(Poligono poli: ListaDePoligonos){
    	   poli.update(timeCerto,0,0);
       }
         aux+=timeCerto;
       if(aux>=timerAnimation){
       
       //faz animação
       indexAnimation+=1;
       if(indexAnimation>6) indexAnimation=0;
       aux=0;
      
       
     
       }
    
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_D){
        	
        	
          /*  if(cameraX>=limiteCameraD){
                cameraX=limiteCameraD;
                bola.x+=10;
                 }else{
                if(bola.x>=maxX){
                     cameraX+=10;
                     bola.x=maxX;
                    // movePer=false;
                 }else{
                     bola.x+=10;
                    // movePer=true;
                 }
            } */
        }
        
        if(e.getKeyCode()==KeyEvent.VK_A){
        	
        	
            /*if(cameraX<=limiteCameraE){
                cameraX=limiteCameraE;
                bola.x-=10;
                 }else{
                
                if(bola.x<=minX){
                 cameraX-=10;
                 bola.x=minX;
                }else{
                    bola.x-=10;
                }
            }  */
        }
        
        if(e.getKeyCode()==KeyEvent.VK_W){
 
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_D){
   
        }
        
        if(e.getKeyCode()==KeyEvent.VK_A){
      
        }
    }
    

    @Override
    public void onMousePressed(MouseEvent e) {
       
    	
    	
    	
    	if(e.getButton()==1){
            //System.out.println("Botao esquerdo!");
   
        }
        if(e.getButton()==2){
            //System.out.println("Botao do Meio!");
           
        }
        if(e.getButton()==3){
            //System.out.println("Botao Dirieto!");
          
        }
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
    	
    }

    @Override
    public void onMouseMove(int x, int y) {
    	mouseX=x;
    	mouseY=y;
    	
    	
    }

    @Override
    public void draw(Graphics2D dbg) {
        //background
    	tabu.draw(dbg, 0, 0);
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
    
    
}

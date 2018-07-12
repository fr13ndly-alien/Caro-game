/*
  header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecaro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Huu Hien
 */
public class GamePane extends JPanel implements MouseListener, Runnable{
    //attributes
    
    public static final int NUMBER_OF_CELLS = 24;
    public static final int CELL_LEN = 25;
    //call with a GameLogic Object
    private int gameBoard[][];
    private GameLogic game;
    
    public GamePane(){
        gameBoard = new int[24][24];
        for(int i=0; i< NUMBER_OF_CELLS; i++)
            for(int j=0; j<NUMBER_OF_CELLS; j++)
                gameBoard[i][j]= 0;
        game = new GameLogic();
        setSize(671, 671);
        System.out.println("Initialize GamePane!");
        addMouseListener(this);
    }
    
    private void drawBg(Graphics g){
        for (int i=0; i< NUMBER_OF_CELLS; i++){
            for(int j= 0; j<NUMBER_OF_CELLS; j++){                
                if(gameBoard[i][j] >0){
                    if(gameBoard[i][j] == 1)
                        paintX(g, 27*i+1, j*27 +1);
                    else paintO(g, 27*i+1, j*27 +1);
                }
                else{
                    g.setColor(Color.black);
                    g.drawRect(i*(CELL_LEN+2)+1, j*(CELL_LEN+2)+1, CELL_LEN, CELL_LEN);
                }           
            }
        }
    }
    
    private void paintX(Graphics g, int x, int y){
        g.setColor(Color.red);
        g.fillOval(x, y, CELL_LEN, CELL_LEN);
    }
    
    private void paintO(Graphics g, int x, int y){
        g.setColor(Color.green);
        g.fillOval(x, y, CELL_LEN, CELL_LEN);
    }
    
    @Override
    public void paint(Graphics g){
        drawBg(g);
        //game.drawGameBoard(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x= e.getX();
        int y= e.getY();
        int player = game.getPlayer();
        System.out.println("Mouse click in Location: x= "+ (x/27)+ " - y= "+ (y/27)); 
        
        gameBoard[x/27][y/27]= player;
        game.setBean(player, x/27, y/27);
        boolean bol = false;
        try{           
           bol = game.checkWin(x/27, y/27, player);
        }catch (Exception ex){
            System.out.println(ex.toString());
        }               
        repaint();
        
        if(bol == true){
            if(player == 1){
                System.out.println("Player "+ player+ " - "+ GameLogic.PLAYER_1_COLOR+ " WIN!");
                JOptionPane.showMessageDialog(this,"Player "+ player+ " - "+ GameLogic.PLAYER_1_COLOR+ " WIN!");
            }else{
                System.out.println("Player "+ player+ " - "+ GameLogic.PLAYER_2_COLOR+ " WIN!");
                JOptionPane.showMessageDialog(this,"Player "+ player+ " - "+ GameLogic.PLAYER_2_COLOR+ " WIN!");
            }
        }
        
        System.out.println("---------------------------");
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void run() {
        
    }
}

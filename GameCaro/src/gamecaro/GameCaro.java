/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecaro;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
/**
 *
 * @author Huu Hien
 */
public class GameCaro extends JFrame{
    
    /**
     * @param args the command line arguments
     */
    public GameCaro(){
        setResizable(false);
        setTitle("Game Caro");
        GamePane gamePane = new GamePane();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // current height = 25; boder = 2; 24 cells; space= 24 ==> 672
        setSize(671, 694);
        add(gamePane);
        setVisible(true);
    }//
    
    public static void main(String[] args) {
        // TODO code application logic here
        GameCaro game = new GameCaro();
    }

   
    
}

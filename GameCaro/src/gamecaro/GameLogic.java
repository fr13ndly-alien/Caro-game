/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecaro;

import static gamecaro.GamePane.CELL_LEN;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Huu Hien
 */
public class GameLogic {
    public static final String PLAYER_1_COLOR= "Red"; //red
    public static final String PLAYER_2_COLOR= "green"; //green
    private int nowPlayer;
    private int winner;
    private int gameBoard[][];
    
    public GameLogic(){
        initialize();
    }
    
    private void initialize(){
        Random ran = new Random();
        nowPlayer = ran.nextInt()%2;
        if(nowPlayer == 0) nowPlayer = 2;
        winner= -1;
        gameBoard = new int[24][24];
        //establish gameBoard
        for(int i=0; i<24; i++)
            for(int j=0; j<24; j++)
                gameBoard[i][j]= 0;
    }
    
    //the most important method in this game, call this method from GamePane
    //Synchoronus location between GamePane (GUI) and GameLogic
    public boolean checkWin(int x, int y, int player){
        boolean result = false;  
        System.out.println("checkWin get location: "+x+":"+y);
        //check Horizontal        
        if(checkHorizontal(x, y,player)) return true;
        //check Vertical
        if(checkVertical(x, y, player)) return true;
        //check diagonal UP
        if(checkDiagonalUp(x, y, player)) return true;
        //check diagonal DOWN
        if(checkDiagonalDown(x, y, player)) return true;
        return false;
    }
    
    private boolean checkHorizontal(int x, int y, int player){
        int count =1, tmp= x;      
        while(tmp-1 >0 && gameBoard[y][tmp-1] == player){
            tmp--; count++;
        }
        tmp= x;
        while(tmp+1 <24 && gameBoard[y][tmp+1] == player){
            tmp++; count++;
        }
        return (count>=5)?true:false;
    }   
    private boolean  checkVertical(int x, int y, int player){
        int count =1, tmp= y;        
        while(tmp-1 >0 && gameBoard[tmp-1][x] == player){
            tmp--; count++;
        }
        tmp= y;
        while(tmp+1 <24 && gameBoard[tmp+1][x] == player){
            tmp++; count++;
        }
        return (count>=5)?true:false;
    }   
    private boolean checkDiagonalUp(int x, int y, int player){
        int count= 1, tmpX= x, tmpY= y;
        while(tmpX-1 >0 && tmpY+1 <24 && gameBoard[tmpY+1][tmpX-1] == player){
            tmpX--; tmpY++; count++;
        }
        tmpX= x; tmpY= y;
        while(tmpX+1 <24 && tmpY-1 >0 && gameBoard[tmpY-1][tmpX+1]== player){
            tmpX++; tmpY--; count++;
        }
        return (count>=5)?true:false;
    } 
    private boolean checkDiagonalDown(int x, int y, int player){
        int count=1, tmpX= x, tmpY= y;
        while(tmpX-1 > 0 && tmpY-1 > 0 && gameBoard[tmpY-1][tmpX-1] == player){
            tmpX--; tmpY--; count++;
        }
        tmpX= x; tmpY= y;
        while(tmpX+1 < 24 && tmpY+1<24 && gameBoard[tmpY+1][tmpX+1] == player){
            tmpX++; tmpY++; count++;
        }
        return (count>=5)?true:false;
    }
    
    public int getWinner(){
        return nowPlayer;
    }
    
    public int getPlayer(){
        return nowPlayer;
    }
    
    public void setBean(int player, int x, int y){
        System.out.println(" Now Player: "+ nowPlayer+ "");
        gameBoard[y][x] = player;
        if(player == 2)
            nowPlayer=1;
        else nowPlayer=2;
        
    }
    
}

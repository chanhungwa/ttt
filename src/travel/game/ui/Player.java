/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package travel.game.ui;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author zzxx
 */
public class Player {
    private String playerName;
    private int zone;
    private int x;
    private int y;
    private ArrayList<Card> cards;
    private String[] targetCity; 
    
    public Player(){
    playerName = "someOne";
    zone = 1;
    x=0;
    y=0;
    cards = new ArrayList<Card>();
    
}
    
    public void setName(String name){
        playerName = name;
    }
    
    public String getName(){
        return playerName;
    }
    
    public void setX(int currentX){
        x = currentX;
    }
    
    public int getX(){
        return x;
    }
    
    public void setY(int currentY){
        y = currentY;
    }
    
    public int getY(){
        return y;
    }
    
    public void setZone(int currentZone){
        zone = currentZone;
    }
    
    public int getZone(){
        return zone;
    } 
    
    public Card getCard(int cardIndex){
        return (Card) cards.get(cardIndex);
    }
    
    public void addCard(Card newCard){
        cards.add(newCard);
    }
    
    public void setTargetCity(){
        
    }
    
    
}

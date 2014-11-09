/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package travel.game.ui;

/**
 *
 * @author zzxx
 */
public class Card {
    private String city;
    private String effect;
    private int effectType;
    
    
    public Card(){
        
    }
    
    public Card(String cityName, String newEffect,int newEffectType){
        city = cityName;
        effect = newEffect;
        effectType = newEffectType;
    }
    
    
    
}

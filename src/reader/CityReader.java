/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reader;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.Integer.parseInt;
/**
 *
 * @author zzxx
 */
import java.lang.reflect.Array;
import java.util.Scanner;
public class CityReader {
    private String[][] zoneOneCityList;
    private String[][] zoneTwoCityList;
    private String[][] zoneThreeCityList;
    private String[][] zoneFourCityList;
    private int read;
    private String tempName;
    private String tempColor;
    private String tempQuarter;
    private String tempX;
    private String tempY;
    private File txt;
    private BufferedReader input;
    private Scanner scan;
    private int i;
    private int j;
    private FileReader fileReader;
    private String jake;
    private int count = 0;
    
    public CityReader(){
        read =1;
        i = 0;
        j = 0;
        txt = new File("file:data/citiesData");  
    }
    
    public String[][] readCity() throws FileNotFoundException, IOException{
       // txt = new File("file:data/citiesData");
        
        
        fileReader = new FileReader("C:/Users/zzxx/Desktop/netBean/TravelGame/data/city5.txt");
        input = new BufferedReader(fileReader);
        scan = new Scanner(input);
        if(read == 1){
            zoneOneCityList = new String[180][5];
            
            while(count<179){
                count++;
               // jake = scan.next();
                tempName = scan.next();
               // jake = scan.next();
               
                tempColor = scan.next();
                //jake = scan.next();
                System.out.println("Color: "+tempColor);
                tempQuarter = scan.next();
                //jake = scan.next();
                System.out.println("Quarter: "+tempQuarter);
                tempX = scan.next();
                //jake = scan.next();
                System.out.println("X: "+tempX);
                tempY = scan.next();
                //jake = scan.next();
                System.out.println("Y: "+tempY);
                
                if(tempQuarter.equals("1")){
                    zoneOneCityList[i][0] = tempName;
                    System.out.println("name: "+tempName);
                    zoneOneCityList[i][1] = tempColor;
                    zoneOneCityList[i][2] = tempQuarter;
                    zoneOneCityList[i][3] = tempX;
                    zoneOneCityList[i][4] = tempY;
                    i++;
                }
                
            }
            
            i=0;
            j=0;
            
                    fileReader.close();
        scan.close();
        input.close();
            
            
            read++;
            return zoneOneCityList;
            
        }
  
        
        if(read == 2){
            System.out.println("READING 2ND City");
            count=0;
            zoneTwoCityList = new String[180][5];
            
            while(count<179){
                count++;
                tempName = scan.next();
                tempColor = scan.next();
                tempQuarter = scan.next();
                tempX = scan.next();
                tempY = scan.next();
                
                    if(tempQuarter.equals("2")){
                    zoneOneCityList[i][0] = tempName;
                    zoneOneCityList[i][1] = tempColor;
                    zoneOneCityList[i][2] = tempQuarter;
                    zoneOneCityList[i][3] = tempX;
                    zoneOneCityList[i][4] = tempY;
                    i++;
                }
                
            }
            
            i=0;
            j=0;
            
                    fileReader.close();
        scan.close();
        input.close();
            
            
            read++;
            return zoneTwoCityList;
            
        }
        
        
        
        
        if(read == 3){
            zoneThreeCityList = new String[180][5];
            
           while(count<179){
                count++;
                tempName = scan.next();
                //jake = scan.next();
                //System.out.println("name: "+tempName);
                tempColor = scan.next();
                //jake = scan.next();
                //System.out.println("Color: "+tempColor);
                tempQuarter = scan.next();
                //jake = scan.next();
                //System.out.println("Quarter: "+tempQuarter);
                tempX = scan.next();
                //jake = scan.next();
                //System.out.println("X: "+tempX);
                tempY = scan.next();
                //jake = scan.next();
                //System.out.println("Y: "+tempY);
                
                
                    if(tempQuarter.equals("3")){
                    zoneOneCityList[i][0] = tempName;
                    zoneOneCityList[i][1] = tempColor;
                    zoneOneCityList[i][2] = tempQuarter;
                    zoneOneCityList[i][3] = tempX;
                    zoneOneCityList[i][4] = tempY;
                    i++;
                }
                
            }
            
            i=0;
            j=0;
            
                    fileReader.close();
        scan.close();
        input.close();
            
            read++;
            return zoneThreeCityList;
        }
        
        
        
        
        
        
        else if (read == 4){
        zoneFourCityList = new String[180][5];
            
       while(count<179){
                count++;
                tempName = scan.next();
                //jake = scan.next();
               // System.out.println("name: "+tempName);
                tempColor = scan.next();
                //jake = scan.next();
                //System.out.println("Color: "+tempColor);
                tempQuarter = scan.next();
                //jake = scan.next();
                //System.out.println("Quarter: "+tempQuarter);
                tempX = scan.next();
                //jake = scan.next();
                //System.out.println("X: "+tempX);
                tempY = scan.next();
                //jake = scan.next();
                //System.out.println("Y: "+tempY);
                
                if(tempQuarter.equals("4")){
                    zoneOneCityList[i][0] = tempName;
                    zoneOneCityList[i][1] = tempColor;
                    zoneOneCityList[i][2] = tempQuarter;
                    zoneOneCityList[i][3] = tempX;
                    zoneOneCityList[i][4] = tempY;
                    i++;
                }
                
            }
            
            i=0;
            j=0;
        
        
        
        
        tempColor = scan.next();
        tempQuarter = scan.next();
        tempX = scan.next();
        tempY = scan.next();
            
        fileReader.close();
        scan.close();
        input.close();
        
            return zoneFourCityList;
    }
        
        
        return null;
    }
    
}

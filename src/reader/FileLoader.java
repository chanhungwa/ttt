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
/**
 *
 * @author zzxx
 */
public class FileLoader {
   private String text; 
    
    
    public FileLoader(){
        
    }
    public String getHistoryText() throws FileNotFoundException, IOException{
        
        
        FileReader fr = new FileReader("C:/Users/zzxx/Desktop/netBean/TravelGame/data/history.html");
       BufferedReader reader = new BufferedReader(fr);
           
       // READ THE FILE, ONE LINE OF TEXT AT A TIME
       String inputLine = reader.readLine();
       while (inputLine != null)
       {
           // APPEND EACH LINE TO THE STRING
           text += inputLine + "\n";
           
           // READ THE NEXT LINE
           inputLine = reader.readLine();        
       }
        
        
        return text;
    }
    
        public String getAboutText() throws FileNotFoundException, IOException{
        
        
        FileReader fr = new FileReader("C:/Users/zzxx/Desktop/netBean/TravelGame/data/help.html");
       BufferedReader reader = new BufferedReader(fr);
           
       // READ THE FILE, ONE LINE OF TEXT AT A TIME
       String inputLine = reader.readLine();
       while (inputLine != null)
       {
           // APPEND EACH LINE TO THE STRING
           text += inputLine + "\n";
           
           // READ THE NEXT LINE
           inputLine = reader.readLine();        
       }
        
        
        return text;
    }
    
}

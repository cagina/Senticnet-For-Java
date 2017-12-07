
package senticnet_java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author cagin
 */
public class HashTableMap {
    
     private final HashMap[] Hash_Table ; 
     private final HashMap<String ,Double> temp_map ; 
    
    public HashTableMap () throws IOException 
    {   
        this.Hash_Table =new HashMap[27]; 
        this.temp_map =new HashMap<>();
        setSenticnet_HashTable();
       
    }
    
    public double getValue(String y) throws IOException
    {   
       y=y.toUpperCase(Locale.ENGLISH);
       if(!y.equals(""))
       {
       
           char x = y.charAt(0);
           
           HashMap<String ,Double> value;
       
            if((x-64)>0 && (x-64)<27)
                value= this.Hash_Table[x-64];
            else
                value= this.Hash_Table[0];
       
            try {
                    return (value.get(y));
        
                } catch(NullPointerException e) {
            
                    return 0.0;
                }
        }
      return 0.0;
       
    }
    
    public void HashTable_locationToString(int a)
    {
         HashMap<String ,Double> value= this.Hash_Table[a];
         
         char local = (char)((char)a+64);
         
         value.entrySet().forEach((Map.Entry<String, Double> entry) -> {
             
             System.out.println(entry.getKey() + "/" + entry.getValue());
         });
         
         System.out.println("\n ' "+local+" ' count:"+value.size()+"\n"); 
    }
    public void addHashTable_location(String y,Double d)
    {
       y=y.toUpperCase(Locale.ENGLISH);
       if(!y.equals(""))
       {
           char x = y.charAt(0);
           
           HashMap<String ,Double> value;
       
            if((x-64)>0 && (x-64)<27)
                value= this.Hash_Table[x-64];
            else
                value= this.Hash_Table[0];
            value.put(y,d);
       }
    }
    public void setSenticnet_HashTable() throws FileNotFoundException, IOException
    {
    
        try (BufferedReader in = new BufferedReader(new FileReader("senticnet4.txt"))) {
             
            String line;
             
            int location = -1;
             
            char xcpy = '3';
             
            line = in.readLine();
             
            while(true)
            {
                String[] division = line.split("\\s+");
                 
                if(!division[2].isEmpty())
                {
                     char x = division[0].toUpperCase(Locale.ENGLISH).charAt(0);
                     double number = Double.parseDouble(division[2].replaceAll(" ","."));
                     
                     if(xcpy == x)
                         this.temp_map.put( division[0].replaceAll("_"," ").toUpperCase(),number);
                     
                     else
                     {
                         ++location;
                         
                         HashMap<String,Double> flag_map=new HashMap<>();
                         
                         flag_map=(HashMap<String, Double>) this.temp_map.clone();
                         
                         this.Hash_Table[location]=flag_map;
                         this.temp_map.clear();
                         this.temp_map.put( division[0].replaceAll("_"," ").toUpperCase(),number);
                     }
                     xcpy=x;
                 }
                 
                line = in.readLine();
                 
                 if(line == null)
                 { ++location;  this.Hash_Table[location] = this.temp_map;  break;    }
            }
            in.close();
        }
        catch (FileNotFoundException e){
                System.out.println(e.getLocalizedMessage());
        }
    }
    
    
}

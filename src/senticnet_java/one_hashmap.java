package senticnet_java;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

/**
 *
 * @author cagin
 */
public class one_hashmap {
    
     private final HashMap<String ,Double> one_map ; 
    
     public one_hashmap () throws IOException 
    {   
        this.one_map =new HashMap<>();
        setSenticnet_HashMap();
    }
    public double getValue(String y) throws IOException
    {   
          y=y.toUpperCase(Locale.ENGLISH);
       if(!y.equals(""))
       {
            try {
                 return (this.one_map.get(y));
        
                } catch(NullPointerException e) {
            
                    return 0.0;
                }
       }
       return 0.0;
    }
    public void setSenticnet_HashMap() throws FileNotFoundException, IOException
    {
    
        try (BufferedReader in = new BufferedReader(new FileReader("senticnet4.txt"))) {
           String line;
            while((line = in.readLine()) != null)
            {
                  String[] division = line.split("\\s+");
                if(!division[2].isEmpty())
                {
                     char x = division[0].toUpperCase(Locale.ENGLISH).charAt(0);
                     double number = Double.parseDouble(division[2].replaceAll(" ","."));
                     this.one_map.put( division[0].replaceAll("_"," ").toUpperCase(),number);
                }
            }
            in.close();
            
        }
    }
}


package senticnet_java;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cagin
 */
public class Senticnet_Java {

    public static void main(String[] args) {
        String[] words = {"ambidextrous","ambient illumination","ambient noise",
       "ba lot of out","byzantine rite","c clamp",
       "zymosis","yup","z skayr","x-ray","xerosis",
       "wyeth","wyeth trade","vulvovaginitis","wackett","wadded up"
       };
        
        HashTableMap yeni;
        try {
            yeni = new HashTableMap();
            System.out.println("Hash Table");
             for (String words1 : words)
             System.out.println(yeni.getValue(words1));
             yeni.addHashTable_location("AUDIT", 0.0566);
              System.out.println("\n Hash Table Location ToString\n");
              yeni.HashTable_locationToString(1);
        } catch (IOException ex) {
            Logger.getLogger(Senticnet_Java.class.getName()).log(Level.SEVERE, null, ex);
        }
       one_hashmap yeni1;
        try {
            yeni1 = new one_hashmap();
            System.out.println("\n\n Hash map\n\n"); 
            for (String words1 : words) 
             System.out.println(yeni1.getValue(words1));
        } catch (IOException ex) {
            Logger.getLogger(Senticnet_Java.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}

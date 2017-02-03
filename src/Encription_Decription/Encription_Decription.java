/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encription_Decription;

/**
 *
 * @author kasun sampath
 */
public class Encription_Decription {
    public static final String str="abcdefghigklmnopqrstuvwxyz";
    
    public static String encription(String plaint,int key){
    
        plaint =plaint.toLowerCase();
        String cipher="";
        
        for(int i=0;i<plaint.length();i++){
        int charpose=str.indexOf(plaint.charAt(i));
        int keyval=(charpose+key)%26;
        char replaceval=str.charAt(keyval);
        cipher =cipher+replaceval;
        
        }
       
        
        
    return cipher;
    
    
    }
    public String decription(String cipher,int key){
    cipher = cipher.toLowerCase();
    String plaint="";
    for(int i=0;i<cipher.length();i++){
        
        int charpose=str.indexOf(cipher.charAt(i));
        int keyval=(charpose-key)%26;
        if(keyval<0){
        
        keyval=str.length()+keyval;
        }
        char replaceval=str.charAt(keyval);
        plaint =cipher+replaceval;
        
        
    }
    
    return plaint;
    
    }
    
    
    
}

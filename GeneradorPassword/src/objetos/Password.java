/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Password {
    private int longitud;
    private String contrasenia;
    
    public Password(){
        this.longitud = 8;
    }
    
    public Password(int longitud){
        this.longitud = longitud;
        this.contrasenia = generarPassword();
    }
    
    public boolean esFuerte(){
        boolean esFuerte = false;
        int conteoMayusculas = 0;
        int conteoMinusculas = 0;
        int conteoNumeros = 0;
        for(int i = 0; i < contrasenia.length(); i++){
            char caracterActual = contrasenia.charAt(i);
            if(Character.isLetter(caracterActual)){
                if(Character.isUpperCase(caracterActual)){
                    conteoMayusculas++;                
                }
                else if(Character.isLowerCase(caracterActual)){
                    conteoMinusculas++;                
                }
            }
            else// es numero
                conteoNumeros++;
        }
        if(conteoMayusculas > 2 && conteoMinusculas > 1 && conteoNumeros > 5)
            esFuerte = true;
        return esFuerte;
    }
    
    public String generarPassword(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = this.longitud;
        Random random = new Random();
        
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        
        return generatedString;
    }
    
    public int getLongitud(){
        return this.longitud;
    }
    
    public String getContrasenia(){
        return contrasenia;
    }
    
    public void setLongitud(int longitud){
        this.longitud = longitud;
    }
}

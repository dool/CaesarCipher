
/**
 * CaesarCipher:
 * This class encrypts a statement using mono-alphabetic cipher using English Language
 * @author (Dool) 
 * @version (December 4, 2016)
 */
import edu.duke.*;
public class CaesarCipher {
    
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        
        for (int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            int index = alphabet.indexOf(Character.toUpperCase(currChar));
            
            if (index != -1){
                char newChar = shiftedAlphabet.charAt(index);
                encrypted.setCharAt(i, newChar);
            }
        }
        
        return encrypted.toString();
    }
    
    public void testEncrypt(){
        /**int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        System.out.println(encrypt(encrypted, 26-key));
        **/
        
        System.out.println(encrypt("The digital methods should all be easily recognizable, and they either work or they don't", 17));
    }

}

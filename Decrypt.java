

/**
 * Decrypt:
 * This class decrypts a statement using mono-alphabetic cipher using English Language
 * @author (Dool) 
 * @version (December 4, 2016)
 */
import edu.duke.*;
public class Decrypt {
    
    
    public int maxIndex(int [] vals){
        int maxAlph = 0;
        
        for (int i = 0; i<vals.length; i++){
            if (vals[i]>vals[maxAlph]){
                maxAlph = i;
            }
        }
        
        return maxAlph;
    }
    
    public String decrypt(String input){
       input = input.toUpperCase();
       int [] freq = countLetters(input);
       int maxNum = maxIndex(freq);
       System.out.println(maxNum);
       int dkey = maxNum - 4;
        if (maxNum < 4){
           dkey = 26  - (4 - maxNum);
        }
        
       
         CaesarCipher cc = new CaesarCipher();
         return cc.encrypt(input, 26 - dkey);
        
    }
    
    
    public int [] countLetters(String input){
        int [] count = new int[26];
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                         
        for (int i = 0; i< input.length(); i++){
            char currChar = input.charAt(i);
            int index = alphabet.indexOf(Character.toUpperCase(currChar));
            if (index != -1){
                count[index]++;
            }
        }
        
        return count;
    }

    
    public void testDecrypt(){
        
        System.out.println(decrypt("KYV UZXZKRC DVKYFUJ JYFLCU RCC SV VRJZCP IVTFXEZQRSCV, REU KYVP VZKYVI NFIB FI KYVP UFE'K"));
        
        
    }
    
    public void testDecryptFile(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = decrypt(message);
        System.out.println(encrypted);
      
    }
    
}

import edu.duke.*;
import java.lang.Character;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            char upperCurrChar = Character.toUpperCase(currChar);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(upperCurrChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                if (Character.isLowerCase(currChar)) {
                    newChar = Character.toLowerCase(newChar);
                }
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public String encrypt2Key(String input, int key1, int key2) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        
        String shiftedAlphabet2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
        
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            char upperCurrChar = Character.toUpperCase(currChar);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(upperCurrChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = (i % 2 == 0) ? shiftedAlphabet1.charAt(idx) : shiftedAlphabet2.charAt(idx);
                if (Character.isLowerCase(currChar)) {
                    newChar = Character.toLowerCase(newChar);
                }
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public void testCaesar() {
        int key = 15;
        int key1 = 14;
        int key2 = 24;
        //FileResource fr = new FileResource();
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
        String encrypted2Key = encrypt2Key(message, key1, key2);
        System.out.println(encrypted2Key);
        String decrypted2Key = encrypt2Key("Hfs cpwewloj loks cd Hoto kyg Cyy.", 26- key1, 26 - key2);
        String decrypted2Key1 = encrypt2Key("Hfs cpwewloj loks cd Hoto kyg Cyy.", key1, key2);
        System.out.println(decrypted2Key);
        System.out.println(decrypted2Key1);
    }
    
    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
         || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
            }
            return false;
    }
    
    public String replaceVowels(String phrase, char ch) {
        StringBuilder encrypted = new StringBuilder(phrase);
        for (int i = 0; i < encrypted.length(); i++) {
            char curChar = encrypted.charAt(i);
            if (isVowel(curChar)) {
                encrypted.setCharAt(i, ch);
            }
        }
        return encrypted.toString();
    }
    
    public String emphasize(String phrase, char ch) {
        StringBuilder encrypted = new StringBuilder(phrase);
        for (int i = 0; i < encrypted.length(); i++) {
            char curChar = encrypted.charAt(i);
            if (Character.toLowerCase(curChar) == Character.toLowerCase(ch)) {
                encrypted.setCharAt(i, i % 2 == 0 ? '*' : '+');
            }
        }
        return encrypted.toString();
    }
    
    public void testEmphasize() {
        String decrypted = emphasize("Mary Bella Abracadabra", 'a');
        System.out.println(decrypted);
    }
    
    
    
     public int[] countLetters(String message){
        String alph = "abcdefghijklmnoqprstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for (int k = 0; k < vals.length; k++){
            if (vals[k] > vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    public String decrypt(String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return encrypt(encrypted, dkey);
    }
    
    public String halfOfString(String message, int start){
        StringBuilder half = new StringBuilder();
        for (int i = start; i < message.length(); i += 2){
            char a = message.charAt(i);
            half.append(a);
        }
        return half.toString();
    }
    
    public int getKey(String s){
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }
    
    public String decryptTwoKeys(String encrypted){
        int dkey1 = getKey(halfOfString(encrypted, 0));
        int dkey2 = getKey(halfOfString(encrypted, 1));
        System.out.println(dkey1 + "\t" + dkey2);
        System.out.println(encrypt2Key(encrypted, 26 - dkey1, 26 - dkey2));
        return encrypt2Key(encrypted, 26 - dkey1, 26 - dkey2);
    }
}


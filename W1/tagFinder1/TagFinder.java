/**
 * Finds a protein within a strand of DNA represented as a string of c,g,t,a letters.
 * A protein is a part of the DNA strand marked by start and stop codons (DNA triples)
 * that is a multiple of 3 letters long.
 *
 * @author Duke Software Team 
 */
import edu.duke.*;
import java.io.*;

public class TagFinder {
    public String findProtein(String dna) {
        int start = dna.indexOf("atg");
        if (start == -1) {
            return "";
        }
        int stop = dna.indexOf("tag", start+3);
        if ((stop - start) % 3 == 0) {
        return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }
    
    public String findSimpleGene(String dna) {
        int start = dna.indexOf("ATG");
        if (start == -1) {
            return "";
        }
        int stop = dna.indexOf("TAA", start+3);
        if ((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }
    
    public String findSimpleGene(String dna, int startCodon, int endCodon) {
        int start = dna.toUpperCase().indexOf("ATG");
        if (start == -1) {
            return "";
        }
        int stop = dna.toUpperCase().indexOf("TAA", start+3);
        if ((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }
    
    public boolean twoOccurrences(String stringa, String stringb) {
        boolean isLeastTwice = false;
        int startIndex1 = stringb.indexOf(stringa);
        if (startIndex1 == -1) {
            return isLeastTwice;
        }
        int startIndex2 = stringb.indexOf(stringa, startIndex1 + stringa.length());
        if (startIndex2 == -1) {
            return isLeastTwice;
        }
        isLeastTwice = true;
        return isLeastTwice;
    }
    
    public String lastPart(String stringa, String stringb) {
        int startIndex1 = stringb.indexOf(stringa);
        if (startIndex1 == -1) {
            return stringb;
        }
        return stringb.substring(startIndex1 + stringa.length());
    }
    
    public void testTwoOccurrences() {
        String b = "A story by Abby Long";
        String a = "by";
        boolean result = twoOccurrences(a, b);
        System.out.println("result "+ result);
        
        String b1 = "ctgtatgta";
        String a1 = "atg";
        boolean result1 = twoOccurrences(a1, b1);
        System.out.println("result1 "+ result1);
        
    }
    
    public void testLastPart() {
        String b = "banana";
        String a = "an";
        String result = lastPart(a, b);
        System.out.println("result "+ result);
        
        String b1 = "forest";
        String a1 = "zoo";
        String result1 = lastPart(a1, b1);
        System.out.println("result1 "+ result1);
        
    }
    
    public void testSimpleGene() {
        String a = "ATGCCCTAA";
        String ap = "ATGCCCTAG";
        String result = findProtein(a);
        System.out.println("result "+ result);
        
    }
    
    
    public void printUrl() {
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String word : ur.words()) {
            String wordNormal = word;
            int index = word.toLowerCase().indexOf("youtube");
            if (index == -1) {
                continue;
            }
            int startIndex = word.indexOf("\"");
            if (startIndex == -1) {
                continue;
            }
            int endIndex = word.indexOf("\"", index + 7);
            if (endIndex == -1) {
                continue;
            }
            
            System.out.println(wordNormal.substring(startIndex - 1, endIndex));
        }   
    }
    
    
}

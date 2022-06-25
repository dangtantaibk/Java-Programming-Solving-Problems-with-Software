import edu.duke.*;
import java.util.HashMap;
import java.lang.Character;

public class CodonCount {
    private HashMap<String, Integer> codonCountDNA;
    public CodonCount() {
        codonCountDNA = new HashMap<>();
    }
    private void buildCodonMap(int start, String dna) {
        codonCountDNA = new HashMap<>();
        String dnaTrim = dna.trim();
        int length = dnaTrim.length();
        int i = start;
        while(true) {
            if (length < 3) {
                break;
            }
            String a = dnaTrim.substring(i, i + 3);
            codonCountDNA.put(a, codonCountDNA.getOrDefault(a, 0) + 1);
            i += 3;
            length -= 3;
        }
        return;
    }
    
    private String getMostCommonCodon() {
        String a = "";
        int count = 0;
        for (String key : codonCountDNA.keySet()) {
            if (codonCountDNA.getOrDefault(key, 0) > count) {
                a = key;
                count = codonCountDNA.getOrDefault(key, 0);
            }
        }
        return a;
    }
    
    private void printCodonCounts(int start, int end) {
        for (String key : codonCountDNA.keySet()) {
            if (codonCountDNA.getOrDefault(key, 0) >= start
                && codonCountDNA.getOrDefault(key, 0) <= end) {
                System.out.println(key + "\t" + codonCountDNA.getOrDefault(key, 0));
            }
        }
    }
    
    public void test() {
        String a = "CGTTCAAGTTCAA";
        buildCodonMap(1, a);
        System.out.println("getMostCommonCodon: " + getMostCommonCodon());
        printCodonCounts(1, 5);
        
    }
    
    public void testWithFile() {
        FileResource resource = new FileResource();
        for(String s : resource.words()){
            buildCodonMap(1, s);
            System.out.println("getMostCommonCodon: " + s + "    " + getMostCommonCodon());
            printCodonCounts(1, 5);
        }
        
    }
}


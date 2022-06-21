
/**
 * Count common words in Shakespeare's works
 * 
 * @author Duke Software Team
 * @version 1.0
 */
import edu.duke.*;

public class CommonWords
{
    public String[] getCommon(){
        FileResource resource = new FileResource("data/common.txt");
        String[] common = new String[20];
        int index = 0;
        for(String s : resource.words()){
            common[index] = s;
            index += 1;
        }
        return common;
    }
    
    public int indexOf(String[] list, String word) {
        for (int k=0; k<list.length; k++) {
            if (list[k].equals(word)) {
                   return k;
               }
           }
        return -1;
    }
    
    public void countWords(FileResource resource, String[] common, int[] counts){
        for(String word : resource.words()){
            word = word.toLowerCase();
            int index = indexOf(common,word);
            if (index != -1) {
                counts[index] += 1;
            }
        }
    }
    void countShakespeare(){
        //String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
            //          "likeit.txt", "macbeth.txt", "romeo.txt"};
        String[] plays = {"small.txt"};
        String[] common = getCommon();
        int[] counts = new int[common.length];
        for(int k=0; k < plays.length; k++){
            FileResource resource = new FileResource("data/" + plays[k]);
            countWords(resource,common,counts);
            System.out.println("done with " + plays[k]);
        }
        
        for(int k=0; k < common.length; k++){
            System.out.println(common[k] + "\t" + counts[k]);
        }
    }
    
    public int countWord(String word) {
        int count = 0;
        for(int k=0; k < word.length(); k++){
            char curChar = word.charAt(k);
            if (Character.isLetter(curChar) || curChar == '\'') {
                count += 1;
            }
        }
        return count;
    }
    
    public void countWordLengths(FileResource resource, int[] counts) {
        for(String word : resource.words()){
            int count = countWord(word);
            counts[count] += 1;
        }
        return;
    }
    
    public int indexOfMax(int[] values) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (max < values[i]) {
                max = values[i];
            }
        }
        return max;
    }
    
    public void testCountWordLengths() {
        FileResource file = new FileResource();
        int[] count = new int[31];
        countWordLengths(file, count);
        int max = indexOfMax(count);
        System.out.println("indexOfMax: " + max);
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println(count[i] + " words of length " + i);
            }
        }
    }
    
}

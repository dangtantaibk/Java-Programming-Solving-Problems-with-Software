
/**
 * Find out how many times each word occurs, and
 * in particular the most frequently occurring word.
 * 
 * @author Duke Software Team
 * @version 1.0
 */
import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    private ArrayList<String> myChars;
    private ArrayList<Integer> myCountChars;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
        myChars = new ArrayList<String>();
        myCountChars = new ArrayList<Integer>();
    }
    
    private void update(String s) {
        int index = myChars.indexOf(s);
        if (index == -1){
            myChars.add(s);
            myCountChars.add(1);
        }
        else {
            int freq = myCountChars.get(index);
            myCountChars.set(index,freq+1);
        }
            
    }
    
    private void findAllCharacters(){
        FileResource resource = new FileResource();
        
        for(String s : resource.lines()){
            int index = s.indexOf(".");
            if (index != -1) {
                String word = s.substring(0, index);
                update(word);
            }
        }
    }
    
    private void charactersWithNumParts(int num1, int num2){
        for (int i = 0; i < myCountChars.size(); i++) {
            int count = myCountChars.get(i);
            if (count >= num1 && count <= num2) {
                System.out.println(myChars.get(i) + " " + myCountChars.get(i));
            }
        }
    }
    
    public void testerFindAllCharacters() {
        findAllCharacters();
        for (int i = 0; i < myChars.size(); i++) {
            //System.out.println(myChars.get(i) + " " + myCountChars.get(i));
        }
        charactersWithNumParts(10,15);
        int index = findMax();
        System.out.println("The word that occurs most often and its count are: "+myChars.get(index)+" "+myCountChars.get(index));
    }
    
    public int findMax(){
        int max = myCountChars.get(0);
        int maxIndex = 0;
        for(int k=0; k < myCountChars.size(); k++){
            if (myCountChars.get(k) > max){
                max = myCountChars.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    public void findUnique(){
        FileResource resource = new FileResource();
        
        for(String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
        }
    }
    
    public void tester(){
        findUnique();
        System.out.println("Number of unique words: "+myWords.size());
        for (int i = 0; i < myWords.size(); i++) {
        //    System.out.println(myFreqs.get(i) + " " + myWords.get(i));
        }
        int index = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: "+myWords.get(index)+" "+myFreqs.get(index));
    }
    public int findIndexOfMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}

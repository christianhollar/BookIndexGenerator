/**
 * This creates a index for a book using a sorted array list of entry objects
 *
 * @author Kyle Chmielewski (chmielek@lafayette.edu)
 * @version Date: 12/3/20
 */
import java.util.*;
import java.io.*;
public class IndexUsingSortedList
{
    //instance variable
    ArrayList<Entry> index;

    /**
     * Constructor for creating the index
     */
    public IndexUsingSortedList(String file)
    {
        index = new ArrayList<Entry>();
        createIndex(file);
    }

    /**
     * Method createIndex is the main method resposible for putting together the index
     *
     * @param file the input file to be indexed
     */
    public void createIndex(String file)
    {
        Integer counter = 0;
        int j = 0;
        try{
            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);

            String line;
            ArrayList<String> allTheWords = new ArrayList<String>();

            //while there are lines read them in
            while((line = in.readLine()) != null && j<=10){
                //counter ++;
                String[] words = line.split("\\W+");  

                //iterates through each word
                for  (String ss : words) {
                    String key = ss.toLowerCase();   
                    allTheWords.add(key);
                    //adds all the words from a line to an arrayList
                }
               // System.out.println(allTheWords.toString());
                for(int i = 0; i < allTheWords.size(); i++){
                    
                    if(binarySearch(dictionary(), allTheWords.get(i)) != -1){ //if in dictionary
                        if(contains(allTheWords.get(i))){        //if already in arrayList
                            addAdditionalLineNumber(counter);
                        }else{ //creating new entry and adding to Index
                            //System.out.println("entering: " + allTheWords.get(i));
                            Entry newWord = new Entry(allTheWords.get(i),counter); 
                            insertSorted(newWord);
                        }
                    }
                }
               //System.out.println(toString());
                allTheWords.clear();
                counter ++;
                j++;
            }
            //System.out.println(toString());
            in.close();
        }

        catch(Exception e){
            System.out.println("Exception has occured " + e);
        }
       // System.out.println(toString());
    }

    /**
     * Method dictionary is responsible for reading in the dictionary and formatting it so it can be used to identify
     * words to index.
     *
     * @return Array of all the words in the english language.
     */
    public String[] dictionary()
    {
        ArrayList<String> workingDictionary = new ArrayList<String>();
                String dictionary ="/Users/christianhollar/Desktop/English.txt"; 

        try{
            FileReader fr = new FileReader(dictionary);
            BufferedReader in = new BufferedReader(fr);
            String line;

            //while there are lines read them in
            while((line = in.readLine()) != null){
                String[] words = line.split("\\W+");

                //add each word to an arrayList
                for(int i = 0; i < words.length; i++){
                    workingDictionary.add(words[i]);
                }
            }

            String[] english = new String[workingDictionary.size()];

            //iterated through arrayList to create an array of Strings which can be used by binary Search
            for(int i = 0; i < english.length; i++){
                english[i] = workingDictionary.get(i);
            }
            in.close();
            return english;
        }
        catch(Exception e){
            System.out.println("Exception has occured " + e);
        }
        return null;
    }

    /**
     * Method binarySearch simple binary seach algorithm to find strings in a sorted list
     *
     * @param arr array of strings to be searched through
     * @param x the key that we want to find
     * @return greater than 0 if in the array and -1 if not present
     */
    public int binarySearch(String[] arr, String x) 
    { 
        int left = 0;
        int right = arr.length - 1; 
        while (left <= right) { 
            int mid = left + (right - left) / 2; 

            int result = x.compareTo(arr[mid]); 

            // Check if x is present at mid 
            if (result == 0) 
                return mid; 

            // If x greater, ignore left half 
            if (result > 0) 
                left = mid + 1; 

            // If x is smaller, ignore right half 
            else
                right = mid - 1; 
        } 

        return -1; 
    } 

    /**
     * Method insertSorted is a helper method that adds items in sorted order to the ArrayList
     *
     * @param value the Entry to be added
     */
    private void insertSorted(Entry value)
    {
       //if empty just add normally;
        if(index.size() == 0){
            index.add(value);
        }else{
            //go through arrayList to find which point to insert
            for(int i = 0; i < index.size(); i++){ 
                if (value.getWord().compareTo(index.get(i).getWord()) < 0){
                    index.add(i,value);
                    break;
                }
            }
        }
    }
    

    Entry duplicate;
    /**
     * Method contains is a helper method that determines if a word is in the arrayList
     *
     * @param word is the word being searched for
     * @return true if present, false if absent
     */
    private boolean contains(String word)
    {
        //searching through arrayList
        for(int i = 0; i < index.size(); i++){
            if(word.equals(index.get(i).getWord())){
                duplicate = index.get(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Method addAdditionalLineNumber is a helper method which adds an additional line number to the set of line
     * numbers
     *
     * @param lineNumber the line number to be addded
     */
    private void addAdditionalLineNumber(int lineNumber)
    {
        duplicate.addAdditionalLineNumber(lineNumber);
    }

    public String toString()
    {
        String a = "";
        for(int i = 0; i < index.size(); i++){
            a = a + "Word: " + index.get(i).getWord() +  " LineNumbers: " + index.get(i).getLineNumbers().toString();
        }
        return a;
    }
}

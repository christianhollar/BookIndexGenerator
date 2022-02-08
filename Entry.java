/**
 * Entry is a simple container class, which houses the data for each entry object
 *
 * @author Kyle Chmielewski (chmielek@lafayett.edu)
 * @version Date:12/3/2020
 */
import java.util.*;
public class Entry implements Comparable<Entry>
{
    //instance variables
    private String word;                //word to be added
    private TreeSet<Integer> lineNumbers = new TreeSet<Integer>();  //line number of that word
    private Integer lineNumber;
  
    /**
     * Constructor for objects of class Entry
     */
    public Entry(String word, Integer lineNumber)
    {
        this.word = word;    
        lineNumbers.add(lineNumber);        //add to set of line numbers upon contruction
    }
    
    /**
     * Method getWord is a simple getter method
     *
     * @return the word within each entry object
     */
    public String getWord()
    {
        return this.word;
    }
    
    public ArrayList<Integer> getLineNumbers()
    {
        ArrayList<Integer> lines = new ArrayList<Integer>();
        Iterator<Integer> it = lineNumbers.iterator();
        while(it.hasNext()){
            lines.add(it.next());
        }
        return lines;
    }
    
    /**
     * Method addAdditionalLineNumber adds the additional line number to the set of line numbers
     *
     * @param lineNumber to be added
     */
    public void addAdditionalLineNumber(Integer lineNumber)
    {
        lineNumbers.add(lineNumber);
    }
    
    @Override
    public int compareTo(Entry x)
    {
        if(getWord().compareTo(x.getWord()) == 0){
            return 0;
        }else if(getWord().compareTo(x.getWord()) > 0){
            return 1;
        }else{
            return -1;
        }
    }
}

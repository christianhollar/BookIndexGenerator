import java.util.*;
import java.io.*;
/**
 * Creates an index of a text file using TreeMap
 *
 * @author Andrew Heare
 * @version 12/04/2020
 */
public class TreeMapIndex
{
    TreeMap<String, TreeSet<Integer>> index;
    ArrayList<String> dictionary;
    


    /**
     * Constructor for objects of class TreeMapIndex
     */
    public TreeMapIndex()
    {
        index = new TreeMap<>();
        dictionary = new ArrayList<>();
        try
        {
            File file = new File("shakespeare.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine())
            {
                String line = scan.nextLine();
                dictionary.add(line);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: dictionary not found");
        }
    }

    /**
     * Reads the input file and adds words to the index
     *
     * @param  
     * @return  
     */
    public void run()
    {
        int lineCounter = 1;
        long runTime = 0;
        long start = 0;
        long end = 0;
        int linesToRead = 0;;
        try
        {
            File input = new File("Shakespeare.txt");
            Scanner scan = new Scanner(input);
            while(scan.hasNextLine() && linesToRead < 1001)
            {
                String line = scan.nextLine();
                String[] words = line.split("[ˆA-Za-z]+");
                
                for(int i = 0; i < words.length; i++)
                    words[i] = words[i].toLowerCase();
                    
                for(String word : words)
                {
                    start = System.currentTimeMillis();
                    addToTreeMap(word, lineCounter);
                    end = System.currentTimeMillis();
                    runTime += (end - start);
                    
                }   
                lineCounter++;
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: input file not found");
        }
        System.out.println("TreeMap Runtime is: "+runTime+" ms");
    }
    
    /**
     * Adds words to index using TreeMap
     *
     * @param  word The word to be inserted
     *         line The line number where the word appears
     * @return    
     */
    public void addToTreeMap(String word, int line)
    {
        int useLine = line + 1;
        if(index.containsKey(word))
        {
            TreeSet<Integer> temp = index.get(word);
            temp.add(useLine);
            index.replace(word, temp);
        }
        else
        {
            TreeSet<Integer> t = new TreeSet<>();
            t.add(useLine);
            index.put(word, t);
        }
    }
}

import java.io.*;
import java.util.*;
/**
 * ReadHash:
 * -ReadHash takes in a file.
 * -File is broken into strings.
 * -Strings are added to ArrayList.
 * -HashMap holds each string as key elements.
 * -HashMap holds number appearence as value elements.
 *
 * @ChristianHollar
 * @12/1/20
 */
public class ReadHash
{
    //HashMap h of type <String,TreeSet<Integer>>
    HashMap<String,TreeSet<Integer>> h = new HashMap<String,TreeSet<Integer>>();
    //ArrayList<String> => Holds output 
    ArrayList<String> a = new ArrayList<String>();
    
    /**
     * Inner Class HashObject:
     * -Stores key String
     * -Stores value TreeSet<Integer>
     * -Comparable uses key Strings
     * -toString prints key then each integer from TreeSet
     */
    public class hashObject implements Comparable<hashObject>
        {
            public String key;
            public TreeSet<Integer> value;
            
            hashObject(String key, TreeSet<Integer> value)
            {
                this.key = key;
                this.value = value;
            }
            //using comparable for sorting lists
            @Override
            public int compareTo(hashObject other)
            {
                return key.compareTo(other.key);
            }
            //using toString for list output
            @Override
            public String toString()
            {
                String useReturn = key+" {";
                Iterator<Integer> it = value.iterator();
                while(it.hasNext())
                {
                    String current = Integer.toString(it.next());
                    if(!it.hasNext())
                    {
                        useReturn+=current+"}";
                        break;
                    }
                    useReturn += current+", ";
                }
                return useReturn;
            }
            //checking function
            public void size()
            {
                System.out.println("The size is "+value.size()+" for element "+key);
            }
        }

    /**
     * ReadHash
     * -Takes in filename String
     * -Converts to File
     * -Scanner adds each line to ArrayList<String>
     * @String
     */
    public ReadHash(String filename)
    {
        File thisFile = new File(filename);
        try{
            Scanner s = new Scanner(thisFile);
            int j = 0;  
            //add each line from file to arraylist<String>
            while(s.hasNextLine())
            {
                a.add(s.nextLine());
                j++;
            }
            s.close();
        }catch(Exception e){
            System.out.println("Error: Scanner Input");
        }
    }

    /**
     * readInHash
     * -cycles through each String in ArrayList<String>
     * -converts each String to lowercase
     * -removes punctuation etc.
     * -long to track time for each add
     *
     * @param void
     * @return  long total time of each add to hashMap
     */
    public long readInHash()
    {
        String[] words={""};
        long currentT = 0;
        for(int i = 0; i<a.size(); i++)
        {
            String current = a.get(i);
            words = current.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            //words = current.split("[ˆA-Za-z]+");
            for(int j = 0; j<words.length; j++)
            {
                if(words[j].length()>0)
                {
                    long start = System.currentTimeMillis();
                    addToHashMap(words[j], i);                
                    long stop = System.currentTimeMillis();
                    currentT+=(stop-start);
                }
            }
            
        }
        h.remove(null);
        return currentT;
    }
    /**
     * addToHashMap
     * currentLine Tracker
     * check if key contain
     *      -if so add new lineNumber to TreeSet
     *      -else new treeSet and key,value point on HashMap
     * param String word to add, int line number of the word
     * return void
     */
    public void addToHashMap(String word, int line)
    {        
        int useLine = line+1;
        if(contains(word))
        {
            TreeSet<Integer> temp = h.get(word);
            temp.add(useLine);
            h.replace(word,temp);            
        }
        else
        {
            TreeSet<Integer> t = new TreeSet<Integer>();
            t.add(useLine);
            h.put(word,t);
        }
    }
    /**
     * contains()
     * param String key value to search for
     * return boolean true/false if contained
     */
    public boolean contains(String key)
    {
        return h.containsKey(key);
    }
    /**
     * getHashMap()
     * print HashMap to txt file
     * 
     * param void
     * return void
     */
    public void getHashMap()
    {
        System.out.println(h);
    }
    /**
     * sortHashMap()
     * two Lists
     * First
     *      -holds all key values from HashMap.keySet()
     *      -sort
     * Second
     *      -holds HashObjects
     * for each key
     *      -create hashObject with string key and tree set value
     *      -tree set from h.get(key)
     *      -add hashObject to List
     * Sort List based on compareTo => Set to String keys comparison
     * Print each hashObject from List
     * 
     * param void
     * return void
     */
    public void sortHashMap()
    {
        
        List<String> mapKeys = new ArrayList<String>(h.keySet());
        Collections.sort(mapKeys);
        List<hashObject> hashList = new ArrayList<hashObject>();
        
        for(int i = 0; i<mapKeys.size(); i++)
        {
            String current = mapKeys.get(i);
            TreeSet<Integer> curTSet = h.get(current);
            hashObject temp = new hashObject(current, curTSet);
            hashList.add(temp);
        }
        
        Collections.sort(hashList);
        System.out.println(Arrays.toString(hashList.toArray()));
    }
    
    /*public void useTreeMap()
    {
        TreeMap<String,TreeSet<Integer>> tree = new TreeMap<String,TreeSet<Integer>>(h);
        String s = tree.firstKey();
        System.out.println(s);
        System.out.println(tree.get(s).size());
    }*/
    
}

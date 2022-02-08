import java.io.*;
/**
 * Automatically Runs ReadHash correctly once initilized
 *
 * @ChristianHollar
 * @12/4/20
 */
public class ControllerHashMap
{
    /**
     * Automatic ReadHash Run Class/Method
     * param void
     */

    public ControllerHashMap()
    {
        //Set output to .txt file
        
        try{
            PrintStream o = new PrintStream(new File("/Users/christianhollar/Desktop/A.txt"));
            System.setOut(o);
        }catch(Exception e){
            System.out.println("Error PrintStream");
        }
        //file options 
        String shakespeare = 
        "/Users/christianhollar/Downloads/Project 3 sample inputoutput files (2)/Shakespeare.txt";
        String petroSch = 
        "/Users/christianhollar/Desktop/Computer Science/CS150/HollarLab3/EBookPetroSchlemihl.txt";
        String dictionary ="/Users/christianhollar/Desktop/English.txt"; 
        ReadHash r = new ReadHash(shakespeare);
        System.out.println("Time: "+r.readInHash()+" ms");
        r.sortHashMap();
        try{
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        }catch(Exception e){
        }
        /*int trials = 5;
        for(int i = 0; i<trials; i++)
        {
            
            ReadHash runIt = new ReadHash(shakespeare);
            System.out.println(runIt.readInHash());

        }*/
    }

}

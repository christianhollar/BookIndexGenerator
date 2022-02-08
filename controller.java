/**
 * Write a description of class controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class controller
{
    public controller()
    {
        String shakespeare = 
        "/Users/christianhollar/Downloads/Project 3 sample inputoutput files (2)/Shakespeare.txt";
        
        long startTime = System.currentTimeMillis();
        IndexUsingSortedList bob = new IndexUsingSortedList(shakespeare);
        long stopTime = System.currentTimeMillis();
        long runTime = stopTime - startTime;
        System.out.println("ArrayList RunTime is: " +runTime+" ms");
    }
}

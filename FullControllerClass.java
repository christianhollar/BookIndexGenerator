
/**
 * Holds calls for indexes for each data structure. 
 *
 * @ChristianHollar
 * @12/4/20
 */
public class FullControllerClass
{
    public static void main(String[] args)
    {
        //FullControllerClass c1 = new FullControllerClass("ArrayList");
        //FullControllerClass c2 = new FullControllerClass("TreeMap");
        FullControllerClass c3 = new FullControllerClass("HashMap");

    }
    
    public FullControllerClass(String type)
    {
        if (type == "ArrayList")
        {
            controller c = new controller();
        }
        
        if(type == "TreeMap")
        {
            TreeMapIndex testIndex = new TreeMapIndex();
            testIndex.run();
        }
        
        if(type=="HashMap")
        {
            ControllerHashMap c = new ControllerHashMap();
        }
    }
}

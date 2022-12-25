import java.io.*;
public class screen
{
    public static void clr()
    {
        try
        {
            
            if(System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            //else
            //Runtime.getRunTime().exec("clear");

        }catch(IOException | InterruptedException ex){}
    }
}
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FakeNetworkRequestLogger
{
    private static final Logger fakeLogger = Logger.getLogger(FakeNetworkRequestLogger.class.getName());
    static
    {
    try
    {
        FileHandler fileHandler = new FileHandler("fakeRequest.log");
        fileHandler.setFormatter(new SimpleFormatter());
        fakeLogger.addHandler(fileHandler);
        fakeLogger.setLevel(Level.INFO);



    }
    catch(IOException e)
    {
        System.err.println("Failed to set up logger, due to the following error " + e.getMessage());
    }
    }

    public static void main(String[] args)
    {
        for(int i = 0; i < 50; i++)
        {
            fakeLogger.info("205.160.186.7" + i + " uknown [" + LocalDateTime.now() + "]" + "GET /bgs/geenbg.gif HTTP 1.0 200 5" + i);

            try
            { 
                Thread.sleep(1000);
                fakeLogger.info("Information request recieved from network(thread slept for 1000millis)");
            }
            catch(InterruptedException e)
            {
                fakeLogger.severe("Netork error occured(thread sleep interupted " + e.getMessage());
            }
    

        }
       

    }

}


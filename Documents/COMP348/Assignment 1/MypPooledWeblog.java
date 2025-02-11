import java.io.*;
import java.net.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* 
            java MyPooledWeblog logname option
            logname is the file name
         option is one of the following:
            1 = count number of accesses by each remotehost; 2 = count total bytes
            transmitted; 3 = count total bytes by remotehost

            Example: java MyPooledWeblog fakeRequest.log 1
        */
public class MypPooledWeblog {

    public static void addValueOrUpdateKeyValue( Map<String, Integer> keyValueListToFill, String ip, Integer bits)
    {
        keyValueListToFill.put(ip,keyValueListToFill.getOrDefault(ip,0) + bits);
    }
    
    public static Map<String,Integer> howManyTimesIpAppearsInList( List<String> ipList)
    {
        Map<String,Integer> frequencyMap = new HashMap<>();
        for(String ip : ipList)
        {
            frequencyMap.put(ip, frequencyMap.getOrDefault(ip,0) + 1);
        }

        return frequencyMap;
    }

    //1
    public static void inputOne(List<String> ipList)
    {
        Map<String,Integer> inpuOneOutput = howManyTimesIpAppearsInList(ipList);
    
        System.out.println(inpuOneOutput);
    
    }

    //2
    public static void inputTwo(int bitsTransmitted)
    {
        System.out.println(bitsTransmitted);
    }

    //3
    public static void inputThree(Map<String,Integer> uniqueIpBitKeyValueList)
    {
        uniqueIpBitKeyValueList.forEach((key, value) -> System.out.println(key + ": " + value));

    }
   
    public static void main(String[] args)
    {
        Map<String,Integer> ipBitsMap = new HashMap<>(); //save the ip addreses here
        List<String> ipList = new ArrayList<>();
       int totalBitsTransmitted = 0;
   
     try (FileInputStream fin = new FileInputStream(args[0]);

        Reader in = new InputStreamReader(fin);

        BufferedReader bin = new BufferedReader(in);) 
        {
       
            for (String entry = bin.readLine();

                entry != null;

                entry = bin.readLine()) {

                // separate out the IP address
                int index = entry.indexOf(' ');

                String ip = entry.substring(0, index); //from the first index to the first space
                ipList.add(ip);
               
                String bitsTransmittedText = entry.substring(entry.length() - 1, entry.lastIndexOf(' ')); //from the last index to the last space
                int bitsTransmitted = Integer.parseInt(bitsTransmittedText);
                totalBitsTransmitted += bitsTransmitted;
                addValueOrUpdateKeyValue(ipBitsMap,ip,bitsTransmitted);
              
              //now assuming I have the ips,and all the bits they got... PRESS 3 you this hashmap printed
              //PRESS 1 you get the value of me looping through a list of ips and countring how many times they show up
              //Press 2 you get the value of me looping through the hashmap and printing how many total bits
            }

        } 
        
        catch (IOException ex) 
        {

            System.out.println("Exception: " + ex);

        }
        

        if(args[1] == "1")
        {
            
            inputOne(ipList);
            
        }

        if(args[1] == "2")
        {
           
            inputTwo(totalBitsTransmitted);
            
           
        }

        if(args[1] == "3")
        {
           
            inputThree(ipBitsMap);
            
            
        }
    }
}



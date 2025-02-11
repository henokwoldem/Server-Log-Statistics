import java.io.*;
import java.net.*;
import java.util.List;
import java.util.ArrayList;

public class Weblog {
/* 
    1 = count number of accesses by each remotehost; 2 = count total bytes
    transmitted; 3 = count total bytes by remotehost 
*/
/* I need the ip's, and the bytes from the file. IP is the first thing, bytes is the last after HTTP and a space */
    public static void main(String[] args) {

    List<String> ipList = new ArrayList<>(); //save the ip addreses here

   
    try (FileInputStream fin = new FileInputStream(args[0]);

        Reader in = new InputStreamReader(fin);

        BufferedReader bin = new BufferedReader(in);) {

            for (String entry = bin.readLine();

            entry != null;

            entry = bin.readLine()) {

                // separate out the IP address
                int index = entry.indexOf(' ');

                String ip = entry.substring(0, index);
                ipList.add(ip);//now I need to 
               


                String theRest = entry.substring(index);

                // Ask DNS for the hostname and print it out
                try {

                    InetAddress address = InetAddress.getByName(ip);

                    System.out.println(address.getHostName() + theRest);

                } catch (UnknownHostException ex) {

                    System.err.println(entry);

                }

            }

        } catch (IOException ex) {

            System.out.println("Exception: " + ex);

        }

    }

}

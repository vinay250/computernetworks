import java.net.*; 
import java.util.*;

class DNSTest
{
public static void main(String[] args)
{ 
String host = new String();
Scanner input = new Scanner(System.in); 
InetAddress inetAddress;
try
{
System.out.println("Enter host name"); 
host = input.nextLine();
inetAddress = InetAddress.getByName(host); 
System.out.println("Host Name: " + inetAddress.getHostName()); 
System.out.println("Host Address: " +
inetAddress.getHostAddress());
System.out.println();
}
catch(UnknownHostException e)
{ 
System.out.println("Host not found: " + host);
}
}
}





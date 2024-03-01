import java.net.*; 
import java.io.*; 
import java.util.*;

class EchoClient
{
public static void main(String[] args)
{
Socket socket = null;
Scanner scan = new Scanner(System.in);
String yourMsg, echo;
InputStream inputStream = null; 
OutputStream outputStream = null; 
DataInputStream dataInputStream = null; 
DataOutputStream dataOutputStream = null; 
try
{
socket = new Socket("localhost", 7313); 
System.out.println("Connected...");
inputStream = socket.getInputStream(); 
outputStream = socket.getOutputStream();
dataInputStream = new DataInputStream(inputStream); 
dataOutputStream = new DataOutputStream(outputStream);
System.out.println("Enter msg to echo..."); 
yourMsg = scan.nextLine();
dataOutputStream.writeUTF(yourMsg); 
echo = dataInputStream.readUTF();
System.out.println(echo); 
System.out.println("Echoed successfully"); 
socket.close();
scan.close();
}
catch(IOException e)
{
 System.out.println(e);
}
}
}
